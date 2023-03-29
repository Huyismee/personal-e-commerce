<%-- 
    Document   : index
    Created on : Nov 1, 2022, 8:03:44 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="Data.Skin" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

        <title>Cyborg - Awesome HTML5 Template</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


        <!-- Additional CSS Files -->
        <link rel="stylesheet" type="text/css" href="assets/css/fontawesome.css">
        <link rel="stylesheet" type="text/css" href="assets/css/templatemo-cyborg-gaming.css">
        <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
        <link rel="stylesheet" type="text/css" href="assets/css/owl.css">
        <link rel="stylesheet" href="assets/css/animate.css">
        <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css"/>
        <!--
        
        TemplateMo 579 Cyborg Gaming
        
        https://templatemo.com/tm-579-cyborg-gaming
        
        -->
    </head>

    <body>

        <!-- ***** Preloader Start ***** -->
        <div id="js-preloader" class="js-preloader">
            <div class="preloader-inner">
                <span class="dot"></span>
                <div class="dots">
                    <span></span>
                    <span></span>
                    <span></span>
                </div>
            </div>
        </div>
        <!-- ***** Preloader End ***** -->

        <!-- ***** Header Area Start ***** -->
        <header class="header-area header-sticky">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <nav class="main-nav">
                            <!-- ***** Logo Start ***** -->
                            <a href="main" class="logo">
                                <img src="assets/images/val.png" alt="">
                            </a>
                            <!-- ***** Logo End ***** -->
                            <!-- ***** Search End ***** -->
                            <div class="search-input">
                                <form id="search" action="browse" method="POST">
                                    <input type="text" placeholder="Find Something" id='searchText' name="input" onkeypress="handle" style="margin: 0;
                                           width: auto;"/>
                                    <i class="fa fa-search"></i>
                                </form>
                            </div>
                            <!-- ***** Search End ***** -->
                            <!-- ***** Menu Start ***** -->
                            <ul class="nav">
                                <form action="login" Method="POST">
                                    <c:if test="${account == 'admin'}">
                                        <li><a href="edit?mode=1" >Edit</a></li>
                                    </c:if>
                                    <li><a href="main" >Home</a></li>
                                    <li><a href="browse" class="active">Browse</a></li>
                                    <li><input type="submit" name="logout" value="Log Out"></li>
                                </form>
                            </ul>     
                            <a class='menu-trigger'>
                                <span>Menu</span>
                            </a>
                            <!-- ***** Menu End ***** -->
                        </nav>
                    </div>
                </div>
            </div>
        </header>
        <!-- ***** Header Area End ***** -->


        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="page-content">

                        <!-- ***** Banner Start ***** -->
                        <div class="browse-banner">
                            <div class="row">
                                <div class="col-lg-7">
                                    <div class="header-text">
                                        <h6>Pick Your Best <em>Weapon</em></h6>
                                        <h4><em>DEFINE</em> YOUR STYLE WITH VALO GUNSMITH</h4> 

                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- ***** Banner End ***** -->

                        <!-- ***** Most Popular Start ***** -->
                        <div class="row">
                            <div class="most-popular">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="heading-section">
                                            <h4><em>Browse</em> Gunsmith Now</h4>
                                        </div>
                                        <div class="row">
                                            <c:forEach items="${sList}" var = "item">
                                                <div class="col-lg-3 col-sm-6">
                                                    <a href="detail?id=${item.getItemId()}" class="item" style="display: block">
                                                        <div class="gun">
                                                            <img src="${item.getImg()}" alt="">
                                                        </div>
                                                        <h4>${item.getName()} <img style="width: 18px" src="${item.getEdition()}" ><br><span>${item.getGunName()}</span></h4>
                                                        <ul>
                                                            <li><i class="fa fa-dollar"></i> ${item.getPrice()}</li>
                                                            <li><i class="fa fa-boxes-stacked"></i> ${item.getStock()}</li>
                                                            <li><i class=""></i>View: ${item.getViewNum()}</li>
                                                        </ul>
                                                    </a>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- ***** Most Popular End ***** -->

                            <!-- ***** Gaming Library Start ***** -->
                            <!-- ***** Gaming Library End ***** -->
                        </div>
                        <div class="gaming-library">
                            <h3>CHOOSE YOUR OWN <em>STYLE</em></h3>
                        </div>
                    </div>
                </div> 
                <footer>
                    <div class="footer__container">
                        <div class="footer__about">
                            <a href="#" class="logo">
                                <span class="logo__text"> Valo Gunsmith </span>
                                <img width=35px height=auto src="https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/217d5ea0-623d-40b1-9b31-027b904a5f15/de9c55i-a9f9659c-6618-40aa-a929-1df276518a25.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzIxN2Q1ZWEwLTYyM2QtNDBiMS05YjMxLTAyN2I5MDRhNWYxNVwvZGU5YzU1aS1hOWY5NjU5Yy02NjE4LTQwYWEtYTkyOS0xZGYyNzY1MThhMjUucG5nIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.xbaL4M9esVlNebimkbUKXLjhoMw_iQejkPd9r9L77DE" style="width: 35px">
                            </a>
                            <div class="social">
                                <a href="" class="social__item">
                                    <i class="fab fa-github" aria-hidden="true"></i>
                                </a>
                                <a href="" class="social__item">
                                    <i class="fab fa-facebook-f" aria-hidden="true"></i>
                                </a>
                                <a href="" class="social__item">
                                    <i class="fab fa-instagram" aria-hidden="true"></i>
                                </a>
                                <a href="" class="social__item">
                                    <i class="fab fa-twitter" aria-hidden="true"></i>
                                </a>
                            </div>
                        </div>
                        <div class="footer__link">
                            <h3 class="footer__link__title">About Us</h3>
                            <ul class="footer__list">
                                <li class="footer__item">
                                    <a href="/about_us" class="footer__item__link">Huy Nguyen</a>
                                </li>                      
                            </ul>
                        </div>
                        <div class="footer__link">
                            <h3 class="footer__link__title">Contact</h3>
                            <ul class="footer__list">
                                <li class="footer__item">
                                    <a href="https://discord.gg/EF8RbGG" class="footer__item__link" target="_blank">Discord</a>
                                </li>
                                <li class="footer__item">
                                    <a href="mailto:huynqhe163750@fpt.edu.vn" class="footer__item__link">Email</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </footer>
                <div class="footer__bottom">
                    <p class="footer__bottom__text">© 2022 HuyMe. ALL RIGHT RESERVED.</p>
                </div>
            </div>
        </div>




        <!-- Scripts -->
        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

        <script src="assets/js/isotope.min.js"></script>
        <script src="assets/js/owl-carousel.js"></script>
        <script src="assets/js/tabs.js"></script>
        <script src="assets/js/popup.js"></script>
        <script src="assets/js/custom.js"></script>
        <script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>


    </body>

</html>
