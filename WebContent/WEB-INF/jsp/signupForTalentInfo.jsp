<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- インポート部 -->
<%@ page
import="dto.LoginDTO"
import="dto.TalentDTO"
import="dto.RequestDTO"
import="java.util.List"
%>

<!-- セッション取得部 -->
<%
request.setCharacterEncoding("UTF-8");
LoginDTO loginDTO = (LoginDTO)session.getAttribute("login");
TalentDTO talentDTO = (TalentDTO)session.getAttribute("talentDTO");
RequestDTO requestDTO = (RequestDTO)session.getAttribute("requestDTO");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/komimi-chan-t-1/ManagementForOperation">運営用管理画面</a><br>
</body>
</html>