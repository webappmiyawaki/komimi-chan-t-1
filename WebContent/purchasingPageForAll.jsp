<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- インポート部 -->
<%@ page
import="dto.LoginDTO"
import="dto.TalentDTO"
import="dto.UserDTO"
import="dto.ProductDTO"
import="java.util.*"
%>

<!-- セッション取得部 -->
<%
request.setCharacterEncoding("UTF-8");
LoginDTO loginDTO = (LoginDTO)session.getAttribute("login");
UserDTO userDTO = (UserDTO)session.getAttribute("userDTO");
List<TalentDTO> talentList = (List<TalentDTO>)session.getAttribute("talentList");
Collections.shuffle(talentList);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>芸能人購買ページ一覧</title>
</head>
<body>

芸能人購買ページ一覧<br>
<a href="/komimi-chan-t-1/Main">メイン</a>
<a href="/komimi-chan-t-1/PurchasingPageForEach">個別</a>

<!--タレントリスト表示 -->
<h1>タレントリスト</h1>
<%for(TalentDTO talent:talentList){ %>
<form action="/komimi-chan-t-1/TalentInfo" method="post">
<img src="<%= request.getContextPath()+"/img_talent/" + talent.getTalentImgAddress() %>" width="150"><br>
	<%= "名前："+talent.getTalentName() %><br>
	<%= "コンビ名："+talent.getTalentGroupName() %><br>
	<%= "お気に入り数："+talent.getTalentFavoriteCount() %><br>
	<input  type="submit" value=<%= talent.getTalentId() %> name="talentDTO">TalentDTO<br>
</form>
<br><br>
<%} %>
<br>

</body>
</html>