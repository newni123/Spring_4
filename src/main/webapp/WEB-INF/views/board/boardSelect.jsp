<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:import url="../layout/boot.jsp" />
<link href="../css/layout.css" rel="stylesheet" />
<link href="../css/reset.css" rel="stylesheet" />
<body>
	<c:import url="../layout/nav.jsp" />
	<section>
		<h1 class="pad">
			<a href="./${board}List">${board}</a>
		</h1>
		<br />
		<table class="t1">
			<tr class="head">
				<td class="sub" style="text-align: center;">SUBJECT</td>
				<td class="name" style="text-align: center;">NAME</td>
				<td class="date" style="text-align: center;">DATE</td>
				<td class="hit" style="text-align: center;">HIT</td>
			</tr>
			<tr>
				<td>${vo.title}</td>
				<td>${vo.writer}</td>
				<td>${vo.reg_date}</td>
				<td>${vo.hit}</td>
			</tr>
			<tr>
				<td colspan="4" class="contents">${vo.contents}</td>
			</tr>
			<tr>
				<td colspan="5">
					<a href="${board}Update?num=${vo.num}"style="float: right; margin-right: 20px;">Update</a>
					<a href="${board}Reply?num=${vo.num}" style="float: right; margin-right: 20px;">Reply</a>
					<a href="${board}Delete?num=${vo.num}" id="del" style="float: left; margin-left: 20px;">Delete</a>
				</td>
			</tr>
		</table>
	</section>
</body>
</html>