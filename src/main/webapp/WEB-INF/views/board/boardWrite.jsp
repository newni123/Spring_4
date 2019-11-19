<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../layout/nav.jsp" />
	<c:import url="../layout/boot.jsp" />
	<h1>Write</h1>
	<form action="${board}Write" method="post"
		enctype="multipart/form-data">
		<div class="container">
			<h1>Notice input</h1>
			<div class="form-group">
				<label for="title">titled:</label> <input type="text"
					class="form-control del" id="title" placeholder="Enter title"
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
			<div id="files" class="form-group">
				<div class="form-group ">
					<label for="image">file:</label> <input type="file" name="file"
						class="form-control" id="file">
				</div>
				<div>
					<input type="button" name="del"
						class="form-control btn btn-danger del" value="del">
				</div>
			</div>
			<input type="button" class="btn btn-success" value="Add File"
				id="btn">
			<button type="submit" class="btn btn-default">Submit</button>
		</div>
	</form>
	<script type="text/javascript">
		var files = $("#files").html(); // 이벤트 태그 안에 넣으면 처음클릭시 1개.. 두번째 클릭시 2개.. 세번째 클릭시 4개.. 이런식으로 늘어남
		var count = 0;
		$("#files").empty();
		$("#btn").click(function() {
			if (count < 5) {
				$("#files").append(files);
				count++;
				$("#files > div").addClass('num' + count);
			} else
				alert('첨부파일은 5개까지 추가 가능합니다');

		});

		$('#files').on("click", ".del", function() {
			alert('test')
			$(".num"+count-1).remove();
			count--;
		});
	</script>
</body>
</html>