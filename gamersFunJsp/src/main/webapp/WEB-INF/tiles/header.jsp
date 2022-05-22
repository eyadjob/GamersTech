<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Main Wrap Start -->
<header class="main-header header-style-2">
    <div class="top-bar background-white d-none d-md-block">
        <div class="container">
            <div class="topbar-inner pt-10 pb-10">
                <div class="row">
                    <div class="col-6">
                        <div class="language d-inline-block font-small">
                            <div id="langMenuDropdow" class="dropdown-menu dropdown-menu-left" aria-labelledby="langMenu">
                                <a class="dropdown-item" href="#">Français</a>
                                <a class="dropdown-item" href="#">English</a>
                                <a class="dropdown-item" href="#">Deutsch</a>
                                <a class="dropdown-item" href="#">РУССКИЙ</a>
                            </div>
                            <a class="dropdown-toggle" href="#" role="button" id="langMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="ti-world mr-5"></i>
                                <span>EN</span>
                            </a>
                        </div>
                        <div id="datetime" class="d-inline-block">
                            <ul>
                                <li><span class="font-small"><i class="wi wi-day-cloudy mr-5"></i>34ºc, Sunny. <a class="active" href="#">London</a></span></li>
                                <li><span class="font-small"><i class="ti-calendar mr-5"></i>Monday, April 6, 2020</span></li>
                                <li><a class="active" href="#"><span class="font-small"><i class="ti-book mr-5"></i>Read Today’s Paper</span></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-6 text-right">
                        <ul class="header-social-network d-inline-block list-inline">
                            <li class="list-inline-item"><a class="social-icon facebook-icon text-xs-center" target="_blank" href="#"><i class="ti-facebook"></i></a></li>
                            <li class="list-inline-item"><a class="social-icon twitter-icon text-xs-center" target="_blank" href="#"><i class="ti-twitter-alt"></i></a></li>
                            <li class="list-inline-item"><a class="social-icon pinterest-icon text-xs-center" target="_blank" href="#"><i class="ti-pinterest"></i></a></li>
                            <li class="list-inline-item"><a class="social-icon instagram-icon text-xs-center" target="_blank" href="#"><i class="ti-instagram"></i></a></li>
                        </ul>
                        <div class="vline-space d-inline-block"></div>
                        <sec:authorize access="!isAuthenticated()">
                            <div class="userEntity-account d-inline-block font-small">
                                <a class="dropdown-toggle" href="#" role="button" id="userMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="ti-userEntity"></i>
                                    <span>Crate Account</span>
                                </a>
                                <div id="userMenuDropdow" class="dropdown-menu dropdown-menu-right" aria-labelledby="userMenu">
                                    <a class="dropdown-item" href="${contextRoot}/signup"><i class="ti-pencil-alt"></i>Sign Up</a>
                                </div>
                            </div>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <div class="userEntity-account d-inline-block font-small">
                                <a class="dropdown-toggle" href="#" role="button" id="userMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="ti-userEntity"></i>
                                    <span>Account</span>
                                </a>
                                <div id="userMenuDropdow" class="dropdown-menu dropdown-menu-right" aria-labelledby="userMenu">
                                    <a class="dropdown-item" href="#"><i class="ti-pencil-alt"></i>Go to Admin Page</a>
                                    <a class="dropdown-item" href="javascript:$('#logoutForm').submit()"><i class="ti-share"></i>Logout</a>
                                </div>
                            </div>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                            <div class="userEntity-account d-inline-block font-small">
                                <a class="dropdown-toggle" href="#" role="button" id="userMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="ti-userEntity"></i>
                                    <span>Account</span>
                                </a>
                                <div id="userMenuDropdow" class="dropdown-menu dropdown-menu-right" aria-labelledby="userMenu">
                                    <a class="dropdown-item" href="#"><i class="ti-pencil-alt"></i>Edit Profile</a>
                                    <a class="dropdown-item" href="#"><i class="ti-settings"></i>Account Settings</a>
                                    <a class="dropdown-item" href="#"><i class="ti-stats-up"></i>Your Dashboard</a>
                                    <a class="dropdown-item" href="#"><i class="ti-heart"></i>Your Favorites</a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="javascript:$('#logoutForm').submit()"><i class="ti-share"></i>Logout</a>
                                </div>
                            </div>
                        </sec:authorize>

                        <c:url var="logoutLink" value="/logout"/>
                        <form id="logoutForm" method="post" action="${logoutLink}">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--End top bar-->
    <div class="header-bottom header-sticky background-white text-center">
        <div class="mobile_menu d-lg-none d-block"></div>
        <div class="container">
            <div class="row">
                <div class="col-lg-2 d-none d-lg-block">
                    <div class="header-logo">
                        <a href="index.html">
                            <img class="logo-img d-inline" src="${contextRoot}/imgs/logo-2.png" alt="">
                        </a>
                    </div>
                </div>
                <div class="col-lg-10 col-md-12">
                    <div class="logo-tablet d-md-inline d-lg-none d-none">
                        <a href="index.html">
                            <img class="logo-img d-inline" src="${contextRoot}/imgs/logo-tablet.png" alt="">
                        </a>
                    </div>
                    <div class="logo-mobile d-inline d-md-none">
                        <a href="index.html">
                            <img class="logo-img d-inline" src="${contextRoot}/imgs/logo-mobile.png" alt="">
                        </a>
                    </div>
                    <!-- Main-menu -->
                    <div class="main-nav text-left d-none d-lg-block">
                        <nav>
                            <ul id="navigation" class="main-menu">
                                <li class="menu-item-has-children">
                                    <a href="index.html">Home</a>
                                    <ul class="sub-menu">
                                        <li><a href="index.html">Home default</a></li>
                                        <li><a href="home-2.html">Homepage 2</a></li>
                                        <li><a href="home-3.html">Homepage 3</a></li>
                                    </ul>
                                </li>
                                <li class="mega-menu-item">
                                    <a href="category.html">Mega menu</a>
                                    <div class="sub-mega-menu">
                                        <div class="nav flex-column nav-pills" role="tablist">
                                            <a class="nav-link active" data-toggle="pill" href="#news-0" role="tab">All</a>
                                            <a class="nav-link" data-toggle="pill" href="#news-1" role="tab">Entertaiment</a>
                                            <a class="nav-link" data-toggle="pill" href="#news-2" role="tab">Fashion</a>
                                            <a class="nav-link" data-toggle="pill" href="#news-3" role="tab">Life Style</a>
                                            <a class="nav-link" data-toggle="pill" href="#news-4" role="tab">Technology</a>
                                            <a class="nav-link" data-toggle="pill" href="#news-5" role="tab">Travel</a>
                                        </div>
                                        <div class="tab-content">
                                            <div class="tab-pane show active" id="news-0" role="tabpanel">
                                                <div class="row">
                                                    <div class="col-3 post-module-1">
                                                        <div class="post-thumb d-flex border-radius-5 img-hover-scale mb-15">
                                                            <a href="single.html">
                                                                <img src="http://via.placeholder.com/900x630" alt="">
                                                            </a>
                                                            <span class="top-right-icon background2">
                                                                        <i class="mdi mdi-audiotrack"></i>
                                                                    </span>
                                                        </div>
                                                        <div class="post-content media-body">
                                                            <h6 class="post-title mb-10 text-limit-2-row">The litigants on the screen are not actors </h6>
                                                            <div class="entry-meta meta-1 font-x-small color-grey">
                                                                <span class="post-on">25 April</span>
                                                                <span class="hit-count has-dot">126k Views</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-3 post-module-1">
                                                        <div class="post-thumb d-flex border-radius-5 img-hover-scale mb-15">
                                                            <a href="single.html">
                                                                <img src="http://via.placeholder.com/900x630" alt="">
                                                            </a>
                                                        </div>
                                                        <div class="post-content media-body">
                                                            <h6 class="post-title mb-10 text-limit-2-row">Not a bit of hesitation, you better think twice</h6>
                                                            <div class="entry-meta meta-1 font-x-small color-grey mt-10">
                                                                <span class="post-on">25 April</span>
                                                                <span class="hit-count has-dot">126k Views</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-3 post-module-1">
                                                        <div class="post-thumb d-flex border-radius-5 img-hover-scale mb-15">
                                                            <a href="single.html">
                                                                <img src="http://via.placeholder.com/900x630" alt="">
                                                            </a>
                                                        </div>
                                                        <div class="post-content media-body">
                                                            <h6 class="post-title mb-10 text-limit-2-row">We got a right to pick a little fight, Bonanza </h6>
                                                            <div class="entry-meta meta-1 font-x-small color-grey mt-10">
                                                                <span class="post-on">25 April</span>
                                                                <span class="hit-count has-dot">126k Views</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-3 post-module-1">
                                                        <div class="post-thumb d-flex border-radius-5 img-hover-scale mb-15">
                                                            <a href="single.html">
                                                                <img src="http://via.placeholder.com/900x630" alt="">
                                                            </a>
                                                        </div>
                                                        <div class="post-content media-body">
                                                            <h6 class="post-title mb-10 text-limit-2-row">My entrance exam was on a book of matches </h6>
                                                            <div class="entry-meta meta-1 font-x-small color-grey mt-10">
                                                                <span class="post-on">25 April</span>
                                                                <span class="hit-count has-dot">126k Views</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="tab-pane" id="news-1" role="tabpanel">
                                                <div class="row">
                                                    <div class="col-3 post-module-1">
                                                        <div class="post-thumb d-flex border-radius-5 img-hover-scale mb-15">
                                                            <a href="single.html">
                                                                <img src="http://via.placeholder.com/900x630" alt="">
                                                            </a>
                                                        </div>
                                                        <div class="post-content media-body">
                                                            <h6 class="post-title mb-10 text-limit-2-row">The litigants on the screen are not actors </h6>
                                                            <div class="entry-meta meta-1 font-x-small color-grey">
                                                                <span class="post-on">25 April</span>
                                                                <span class="hit-count has-dot">126k Views</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-3 post-module-1">
                                                        <div class="post-thumb d-flex border-radius-5 img-hover-scale mb-15">
                                                            <a href="single.html">
                                                                <img src="http://via.placeholder.com/900x630" alt="">
                                                            </a>
                                                            <span class="top-right-icon background3">
                                                                        <i class="mdi mdi-videocam"></i>
                                                                    </span>
                                                        </div>
                                                        <div class="post-content media-body">
                                                            <h6 class="post-title mb-10 text-limit-2-row">Not a bit of hesitation, you better think twice</h6>
                                                            <div class="entry-meta meta-1 font-x-small color-grey mt-10">
                                                                <span class="post-on">25 April</span>
                                                                <span class="hit-count has-dot">126k Views</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-3 post-module-1">
                                                        <div class="post-thumb d-flex border-radius-5 img-hover-scale mb-15">
                                                            <a href="single.html">
                                                                <img src="http://via.placeholder.com/900x630" alt="">
                                                            </a>
                                                        </div>
                                                        <div class="post-content media-body">
                                                            <h6 class="post-title mb-10 text-limit-2-row">We got a right to pick a little fight, Bonanza </h6>
                                                            <div class="entry-meta meta-1 font-x-small color-grey mt-10">
                                                                <span class="post-on">25 April</span>
                                                                <span class="hit-count has-dot">126k Views</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-3 post-module-1">
                                                        <div class="post-thumb d-flex border-radius-5 img-hover-scale mb-15">
                                                            <a href="single.html">
                                                                <img src="http://via.placeholder.com/900x630" alt="">
                                                            </a>
                                                        </div>
                                                        <div class="post-content media-body">
                                                            <h6 class="post-title mb-10 text-limit-2-row">My entrance exam was on a book of matches </h6>
                                                            <div class="entry-meta meta-1 font-x-small color-grey mt-10">
                                                                <span class="post-on">25 April</span>
                                                                <span class="hit-count has-dot">126k Views</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="tab-pane" id="news-2" role="tabpanel">
                                                <div class="row">
                                                    <div class="col-3 post-module-1">
                                                        <div class="post-thumb d-flex border-radius-5 img-hover-scale mb-15">
                                                            <a href="single.html">
                                                                <img src="http://via.placeholder.com/900x630" alt="">
                                                            </a>
                                                            <span class="top-right-icon background2">
                                                                        <i class="mdi mdi-audiotrack"></i>
                                                                    </span>
                                                        </div>
                                                        <div class="post-content media-body">
                                                            <h6 class="post-title mb-10 text-limit-2-row">The litigants on the screen are not actors </h6>
                                                            <div class="entry-meta meta-1 font-x-small color-grey">
                                                                <span class="post-on">25 April</span>
                                                                <span class="hit-count has-dot">126k Views</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-3 post-module-1">
                                                        <div class="post-thumb d-flex border-radius-5 img-hover-scale mb-15">
                                                            <a href="single.html">
                                                                <img src="http://via.placeholder.com/900x630" alt="">
                                                            </a>
                                                            <span class="top-right-icon background8">
                                                                        <i class="mdi mdi-favorite"></i>
                                                                    </span>
                                                        </div>
                                                        <div class="post-content media-body">
                                                            <h6 class="post-title mb-10 text-limit-2-row">Not a bit of hesitation, you better think twice</h6>
                                                            <div class="entry-meta meta-1 font-x-small color-grey mt-10">
                                                                <span class="post-on">25 April</span>
                                                                <span class="hit-count has-dot">126k Views</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-3 post-module-1">
                                                        <div class="post-thumb d-flex border-radius-5 img-hover-scale mb-15">
                                                            <a href="single.html">
                                                                <img src="http://via.placeholder.com/900x630" alt="">
                                                            </a>
                                                        </div>
                                                        <div class="post-content media-body">
                                                            <h6 class="post-title mb-10 text-limit-2-row">We got a right to pick a little fight, Bonanza </h6>
                                                            <div class="entry-meta meta-1 font-x-small color-grey mt-10">
                                                                <span class="post-on">25 April</span>
                                                                <span class="hit-count has-dot">126k Views</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-3 post-module-1">
                                                        <div class="post-thumb d-flex border-radius-5 img-hover-scale mb-15">
                                                            <a href="single.html">
                                                                <img src="http://via.placeholder.com/900x630" alt="">
                                                            </a>
                                                        </div>
                                                        <div class="post-content media-body">
                                                            <h6 class="post-title mb-10 text-limit-2-row">My entrance exam was on a book of matches </h6>
                                                            <div class="entry-meta meta-1 font-x-small color-grey mt-10">
                                                                <span class="post-on">25 April</span>
                                                                <span class="hit-count has-dot">126k Views</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="tab-pane" id="news-3" role="tabpanel">
                                                <div class="row">
                                                    <div class="col-3 post-module-1">
                                                        <div class="post-thumb d-flex border-radius-5 img-hover-scale mb-15">
                                                            <a href="single.html">
                                                                <img src="http://via.placeholder.com/900x630" alt="">
                                                            </a>
                                                        </div>
                                                        <div class="post-content media-body">
                                                            <h6 class="post-title mb-10 text-limit-2-row">The litigants on the screen are not actors </h6>
                                                            <div class="entry-meta meta-1 font-x-small color-grey">
                                                                <span class="post-on">25 April</span>
                                                                <span class="hit-count has-dot">126k Views</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-3 post-module-1">
                                                        <div class="post-thumb d-flex border-radius-5 img-hover-scale mb-15">
                                                            <a href="single.html">
                                                                <img src="http://via.placeholder.com/900x630" alt="">
                                                            </a>
                                                        </div>
                                                        <div class="post-content media-body">
                                                            <h6 class="post-title mb-10 text-limit-2-row">Not a bit of hesitation, you better think twice</h6>
                                                            <div class="entry-meta meta-1 font-x-small color-grey mt-10">
                                                                <span class="post-on">25 April</span>
                                                                <span class="hit-count has-dot">126k Views</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-3 post-module-1">
                                                        <div class="post-thumb d-flex border-radius-5 img-hover-scale mb-15">
                                                            <a href="single.html">
                                                                <img src="http://via.placeholder.com/900x630" alt="">
                                                            </a>
                                                        </div>
                                                        <div class="post-content media-body">
                                                            <h6 class="post-title mb-10 text-limit-2-row">We got a right to pick a little fight, Bonanza </h6>
                                                            <div class="entry-meta meta-1 font-x-small color-grey mt-10">
                                                                <span class="post-on">25 April</span>
                                                                <span class="hit-count has-dot">126k Views</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-3 post-module-1">
                                                        <div class="post-thumb d-flex border-radius-5 img-hover-scale mb-15">
                                                            <a href="single.html">
                                                                <img src="http://via.placeholder.com/900x630" alt="">
                                                            </a>
                                                            <span class="top-right-icon background2">
                                                                        <i class="mdi mdi-audiotrack"></i>
                                                                    </span>
                                                        </div>
                                                        <div class="post-content media-body">
                                                            <h6 class="post-title mb-10 text-limit-2-row">My entrance exam was on a book of matches </h6>
                                                            <div class="entry-meta meta-1 font-x-small color-grey mt-10">
                                                                <span class="post-on">25 April</span>
                                                                <span class="hit-count has-dot">126k Views</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="tab-pane" id="news-4" role="tabpanel">
                                                <div class="row">
                                                    <div class="col-3 post-module-1 text-left">
                                                        <div class="post-thumb position-relative">
                                                            <div class="thumb-overlay img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/900x630)">
                                                                <a class="img-link" href="single.html" tabindex="0"></a>
                                                                <span class="top-right-icon background10">
                                                                            <i class="mdi mdi-audiotrack"></i>
                                                                        </span>
                                                                <div class="post-content-overlay">
                                                                    <div class="entry-meta meta-0 font-small mb-10">
                                                                        <a href="category.html" tabindex="0"><span class="post-cat background2 color-white">Gaming</span></a>
                                                                    </div>
                                                                    <h6 class="post-title">
                                                                        <a class="color-white" href="single.html" tabindex="0">Tesla’s Cooking Up A New Way To Wire Its Cars, Report Says</a>
                                                                    </h6>
                                                                    <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                                                        <span class="post-on">02 Jan</span>
                                                                        <span class="hit-count has-dot">23k Views</span>
                                                                        <a class="float-right" href="#" tabindex="0"><i class="ti-heart"></i></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-3 post-module-1 text-left">
                                                        <div class="post-thumb position-relative">
                                                            <div class="thumb-overlay img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/900x630)">
                                                                <a class="img-link" href="single.html" tabindex="0"></a>
                                                                <div class="post-content-overlay">
                                                                    <div class="entry-meta meta-0 font-small mb-10">
                                                                        <a href="category.html" tabindex="0"><span class="post-cat background7 color-white">Travel</span></a>
                                                                    </div>
                                                                    <h6 class="post-title">
                                                                        <a class="color-white" href="single.html" tabindex="0">Tesla’s Cooking Up A New Way To Wire Its Cars, Report Says</a>
                                                                    </h6>
                                                                    <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                                                        <span class="post-on">02 Jan</span>
                                                                        <span class="hit-count has-dot">23k Views</span>
                                                                        <a class="float-right" href="#" tabindex="0"><i class="ti-heart"></i></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-3 post-module-1 text-left">
                                                        <div class="post-thumb position-relative">
                                                            <div class="thumb-overlay img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/900x630)">
                                                                <a class="img-link" href="single.html" tabindex="0"></a>
                                                                <div class="post-content-overlay">
                                                                    <div class="entry-meta meta-0 font-small mb-10">
                                                                        <a href="category.html" tabindex="0"><span class="post-cat background4 color-white">World</span></a>
                                                                    </div>
                                                                    <h6 class="post-title">
                                                                        <a class="color-white" href="single.html" tabindex="0">Tesla’s Cooking Up A New Way To Wire Its Cars, Report Says</a>
                                                                    </h6>
                                                                    <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                                                        <span class="post-on">02 Jan</span>
                                                                        <span class="hit-count has-dot">23k Views</span>
                                                                        <a class="float-right" href="#" tabindex="0"><i class="ti-heart"></i></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-3 post-module-1 text-left">
                                                        <div class="post-thumb position-relative">
                                                            <div class="thumb-overlay img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/900x630)">
                                                                <a class="img-link" href="single.html" tabindex="0"></a>
                                                                <div class="post-content-overlay">
                                                                    <div class="entry-meta meta-0 font-small mb-10">
                                                                        <a href="category.html" tabindex="0"><span class="post-cat background3 color-white">Fashion</span></a>
                                                                    </div>
                                                                    <h6 class="post-title">
                                                                        <a class="color-white" href="single.html" tabindex="0">Tesla’s Cooking Up A New Way To Wire Its Cars, Report Says</a>
                                                                    </h6>
                                                                    <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                                                        <span class="post-on">02 Jan</span>
                                                                        <span class="hit-count has-dot">23k Views</span>
                                                                        <a class="float-right" href="#" tabindex="0"><i class="ti-heart"></i></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="tab-pane" id="news-5" role="tabpanel">
                                                <div class="row">
                                                    <div class="col-3 post-module-1 text-left">
                                                        <div class="post-thumb position-relative">
                                                            <div class="thumb-overlay img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/500x500)">
                                                                <a class="img-link" href="single.html" tabindex="0"></a>
                                                                <span class="top-right-icon background3">
                                                                            <i class="mdi mdi-videocam"></i>
                                                                        </span>
                                                                <div class="post-content-overlay">
                                                                    <div class="entry-meta meta-0 font-small mb-10">
                                                                        <a href="category.html" tabindex="0"><span class="post-cat background2 color-white">Gaming</span></a>
                                                                    </div>
                                                                    <h6 class="post-title">
                                                                        <a class="color-white" href="single.html" tabindex="0">Tesla’s Cooking Up A New Way To Wire Its Cars, Report Says</a>
                                                                    </h6>
                                                                    <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                                                        <span class="post-on">02 Jan</span>
                                                                        <span class="hit-count has-dot">23k Views</span>
                                                                        <a class="float-right" href="#" tabindex="0"><i class="ti-heart"></i></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-3 post-module-1 text-left">
                                                        <div class="post-thumb position-relative">
                                                            <div class="thumb-overlay img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/500x500)">
                                                                <a class="img-link" href="single.html" tabindex="0"></a>
                                                                <div class="post-content-overlay">
                                                                    <div class="entry-meta meta-0 font-small mb-10">
                                                                        <a href="category.html" tabindex="0"><span class="post-cat background7 color-white">Travel</span></a>
                                                                    </div>
                                                                    <h6 class="post-title">
                                                                        <a class="color-white" href="single.html" tabindex="0">Tesla’s Cooking Up A New Way To Wire Its Cars, Report Says</a>
                                                                    </h6>
                                                                    <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                                                        <span class="post-on">02 Jan</span>
                                                                        <span class="hit-count has-dot">23k Views</span>
                                                                        <a class="float-right" href="#" tabindex="0"><i class="ti-heart"></i></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-3 post-module-1 text-left">
                                                        <div class="post-thumb position-relative">
                                                            <div class="thumb-overlay img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/500x500)">
                                                                <a class="img-link" href="single.html" tabindex="0"></a>
                                                                <div class="post-content-overlay">
                                                                    <div class="entry-meta meta-0 font-small mb-10">
                                                                        <a href="category.html" tabindex="0"><span class="post-cat background4 color-white">World</span></a>
                                                                    </div>
                                                                    <h6 class="post-title">
                                                                        <a class="color-white" href="single.html" tabindex="0">Tesla’s Cooking Up A New Way To Wire Its Cars, Report Says</a>
                                                                    </h6>
                                                                    <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                                                        <span class="post-on">02 Jan</span>
                                                                        <span class="hit-count has-dot">23k Views</span>
                                                                        <a class="float-right" href="#" tabindex="0"><i class="ti-heart"></i></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-3 post-module-1 text-left">
                                                        <div class="post-thumb position-relative">
                                                            <div class="thumb-overlay img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/500x500)">
                                                                <a class="img-link" href="single.html" tabindex="0"></a>
                                                                <div class="post-content-overlay">
                                                                    <div class="entry-meta meta-0 font-small mb-10">
                                                                        <a href="category.html" tabindex="0"><span class="post-cat background3 color-white">Fashion</span></a>
                                                                    </div>
                                                                    <h6 class="post-title">
                                                                        <a class="color-white" href="single.html" tabindex="0">Tesla’s Cooking Up A New Way To Wire Its Cars, Report Says</a>
                                                                    </h6>
                                                                    <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                                                        <span class="post-on">02 Jan</span>
                                                                        <span class="hit-count has-dot">23k Views</span>
                                                                        <a class="float-right" href="#" tabindex="0"><i class="ti-heart"></i></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="menu-item-has-children">
                                    <a href="shop-category.html">Shop</a>
                                    <ul class="sub-menu">
                                        <li><a href="shop-cart.html">Cart</a></li>
                                        <li><a href="shop-checkout.html">Checkout</a></li>
                                        <li><a href="shop-account.html">My Account</a></li>
                                        <li><a href="shop-wishlist.html">Wishlist</a></li>
                                        <li><a href="shop-compare.html">Compare</a></li>
                                        <li><a href="shop-order.html">Order completed</a></li>
                                        <li><a href="shop-product-detail.html">Product details</a></li>
                                        <li><a href="shop-product-detail-full.html">Product details full</a></li>
                                    </ul>
                                </li>
                                <sec:authorize access="!isAuthenticated()">
                                    <li><a href="${contextRoot}/login">Sign In</a></li>
                                </sec:authorize>
                                <li><a href="${contextRoot}/about">About</a></li>
                                <li class="menu-item-has-children">
                                    <a href="category.html">Category</a>
                                    <ul class="sub-menu">
                                        <li><a href="category.html">List</a></li>
                                        <li><a href="category-grid.html">Grid</a></li>
                                        <li><a href="category-metro.html">Metro</a></li>
                                        <li><a href="category-big.html">Big</a></li>
                                    </ul>
                                </li>
                                <li class="menu-item-has-children">
                                    <a href="single.html">Posts</a>
                                    <ul class="sub-menu">
                                        <li><a href="single.html">Layout 1</a></li>
                                        <li><a href="single-2.html">Layout 2</a></li>
                                        <li><a href="single-3.html">Layout 3</a></li>
                                    </ul>
                                </li>
                                <li class="menu-item-has-children"><a href="#">Pages</a>
                                    <ul class="sub-menu">
                                        <li><a href="404.html">404</a></li>
                                        <li><a href="${contextRoot}/author">Author</a></li>
                                        <li><a href="${contextRoot}/search">Search</a></li>
                                    </ul>
                                </li>
                                <li><a href="contact.html">Contact</a></li>
                            </ul>
                        </nav>
                    </div>
                    <!-- Off canvas -->
                    <div class="off-canvas-toggle-cover">
                        <div class="off-canvas-toggle hidden d-inline-block ml-15" id="off-canvas-toggle">
                            <span></span>
                            <p class="font-small d-none d-md-inline">All Sections</p>
                        </div>
                    </div>
                    <!-- Search -->
                    <div class="search-button">
                        <button class="search-icon"><i class="ti-search"></i></button>
                        <span class="search-close float-right font-small"><i class="ti-close mr-5"></i>CLOSE</span>
                    </div>
                    <!-- Shopping cart -->
                    <div class="nav-shopping-cart">
                        <div class="dropdown cart_dropdown">
                            <a class="cart-icon nav-link cart_trigger" href="#" data-toggle="dropdown" aria-expanded="false">
                                        <span class="position-relative">
                                            <i class="ti-bag"></i>
                                            <span class="cart_count">2</span>
                                        </span>
                            </a>
                            <div class="cart_box dropdown-menu dropdown-menu-right keep-open">
                                <ul class="cart_list">
                                    <li>
                                        <img class="float-left" src="http://via.placeholder.com/600x600" alt="cart_thumb1">
                                        <a href="#">Dead Men Womens2</a>
                                        <a href="#" class="item_remove font-small"><i class="ti-close"></i></a>
                                        <span class="cart_quantity"> 1 x <span class="cart_amount"> <span class="price_symbole">$</span></span>75.00</span>
                                    </li>
                                    <li>
                                        <img class="float-left" src="http://via.placeholder.com/600x600" alt="cart_thumb1">
                                        <a href="#">Zoo Puzzle Kids</a>
                                        <a href="#" class="item_remove font-small"><i class="ti-close"></i></a>
                                        <span class="cart_quantity"> 2 x <span class="cart_amount"> <span class="price_symbole">$</span></span>25.00</span>
                                    </li>
                                </ul>
                                <div class="cart_footer mt-15 pb-15">
                                    <p class="cart_total"><strong>Subtotal:</strong> <span class="cart_price"> <span class="price_symbole">$</span></span>125.00</p>
                                    <p class="cart_buttons">
                                        <a href="shop-cart.html" class="btn btn-dark view-cart"><i class="ti-shopping-cart mr-5"></i>View Cart</a>
                                        <a href="shop-checkout.html" class="btn checkout"><i class="ti-check-box mr-5"></i>Checkout</a></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>