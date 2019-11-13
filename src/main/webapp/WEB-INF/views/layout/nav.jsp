<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/">WebSiteName</a> <!-- 컨텍스트패스가 루트 경로 뽑아와줌(이름을바꾸더라도 동일하게적용되게함) -->
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="#">Home</a></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="${pageContext.request.contextPath}/">Point <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="${pageContext.request.contextPath}/point/pointList.jsp">Page 1-1</a></li>
					<li><a href="#">Page 1-2</a></li>
					<li><a href="#">Page 1-3</a></li>
				</ul></li>
			<li><a href="<%= request.getContextPath()%>/notice/noticeList">Notice</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
		
				<li><a href="${pageContext.request.contextPath}/member/memberMypage.jsp"><span
						class="glyphicon glyphicon-user"></span> MyPage</a></li>
				<li><a href="${pageContext.request.contextPath}/member/memberLogout.jsp"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a></li>
			
				<li><a href="${pageContext.request.contextPath}/member/memberJoinForm.jsp"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="${pageContext.request.contextPath}/member/memberLoginForm.jsp"><span
				class="glyphicon glyphicon-log-in"></span> Login</a></li>
			
		</ul>
	</div>
</nav>
