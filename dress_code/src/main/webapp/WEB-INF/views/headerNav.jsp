<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"
                  isELIgnored="false"
                  buffer="none"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="utf-8">
    </head>
    <body>
    <nav class="fh5co-nav" role="navigation">
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-xs-2" style="width: 40%">
                    <div id="fh5co-logo">
                        <ul>
                            <a href="/">DRESS_CODE</a>
                            <% if (session.getAttribute("userName") != null) {%>
                                <li class="active" style="font-family: 'Malgun Gothic', '맑은 고딕', 'Arial', sans-serif;">
                                    <form action="logout" method="post">
                                        <span style="font-size: 14px;">${userName}님</span>
                                        <button class="btn btn-primary" type="submit" style="height: 30px; font-size: 15px;  padding: 5px;">로그아웃</button>
                                    </form>
                                </li>
                            <%} else {%>
                                <li class="active" style="font-family: 'Malgun Gothic', '맑은 고딕', 'Arial', sans-serif;">
                                    <a href="loginForm"><span style="font-family: 'Malgun Gothic', '맑은 고딕', 'Arial', sans-serif; font-size: 20px;">로그인</span></a>
                                </li>
                                <li class="active" style="font-family: 'Malgun Gothic', '맑은 고딕', 'Arial', sans-serif;">
                                    <a href="join"><span style="font-family: 'Malgun Gothic', '맑은 고딕', 'Arial', sans-serif; font-size: 20px;">회원가입</span></a></li>
                            <%}%>
                        </ul>
                    </div>
                </div>
                <div class="col-md-6 col-xs-6 text-center menu-1" style="width: 20%">
                    <ul>
                        <li class="has-dropdown">
                            <a href="product"><span style="font-family: 'Malgun Gothic', '맑은 고딕', 'Arial', sans-serif; font-size: 20px;">상품 목록</span></a>
                            <ul class="dropdown">
                                <li><a href="productUP">상의</a></li>
                                <li><a href="productBOTTOMS">하의</a></li>
                                <li><a href="productShoes">신발</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <div class="col-md-3 col-xs-4 text-right hidden-xs menu-2" style="width: 40%">
                    <ul>
                        <li class="search">
                            <div class="input-group">
                                <input type="text" placeholder="Search..">
                                <span class="input-group-btn">
                                    <button class="btn btn-primary" type="button">
                                        <i class="icon-search"></i>
                                    </button>
                                </span>
                            </div>
                        </li>
                        <li class="shopping-cart"><a href="#" class="cart"><span><small>0</small><i
                                class="icon-shopping-cart"></i></span></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
    </body>
</html>