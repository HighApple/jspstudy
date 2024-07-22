<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<% 
		// 업로드 된 파일 목록 가져오기
		String uploadPath = application.getRealPath("upload");
		File uploadDir = new File(uploadPath);
		File[] uploadFiles = uploadDir.listFiles();	// 업로드 된 파일 목록 전부 가져옴.
		
		// 가장 최근 업로드 파일명 출력
		out.println("<div>최근 업로드 파일명 : " + session.getAttribute("uploadName") + "</div>"); 
		// 세션 이용. save와 confirm이 속성으로 데이터를 주고받지 않아도 가져올 수 있는 데이터. 등록 시 꺼내 쓸 수 있음. 
		
		// 결과 화면 만들기
		for(File uploadFile : uploadFiles) {
			out.println("<div>");
			out.println("<a href=\"" + uploadFile.getPath().substring(2) + "\">" + uploadFile.getName() + "</a>"); // 절대경로 회피를 위해 루트를 제거. substring(2).
		}
	%>
	
	<!--  
		이 부분이 위의 결과화면 만들기 부분과 같이 대체될 수 있다.
	   <% for (File uploadFile : uploadFiles){ %>
	   <div>
	     <a href="<%=uploadFile.getPath()%>"><%=uploadFile.getName()%></a>
	   </div>
	   <% } %>
	-->	
	
	<hr>
	
	<div>
	<a href="<%=request.getContextPath()%>/pkg02_builtin_object/write.jsp">작성화면</a>
	</div>
	
</body>
</html>