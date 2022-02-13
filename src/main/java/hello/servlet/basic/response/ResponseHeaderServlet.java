package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println();

        System.out.println("[STATUS CODE]");
        response.setStatus(HttpServletResponse.SC_OK);

        System.out.println("[Response-Header]");
        response.setHeader("Content-Type", "text/plain");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("servlet-header", "hyej");

        System.out.println("[header 편의 메서드]");
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.setContentLength(1000);

        System.out.println("[리다이렉트]");
        response.setStatus(HttpServletResponse.SC_FOUND);
        response.sendRedirect("/basic/hello-form.html");

        Cookie cookie = new Cookie("custom-cookie", "GOOOOD");
        cookie.setMaxAge(100);
        response.addCookie(cookie);

        System.out.println("[msg body]");
        response.getWriter().write("OK");
    }

}
