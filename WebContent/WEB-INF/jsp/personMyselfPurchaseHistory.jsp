<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- インポート部 -->
<%@ page
import="dto.LoginDTO"
import="dto.HistoryDTO"
import="dto.ProductDTO"
import="java.util.List"
%>

<!-- セッション取得部 -->
<%
request.setCharacterEncoding("UTF-8");
LoginDTO loginDTO = (LoginDTO)session.getAttribute("login");
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
<%int counter=0; %>
<% for(HistoryDTO historyDTO:historyList){ %>
<%if(loginDTO.getId().equals(historyDTO.getProductId())){ %>
	<%for(ProductDTO productDTO:productAllList){ %>
	<% if(productDTO.getProductId().equals(historyDTO.getProductId())){ %>
		<%="履歴No." + counter + "名前："+productDTO.getProductName()+" 価格："+productDTO.getProductPrice() %>
	<%} %>
	<%} %>
<%} %>
<% } %>
<br>
</body>
</html>