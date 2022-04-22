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
import="dao.ProcessInsert"
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
<form action="/komimi-chan-t-1/PersonMyself" method="post">
	<input  type="submit" value="マイページ" name="select">マイページへ<br>
</form>

<% String result = request.getParameter("key4"); %><br>
<%if(result!=null) {%>
<%if(result.equals("true")){ %>
<%
//決済完了したのでカートの中身を履歴に保存して消す。
ProcessInsert pi = new ProcessInsert();
for(ProductDTO productDTO:cart){
	pi.insertHistory(myUserDTO.getUserId(),productDTO.getProductId());
}
cart=null; %>
決済が完了しました。
カートの中身が空になりました。
<%}else if(result.equals("false")){ %>
決済できませんでした。
商品を減らしてください。
<%}else {
}}%>

購買品商品一覧
<% int total=0; %>
<% if(cart!=null){ %>
cart   : <%=cart.size() %>件<br>

<% for(ProductDTO productDTO:cart){ %>
	<% total+=productDTO.getProductPrice(); %><br>
<% } %>
合計金額: <%=total %>円
<a href="http://localhost:5050/view/test?key1=<%=myUserDTO.getUserId() %>&key2=<%= total %>">決済</a>
<br>
<% } %>


<br>


<br>
<br>

<form action="/komimi-chan-t-1/PaymentPage" method="post">
	<table>
    <thead>
        <tr>
            <th class="title" colspan="3">商品一覧</th>
        </tr>
        <tr class="midashi">
            <th>画像</th>
            <th>商品名</th>
            <th>販売単価</th>
       	</tr>
    </thead>
    <tbody>


<%if(cart!=null){%>
<%for(ProductDTO productDTO:cart) {%>
<tr>
<td><input type="radio" name="productId" value=<%= productDTO.getProductId() %>>
</td>
<td><img src="<%= request.getContextPath()+"/img_product/" + productDTO.getProductImg() %>" width="150"></td>
<td><%= productDTO.getProductName() %></td>
<td><%= productDTO.getProductPrice() %></td>
</tr>
<%}} %>

    </tbody>
</table>
<input type="submit" value="削除" name="paymentPageAction">
</form>

</body>
</html>