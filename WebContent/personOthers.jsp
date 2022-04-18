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
UserDTO userDTO = (UserDTO)session.getAttribute("userDTO");
TalentDTO talentDTO = (TalentDTO)session.getAttribute("talentDTO");
CommentDTO commentDTO = (CommentDTO)session.getAttribute("commentDTO");
List<TalentDTO> talentList = (List<TalentDTO>)session.getAttribute("talentList");
List<CommentDTO> commentList = (List<CommentDTO>)session.getAttribute("commentList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--
<meta http-equiv="refresh" content="1; URL=/komimiSample/Main">
-->
<title>PersonOthers</title>
</head>
<body>
<a href="/komimi-chan-t-1/PersonMyself">マイページ</a><br>
<a href="/komimi-chan-t-1/Main">戻る</a>
おすすめユーザー<br>
<br>
<form action="/komimi-chan-t-1/PersonOthersProcessSwitch" method="post">
<input  type="submit" value="talentInfo" name="select">talentInfo<br>
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

	<!--タレントリスト表示 -->
	<h1>タレントリスト</h1>
	<%for(TalentDTO talent:talentList){ %>
	<%= talent %><br>
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