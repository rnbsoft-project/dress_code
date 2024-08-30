<%--
  Created by IntelliJ IDEA.
  User: 탁우근
  Date: 2024-08-22
  Time: 오후 1:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Shop &mdash; Free Website Template, Free HTML5 Template by gettemplates.co</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="Free HTML5 Website Template by gettemplates.co" />
  <meta name="keywords" content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
  <meta name="author" content="gettemplates.co" />

  <!-- Animate.css -->
  <link rel="stylesheet" href="/resources/css/animate.css">
  <!-- Icomoon Icon Fonts-->
  <link rel="stylesheet" href="/resources/css/icomoon.css">
  <!-- Bootstrap  -->
  <link rel="stylesheet" href="/resources/css/bootstrap.css">
  <!-- Flexslider  -->
  <link rel="stylesheet" href="/resources/css/flexslider.css">


  <!-- Owl Carousel  -->
  <link rel="stylesheet" href="/resources/css/owl.carousel.min.css">
  <link rel="stylesheet" href="/resources/css/owl.theme.default.min.css">

  <!-- Theme style  -->
  <link rel="stylesheet" href="/resources/css/style.css">

  <!-- Modernizr JS -->
  <script src="/resources/js/modernizr-2.6.2.min.js"></script>
  <!-- FOR IE9 below -->
  <!--[if lt IE 9]>
  <script src="/resources/js/respond.min.js"></script>
  <![endif]-->

</head>
<body>

<div class="fh5co-loader"></div>

<div id="page">
  <jsp:include page="headerNav.jsp" flush="false"/>
  <header id="fh5co-header" class="fh5co-cover fh5co-cover-sm" role="banner" style="background-image:url(/resources/images/img_bg_2.jpg);">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-md-8 col-md-offset-2 text-center">
          <div class="display-t">
            <div class="display-tc animate-box" data-animate-effect="fadeIn">
              <h1>DRESS_CODE</h1>
              <h2>Welcome to Dresscode, and thank you for visiting us!</h2>
            </div>
          </div>
        </div>
      </div>
    </div>
  </header>


  <div id="fh5co-contact" style="float:right">
    <div class="container">
      <div class="row">
        <div class="col-md-6 animate-box">
          <h3>Login To DRESS_CODE</h3>

          <!-- 유저 로그인 시작 -->
          <form action="userLogin" method="post">
            <div class="row form-group">
              <div class="col-md-12">
                <input type="text" id="requestUserId" name="requestUserId" class="form-control"
                           style="font-family: 'Malgun Gothic', '맑은 고딕', 'Arial', sans-serif;"
                           placeholder="아이디를 입력해주세요">
              </div>
            </div>

            <div class="row form-group">
              <div class="col-md-12">
                <!-- <label for="email">Email</label> -->
                <input type="password" id="requestUserPassword" name="requestUserPassword" class="form-control"
                           style="font-family: 'Malgun Gothic', '맑은 고딕', 'Arial', sans-serif;"
                           placeholder="비밀번호를 입력해주세요">
              </div>
            </div>

            <!-- 로그인 버튼 -->
            <div class="form-group" style="float : right">
              <button type="submit" class="btn btn-primary" style="height: 45px">로그인</button>
            </div>
          </form>
          <div class="form-group" style="float : right; padding-right: 10px">
            <!-- 카카오 로그인 -->
            <form action="/kakaoLogin" method="post">
              <button type="submit" style="background-image:url(/resources/images/kakao_login.png); width: 90px; height: 45px; solid-color: yellow"></button>
            </form>
          </div>
          <%// 자바 영역
               if(request.getAttribute("loginError") != null) { %>
                    <p>아이디 또는 비밀번호를 잘못 입력 되었습니다. 다시 로그인 해주세요.</p>
          <%}%>
        </div>
      </div>

    </div>
  </div>

  <div id="map" class="animate-box" data-animate-effect="fadeIn"></div>

  <footer id="fh5co-footer" role="contentinfo">
    <div class="container">
      <div class="row row-pb-md">
        <div class="col-md-4 fh5co-widget">
          <h3>Shop.</h3>
          <p>Facilis ipsum reprehenderit nemo molestias. Aut cum mollitia reprehenderit. Eos cumque dicta adipisci architecto culpa amet.</p>
        </div>
        <div class="col-md-2 col-sm-4 col-xs-6 col-md-push-1">
          <ul class="fh5co-footer-links">
            <li><a href="#">About</a></li>
            <li><a href="#">Help</a></li>
            <li><a href="#">Contact</a></li>
            <li><a href="#">Terms</a></li>
            <li><a href="#">Meetups</a></li>
          </ul>
        </div>

        <div class="col-md-2 col-sm-4 col-xs-6 col-md-push-1">
          <ul class="fh5co-footer-links">
            <li><a href="#">Shop</a></li>
            <li><a href="#">Privacy</a></li>
            <li><a href="#">Testimonials</a></li>
            <li><a href="#">Handbook</a></li>
            <li><a href="#">Held Desk</a></li>
          </ul>
        </div>

        <div class="col-md-2 col-sm-4 col-xs-6 col-md-push-1">
          <ul class="fh5co-footer-links">
            <li><a href="#">Find Designers</a></li>
            <li><a href="#">Find Developers</a></li>
            <li><a href="#">Teams</a></li>
            <li><a href="#">Advertise</a></li>
            <li><a href="#">API</a></li>
          </ul>
        </div>
      </div>

      <div class="row copyright">
        <div class="col-md-12 text-center">
          <p>
            <small class="block">&copy; 2016 Free HTML5. All Rights Reserved.</small>
            <small class="block">Designed by <a href="http://freehtml5.co/" target="_blank">FreeHTML5.co</a> Demo Images: <a href="http://blog.gessato.com/" target="_blank">Gessato</a> &amp; <a href="http://unsplash.co/" target="_blank">Unsplash</a></small>
          </p>
          <p>
          <ul class="fh5co-social-icons">
            <li><a href="#"><i class="icon-twitter"></i></a></li>
            <li><a href="#"><i class="icon-facebook"></i></a></li>
            <li><a href="#"><i class="icon-linkedin"></i></a></li>
            <li><a href="#"><i class="icon-dribbble"></i></a></li>
          </ul>
          </p>
        </div>
      </div>

    </div>
  </footer>
</div>

<div class="gototop js-top">
  <a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
</div>

<!-- jQuery -->
<script src="/resources/js/jquery.min.js"></script>
<!-- jQuery Easing -->
<script src="/resources/js/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="/resources/js/bootstrap.min.js"></script>
<!-- Waypoints -->
<script src="/resources/js/jquery.waypoints.min.js"></script>
<!-- Carousel -->
<script src="/resources/js/owl.carousel.min.js"></script>
<!-- countTo -->
<script src="/resources/js/jquery.countTo.js"></script>
<!-- Flexslider -->
<script src="/resources/js/jquery.flexslider-min.js"></script>

<!-- Main -->
<script src="/resources/js/main.js"></script>

<!-- 유저 자바스크립트 연결 -->
<script src="/resources/js/user.js"></script>

</body>
</html>