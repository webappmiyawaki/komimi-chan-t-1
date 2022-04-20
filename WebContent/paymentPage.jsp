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
UserDTO myUserDTO = (UserDTO)session.getAttribute("myUserDTO");
List<ProductDTO> productList = (List<ProductDTO>)session.getAttribute("productList");
List<ProductDTO> cart = (List<ProductDTO>)session.getAttribute("cart");
%>

<html>
<head>
<meta charset="UTF-8">

<title>payment</title>
</head>
<body>
<%= myUserDTO.getUserName() %>さん<br>
<br>
決済ページ<br>

<% String result = request.getParameter("key4"); %><br>
result:<%=result %><br>

購買品商品一覧
<% int total=0; %>
<% if(cart!=null){ %>
cart   : <%=cart.size() %>件<br>

<% for(ProductDTO productDTO:cart){ %>
	<% total+=productDTO.getProductPrice(); %><br>
<% } %>
合計金額: <%=total %>円
<% } %>

<br>
<a href="http://localhost:5050/view/test?key1=<%=myUserDTO.getUserId() %>&key2=<%= total %>">決済</a>
<br>
<br>
<form action="/komimi-chan-t-1/PersonMyself" method="post">
	<input  type="submit" value="マイページ" name="select">マイページへ<br>
</form>

<br>
<br>
<%if(cart!=null){ %>
現在のカートの中身<br><br>
<%int cartTotalPrice=0; %>
<%for(ProductDTO productDTO:cart) {%>
	<img src="<%= request.getContextPath()+"/img_product/" + productDTO.getProductImg() %>" width="150"><br>
	名前：<%=productDTO.getProductName() %><br>
	価格：<%=productDTO.getProductPrice() %><br>
	<br>
<% } %>
<% } %>

</body>
</html>