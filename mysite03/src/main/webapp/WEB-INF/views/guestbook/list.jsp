<%-- <%@page import="com.bit2020.mysite.repository.GuestbookRepository"%>
<%@page import="java.util.List"%>
<%@page import="com.bit2020.mysite.vo.GuestbookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
		List<GuestbookVo> list = new GuestbookRepository().findAll(); 
	%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="<%=request.getContextPath()%>/assets/css/main.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="guestbook">
				<form action="<%=request.getContextPath() %>/guestbook" method="post">
					<input type="hidden" name="a" value="insert">
					<table>
						<tr>
							<td>이름</td>
							<td><input type="text" name="name"></td>
							<td>비밀번호</td>
							<td><input type="password" name="pass"></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="content" id="content"></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
					</table>
				</form>
				<ul>
					<li>
					<%
						int count = list.size();
						int index = 0;
						for(GuestbookVo vo : list){
					%>
						<table>
							<tr>
								<td><%=count - index++ %></td>
								<td><%= vo.getName() %></td>
								<td><%= vo.getReg_date() %></td>
								<td><a href="<%=request.getContextPath()%>/guestbook?a=deleteform&no=<%=vo.getNo()%>">삭제</a></td>
							</tr>
							<tr>
								<td colspan=4><%= vo.getMessage().replaceAll("\n", "<br>") %><br> 하하하하
								</td>
							</tr>
						</table> <br>
						<%
						}
						%>
					</li>
				</ul>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />

		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />

	</div>
</body>
</html> --%>