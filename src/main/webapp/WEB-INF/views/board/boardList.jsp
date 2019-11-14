<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="../layout/boot.jsp" />
</head>
<c:import url="../layout/nav.jsp" />
<h1 class="pad">
	<a href="">${board}</a>
</h1>
<br />
<div class="container">
	<form action="boardList" id="frm">
		<div>
			<input type="hidden" value="1" id="curPage" name="curPage"> <select
				name="kind">
				<option id="kindSubject" value="kindSubject">Subject</option>
				<option id="kindContents" value="kindContents">Contents</option>
				<option id="kindWrite" value="kindWrite">Write</option>
			</select> <input type="text" name="search" value="${pager.search}">
			<button>검색</button>
		</div>
		<table class="table table-hover">
			<thead>
				<tr class="head">
					<th class=no style="text-align: center;">NO</th>
					<th class=sub style="text-align: center;">SUBJECT</th>
					<th class=name style="text-align: center;">WRITE</th>
					<th class=date style="text-align: center;">DATE</th>
					<th class=hit style="text-align: center;">HIT</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="vo">
					<tr>
						<td style="text-align: center;">${vo.num}</td>
						<!--<c:catch>
						<c:if test="${board ne 'notice'}">-->
						<td style="text-align: center;"><a
							href="./noticeSelect?num=${vo.num}">${vo.title}</a></td>
						<!--</c:if></c:catch>-->
						<td style="text-align: center;">${vo.writer}</td>
						<td style="text-align: center;">${vo.reg_date}</td>
						<td style="text-align: center;">${vo.hit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<ul class="pagination">
				<c:if test="${pager.curBlock gt 1}">
					<li><span id="${pager.startNum-1}" class="list">이전</span></li>
				</c:if>
				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
					<li><span id="${i}" class="list">${i}</span></li>
				</c:forEach>
				<c:if test="${pager.curBlock lt pager.totalBlock}">
					<li><span id="${pager.lastNum+1}" class="list">다음</span></li>
				</c:if>
			</ul>
		</div>
		<a href="boardWrite">Write</a>
		<script type="text/javascript">
			var kind = '${pager.kind}';
			if (kind == '')
				kind = "kindSubject";
			$("#" + kind).prop("selected", true);
			$(".list").click(function() {
				$("#curPage").val($(this).attr("id"));
				$("#frm").submit();
			});
		</script>
	</form>
</div>
</body>
</html>