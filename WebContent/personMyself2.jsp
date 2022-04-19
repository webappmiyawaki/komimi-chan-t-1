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
List<CommentDTO> commentList = (List<CommentDTO>)session.getAttribute("commentList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--
<meta http-equiv="refresh" content="1; URL=/komimiSample/Main">
-->
<title>PersonMyself</title>
</head>
<body>
<a href="/komimi-chan-t-1/Logout">ログアウト</a><br>
<a href="/komimi-chan-t-1/Main">戻る</a>
マイページ<br>
<br>
<a href="/komimi-chan-t-1/PersonMyselfPurchaseHistory">購入履歴</a>
<form action="/komimi-chan-t-1/PersonMyselfProcessSwitch" method="post">
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
	<h1>ユーザー情報</h1>
	name:<%= userDTO.getUserName() %><br>
	pass:<%= userDTO.getUserPass() %><br>
	type:<%= userDTO.getUserType() %><br>
	img :<%= userDTO.getInfo03() %><br>

	<br>
	<h1>好きなタレント一覧</h1>
	<form action="/komimi-chan-t-1/TalentInfo" method="post">
	<% for(TalentDTO talentDTO:talentList){
		if(talentDTO.getTalentId().equals(userDTO.getUserFavoriteTalent01())){%>

				<img src="<%= request.getContextPath()+"/img/" + talentDTO.getTalentImgAddress() %>" width="150"><br>
				<%= "コンビ名:"+talentDTO.getTalentGroupName() %><br>
				<%= "favorite01:"+talentDTO.getTalentName() %><br>

	<%  }%>
	<% } %>
	<% for(CommentDTO commentDTO:commentList){%>
	<%	if(commentDTO.getUserId().equals(userDTO.getUserId())){%>
		<%	if(commentDTO.getTalentId().equals(userDTO.getUserFavoriteTalent01())){%>
				favorite01comment:<%= commentDTO.getComment() %><br>
		<%  }%>
		<% } %>
	<% } %>
	<input  type="submit" value=talentDTO name="talentDTO">ボタン<br>
	</form>
	<br>

	<form action="/komimi-chan-t-1/TalentInfo" method="post">
	<% for(TalentDTO talentDTO:talentList){ %>
	<%	if(talentDTO.getTalentId().equals(userDTO.getUserFavoriteTalent02())){%>
							<img src="<%= request.getContextPath()+"/img/" + talentDTO.getTalentImgAddress() %>" width="150"><br>
				<%= "コンビ名:"+talentDTO.getTalentGroupName() %><br>
				<%= "favorite02:"+talentDTO.getTalentName() %><br>
	<%  }%>
	<% } %>
	<% for(CommentDTO commentDTO:commentList){%>
	<%	if(commentDTO.getUserId().equals(userDTO.getUserId())){%>
		<%	if(commentDTO.getTalentId().equals(userDTO.getUserFavoriteTalent02())){%>
				favorite02comment:<%= commentDTO.getComment() %><br>
		<%  }%>
		<% } %>
	<% } %>
	<input  type="submit" value=talentDTO name="talentDTO">ボタン<br>
	</form>
	<br>
	<form action="/komimi-chan-t-1/TalentInfo" method="post">
	<% for(TalentDTO talentDTO:talentList){ %>
	<%	if(talentDTO.getTalentId().equals(userDTO.getUserFavoriteTalent03())){%>
										<img src="<%= request.getContextPath()+"/img/" + talentDTO.getTalentImgAddress() %>" width="150"><br>
				<%= "コンビ名:"+talentDTO.getTalentGroupName() %><br>
				<%= "favorite03:"+talentDTO.getTalentName() %><br>
	<%  }%>
	<% } %>
	<% for(CommentDTO commentDTO:commentList){%>
	<%	if(commentDTO.getUserId().equals(userDTO.getUserId())){%>
		<%	if(commentDTO.getTalentId().equals(userDTO.getUserFavoriteTalent03())){%>
				favorite03comment:<%= commentDTO.getComment() %><br>
		<%  }%>
		<% } %>
	<% } %>
	<input  type="submit" value=talentDTO name="talentDTO">ボタン<br>
	</form>
	<br>

	<form action="/komimi-chan-t-1/TalentInfo" method="post">
	<% for(TalentDTO talentDTO:talentList){ %>
	<%	if(talentDTO.getTalentId().equals(userDTO.getUserFavoriteTalent04())){%>
				<img src="<%= request.getContextPath()+"/img/" + talentDTO.getTalentImgAddress() %>" width="150"><br>
				<%= "コンビ名:"+talentDTO.getTalentGroupName() %><br>
				<%= "favorite04:"+talentDTO.getTalentName() %><br>
	<%  }%>
	<% } %>
	<% for(CommentDTO commentDTO:commentList){%>
	<%	if(commentDTO.getUserId().equals(userDTO.getUserId())){%>
		<%	if(commentDTO.getTalentId().equals(userDTO.getUserFavoriteTalent04())){%>
				favorite04comment:<%= commentDTO.getComment() %><br>
		<%  }%>
		<% } %>
	<% } %>
	<input  type="submit" value=talentDTO name="talentDTO">ボタン<br>
	</form>
	<br>

	<form action="/komimi-chan-t-1/TalentInfo" method="post">
	<% for(TalentDTO talentDTO:talentList){ %>
	<%	if(talentDTO.getTalentId().equals(userDTO.getUserFavoriteTalent05())){%>
	<img src="<%= request.getContextPath()+"/img/" + talentDTO.getTalentImgAddress() %>" width="150"><br>
	<%= "コンビ名:"+talentDTO.getTalentGroupName() %><br>
	<%= "favorite05:"+talentDTO.getTalentName() %><br>
	<%  }%>
	<% } %>
	<% for(CommentDTO commentDTO:commentList){%>
	<%	if(commentDTO.getUserId().equals(userDTO.getUserId())){%>
		<%	if(commentDTO.getTalentId().equals(userDTO.getUserFavoriteTalent05())){%>
				favorite05comment:<%= commentDTO.getComment() %><br>
		<%  }%>
		<% } %>
	<% } %>
	<input  type="submit" value=talentDTO name="talentDTO">ボタン<br>
	</form>
	<br>

	<!--ユーザーリスト表示 -->
	<h1>おすすめユーザー</h1>
	<% int userCount =0; %>
	<%for(UserDTO user:userList){ %>
		<% userCount++; %>
		<% if(userCount>5)break; %>
		ユーザー名：<%= user.getUserName() %><br>
		<br>
		<%if( user.getUserFavoriteTalent01()!=null){ %>
			<% for(TalentDTO talentDTO:talentList){
				if(talentDTO.getTalentId().equals(user.getUserFavoriteTalent01())){%>
					othersfavorite01:<%= talentDTO.getTalentName() %><br>
				<%  }%>
			<% } %>
			<% for(CommentDTO commentDTO:commentList){%>
			<%	if(commentDTO.getUserId().equals(user.getUserId())){%>
				<%	if(commentDTO.getTalentId().equals(user.getUserFavoriteTalent01())){%>
						othersfavorite01comment:<%= commentDTO.getComment() %><br>
				<%  }%>
				<% } %>
			<% } %>
		<% } %>

		<br>
		<%if( user.getUserFavoriteTalent02()!=null){ %>
			<% for(TalentDTO talentDTO:talentList){
				if(talentDTO.getTalentId().equals(user.getUserFavoriteTalent02())){%>
					othersfavorite02:<%= talentDTO.getTalentName() %><br>
				<%  }%>
			<% } %>
			<% for(CommentDTO commentDTO:commentList){%>
			<%	if(commentDTO.getUserId().equals(user.getUserId())){%>
				<%	if(commentDTO.getTalentId().equals(user.getUserFavoriteTalent02())){%>
						othersfavorite02comment:<%= commentDTO.getComment() %><br>
				<%  }%>
				<% } %>
			<% } %>
		<% } %>

		<br>
		<%if( user.getUserFavoriteTalent03()!=null){ %>
			<% for(TalentDTO talentDTO:talentList){
				if(talentDTO.getTalentId().equals(user.getUserFavoriteTalent03())){%>
					othersfavorite03:<%= talentDTO.getTalentName() %><br>
				<%  }%>
			<% } %>
			<% for(CommentDTO commentDTO:commentList){%>
			<%	if(commentDTO.getUserId().equals(user.getUserId())){%>
				<%	if(commentDTO.getTalentId().equals(user.getUserFavoriteTalent03())){%>
						othersfavorite03comment:<%= commentDTO.getComment() %><br>
				<%  }%>
				<% } %>
			<% } %>
		<% } %>

		<br>
		<%if( user.getUserFavoriteTalent04()!=null){ %>
			<% for(TalentDTO talentDTO:talentList){
				if(talentDTO.getTalentId().equals(user.getUserFavoriteTalent04())){%>
					othersfavorite04:<%= talentDTO.getTalentName() %><br>
				<%  }%>
			<% } %>
			<% for(CommentDTO commentDTO:commentList){%>
			<%	if(commentDTO.getUserId().equals(user.getUserId())){%>
				<%	if(commentDTO.getTalentId().equals(user.getUserFavoriteTalent04())){%>
						othersfavorite04comment:<%= commentDTO.getComment() %><br>
				<%  }%>
				<% } %>
			<% } %>
		<% } %>
		<br>
		<%if( user.getUserFavoriteTalent05()!=null){ %>
			<% for(TalentDTO talentDTO:talentList){
				if(talentDTO.getTalentId().equals(user.getUserFavoriteTalent05())){%>
					othersfavorite05:<%= talentDTO.getTalentName() %><br>
				<%  }%>
			<% } %>
			<% for(CommentDTO commentDTO:commentList){%>
			<%	if(commentDTO.getUserId().equals(user.getUserId())){%>
				<%	if(commentDTO.getTalentId().equals(user.getUserFavoriteTalent05())){%>
						othersfavorite05comment:<%= commentDTO.getComment() %><br>
				<%  }%>
				<% } %>
			<% } %>
		<% } %>
		<br>
	<%} %>
	<br>

<%} %>

</body>
</html>