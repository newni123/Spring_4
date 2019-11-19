<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../layout/boot.jsp"%>
<style type="text/css">
.nonepass {
	color: red;
}

.pass {
	color: black;
}
</style>
</head>
<body>
	<%@ include file="../layout/nav.jsp"%>
	<div class="container">
		<h2>SignIn</h2>
		<form action="memberJoin" method="post" id="form" enctype="multipart/form-data">
			<div class="form-group">
				<label for="id">아이디:</label> <input type="text" class="form-control"
					id="id" name="id" required="required">
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
					class="form-control" id="name1" name="name" required="required">
				<p id="input_name1" class="btn_check"></p>
			</div>
			<div class="form-group">
				<label for="email">이메일:</label> <input type="email"
					class="form-control" id="email" name="email" required="required">
				<p id="input_email" class="btn_check"></p>
			</div>
			<div class="form-group">
				<label for="birth">생일:</label> <input type="date"
					class="form-control" id="birth" name="birth" required="required">
				<%--  <select name="year">
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
				<b>일</b>  --%>
			</div>
			<div class="form-group">
				<label for="gender">성별:</label> <input type="radio" value="M"
					name="gender" checked="checked">남 <input type="radio"
					value="F" name="gender">여
			</div>
			<div class="form-group">
				<label for="file">파일:</label> <input type="file"
					class="form-control" id="file" name="file" required="required">
				<p id="input_file" class="btn_check"></p>
			</div>
			<!-- <button type="submit" class="btn btn-default">SignIn</button> -->
			<input type="button" class="btn btn-default" value="Join" id="join">
		</form>
	</div>
	<script type="text/javascript">
		var idCheck = false; // 아이디 중복검사했는지 체크용 false : 중복 / true : 중복되지않음
		var pwEachCheck = false; // 비밀번호 일치검사
		var emailCheck = false; // 이메일 중복검사 여부 
		var nameCheck = false;	// 이름 null 여부 검사
		$("#join").click(function() {
		/* 	alert('사용가능아이디: ' + idCheck);
			alert('비밀번호 일치여부: ' + pwEachCheck);
			alert('이름 작성 여부: ' + nameCheck);
			alert('사용가능이메일: ' + emailCheck); */
			if (idCheck && pwEachCheck && emailCheck && nameCheck){
				$("#form").submit();
			}
		});
		$("#id").blur(function() {
			var id = $(this).val();
			$.post("./member_Check_Test", {id : id}, function(data) {
				data = data.trim();
				if ($("#id").val() == "") {
					$("#input_id").text("아이디를 입력하세요.");
				} else if ($("#id").val().length < 4) {
					$("#input_id").text("4자리 이상 입력하세요.");
				} else if (data == 'pass') {
					$("#input_id").text('사용가능한 ID');
					$("#input_id").attr("class", "pass");
					idCheck = true;
				} else {
					$("#input_id").text('중복된 ID');
					$("#input_id").attr("class", "nonepass");
					$("#id").val("");
					$("#id").focus();
					idCheck = false;
				}

			});
		});
		$("#pw").blur(function() {
			if ($("#pw").val() == "") {
				$("#input_pw").text("비밀번호를 입력하세요.");
				pw.style.border = "1px solid red";
			} else if ($("#pw").val().length < 4) {
				$("#input_pw").text("4자리 이상 입력하세요.");
				pw.style.border = "1px solid red";
			} else {
				$("#input_pw").text("");
				pw.style.border = "1px solid #ccc";
			}
		});
		$("#pw").change(function() {
			pwCheck.style.border = "1px solid #ccc";
			$("#pwCheck").val("");
			$("#input_pw").text("");
		});
		$("#pwCheck").blur(
				function() {
					if ($("#pw").val() != $("#pwCheck").val()
							|| $("#pw").val().length < 4) {
						$("#input_pwCheck").text("비밀번호가 일치하지 않습니다");
						pwCheck.style.border = "1px solid red";
						pwEachCheck = false;

					} else {
						$("#input_pwCheck").text("");
						pwCheck.style.border = "1px solid #ccc";
						pwEachCheck = true;
					}
				})
		$("#name1").blur(function() {
			if ($("#name1").val() == "") {
				$("#input_name1").text("이름을 입력하세요.");
				name1.style.border = "1px solid red";
				nameCheck=false;
			} else {
				$("#input_name1").text("");
				name1.style.border = "1px solid #ccc";
				nameCheck=true;
			}
		})
			
		$("#email").blur(function() {
			var email = $(this).val();
			$.post("./emailCheck", {email : email}, function(data) {
				data = data.trim();
				if ($("#email").val() == "") {
					$("#input_email").text("이메일을 입력하세요.");
				} else if (data == 'pass') {
					$("#input_email").text('사용가능한 email');
					$("#input_email").attr("class", "pass");
					emailCheck = true;
				} else {
					$("#input_email").text('중복된 email');
					$("#input_email").attr("class", "nonepass");
					$("#email").val("");
					$("#email").focus();
					emailCheck = false;
				}

			});
		});
		$("#phone").blur(function() {
			if ($("#phone").val() == "") {
				$("#input_phone").text("전화번호를 입력하세요.");
				phone.style.border = "1px solid red";
			} else {
				$("#input_phone").text("");
				phone.style.border = "1px solid #ccc";
			}
		})
		$("#checkId").click(
				function() {
					var id = $("#id").val();
					window.open("./memberCheckId?id=" + id, "",
							"width=400px,height=200px,left=400px,top=200px");
				});// 콜백 함수
	</script>
</body>
</html>