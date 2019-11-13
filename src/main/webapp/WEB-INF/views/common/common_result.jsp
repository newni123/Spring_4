<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("msg"); // request.setAttribute("msg", msg); 로 보낸걸 받아줌 (이름 일치시키기)
	String path = (String)request.getAttribute("path"); // request.setAttribute("path", "./pointList.jsp"); 로 보낸걸 받아줌
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
	alert('<%=msg%>');
	location.href = '<%=path%>';
	</script>
</body>
</html>