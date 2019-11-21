<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:import url="../layout/nav.jsp" />
<c:import url="../layout/boot.jsp" />
<link href=<c:url value="../css/layout.css"/> rel="stylesheet">
<link href=<c:url value="../css/reset.css"/> rel="stylesheet">
<body>
	<h1>Update</h1>
	<div class="container">
		<h2>${fn:toUpperCase(board) }Update</h2>
		<form action="./${board}Update" method="post" id="form" enctype="multipart/form-data">
			<input type="text" name="num" value="${vo.num}" hidden="true">
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
				<textarea class="form-control" id="contents" style="height: 300px"
					placeholder="Enter contents" name="contents">${vo.contents}</textarea>
			</div>
				<div id="files" class="form-group">
				<div class="form-group">
					<label for="image">file:</label> <input type="file" name="file"
						class="form-control" id="file">
					<div>
						<input type="button" name="del"
							class="form-control btn btn-danger del" value="del">
					</div>
				</div>
			</div>
			
			<input type="button" class="btn btn-success" value="Add File"
				id="btn">
			<button type="submit" class="btn btn-default">Submit</button>
			
			<c:forEach items="${vo.files}" var="file">
				<div id="f${file.fnum}" class="form-group">
						<p>${file.oname}<input type="button" name="del" id="${file.fnum}" 
								class="form-control btn btn-danger del_file" value="del"></p>
				</div>
			</c:forEach>
		</form>
		<script type="text/javascript">
			var files = $("#files").html();
			$("#files").empty();
			var count = ${fn:length(vo.files)};
			$("#btn").click(function() {
				if (count < 5) {
					$("#files").append(files);
					count++;
				} else
					alert('첨부파일은 5개까지 추가 가능합니다');
			});
			$('#files').on("click", ".del", function() {
	 			$(this).parent().parent().remove();
				count--;
			});
			$('.del_file').click(function() { // 이미 div가 뿌려져있기 때문에 이벤트 위임 안써도 됨
				var fnum = $(this).attr("id");
				$.post("./fileDelete", {fnum : fnum}, function(data) { // {fnum(파라미터이름):fnum(위에 선언한 변수)} -> 둘이 이름은 같지만 다름 !!
					data = data.trim(); // 공백제거 꼭 하기
					if (data == '1') {
						$("#f" + fnum).remove();
						count--;
					}
					alert(data);
					console.log();
				});
			});
		</script>
	</div>
</body>
</html>