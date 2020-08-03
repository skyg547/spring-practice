<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/gb" method="post">
		<input type="hidden" name="a" value="add">
		<table border=1 width=500>
			<tr>
				<td>이름</td><td><input type="text" name="name" value=""></td>
				<td>비밀번호</td><td><input type="password" name="password" value=""></td>
			</tr>
			<tr>
				<td colspan=4><textarea name="message" cols=60 rows=5></textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE="등록"></td>
			</tr>
		</table>
	</form>
	<c:set var="count" scope="page" value =""/>
	<c:set var="index" scope="page" value ="0"/>
	
	
	<%
		int count = list.size();
		int index = 0;
		for(GuestbookVo vo : list){
	%>
	<c:>
			<br>
			<table width=510 border=1>
				<tr>
					<td>[<%=count-index++ %>]</td>
					<td><%=vo.getName() %></td>
					<td><%=vo.getRegDate() %></td>
					<td><a href="<%=request.getContextPath()%>/gb?a=deleteform&no=<%=vo.getNo()%>">삭제</a></td>
				</tr>
				<tr>
					<td colspan=4>
						<%=vo.getMessage().replaceAll("\n", "<br>") %>
					</td>
				</tr>
			</table>
	<%
		}
	%>	
	
</body>
</html>