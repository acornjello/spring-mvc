package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";

        // Controller -> View 이동 시 사용
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response); // 다른 서블릿이나 JSP로 이동할 수 있는 기능 (서버 내부에서 다시 호출이 발생)
        // C->S 호출하고, JSP호출하고 JSP에서 응답을 만들어서 S->C로 redirect가 아님 //  웹브라우저 다시 요청하지 않음.

        // 서버에서 WAS서버 룰에서 WEB-INF안에 있는 자원들은, 외부에서 호출해도 보여지지않음.
        // 무조건 Controller(Servlet)을 거쳐서 forward를 해야 보여짐.

        // redirect : 실제 웹브라우저에 응답이 나갔다가 클라이언트가 redirect 경로로 다시 요청. (url경로가 실제로 변경된다.) 클라이언트 두번 호출
        // forward : 클라이언트 입장에서는 한번만 호출. 클라이언트가 인지하지 못함.


    }
}
