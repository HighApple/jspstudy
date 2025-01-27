package pkg09_bind;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DataBind1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	     /*
	       * 데이터 저장 영역
	       * 
	       * 1. ServletContext      : 컨텍스트 종료(애플리케이션 실행 종료) 전까지 데이터를 유지한다. 
	       * 2. HttpSession         : 세션 종료(웹 브라우저 종료) 전까지 데이터를 유지한다.
	       * 3. HttpServletRequest  : 요청 종료(응답) 전까지 데이터를 유지한다.  (주로 이게많이 쓰임)
	       * 
	       * 일회성 저장은 HttpServletRequest
	       * 다회성 저장은  HttpSession  그리고 Cookie
	       *               서버에 저장되는 HttpSession 로그인 정보같은 민감한 정보가
	       *               클라이언트 PC에 저장되는 Cookie는 보안이 중요하지 않은 정보가 들어감
	       */
	      
	      /*
	       * 데이터 처리 메소드(2, 3번이 중요)
	       * 
	       * 1. setAttribute(속성, 값)  : Object 타입의 값을 저장한다.
	       * 2. getAttribute(속성)      : Object 타입의 값을 반환한다. (캐스팅이 필요할 수 있다.)
	       * 3. removeAttribute(속성)   : 제거한다.
	       */
	    
	    // ServletContext에 데이터 저장하기
	    ServletContext servletContext = request.getServletContext();
	    servletContext.setAttribute("a", "전체방문자수");
	    
	    // 데이터로 확인 페이지 이동하기
	    response.sendRedirect("/servlet/dataConfirm");
	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
