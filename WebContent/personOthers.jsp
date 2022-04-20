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
UserDTO personOthers = (UserDTO)session.getAttribute("personOthersDTO");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>PersonOthers</title>
</head>
<body>
<a href="/komimi-chan-t-1/PersonMyself">マイページ</a><br>
<a href="/komimi-chan-t-1/Main">戻る</a>
おすすめユーザー<br>
<br>

<h1>ユーザー</h1>
<img src="<%= request.getContextPath()+"/img_user_logo/" + personOthers.getInfo03() %>" width="150"><br>
名前：<%= personOthers.getUserName() %><br>
<br>

タレントリスト
<%
TalentDTO talent=null;
int counter=0;
%>
<%for(TalentDTO talentDTO:personOthers.getUserFavoriteTalentList()){ %>
<form action="/komimi-chan-t-1/TalentInfo" method="post">
<% if(talentDTO!=null){ %>
	<img src="<%= request.getContextPath()+"/img/" + talentDTO.getTalentImgAddress() %>" width="150"><br>
	<%= "コンビ名:"+talentDTO.getTalentGroupName() %><br>
	<%= "favorite:"+talentDTO.getTalentName() %><br>
	<%= "comment:"+userDTO.getCommentDTOList().get(counter).getComment() %><br>
	<% counter++; %>
<input  type="submit" value=<%= talentDTO.getTalentId() %> name="talentDTO"><br>
</form>
<% } %>
<% } %>

<br>

</body>
</html>