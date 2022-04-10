<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- インポート部 -->
<%@ page
import="dto.LoginDTO"
import="dto.TalentDTO"
import="dto.UserDTO"
import="dto.CommentDTO"
import="java.util.List"
%>

<!-- セッション取得部 -->
<%
request.setCharacterEncoding("UTF-8");
LoginDTO loginDTO = (LoginDTO)session.getAttribute("login");
UserDTO userDTO = (UserDTO)session.getAttribute("userDTO");
TalentDTO talentDTO = (TalentDTO)session.getAttribute("talentDTO");
CommentDTO commentDTO = (CommentDTO)session.getAttribute("commentDTO");
List<UserDTO> userList = (List<UserDTO>)session.getAttribute("userList");
List<CommentDTO> commentList = (List<CommentDTO>)session.getAttribute("commentList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--
<meta http-equiv="refresh" content="1; URL=/komimiSample/Main">
-->
<title>Talent Infomation</title>
</head>
<body>
<a href="/komimi-chan-t-1/Main">メイン</a><br>
<a href="/komimi-chan-t-1/PersonMyself">マイページ</a><br>
有名人情報<br>
<br>
<form action="/komimi-chan-t-1/TalentInfoProcessSwitch" method="post">
<input  type="submit" value="purchasingPageForEach" name="select">芸能人個別購買ページ<br>
<input  type="submit" value="personOthers" name="select">personOthers<br>
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

<%} %>
</body>
</html>