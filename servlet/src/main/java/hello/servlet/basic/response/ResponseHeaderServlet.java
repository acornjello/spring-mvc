package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ResponseHeaderServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        //[status-line]
        response.setStatus(HttpServletResponse.SC_OK);

        //[response-headers]
        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 캐시를 완전히 무효화
        response.setHeader("Pragma", "no-cache"); // 과거버전까지 캐시 없앰
        response.setHeader("my-header", "hello"); // 임의의 헤더

        // [Header 편의 메서드]
//        content(response); // Content-Length : 4 ...? #
//        cookie(response);
        redirect(response);

        // [message body]
        PrintWriter writer = response.getWriter(); // 또는 inputstream..?
        writer.println("ok"); // ln으로 Content-Length : 3
    }

    private void content(HttpServletResponse response) {
        // Content-Type : text/plain;charset=utf-8
        // Content-Length : 2
        // response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        // response.setContentLength(2); // 생략 시 자동 계산하여 생성
        
    }

    private void cookie(HttpServletResponse response) {
        //Set-Cookie : myCookie=good; Max-Age=600;
        // reponse.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);
        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException {
        //Status Code 302
        //Location: /basic/hello-form.html

        //response.setStatus(HttpServletResponse.SC_FOUND);
        //response.setHeader("Location", "/basic/hello-from.html");
        response.sendRedirect("/basic/hello-form.html");
    }
}
