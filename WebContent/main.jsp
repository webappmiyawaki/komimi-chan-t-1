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
List<TalentDTO> talentList = (List<TalentDTO>)session.getAttribute("talentList");
List<UserDTO> userList = (List<UserDTO>)session.getAttribute("userList");
List<CommentDTO> commentList = (List<CommentDTO>)session.getAttribute("commentList");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
</head>
<body>
メイン画面<br>
<br>
<a href="/komimi-chan-t-1/PersonMyself">マイページ</a><br>
<a href="/komimi-chan-t-1/Logout">ログアウト</a><br>
<form action="/komimi-chan-t-1/MainProcessSwitch" method="post">
<input  type="submit" value="personOthers" name="select">personOthers<br>
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

	<h1>タレント</h1>
	<%= talentDTO %><br>
	<br>

	<h1>コメント</h1>
	<%= commentDTO %><br>
	<br>

	<!--タレントリスト表示 -->
	<h1>タレントリスト</h1>
	<%for(int i=0;i<4;i++){ %>
	<img src="<%= request.getContextPath()+"/img/" + talentList.get(i).getTalentImdAddress() %>" width="150"><br>
	<%= "名前："+talentList.get(i).getTalentName() %><br>
	<%= "コンビ名："+talentList.get(i).getTalentGroupName() %><br>
	<%= "お気に入り数："+talentList.get(i).getTalentFavoriteCount() %>
	<br><br>
	<%} %>
	<br>



	<!--タレントリスト表示 -->
	<h1>タレントリスト</h1>
	<%for(TalentDTO talent:talentList){ %>
	<img src="<%= request.getContextPath()+"/img/" + talent.getTalentImdAddress() %>" width="150"><br>
	<%= "名前："+talent.getTalentName() %><br>
	<%= "コンビ名："+talent.getTalentGroupName() %><br>
	<%= "お気に入り数："+talent.getTalentFavoriteCount() %>
	<br><br>
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

	<br>
<%} %>

</body>
</html>