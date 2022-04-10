<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- インポート部 -->
<%@ page
import="dto.LoginDTO"
import="java.util.List"
%>
<!-- セッション取得部 -->
<%
request.setCharacterEncoding("UTF-8");
LoginDTO loginDTO = (LoginDTO)session.getAttribute("login");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログインページ</title>
</head>
<body>

ログイン
<form action="/komimi-chan-t-1/Login" method="post">
id  :<input  type="text" value="" name="userId"><br>
pass:<input  type="password" value="" name="userPass"><br>
<input  type="submit" value="確定" name="select">
</form>
<br>
<%
if(loginDTO!=null){
	if(loginDTO.getId()==null){
%>
		ログインに失敗しました。
<%	}
}
%>
登録してない方は＞＞<a href="signup.jsp">新規登録</a><br>

<form action="/komimi-chan-t-1/ManagementForTalent" method="post">
<input  type="submit" value="managementForTalent" name="select">タレント用管理画面<br>
</form>
<form action="/komimi-chan-t-1/ManagementForOperation" method="post">
<input  type="submit" value="managementForOperation" name="select">運営用管理画面<br>
</form>

</body>
</html>