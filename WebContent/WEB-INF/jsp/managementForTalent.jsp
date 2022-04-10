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
CommentDTO commentDTO = (CommentDTO)session.getAttribute("commentDTO");
RequestDTO requestDTO = (RequestDTO)session.getAttribute("requestDTO");
List<TalentDTO> talentList = (List<TalentDTO>)session.getAttribute("talentList");
List<UserDTO> userList = (List<UserDTO>)session.getAttribute("userList");
List<CommentDTO> commentList = (List<CommentDTO>)session.getAttribute("commentList");
List<RequestDTO> requestList = (List<RequestDTO>)session.getAttribute("requestList");
List<ProductDTO> productList = (List<ProductDTO>)session.getAttribute("productList");
List<HistoryDTO> historyList = (List<HistoryDTO>)session.getAttribute("historyList");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タレント用管理画面</title>
</head>
<body>
<a href="/komimi-chan-t-1/Logout">ログアウト</a><br>
タレント用管理画面
</body>
</html>