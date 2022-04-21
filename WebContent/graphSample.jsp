<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Random"%>
	<%@ page import="java.util.Arrays" %>
	<%@ page import="java.util.Map" %>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/sample.css">
<meta charset="UTF-8">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js">
</script>

<title>Insert title here</title>
</head>
<body>
<%
	Random rnd = new Random();
	int x1 = rnd.nextInt(100);
	int x2 = rnd.nextInt(100);
	int x3 = rnd.nextInt(100);
	int x4 = rnd.nextInt(100);
	int x5 = rnd.nextInt(100);
	int x6 = rnd.nextInt(100);
	int x7 = rnd.nextInt(100);
	int x8 = rnd.nextInt(100);
	%>

	<canvas id="canvas"></canvas>

</body>
<script src="js/Babel.js"></script>
</html>