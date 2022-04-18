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

<a class="twitter-timeline" data-width="220" data-height="440" href="https://twitter.com/blizzard0828?ref_src=twsrc%5Etfw">Tweets by blizzard0828</a>
<script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>

<a class="twitter-timeline" data-width="220" data-height="440" href="https://twitter.com/tamahito_waters?ref_src=twsrc%5Etfw">Tweets by tamahito_waters</a>
<script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>

<blockquote class="tiktok-embed" cite="https://www.tiktok.com/@uespiiiii.1115" data-unique-id="uespiiiii.1115"  data-embed-type="creator" style="max-width: 720px; min-width: 288px;" > <section> <a target="_blank" href="https://www.tiktok.com/@uespiiiii.1115?refer=creator_embed">@uespiiiii.1115</a> </section> </blockquote> <script async src="https://www.tiktok.com/embed.js"></script>

<iframe width="560" height="315" src="https://www.youtube.com/embed/gU1KhaJIYHE" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
<iframe width="560" height="315" src="https://www.youtube.com/embed/ha8eQQm50RQ" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>



	<h1>タレント</h1>
	<%= talentDTO %><br>
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

</body>
</html>