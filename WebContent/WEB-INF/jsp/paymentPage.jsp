<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- インポート部 -->
<%@ page
import="dto.LoginDTO"
import="dto.ProductDTO"
import="java.util.List"
%>

<!-- セッション取得部 -->
<%
request.setCharacterEncoding("UTF-8");
LoginDTO loginDTO = (LoginDTO)session.getAttribute("login");
List<ProductDTO> productList = (List<ProductDTO>)session.getAttribute("productList");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>決済ページ</title>
</head>
<body>
<form action="/komimi-chan-t-1/PaymentPage" method="post">
<input  type="submit" value="成功" name="select">
<input  type="submit" value="失敗" name="select">
</form>
</body>
</html>