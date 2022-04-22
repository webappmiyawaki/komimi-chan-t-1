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
   <!--------------------Google Font -------------------->
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+JP%7COswald&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
登録してない方は＞＞<a href="/komimi-chan-t-1/SignupForUserInfo">新規登録</a><br>

<div class="container">
  <div class="child">
  ログイン
	<form action="/komimi-chan-t-1/Login" method="post">
	name  :<input  type="text" value="" name="userName"><br>
	pass:<input  type="password" value="" name="userPass"><br>
	<input  type="submit" value="確定" name="select">
	</form>
  </div>

<%--ワードクラウド --%>
<canvas id="cloud"></canvas>
</div>

<br>
<%
if(loginDTO!=null){
	if(loginDTO.getId()==null){
%>
		ログインに失敗しました。
<%	}
}
%>


<!--

<form action="/komimi-chan-t-1/ManagementForTalent" method="post">
<input  type="submit" value="managementForTalent" name="select">タレント用管理画面<br>
</form>
<form action="/komimi-chan-t-1/ManagementForOperation" method="post">
<input  type="submit" value="managementForOperation" name="select">運営用管理画面<br>
</form>
 -->



</body>
    <script src="https://d3js.org/d3.v3.min.js"></script>
    <script src="https://rawgit.com/jasondavies/d3-cloud/master/build/d3.layout.cloud.js"></script>

<script>
  var ctx = document.getElementById("cloud");
//  var TARGET_ELEMENT_ID = '#cloud'; // 描画先
//Simple animated example of d3-cloud - https://github.com/jasondavies/d3-cloud
//Based on https://github.com/jasondavies/d3-cloud/blob/master/examples/simple.html

// Encapsulate the word cloud functionality
function wordCloud(selector) {

    var fill = d3.scale.category20();

    //Construct the word cloud's SVG element
    var svg = d3.select(selector).append("svg")
        .attr("width", 1000)
        .attr("height", 1000)
        .append("g")
        .attr("transform", "translate(250,250)");


    //Draw the word cloud
    function draw(words) {
        var cloud = svg.selectAll("g text")
                        .data(words, function(d) { return d.text; })

        //Entering words
        cloud.enter()
            .append("text")
            .style("font-family","Meiryo UI")
            .style("fill", function(d, i) { return fill(i); })
            .attr("text-anchor", "middle")
            .attr('font-size', 50)
            .text(function(d) { return d.text; });

        //Entering and existing words
        cloud
            .transition()
                .duration(2000)
                .style("font-size", function(d) { return d.size + "px"; })
                .attr("transform", function(d) {
                    return "translate(" + [d.x, d.y] + ")rotate(" + d.rotate + ")";
                })
                .style("fill-opacity", 1);

        //Exiting words
        cloud.exit()
            .transition()
                .duration(1000)
                .style('fill-opacity', 1e-6)
                .attr('font-size', 20)
                .remove();
    }


    //Use the module pattern to encapsulate the visualisation code. We'll
    // expose only the parts that need to be public.
    return {

        //Recompute the word cloud for a new set of words. This method will
        // asycnhronously call draw when the layout has been computed.
        //The outside world will need to call this function, so make it part
        // of the wordCloud return value.
        update: function(words) {
            d3.layout.cloud().size([1500, 500])
                .words(words)
                .padding(5)
                .rotate(function() { return ~~(Math.random() * 2) * 90; })
                .font("Meiryo UI")
                .fontSize(function(d) { return d.size; })
                .on("end", draw)
                .start();
        }
    }

}

//Some sample data - http://en.wikiquote.org/wiki/Opening_lines

<%
StringBuilder sb = (StringBuilder)session.getAttribute("loginTalentList");
%>

var words =[<%=sb%>]

<!--
var words = [
    "片倉ブリザード 小林圭輔 友保隼平 あかさたなはまや 高井佳佑 フェニックス 雨野宮将明 太郎 井下大活躍 好井まさお ありがとうぁみ 細野哲平",
    "おしみんまる えいじ ひるちゃん 八木崇 佐々木崇博 福田恵梧 伊藤智博 下田真生 九条ジョー 篠宮暁 高松新一 栗谷 すがやなおひろ 片倉ブリザード",
    "トミドコロ 杉本青空 伊織 かわばたくん 宮本昌彦 富樫啓郎 上野悠介 清水誠 ぴろ にしやま 安井祐弥 杉昇 渡辺翔太 渡邊孝平",
    "前野悠介 安田邦祐 石井輝明 石井 新山 星野光樹 一平 高木晋哉 池谷和志 野村辰二 柴田アイスピック 川北茂澄 ガク 肥後裕之",
    "大須賀健剛 市川刺身 松本竹馬 しんちゃん ロジャー 菊田竜大 秋山寛貴 岡部大 江上敬子 近藤くみこ 岡安章介 土谷隼人 ",
    "下池輝明 飯塚悟志 角田晃広 豊本明長 福田麻貴 ゆめっち かなで こじまラテ 仲西隼平 前田龍二 じゃい スギ。 ゆうぞう ",
    "シークエンスはやとも りゅうたろう 金城めくるくん Yes!アキト どんぐりたけし サツマカワRPG ノブヨシ日本代表 ",
    "飛び出せっ！安藤っ！ コブラ 中澤本鮪 林万介 ニュー岡部 遠山大輔 五明拓弥 大 坂本純一 福井俊太郎 ひろゆき 幸 彩 宮地謙典",
    "森本英樹 大川知英 藤本秀星 Mr.コブシ 鳩 すがちゃん最高No.1 信子 金子きょんちぃ 本間キッド 中嶋亨 ロングサイズ伊藤 吉住" ]
-->
//Prepare one of the sample sentences by removing punctuation,
// creating an array of words and computing a random size attribute.
function getWords(i) {
    return words[i]
            .replace(/[!\.,:;\?]/g, '')
            .split(' ')
            .map(function(d) {
                return {text: d, size: 10 + Math.random() * 100};
            })
}

//This method tells the word cloud to redraw with a new set of words.
//In reality the new words would probably come from a server request,
// user input or some other source.
function showNewWords(vis, i) {
    i = i || 0;

    vis.update(getWords(i ++ % words.length))
    setTimeout(function() { showNewWords(vis, i + 1)}, 4000)
}

//Create a new instance of the word cloud visualisation.
var myWordCloud = wordCloud('body');

//Start cycling through the demo data
showNewWords(myWordCloud);


</script>
</html>