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
RequestDTO requestDTO = (RequestDTO)session.getAttribute("requestDTO");
List<TalentDTO> talentList = (List<TalentDTO>)session.getAttribute("talentList");
List<UserDTO> userList = (List<UserDTO>)session.getAttribute("userList");
List<CommentDTO> commentList = (List<CommentDTO>)session.getAttribute("commentList");
List<RequestDTO> requestList = (List<RequestDTO>)session.getAttribute("requestList");
List<ProductDTO> productList = (List<ProductDTO>)session.getAttribute("productList");
List<HistoryDTO> historyList = (List<HistoryDTO>)session.getAttribute("historyList");

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