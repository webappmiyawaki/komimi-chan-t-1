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
List<ProductDTO> productList = (List<ProductDTO>)session.getAttribute("productList");
%>

<html>
<head>
<meta charset="UTF-8">

<title>sample</title>
</head>
<body>
SendMain<br>
<%String sendParam01 ="591"; %>
<%String sendParam02 ="2000"; %>
<a href="http://localhost:8080/RecieveApp/RecieveMain.jsp?key1=<%=sendParam01 %>&key2=<%=sendParam02 %>">送る</a>
<br>
<a href="http://localhost:5050/view/test?key1=<%=sendParam01 %>&key2=<%=sendParam02 %>">go送る</a>

<form action="/komimi-chan-t-1/PurchasingPageForEach" method="post">
	<input  type="submit" value="SendMain" name="select">SendMain<br>
</form>

<% String result = request.getParameter("key4"); %><br>
result:<%=result %>
</body>
</html>