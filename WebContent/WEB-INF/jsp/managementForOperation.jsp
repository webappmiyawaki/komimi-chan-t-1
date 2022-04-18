<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- インポート部 -->
<%@ page
import="dto.LoginDTO"
import="dto.TalentDTO"
import="dto.UserDTO"
import="dto.CommentDTO"
import="dto.RequestDTO"
import="dto.ProductDTO"
import="dto.HistoryDTO"
import="java.util.List"
%>

<!-- セッション取得部 -->
<%
request.setCharacterEncoding("UTF-8");
LoginDTO loginDTO = (LoginDTO)session.getAttribute("login");
CommentDTO commentDTO = (CommentDTO)session.getAttribute("commentDTO");
List<TalentDTO> talentList = (List<TalentDTO>)session.getAttribute("talentList");
List<UserDTO> userList = (List<UserDTO>)session.getAttribute("userList");
List<CommentDTO> commentList = (List<CommentDTO>)session.getAttribute("commentList");
List<RequestDTO> requestList = (List<RequestDTO>)session.getAttribute("requestList");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--
<meta http-equiv="refresh" content="1; URL=/komimiSample/Main">
-->
<title>運営用Management</title>
</head>
<body>
運営用管理画面<br>
<a href="/komimi-chan-t-1/Logout">ログアウト</a><br>
<br>
<form action="/komimi-chan-t-1/SignupForTalentInfo" method="post">
<input  type="submit" value="情報追加" name="select">
</form>
<br>

<br>
<br>
<br>
<%
for(RequestDTO requestDTO:requestList){
%>
<form>
	<tr>
	<td><input type="radio" name="request_id" value=<%= requestDTO.getUserId() %>>
	</td>
	<td><%= requestDTO.getUserId() %></td>
	<td><%= requestDTO.getRequestText() %></td>
	</tr>
	<input type="submit" value="削除" name="baseProcessName">
</form>
<%} %>
</body>
</html>