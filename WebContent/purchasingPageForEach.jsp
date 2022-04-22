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

<!-- インポート部 -->
<%@ page
import="dto.LoginDTO"
import="dto.TalentDTO"
import="dto.UserDTO"
import="dto.CommentDTO"
import="java.util.*"
%>

<!-- セッション取得部 -->
<%
request.setCharacterEncoding("UTF-8");
LoginDTO loginDTO = (LoginDTO)session.getAttribute("login");
UserDTO userDTO = (UserDTO)session.getAttribute("userDTO");
TalentDTO talentDTO = (TalentDTO)session.getAttribute("talentDTO");
List<ProductDTO> productList = (List<ProductDTO>)session.getAttribute("talentProductList");
List<ProductDTO> cart = (List<ProductDTO>)session.getAttribute("cart");
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
<form action="/komimi-chan-t-1/PaymentPage" method="post">
	<input  type="submit" value="SendMain" name="select">決済ページへ<br>
</form>

<% if(cart!=null){ %>
cart   : <%=cart.size() %>件
<% int total=0; %>
<% for(ProductDTO productDTO:cart){ %>
	<% total+=productDTO.getProductPrice(); %>
<% } %>
合計金額: <%=total %>円
<% } %>
<br>
<br>
<br>

<%List<ProductDTO>purchasingList = new ArrayList<>(); %>
<%for(ProductDTO productDTO:productList){ %>
<form action="/komimi-chan-t-1/PurchasingPageForEach" method="post">
	<img src="<%= request.getContextPath()+"/img_product/" + productDTO.getProductImg() %>" width="150"><br>
	<%= "商品名："+productDTO.getProductName() %><br>
	<%= "ジャンル："+productDTO.getProductType() %><br>
	<%= "価格："+productDTO.getProductPrice() %><br>
	<input  type="submit" value=<%= productDTO.getProductId() %> name="productId"><br>
</form>
<%} %>

<%if(cart!=null){ %>
現在のカートの中身
<%int cartTotalPrice=0; %>
<%for(ProductDTO productDTO:cart) {%>
	<%=productDTO %>
	<% cartTotalPrice+=productDTO.getProductPrice(); %>
<% } %>
<% } %>

</body>
</html>