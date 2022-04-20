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
List<UserDTO> personOthersList = (List<UserDTO>)session.getAttribute("personOthersList");
List<CommentDTO> commentList = (List<CommentDTO>)session.getAttribute("commentList");
List<CommentDTO> commentTalentList = (List<CommentDTO>)session.getAttribute("commentTalentList");

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
<form action="/komimi-chan-t-1/PurchasingPageForEach" method="post">
<input  type="submit" value="purchasingPageForEach" name="select">芸能人個別購買ページ<br>
</form>
<br>

	<h1>タレント</h1>
	<img src="<%= request.getContextPath()+"/img_talent/" + talentDTO.getTalentImgAddress() %>" width="150"><br>
	名前：<%= talentDTO.getTalentName() %><br>
	コンビ名：<%= talentDTO.getTalentGroupName() %><br>
	出身地：<%= talentDTO.getTalentBirthPlace() %><br>
	血液型：<%= talentDTO.getTalentBloodType() %><br>
	お気に入り数：<%= talentDTO.getTalentFavoriteCount() %><br>
	Twitter：<%= talentDTO.getTwitterAddress() %><br>
	Youtube：<%= talentDTO.getYoutubeAddress() %><br>
	<br>
<br>
<br>
twitter<br>
<a class="twitter-timeline"
data-width="560"
data-height="440"
href="https://twitter.com/<%= talentDTO.getTwitterAddress() %>?ref_src=twsrc%5Etfw">
</a>
<script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>
<br>
<br>
<br>
youtube<br>
<iframe width="560" height="315"
src="https://www.youtube.com/embed/<%= talentDTO.getYoutubeAddress() %>"
title="YouTube video player"
frameborder="0"
allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen>
</iframe>

	Tiktok:<%= talentDTO.getTiktokAddress() %><br>

	<!--コメントリスト表示 -->
	<h1>コメントリスト</h1>
	<%int counter=0; %>
	<%for(CommentDTO comment:commentTalentList){ %>
	<p>
	<%="コメント "+ counter+"." %><br>
	<%= comment.getComment() %></p>
	<% counter++;%>
	<% } %>
	<br>

</body>
</html>