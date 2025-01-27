<%@page import="java.util.List"%>
<%@page import="pkg05_JSTL.Post"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--
  <c:forEach>
  1. 일반 for 문과 향상 for 문을 모두 처리할 수 있다.
  2. 일반 for 문 형식
    <c:forEach var="속성" begin="시작값" end="종료값" step="증가값">
      ${속성}
    </c:forEach>
  3. 향상 for 문 형식
    <c:forEach var="요소" items="배열/리스트" varStatus="vs">
      저장데이터 : ${요소}
      인덱스     : ${vs.index}
      인덱스+1 : ${vs.count}     인덱스는 1부터 시작
    </c:forEach>
 --%>
 
 <%-- 일반 for 문 (수열) --%>
 <c:forEach var="number" begin="1" end="5" step="1">
    <div>${number}</div>
 </c:forEach>
 
 <%-- 향상 for 문 (배열) --%>
 <% pageContext.setAttribute("seasons", new String[]{"spring","summer","autumn","winter"});%>
 <c:forEach var="season" items="${seasons}" varStatus="vs">
   <div>${season} / ${vs.index} / ${vs.count}</div>
 </c:forEach>

<%-- 향상 for 문 (리스트) --%>
<%pageContext.setAttribute("hobbies", Arrays.asList("travel","cook","fitness","game")); %>
<c:forEach var="hobby" items="${hobbies}" varStatus="vs">
<div>${hobby}/${vs.index}/${vs.count}</div>
</c:forEach>
<%List <Post> posts = Arrays.asList(new Post("aa1","aa2","aa3"), new Post("bb1","bb2","bb3"), new Post("cc1","cc2","cc3")); 
request.setAttribute("posts", posts);
%>

<c:forEach var="post" items="${requestScope.posts}" varStatus="vs">
<div>
<span>${vs.count}</span>
<span>${post.title}</span>
<span>${post.reporter}</span>
<span>${post.createdAt}</span>
</div>
</c:forEach>

</body>
</html>