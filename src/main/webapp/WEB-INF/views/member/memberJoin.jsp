<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../layout/boot.jsp" %>
</head>
<body>
<%@ include file="../layout/nav.jsp" %>
	<div class="container">
		<h2>SignIn</h2>
		<form action="memberJoin" method="post" id="form">
			<div class="form-group">
				<label for="id">아이디:</label> <input type="text" class="form-control"
					id="id" name="id" required = "required">
				<p id="input_id" class="btn_check"></p>
				<input type="button" value="중복확인"> 
			</div>
			<div class="form-group">
				<label for="pw">비밀번호:</label> <input type="password"
					class="form-control" id="pw" name="pw" required = "required">
				<p id="input_pw" class="btn_check"></p>
			</div>
			<div class="form-group">
				<label for="pwCheck">비밀번호 확인:</label> <input type="password"
					class="form-control" id="pwCheck" name="pwCheck" required = "required">
				<p id="input_pwCheck" class="btn_check"></p>
			</div>
			<div class="form-group">
				<label for="name">이름:</label> <input type="text"
					class="form-control" id="name1" name="name" required = "required">
				<p id="input_name1" class="btn_check"></p>
			</div>
			<div class="form-group">
				<label for="email">이메일:</label> <input type="email"
					class="form-control" id="email" name="email" required = "required">
				<p id="input_email" class="btn_check"></p>
			</div>
			<div class="form-group">
				<label for="phone">연락처:</label> <input type="tel"
					class="form-control" id="phone" name="phone" required = "required">
				<p id="input_phone" class="btn_check"></p>
			</div>
			<div class="form-group">
				<label for="birth">생일:</label> 
				 <select name="year">
					<c:forEach begin="1920" end="2019" var="year">
						<option>${year}</option>
					</c:forEach>
				</select>
				<b>년</b>
				<select name="month">
					<c:forEach begin="1" end="12" var="month">
						<option>${month}</option>
					</c:forEach>
				</select>
				<b>월</b>
				<select name="date">
					<c:forEach begin="1" end="30" var="date">
						<option>${date}</option>
					</c:forEach>
				</select>
				<b>일</b> 
			</div>
			<div class="form-group">
			<label for="gender">성별:</label> 
				<input type="radio" value="M" name="gender" checked="checked">남
				<input type="radio" value="F" name="gender">여
			</div>
			<button type="submit" class="btn btn-default">SignIn</button>
		</form>
	</div>
	<script type="text/javascript">
		$("#id").blur(function() {
			if ($("#id").val() == "") {
				input_id.innerText = "아이디를 입력하세요.";
				id.style.border = "1px solid red";
			} else if ($("#id").val().length < 6) {
				input_id.innerText = "6자리 이상 입력하세요.";
				id.style.border = "1px solid red";
			} else {
				input_id.innerText = "";
				id.style.border = "1px solid #ccc";
			}
		});
		$("#pw").blur(function() {
			if ($("#pw").val() == "") {
				input_pw.innerText = "비밀번호를 입력하세요.";
				pw.style.border = "1px solid red";
			} else if ($("#pw").val().length < 8) {
				input_pw.innerText = "8자리 이상 입력하세요.";
				pw.style.border = "1px solid red";
			} else {
				input_pw.innerText = "";
				pw.style.border = "1px solid #ccc";
			}
		});
		$("#pw").change(function() {
			pwCheck.style.border = "1px solid #ccc";
			pwCheck.value = "";
			input_pwCheck.innerText = "";
		});
		$("#pwCheck").blur(function() {
			if ($("#pw").val() != $("#pwCheck").val() || $("#pw").val().length < 8){
				input_pwCheck.innerText = "비밀번호가 일치하지 않습니다";
				pwCheck.style.border = "1px solid red";
			}
			else{
				input_pwCheck.innerText = "";
				pwCheck.style.border = "1px solid #ccc";
			}
		})
		$("#name1").blur(function() {
			if ($("#name1").val() == "") {
				input_name1.innerText = "이름을 입력하세요.";
				name1.style.border = "1px solid red";
			}
			else {
				input_name1.innerText = "";
				name1.style.border = "1px solid #ccc";
			}
		})
		$("#email").blur(function() {
			if ($("#email").val() == "") {
				input_email.innerText = "이메일을 입력하세요.";
				email.style.border = "1px solid red";
			}
			else {
				input_email.innerText = "";
				email.style.border = "1px solid #ccc";
			}
		})
		$("#phone").blur(function() {
			if ($("#phone").val() == "") {
				input_phone.innerText = "전화번호를 입력하세요.";
				phone.style.border = "1px solid red";
			}
			else {
				input_phone.innerText = "";
				phone.style.border = "1px solid #ccc";
			}
		})
	</script>
</body>
</html>