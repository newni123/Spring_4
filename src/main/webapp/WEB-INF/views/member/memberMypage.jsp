<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../layout/boot.jsp"%>
</head>
<body>
	<%@ include file="../layout/nav.jsp"%>
	<div class="container">
		<h2>Update</h2>
		<form action="memberMypage" method="post" id="form">
			<div class="form-group">
				<label for="id">아이디:</label> <input type="text" class="form-control"
					id="id" name="id" required="required" readonly="readonly"
					value="${memberVO.id}">
				<p id="input_id" class="btn_check"></p>
			</div>
			<div class="form-group">
				<label for="pw">비밀번호:</label> <input type="password"
					class="form-control" id="pw" name="pw" required="required">
				<p id="input_pw" class="btn_check"></p>
			</div>
			<div class="form-group">
				<label for="pwCheck">비밀번호 확인:</label> <input type="password"
					class="form-control" id="pwCheck" name="pwCheck"
					required="required">
				<p id="input_pwCheck" class="btn_check"></p>
			</div>
			<div class="form-group">
				<label for="name">이름:</label> <input type="text"
					class="form-control" id="name1" name="name" required="required"
					value="${memberVO.name}">
				<p id="input_name1" class="btn_check"></p>
			</div>
			<div class="form-group">
				<label for="email">이메일:</label> <input type="email"
					class="form-control" id="email" name="email" required="required"
					value="${memberVO.email}">
				<p id="input_email" class="btn_check"></p>
			</div>
			<div class="form-group">
				<label for="birth">생일:</label> <input type="date"
					class="form-control" id="birth" name="birth" required="required" value="${memberVO.birth}">
			</div>
			<div class="form-group">
				<label for="gender">성별:</label> <input type="radio" value="M"
					name="gender" checked="checked" id="male">남 <input type="radio"
					value="F" name="gender" id="female">여
			</div>
			<button type="submit" class="btn btn-default">수정</button>
			<a href="memberDelete">탈퇴</a>
		</form>
		
	</div>
	<script type="text/javascript">
		
		if("${memberVO.gender}" == "M")
			$("#male").prop("checked",true);
		else
			$("#female").prop("checked",true);
			
	</script>
</body>
</html>