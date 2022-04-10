<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- インポート部 -->
<%@ page
import="dto.LoginDTO"
import="dto.TalentDTO"
import="dto.UserDTO"
import="dto.CommentDTO"
import="java.util.List"
%>

<!-- セッション取得部 -->
<%
request.setCharacterEncoding("UTF-8");
LoginDTO loginDTO = (LoginDTO)session.getAttribute("login");
UserDTO userDTO = (UserDTO)session.getAttribute("userDTO");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--
<meta http-equiv="refresh" content="1; URL=/komimiSample/Main">
-->
<title>Signup</title>
</head>

<body>
<a href="login.jsp">ログインページへ</a><br><br>
新規登録<br>
<br>

<form action="/komimi-chan-t-1/SignupForUserInfo" method="post">
<input  type="submit" value="成功" name="select">
<input  type="submit" value="失敗" name="select">
</form>
<br>
<%
if(userDTO!=null){
	if(userDTO.getUserId()==null){
%>		 登録に失敗しました。
<%	}else{  %>
		登録に成功しました。
<%	}
}
%>


</body>
</html>