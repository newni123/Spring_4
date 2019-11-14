<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:import url="../layout/nav.jsp"/>
<c:import url="../layout/boot.jsp"/>
<link href=<c:url value="../css/layout.css"/> rel="stylesheet">
<link href=<c:url value="../css/reset.css"/> rel="stylesheet">
<body>
	<h1>Update</h1>
	<div class="container">
		<h1>${board} Update</h1>
		<form action="./${board}Update" method="post" id="form">
			<input type ="text" name= "num" value ="${vo.num}" hidden="true">
			<div class="form-group">
				<label for="title">title:</label> <input type="text"
					class="form-control" id="title" placeholder="Enter title"
					name="title" value="${vo.title}">
			</div>
			<div class="form-group">
				<label for="writer">writer:</label> <input type="text"
					class="form-control" id="writer" placeholder="Enter writer"
					name="writer" value="${vo.writer}" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="contents">contents:</label>
				<textarea class="form-control" id="contents"  style="height: 300px"
					placeholder="Enter contents" name="contents">${vo.contents}</textarea>
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
</body>
</html>