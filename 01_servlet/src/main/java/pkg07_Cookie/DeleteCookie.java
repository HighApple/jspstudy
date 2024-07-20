package pkg07_Cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	// 요청파라미터
    request.setCharacterEncoding("UTF-8");
    String cookieName = request.getParameter("cookieName");
	
    // 쿠키 삭제 (쿠키 유지시간이 0인 쿠키를 만들어서 덮어쓰기)
    Cookie cookie = new Cookie(cookieName, "무의미한값");    // 공백 없는 값 넣기, 보통 빈문자열이 들어감.
    cookie.setMaxAge(0);
    response.addCookie(cookie);
    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
