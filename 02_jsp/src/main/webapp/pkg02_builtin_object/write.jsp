<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% String contextPath = request.getContextPath(); %> <!-- 주소(이름)반환 -->
	
	<form method="POST"
		  action="<%=contextPath%>/pkg02_builtin_object/save.jsp"> 
	<div>
		<label for="created-at">작성일자</label>
		<input type="text" id="created-at" valu="<%=LocalDate.now()%>" readonly>
	</div>
	<div>
		<label for="title">제목</label>
		<input type="text" id="title" name="title">
	</div>
	<div>
		<textarea rows="5" cols="50" name="contents" placeholder="내용"></textarea>
	</div>
	<div>
		<button type="submit">작성완료</button>
		<button type="reset">다시작성</button>
	</div>
	</form>

</body>
</html>