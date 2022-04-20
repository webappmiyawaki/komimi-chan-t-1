<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- インポート部 -->
<%@ page
import="dto.LoginDTO"
import="dto.HistoryDTO"
import="dto.ProductDTO"
import="dto.UserDTO"
import="java.util.List"
%>

<!-- セッション取得部 -->
<%
request.setCharacterEncoding("UTF-8");
LoginDTO loginDTO = (LoginDTO)session.getAttribute("login");
UserDTO myUserDTO = (UserDTO)session.getAttribute("myUserDTO");
List<HistoryDTO> historyList = (List<HistoryDTO>)session.getAttribute("historyList");
List<ProductDTO> productAllList = (List<ProductDTO>)session.getAttribute("productAllList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="personMyself.jsp">マイページへ</a><br>
<br>
<%int counter=0; %>

購入履歴<br><br>
<%for(ProductDTO myProductDTO:myUserDTO.getProductDTOList()){ %>
		<%="履歴No." + counter + "  商品名："+myProductDTO.getProductName()+"  価格："+myProductDTO.getProductPrice() %>
<%} %>
<br>
</body>
</html>