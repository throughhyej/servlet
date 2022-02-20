package hello.servlet.web.frontcontroller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MyView {

    private String path;

    public MyView(String path) {
        this.path = path;
    }

    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }

    public void render(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) throws ServletException, IOException {
        modelToRequestAttribute(request, model);
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }

    private void modelToRequestAttribute(HttpServletRequest request, Map<String, Object> model) {
        model.forEach((name, value) -> request.setAttribute(name, value));
    }

}
