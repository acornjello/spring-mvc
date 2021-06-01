package hello.servlet.web.frontcontroller.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV1 { // 각 컨트롤러가 이 인터페이스 구현, 프론트 컨트롤러는 이 인터페이스 구현하는 컨트롤러 호출?

    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
