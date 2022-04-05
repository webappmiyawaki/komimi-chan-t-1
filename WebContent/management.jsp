<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- インポート部 -->
<%@ page
import="dto.LoginDTO"
import="dto.TalentDTO"
import="dto.UserDTO"
import="dto.CommentDTO"
import="dto.RequestDTO"
import="java.util.List"
%>

<!-- セッション取得部 -->
<%
request.setCharacterEncoding("UTF-8");
LoginDTO loginDTO = (LoginDTO)session.getAttribute("login");
UserDTO userDTO = (UserDTO)session.getAttribute("userDTO");
TalentDTO talentDTO = (TalentDTO)session.getAttribute("talentDTO");
CommentDTO commentDTO = (CommentDTO)session.getAttribute("commentDTO");
RequestDTO requestDTO = (RequestDTO)session.getAttribute("requestDTO");
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
<title>Management</title>
</head>
<body>
管理画面<br>
<br>
<form action="/komimi-chan-t-1/ManagementProcessSwitch" method="post">
<input  type="submit" value="main" name="select">main<br>
<input  type="submit" value="personMyself" name="select">personMyself<br>
<input  type="submit" value="personOthers" name="select">personOthers<br>
<input  type="submit" value="management" name="select">management<br>
<input  type="submit" value="signup" name="select">signup<br>
<input  type="submit" value="talentInfo" name="select">talentInfo<br>
<input  type="submit" value="reset" name="select">reset
</form>
<br>
<%
if(loginDTO==null||loginDTO.getId()==""){
%>
何も表示されません。
<%}else{ %>
<br>
	<h1>ログイン</h1>
	<%= loginDTO %><br>
	<br>

	<h1>ユーザー</h1>
	<%= userDTO %><br>
	<br>

	<h1>タレント</h1>
	<%= talentDTO %><br>
	<br>

	<h1>コメント</h1>
	<%= commentDTO %><br>
	<br>

	<h1>リクエスト</h1>
	<%= requestDTO %><br>
	<br>

	<!--タレントリスト表示 -->
	<h1>タレントリスト</h1>
	<%for(TalentDTO talent:talentList){ %>
	<%= talent %><br>
	<%} %>
	<br>

	<!--ユーザーリスト表示 -->
	<h1>ユーザーリスト</h1>
	<%for(UserDTO user:userList){ %>
	<%= user %><br>
	<%} %>
	<br>

	<!--コメントリスト表示 -->
	<h1>コメントリスト</h1>
	<%for(CommentDTO comment:commentList){ %>
	<%= comment %><br>
	<%} %>
	<br>

	<!--リクエストリスト表示 -->
	<h1>リクエストリスト</h1>
	<%for(RequestDTO requestUnit:requestList){ %>
	<%= requestUnit %><br>
	<%} %>
	<br>
<%} %>
</body>
</html>