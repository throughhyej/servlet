package hello.servlet.web.frontcontroller.v5;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommonUtil {
     public static Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(param -> paramMap.put(param, request.getParameter(param)));
        return paramMap;
    }
}
