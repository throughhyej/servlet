package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
/** GET query string 형태와 POST Body message 형태가 같기 때문에 같은 자바 소스 이용 가능 **/
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println();

        // 파라미터 정보
        request.getParameterNames()
                .asIterator()
                .forEachRemaining(parameter
                        -> System.out.println("parameter > " + parameter + " = " + request.getParameter(parameter)));

        System.out.println();

        // 단일 파라미터 정보
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        System.out.println("username = " + username);
        System.out.println("age = " + age);

        System.out.println();

        // 복수 파라미터 정보
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("duplicate name = " + name);
        }

        System.out.println();

    }
}