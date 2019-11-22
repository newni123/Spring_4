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
	<c:import url="../layout/summernote.jsp" />
<body>
	<c:import url="../layout/nav.jsp" />
	<h1>Write</h1>
	<form action="${board}Reply" method="post">
		<div class="container">
			<input type="hidden" name="num" value="${vo.num}">
			<h1>Notice input</h1>
			<div class="form-group">
				<label for="title">title:</label> <input type="text"
					class="form-control" id="title" placeholder="Enter title"
					name="title">
			</div>
			<div class="form-group">
				<label for="writer">writer:</label> <input type="text"
					class="form-control" id="writer" placeholder="Enter writer"
					name="writer">
			</div>
			<div class="form-group">
				<label for="contents">contents:</label>
				<textarea style="height: 300px" class="form-control" id="contents"
					placeholder="Enter contents" name="contents"></textarea>
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</div>
	</form>
	<script type="text/javascript">
		$("#contents").summernote({
			height : 500
		});	
	</script>
</body>
</html>