<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <jsp:include page="header.jsp">
     <jsp:param value="메인1" name="title"/>
   </jsp:include>
	
	<h1>main1</h1>

<!--  
<%
  request.setCharacterEncoding("UTF-8");
  String title = request.getParameter("title");
%>

<title><%=title%></title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/header.css?dt=<%=System.currentTimeMillis()%>">
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/body.css?dt=<%=System.currentTimeMillis()%>">
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/footer.css?dt=<%=System.currentTimeMillis()%>">

</head>
<body>

	<div class="header-wrap">
	   	<div>
	    <a href="<%=request.getContextPath()%>/pkg03_include/main1.jsp">main1</a>
	    <a href="<%=request.getContextPath()%>/pkg03_include/main2.jsp">main2</a>
	    </div>  
	</div>
	
	<div class="body-wrap">	
	-->
	
	  <%--
    <%@ include %> 지시어
    내용이 변하지 않는 정적 페이지를 포함할 때 사용한다.
   --%>  
  	<%@ include file="footer.jsp" %>  <!-- 동일한 폴더에 존재하는 경우 파일이름만으로도 접근할 수 있다. -->
	
	<%--
    <jsp:include> 액션 태그
    내용이 변하는 동적 페이지를 포함할 때 사용한다. (파라미터 전달이 가능하다.)
   --%>

	
	<!--  
  	</div>
  	
	<div class="footer-wrap">
	  <div>Copyright ABC</div>
	</div>
	-->
		
	
</body>
</html>