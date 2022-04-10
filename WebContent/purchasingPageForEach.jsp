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
List<ProductDTO> productList = (List<ProductDTO>)session.getAttribute("productList");
List<HistoryDTO> historyList = (List<HistoryDTO>)session.getAttribute("historyList");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>芸能人個別購買ページ</title>
</head>
<body>

芸能人個別購買ページ
<br>
<a href="/komimi-chan-t-1/PurchasingPageForAll">芸能人購買ページ一覧</a><br>
<a href="/komimi-chan-t-1/TalentInfo">芸能人情報ページへ</a><br>
<a href="/komimi-chan-t-1/Main">メイン</a><br>
</body>
</html>