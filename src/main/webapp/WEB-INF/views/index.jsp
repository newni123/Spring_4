<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<c:import url="./layout/boot.jsp" />
<c:import url="./layout/summernote.jsp" />
</head>
<body>
	<c:import url="./layout/nav.jsp" />
	<h1>Hello world!</h1>
	<div id= "editor"></div>
	<script type="text/javascript">
		$("#editor").summernote();
	</script>
	<P>The time on the server is ${serverTime}.</P>
</body>
</html>
