<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../layout/boot.jsp"%>
</head>
<body>
	<div class="container">
		<h1>${param.id}${result}</h1>
		<form action="./memberCheckId">
			<div class="form-group">
				<label for="id">Id:</label> <input type="text" class="form-control"
					id="id" placeholder="Enter id" name="id">
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
			<c:if test="${empty memberVO}">
				<input type="button" id="useId" value="사용하기">
			</c:if>
		</form>
	</div>
	<script type="text/javascript">
		$("#useId").click(function() {
			var id = $("id").val();

			// javascript
			//opener.document.getElementById("id").value = id;
			// jquery
			$("#id", opener.document).value(id);
			window.self.close();
		});
	</script>
</body>
</html>