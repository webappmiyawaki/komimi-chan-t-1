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
import="java.util.Random"
%>

<!-- セッション取得部 -->
<%
request.setCharacterEncoding("UTF-8");
LoginDTO loginDTO = (LoginDTO)session.getAttribute("login");
CommentDTO commentDTO = (CommentDTO)session.getAttribute("commentDTO");
List<TalentDTO> talentList = (List<TalentDTO>)session.getAttribute("talentList");
List<UserDTO> userList = (List<UserDTO>)session.getAttribute("userList");
List<CommentDTO> commentList = (List<CommentDTO>)session.getAttribute("commentList");
List<RequestDTO> requestList = (List<RequestDTO>)session.getAttribute("requestList");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/login.css">
<!--
<meta http-equiv="refresh" content="1; URL=/komimiSample/Main">
-->
<title>運営用Management</title>
</head>
<body>
運営用管理画面<br>
<a href="/komimi-chan-t-1/Logout">ログアウト</a><br>
<br>
<form action="/komimi-chan-t-1/SignupForTalentInfo" method="post">
<input  type="submit" value="情報追加" name="select">
</form>
<br>

<br>
<br>
<br>
	<div class="management">
    	<canvas id="myChart"></canvas>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
    <script>
    var ctx = document.getElementById('myChart').getContext('2d');
    var chart = new Chart(ctx, {
      type: 'line',
      data: {
        // 横軸を指定
        <% StringBuilder sb = new StringBuilder("");%>
        <%
        int day = 401;
        for(int i=0;i<20;i++){
        	sb.append("'0"+day+"',");
        	day++;
        }
        %>

        labels: [<%=sb%>],
        datasets: [
          {
            // 上部のタイトル指定
            label: 'アクセス推移',
            lineTension: 0.1,
            // 色周りの指定
            backgroundColor: 'rgba(75,192,192,0.4)',
            borderColor: 'rgba(75,192,192,1)',
            // 縦軸データを指定

            <% StringBuilder data = new StringBuilder("");%>
            <%
            int count = 100;
            Random rand = new Random();
            for(int i=0;i<20;i++){
            	data.append(count+rand.nextInt(50)+",");
            	day++;
            }
            %>
            data: [<%=data%>]
          }
        ]
      },
      options: {
        scales: {
          yAxes: [
            {
              ticks: {
                // ここで最小値を指定することができる。指定しないとdataの最小値が最小値になる。
                min: 75.0,
                // ここで縦軸に単位を加えることができる。
                userCallback: function (tick) {
                  return tick.toString() + 'k';
                }
              },
              // 縦軸のラベル指定
              scaleLabel: {
                display: true,
                labelString: '人'
              }
            }
          ]
        }
      }
    });
    </script>

</body>
</html>