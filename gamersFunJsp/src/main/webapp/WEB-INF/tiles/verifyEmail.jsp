<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>${title} - UltraNews - Bootstrap 4 Magazine Template</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" type="image/x-icon" href="${contextRoot}/imgs/favicon.png">
    <!-- UltraNews CSS  -->
    <link rel="stylesheet" href="${contextRoot}/css/style.css">
    <link rel="stylesheet" href="${contextRoot}/css/shop.css">
    <link rel="stylesheet" href="${contextRoot}/css/widgets.css">
    <link rel="stylesheet" href="${contextRoot}/css/color.css">
    <link rel="stylesheet" href="${contextRoot}/css/responsive.css">
</head>

<body class="category archive js">
<div class="scroll-progress primary-bg"></div>
<!-- Preloader Start -->
<div id="preloader-active">
    <div class="preloader d-flex align-items-center justify-content-center">
        <div class="preloader-inner position-relative">
            <div class="text-center">
                <div data-loader="spinner"></div>
                <p>Loading...</p>
            </div>
        </div>
    </div>
</div>
<div class="main-wrap">
    <!--Offcanvas sidebar-->
    <aside id="sidebar-wrapper" class="custom-scrollbar offcanvas-sidebar">
        <button class="off-canvas-close"><i class="ti-close"></i></button>
        <div class="sidebar-inner">
            <!--Categories-->
            <div class="sidebar-widget widget_categories mb-30">
                <div class="widget-header position-relative mb-20">
                    <h5 class="widget-title mt-5">Categories</h5>
                </div>
                <div class="post-block-list post-module-1 post-module-5">
                    <ul>
                        <li class="cat-item cat-item-2"><a href="category.html">Beauty</a> (3)</li>
                        <li class="cat-item cat-item-3"><a href="category.html">Book</a> (6)</li>
                        <li class="cat-item cat-item-4"><a href="category.html">Design</a> (4)</li>
                        <li class="cat-item cat-item-5"><a href="category.html">Fashion</a> (3)</li>
                        <li class="cat-item cat-item-6"><a href="category.html">Lifestyle</a> (6)</li>
                        <li class="cat-item cat-item-7"><a href="category.html">Travel</a> (2)</li>
                    </ul>
                </div>
            </div>
            <div class="sidebar-widget widget-latest-posts mb-30">
                <div class="widget-header position-relative mb-30">
                    <h5 class="widget-title mt-5 mb-30">Fashion</h5>
                </div>
                <div class="post-block-list post-module-1 post-module-5">
                    <ul class="list-post">
                        <li class="mb-30">
                            <div class="d-flex">
                                <div class="post-thumb d-flex mr-15 border-radius-5 img-hover-scale">
                                    <a class="color-white" href="single.html">
                                        <img src="http://via.placeholder.com/500x500" alt="">
                                    </a>
                                </div>
                                <div class="post-content media-body">
                                    <h6 class="post-title mb-10 text-limit-2-row"><a href="single.html">Traveling
                                        Tends to Magnify All Human Emotions</a></h6>
                                    <div class="entry-meta meta-1 font-x-small color-grey">
                                        <span class="post-on">25 April</span>
                                        <span class="hit-count has-dot">26k Views</span>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="mb-30">
                            <div class="d-flex">
                                <div class="post-thumb d-flex mr-15 border-radius-5 img-hover-scale">
                                    <a class="color-white" href="single.html">
                                        <img src="http://via.placeholder.com/500x500" alt="">
                                    </a>
                                </div>
                                <div class="post-content media-body">
                                    <h6 class="post-title mb-10 text-limit-2-row"><a href="single.html">The Luxury
                                        Of Traveling With Yacht</a></h6>
                                    <div class="entry-meta meta-1 font-x-small color-grey mt-10">
                                        <span class="post-on">25 April</span>
                                        <span class="hit-count has-dot">37k Views</span>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="mb-30">
                            <div class="d-flex">
                                <div class="post-thumb d-flex mr-15 border-radius-5 img-hover-scale">
                                    <a class="color-white" href="single.html">
                                        <img src="http://via.placeholder.com/500x500" alt="">
                                    </a>
                                </div>
                                <div class="post-content media-body">
                                    <h6 class="post-title mb-10 text-limit-2-row"><a href="single.html">Last Minute
                                        Festive Packages From Superbreak</a></h6>
                                    <div class="entry-meta meta-1 font-x-small color-grey mt-10">
                                        <span class="post-on">25 April</span>
                                        <span class="hit-count has-dot">54k Views</span>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="mb-30">
                            <div class="d-flex">
                                <div class="post-thumb d-flex mr-15 border-radius-5 img-hover-scale">
                                    <a class="color-white" href="single.html">
                                        <img src="http://via.placeholder.com/500x500" alt="">
                                    </a>
                                </div>
                                <div class="post-content media-body">
                                    <h6 class="post-title mb-10 text-limit-2-row"><a href="single.html">Last Minute
                                        Festive Packages From Superbreak</a></h6>
                                    <div class="entry-meta meta-1 font-x-small color-grey mt-10">
                                        <span class="post-on">25 April</span>
                                        <span class="hit-count has-dot">54k Views</span>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="mb-30">
                            <div class="d-flex">
                                <div class="post-thumb d-flex mr-15 border-radius-5 img-hover-scale">
                                    <a class="color-white" href="single.html">
                                        <img src="http://via.placeholder.com/500x500" alt="">
                                    </a>
                                </div>
                                <div class="post-content media-body">
                                    <h6 class="post-title mb-10 text-limit-2-row"><a href="single.html">Last Minute
                                        Festive Packages From Superbreak</a></h6>
                                    <div class="entry-meta meta-1 font-x-small color-grey mt-10">
                                        <span class="post-on">25 April</span>
                                        <span class="hit-count has-dot">54k Views</span>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="sidebar-widget widget-ads mb-30">
                <a href="http://via.placeholder.com/900x630" class="play-video" data-animate="zoomIn" data-duration="1.5s" data-delay="0.1s">
                    <img src="http://via.placeholder.com/432x336" alt="">
                </a>
            </div>
        </div>
    </aside>
    <tiles:insertAttribute name="header"/>
    <main class="position-relative background12">
        <!--Search Form-->
        <div class="main-search-form transition-02s">
            <div class="container">
                <div class="pt-50 pb-50 main-search-form-cover">
                    <div class="row mb-20">
                        <div class="col-12">
                            <form action="#" method="get" class="search-form position-relative">
                                <div class=" search-form-icon"><i class="ti-search"></i></div>
                                <label>
                                    <input type="text" class="search_field" placeholder="Enter keywords for search..." value="" name="s">
                                </label>
                                <div class="search-switch">
                                    <ul class="list-inline">
                                        <li class="list-inline-item"><a href="#" class="active">Articles</a></li>
                                        <li class="list-inline-item"><a href="#">Authors</a></li>
                                    </ul>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 font-small suggested-area">
                            <p class="d-inline font-small suggested"><strong>Suggested:</strong></p>
                            <ul class="list-inline d-inline-block">
                                <li class="list-inline-item"><a href="#">Covid-19</a></li>
                                <li class="list-inline-item"><a href="#">Health</a></li>
                                <li class="list-inline-item"><a href="#">WFH</a></li>
                                <li class="list-inline-item"><a href="#">UltraNet</a></li>
                                <li class="list-inline-item"><a href="#">Hospital</a></li>
                                <li class="list-inline-item"><a href="#">Policies</a></li>
                                <li class="list-inline-item"><a href="#">Energy</a></li>
                                <li class="list-inline-item"><a href="#">Business</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--main content-->
        <div class="main_content shop pb-80">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-xl-6 col-md-10">
                        <div class="login_wrap widget-taber-content p-30 background-white border-radius-5">
                            <div class="padding_eight_all bg-white">
                                <div class="heading_s1">
                                    <h3 class="mb-30">Email Sent</h3>
                                </div>

                                <div class="divider-text-center mt-15 mb-15">
                                    <span> Please check your email inbox to verify your email .</span>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <tiles:insertAttribute name="footer" />
</div>
<!-- Main Wrap End-->
<div class="dark-mark"></div>

<tiles:insertAttribute name="jsScripts"/>
</body>

</html>