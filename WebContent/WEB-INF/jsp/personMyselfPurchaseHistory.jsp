<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- インポート部 -->
<%@ page
import="dto.LoginDTO"
import="dto.HistoryDTO"
import="java.util.List"
%>

<!-- セッション取得部 -->
<%
request.setCharacterEncoding("UTF-8");
LoginDTO loginDTO = (LoginDTO)session.getAttribute("login");
List<HistoryDTO> historyList = (List<HistoryDTO>)session.getAttribute("historyList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="personMyself.jsp">マイページへ</a><br>
<%
if(loginDTO==null||loginDTO.getId()==""){
%>
何も表示されません。
<%}else{ %>
ログインしています
<%} %>
<br>
</body>
</html>