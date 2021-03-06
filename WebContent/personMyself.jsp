1<%@ page language="java" contentType="text/html; charset=UTF-8"
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
import="java.util.*"
%>

<!-- セッション取得部 -->
<%
request.setCharacterEncoding("UTF-8");
LoginDTO loginDTO = (LoginDTO)session.getAttribute("login");
UserDTO userDTO = (UserDTO)session.getAttribute("userDTO");
List<TalentDTO> talentList = (List<TalentDTO>)session.getAttribute("talentList");
Map<String,TalentDTO>talentMap=(Map<String,TalentDTO>)session.getAttribute("talentMap");
List<UserDTO> userList = (List<UserDTO>)session.getAttribute("userList");
List<UserDTO> personOthersList = (List<UserDTO>)session.getAttribute("personOthersList");
List<CommentDTO> commentList = (List<CommentDTO>)session.getAttribute("commentList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>PersonMyself</title>
</head>
<body>
<a href="/komimi-chan-t-1/Logout">ログアウト</a><br>
<a href="/komimi-chan-t-1/Main">戻る</a>
マイページ<br>
<br>
<a href="/komimi-chan-t-1/PersonMyselfPurchaseHistory">購入履歴</a>
<br>

	<h1>ユーザー情報</h1>
	<img src="<%= request.getContextPath()+"/img_user_logo/" + userDTO.getInfo03() %>" width="350"><br>
	name:<%= userDTO.getUserName() %><br>
	pass:<%= userDTO.getUserPass() %><br>
	type:<%= userDTO.getUserType() %><br>

	<br>
	<h1>好きなタレント一覧</h1>

	<%
	TalentDTO talent=null;
	int counter=0;

	List<TalentDTO> userTalentList = userDTO.getUserFavoriteTalentList();
	Collections.shuffle(userTalentList);
	Collections.shuffle(personOthersList);
	%>
	<%for(TalentDTO talentDTO:userTalentList){ %>
	<form action="/komimi-chan-t-1/TalentInfo" method="post">
	<% if(talentDTO!=null){ %>
		<img src="<%= request.getContextPath()+"/img_talent/" + talentDTO.getTalentImgAddress() %>" width="150"><br>
		<%= "コンビ名:"+talentDTO.getTalentGroupName() %><br>
		<%= "favorite:"+talentDTO.getTalentName() %><br>
		<%= "comment:"+userDTO.getCommentDTOList().get(counter).getComment() %><br>
		<% counter++; %>
	<input  type="submit" value=<%= talentDTO.getTalentId() %> name="talentDTO"><br>
	</form>
	<% } %>
	<% } %>

	<br>

	<!--ユーザーリスト表示 -->
	<h1>おすすめユーザー</h1>
	<% for(int i=0;i<5;i++){ %>
	<form action="/komimi-chan-t-1/PersonOthers" method="post">
		<img src="<%= request.getContextPath()+"/img_user_logo/" + personOthersList.get(i).getInfo03() %>" width="150"><br>
		名前：<%= personOthersList.get(i).getUserName() %><br>
	<input  type="submit" value=<%= personOthersList.get(i).getUserId() %> name="personOthersID"><br>
	</form>
	<br>
	<% } %>

</body>
</html>