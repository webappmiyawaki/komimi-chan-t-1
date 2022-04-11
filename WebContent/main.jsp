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
TalentDTO talentDTO = (TalentDTO)session.getAttribute("talentDTO");
CommentDTO commentDTO = (CommentDTO)session.getAttribute("commentDTO");
List<TalentDTO> talentList = (List<TalentDTO>)session.getAttribute("talentList");
List<UserDTO> userList = (List<UserDTO>)session.getAttribute("userList");
List<CommentDTO> commentList = (List<CommentDTO>)session.getAttribute("commentList");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="utf-8">
<title>C-1 Grand Prix</title>
<meta name="description"  content="">
<meta name="robots" content="noindex,nofollow"><meta name="keywords"  content="">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<!--------------------Google Font -------------------->
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+JP%7COswald&display=swap" rel="stylesheet">
<!--------------------レイアウトを制御する独自のCSSを読み込み-------------------->

<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/vegas/2.4.4/vegas.min.css">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.10.0/css/lightbox.min.css">

<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css">
<link rel="stylesheet" type="text/css" href="css/parts.css">
<link rel="stylesheet" type="text/css" href="css/layout.css">

</head>
<body>

<div id="splash">
<div id="splash-logo"><div class="loader"></div></div>
<!--/splash--></div>
<div class="splashbg"></div><!---画面遷移用-->


<div id="container">
<header id="header">
<h1><a href="#">C-1 Grand Prix</a></h1>

<div class="g-nav-openbtn"><div class="openbtn-area"><span></span><span></span><span></span></div></div>
<nav id="g-nav">
<div id="g-nav-list">
		<ul id="g-navi" class="nav01c">
			<li><a href="#">Top</a></li>
			<li><a href="/komimi-chan-t-1/PersonMyself">MyPage</a></li>
            <li><a href="/komimi-chan-t-1//PurchasingPageForAll">Online Shop</a></li>
            <li class="has-child"><a href="#">About Us</a>
				<ul>
				<li><a href="#">Company</a></li>
				<li><a href="#">Contact</a></li>
				</ul>
			</li>
            <li><a href="/komimi-chan-t-1/Logout">Logout</a></li>
		</ul>
</div>
</nav>
<div class="open-btn"></div>
</header>

<div id="search-wrap">
<div class="close-btn"><span></span><span></span></div>
<div class="search-area">
<form role="search" method="get" action="">
<input type="text" value="" name="" id="search-text" placeholder="search">
<input type="submit" id="searchsubmit" value="">
</form>
<!--/search-area--></div>
<!--/search-wrap--></div>

<section id="vidual-area">
<div id="logo">
<div id="kmmLogo"><img src="img_k/logo_kmm.png" alt=""></div>
<div id="titleLogo"><img src="img_k/logo_c1g.png" alt=""></div>
<div id="conceptKmm"><img src="img_k/concept_kmm.png" alt=""></div>
</div>
<div id="slider-area" class="bgextend bgRLextendTrigger">
    <div class="bgappearTrigger">
        <div id="slider"></div>
    </div>
<!--/slider-area--></div>
<h2><span class="js_typing">C-1 Grand Prix</span><br></h2>
<dl>
    <dt>Follow Us</dt>
    <dd><ul>
        <li><a href="#"><img src="img_k/ico_fb.svg" alt=""></a></li>
        <li><a href="#"><img src="img_k/ico_tw.svg" alt=""></a></li>
        <li><a href="#"><img src="img_k/ico_insta.svg" alt=""></a></li>
        </ul>
    </dd>
</dl>

<div class="scrolldown1"><span>Scroll</span></div>

<!--/vidual-area--></section>

<main id="main-area">
    <section id="service">
        <h2 class="js_typing">Recommendation for you</h2>


        <div class="service-area">
        <ul class="recomSlider slFadeUpTrigger">
	<li><a href="#"><img src="img_k/recom_sl_01.jpg" alt=""><span class="detail-price">田中 光</span></a></li>
	<li><a href="#"><img src="img_k/recom_sl_02.jpg" alt=""><span class="detail-price">片倉ブリザード</span></a></li>
	<li><a href="#"><img src="img_k/recom_sl_03.jpg" alt=""><span class="detail-price">ランジャタイ</span></a></li>
	<li><a href="#"><img src="img_k/recom_sl_04.jpg" alt=""><span class="detail-price">チカトプライド</span></a></li>
	<li><a href="#"><img src="img_k/recom_sl_05.jpg" alt=""><span class="detail-price">フランスピアノ</span></a></li>
<!--/slider--></ul>

        <!--/service-area--></div>
    </section>

    <div class="news-img-wrapper bgextend bgRLextendTrigger">
        <div class="bgappearTrigger">
            <div class="news-img"></div>
        </div>
    <!--/news-img-wrapper--></div>

<section id="news">
    <h2 class="js_typing">Ranking</h2>
    <div class="tab-area bgextend bgLRextendTrigger">
    <div class="bgappearTrigger">
    <ul class="tab">
		<li class="active"><a href="#topics">Comedian</a></li>
		<li><a href="#parts">Search results</a></li>
	</ul>
    <div class="tab-choice-area">
		<div id="topics" class="area is-active">
			<ul>
			<%for(int i=0;i<10;i++){ %>
            <li><a href="#">
            <time datetime="2021-12-23"></time>
            <img src="<%= request.getContextPath()+"/img/" + talentList.get(i).getTalentImgAddress() %>" width="75">
            <%= talentList.get(i).getTalentName() %>
            <%= "お気に入り数："+talentList.get(i).getTalentFavoriteCount()+"人" %></a>
            </li>
			<%} %>
			</ul>
		<!--/area--></div>
		<div id="parts" class="area">
			<ul>
			<%for(int i=10;i<20;i++){ %>
            <li><a href="#">
            <time datetime="2021-12-23"></time>
            <img src="<%= request.getContextPath()+"/img/" + talentList.get(i).getTalentImgAddress() %>" width="75">
            <%= talentList.get(i).getTalentName() %>
            <%= "お気に入り数："+talentList.get(i).getTalentFavoriteCount()+"人" %></a>
            </li>
			<%} %>
			</ul>
		<!--/area--></div>

    <!--/tab-choice-area--></div>
    </div>
<!--/tab-area--></div>
</section>

<!--ユーザーリスト表示 -->
<ul id="gallery" class="gallery">
		<% for(int i=0;i<8;i++){ %>
			<li class="bgextend bgLRextendTrigger zoomInRotate">
			<div class="abc">
			<div class="bgappearTrigger">
			<a href="img_k/gal_01_l.jpg" data-lightbox="gallery-group" data-title="0000.00.00 あおい空しろい雲">
			<img src="img_k/gal_01.jpg" alt=""></a></div></div></li>
		<% } %>
</ul>

    <div class="bgextend bgLRextendTrigger">
    <div class="bgappearTrigger">
    <section id="contact">
        <div class="contact-detail">
            <h2>Contact</h2>
            <p>お電話・メールにてお気軽にお問い合わせください。</p>
        <!--/contact-detail--></div>
      <div class="contact-tel">
          <p><a href="tel:03-1234-5678">Tel:092-1234-5678</a></p>
          <p><a href="#">お問い合わせ<br>フォーム</a></p>
      <!--/contact-tel--></div>
    </section>
    <!--/bgappearTrigger--></div>
    <!--/bgextend--></div>
</main>

<!--
メイン画面<br>
<br>
<a href="/komimi-chan-t-1/PersonMyself">マイページ</a><br>
<a href="/komimi-chan-t-1/Logout">ログアウト</a><br>
<form action="/komimi-chan-t-1/MainProcessSwitch" method="post">
<input  type="submit" value="personOthers" name="select">personOthers<br>
<input  type="submit" value="talentInfo" name="select">talentInfo<br>
</form>
<br>
 -->

<!--/container--></div>
</body>
<footer id="footer">
    <div class="footer-info">
    <p class="footer-logo">komimi-chan</p>
    <address>〒111-111 福岡県福岡市 1-2-3</address>
    <ul>
        <li><dl><dt>TEL</dt><dd><a href="tel:03-1234-5678">092-1234-5678</a></dd></dl></li>
        <li><dl><dt>営業時間</dt><dd>平日 9:30～18:00</dd><dd>土・日・祝日 10:30～19：00</dd></dl></li>
    </ul>
    </div>

    <div class="footer-link">
        <ul>
			<li><a href="#">Top</a></li>
			<li><a href="#">Recommend</a></li>
            <li><a href="#">Online Shop</a></li>
            <li><a href="#">Company</a></li>
            <li><a href="#">Contact</a></li>
            <li><a href="#">Logout</a></li>
		</ul>
        <small>Copyright &copy; komimi-chan All rights Reserved.</small>
    </div>
	<p id="page-top" class="hide-btn"><a href="#"><span></span></a></p>
</footer>

<!--=============JS ===============-->
<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/vegas/2.4.4/vegas.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.10.0/js/lightbox.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/shuffle-text@0.3.0/build/shuffle-text.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<script src="js/script.js"></script>

</html>