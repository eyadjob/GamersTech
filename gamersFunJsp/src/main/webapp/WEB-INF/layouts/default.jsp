<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>UltraNews - Bootstrap 4 Magazine Template</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
    <link rel="shortcut icon" type="image/x-icon" href="${contextRoot}/imgs/favicon.png">
    <!-- UltraNews CSS  -->
    <link rel="stylesheet" href="${contextRoot}/css/style.css">
    <link rel="stylesheet" href="${contextRoot}/css/widgets.css">
    <link rel="stylesheet" href="${contextRoot}/css/color.css">
    <link rel="stylesheet" href="${contextRoot}/css/responsive.css">
</head>

<body>
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
    <aside id="sidebar-wrapper" class="custom-scrollbar offcanvas-sidebar position-right">
        <button class="off-canvas-close"><i class="ti-close"></i></button>
        <div class="sidebar-inner">
            <!--Categories-->
            <div class="sidebar-widget widget_categories mb-50">
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
                                    <h6 class="post-title mb-10 text-limit-2-row"><a href="single.html">Traveling Tends to Magnify All Human Emotions</a></h6>
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
                                    <h6 class="post-title mb-10 text-limit-2-row"><a href="single.html">The Luxury Of Traveling With Yacht</a></h6>
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
                                    <h6 class="post-title mb-10 text-limit-2-row"><a href="single.html">Last Minute Festive Packages From Superbreak</a></h6>
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
                                    <h6 class="post-title mb-10 text-limit-2-row"><a href="single.html">Last Minute Festive Packages From Superbreak</a></h6>
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
                                    <h6 class="post-title mb-10 text-limit-2-row"><a href="single.html">Last Minute Festive Packages From Superbreak</a></h6>
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

    <main class="position-relative">
        <!--Search Form-->
        <div class="main-search-form transition-02s">
            <div class="container">
                <div class="pt-50 pb-50 main-search-form-cover">
                    <div class="row mb-20">
                        <div class="col-12">
                            <form action="#" method="get" class="search-form position-relative">
                                <div class="search-form-icon"><i class="ti-search"></i></div>
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
        <!--Featured post Start-->
        <div class="home-featured">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12 pl-0 pr-0">
                        <div class="featured-slider-2">
                            <div class="featured-slider-2-items">
                                <div class="slider-single">
                                    <div class="post-thumb position-relative">
                                        <div class="thumb-overlay position-relative" style="background-image: url(http://via.placeholder.com/1920x887)">
                                            <div class="post-content-overlay">
                                                <div class="container">
                                                    <div class="entry-meta meta-0 font-small mb-10">
                                                        <a href="category.html" tabindex="0"><span class="post-cat background2 color-white">Travel</span></a>
                                                    </div>
                                                    <h1 class="post-title mt-20 mb-15">
                                                        <a class="color-white" href="single.html" tabindex="0">Plaschke: Oregon quarterback Justin Herbert is great pick for the Chargers</a>
                                                    </h1>
                                                    <div class="entry-meta meta-1 font-small color-white mt-15 mb-15">
                                                        <span class="post-on"><i class="ti-marker-alt"></i>5 January 2020</span>
                                                        <span class="time-reading"><i class="ti-timer"></i>12 mins read</span>
                                                        <span class="hit-count"><i class="ti-bolt"></i> 169k Views</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="slider-single">
                                    <div class="post-thumb position-relative">
                                        <div class="thumb-overlay position-relative" style="background-image: url(http://via.placeholder.com/1920x887)">
                                            <div class="post-content-overlay">
                                                <div class="container">
                                                    <div class="entry-meta meta-0 font-small mb-10">
                                                        <a href="category.html" tabindex="0"><span class="post-cat background2 color-white">World</span></a>
                                                    </div>
                                                    <h2 class="post-title mt-20 mb-15">
                                                        <a class="color-white" href="single.html" tabindex="0">Federal judge blocks California’s ammunition purchase law</a>
                                                    </h2>
                                                    <div class="entry-meta meta-1 font-small color-white mt-15 mb-15">
                                                        <span class="post-on"><i class="ti-marker-alt"></i>25 April 2020</span>
                                                        <span class="time-reading"><i class="ti-timer"></i>10 mins read</span>
                                                        <span class="hit-count"><i class="ti-bolt"></i> 159k Views</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="slider-single">
                                    <div class="post-thumb position-relative">
                                        <div class="thumb-overlay position-relative" style="background-image: url(http://via.placeholder.com/1920x887)">
                                            <div class="post-content-overlay">
                                                <div class="container">
                                                    <div class="entry-meta meta-0 font-small mb-10">
                                                        <a href="category.html" tabindex="0"><span class="post-cat background2 color-white">Travel</span></a>
                                                    </div>
                                                    <h2 class="post-title mt-20 mb-15">
                                                        <a class="color-white" href="single.html" tabindex="0">As a dying Salton Sea spews harmful dust, Imperial Valley water wars heat up again</a>
                                                    </h2>
                                                    <div class="entry-meta meta-1 font-small color-white mt-15 mb-15">
                                                        <span class="post-on"><i class="ti-marker-alt"></i>25 April 2020</span>
                                                        <span class="time-reading"><i class="ti-timer"></i>10 mins read</span>
                                                        <span class="hit-count"><i class="ti-bolt"></i> 159k Views</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="slider-single">
                                    <div class="post-thumb position-relative">
                                        <div class="thumb-overlay position-relative" style="background-image: url(http://via.placeholder.com/1920x887)">
                                            <div class="post-content-overlay">
                                                <div class="container">
                                                    <div class="entry-meta meta-0 font-small mb-10">
                                                        <a href="category.html" tabindex="0"><span class="post-cat background2 color-white">Travel</span></a>
                                                    </div>
                                                    <h2 class="post-title mt-20 mb-15">
                                                        <a class="color-white" href="single.html" tabindex="0">Joe Biden campaign rejects comedian Louis C.K.'s $2,800 donation</a>
                                                    </h2>
                                                    <div class="entry-meta meta-1 font-small color-white mt-15 mb-15">
                                                        <span class="post-on"><i class="ti-marker-alt"></i>25 April 2020</span>
                                                        <span class="time-reading"><i class="ti-timer"></i>10 mins read</span>
                                                        <span class="hit-count"><i class="ti-bolt"></i> 159k Views</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="slider-single">
                                    <div class="post-thumb position-relative">
                                        <div class="thumb-overlay position-relative" style="background-image: url(http://via.placeholder.com/1920x887)">
                                            <div class="post-content-overlay">
                                                <div class="container">
                                                    <div class="entry-meta meta-0 font-small mb-10">
                                                        <a href="category.html" tabindex="0"><span class="post-cat background2 color-white">Travel</span></a>
                                                    </div>
                                                    <h2 class="post-title mt-20 mb-15">
                                                        <a class="color-white" href="single.html" tabindex="0">Their beautifully curated vintage-book pop-ups were thriving</a>
                                                    </h2>
                                                    <div class="entry-meta meta-1 font-small color-white mt-15 mb-15">
                                                        <span class="post-on"><i class="ti-marker-alt"></i>25 April 2020</span>
                                                        <span class="time-reading"><i class="ti-timer"></i>10 mins read</span>
                                                        <span class="hit-count"><i class="ti-bolt"></i> 159k Views</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="container position-relative">
                                <div class="arrow-cover color-white"></div>
                                <div class="featured-slider-2-nav-cover">
                                    <div class="featured-slider-2-nav">
                                        <div class="slider-post-thumb mr-15 position-relative">
                                            <img class="border-radius-5 mb-15" src="http://via.placeholder.com/500x500" alt="">
                                            <span class="top-right-icon background10">
                                                    <i class="mdi mdi-camera-alt"></i>
                                                </span>
                                        </div>
                                        <div class="slider-post-thumb mr-15 position-relative">
                                            <img class="border-radius-5 mb-15" src="http://via.placeholder.com/500x500" alt="">
                                        </div>
                                        <div class="slider-post-thumb mr-15 position-relative">
                                            <img class="border-radius-5 mb-15" src="http://via.placeholder.com/500x500" alt="">
                                        </div>
                                        <div class="slider-post-thumb mr-15 position-relative">
                                            <img class="border-radius-5 mb-15" src="http://via.placeholder.com/500x500" alt="">
                                        </div>
                                        <div class="slider-post-thumb mr-15 position-relative">
                                            <img class="border-radius-5 mb-15" src="http://via.placeholder.com/500x500" alt="">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--Featured post End-->
        <!-- Recent Posts Start -->
        <div class="pt-50 pb-50 background-white">
            <div class="container mb-50">
                <div class="row">
                    <div class="col-lg-8">
                        <div class="row d-flex justify-content-between">
                            <div class="col-lg-3 col-md-3">
                                <div class="widget-header position-relative mb-30">
                                    <h5 class="widget-title mb-30 text-uppercase color4 font-weight-ultra">Weekly Popular</h5>
                                    <div class="letter-background">W</div>
                                </div>
                            </div>
                            <div class="col-lg-9 col-md-9">
                                <!--Tab Nav  -->
                                <nav class="tab-nav style-1">
                                    <div class="nav nav-tabs" id="nav-tab" role="tablist">
                                        <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true"><i class="mr-5 ti-pulse"></i>All</a>
                                        <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">Lifestyle</a>
                                        <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact" role="tab" aria-controls="nav-contact" aria-selected="false">Travel</a>
                                        <a class="nav-item nav-link" id="nav-last-tab" data-toggle="tab" href="#nav-last" role="tab" aria-controls="nav-contact" aria-selected="false">Fashion</a>
                                        <a class="nav-item nav-link" id="nav-Sports" data-toggle="tab" href="#nav-nav-Sport" role="tab" aria-controls="nav-contact" aria-selected="false">Sports</a>
                                    </div>
                                </nav>
                                <!--End Tab Nav  -->
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12">
                                <!-- Tab content -->
                                <div class="tab-content" id="nav-tabContent">
                                    <!-- Tab one -->
                                    <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                                        <div class="block-tab-item post-module-2 post-module-1">
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="post-block-style">
                                                        <div class="post-thumb position-relative thumb-overlay mb-15">
                                                            <div class="img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/900x630)">
                                                                <a class="img-link" href="single.html"></a>
                                                                <div class="post-content-overlay entry-meta meta-0 font-small transition-ease-04"><a href="category.html"><span class="post-cat background1 color-white">Fashion</span></a></div>
                                                                <span class="top-right-icon background8"><i class="mdi mdi-flash-on"></i></span>
                                                            </div>
                                                        </div>
                                                        <div class="post-content">
                                                            <h4 class="post-title">
                                                                <a href="single.html">The World Caters to Average People and Mediocre Lifestyles</a>
                                                            </h4>
                                                            <div class="entry-meta meta-1 font-small color-grey mt-15 mb-15">
                                                                <span class="post-on"><i class="ti-marker-alt"></i>25 April 2020</span>
                                                                <span class="time-reading"><i class="ti-timer"></i>10 mins read</span>
                                                                <span class="hit-count"><i class="ti-bolt"></i> 159k Views</span>
                                                            </div>
                                                            <p class="font-medium d-none d-lg-block">These people envy me for having a lifestyle they don’t have, but the truth is, sometimes I envy their lifestyle instead.</p>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="row">
                                                        <div class="col-md-6 col-sm-6 sm-grid-content mb-30">
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
                                                        <div class="col-md-6 col-sm-6 sm-grid-content mb-30">
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
                                                        <div class="col-md-6 col-sm-6 sm-grid-content">
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
                                                        <div class="col-md-6 col-sm-6 sm-grid-content">
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
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Tab two -->
                                    <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                                        <div class="block-tab-item post-module-1">
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="post-block-style">
                                                        <div class="post-thumb position-relative thumb-overlay mb-15">
                                                            <div class="img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/900x630)">
                                                                <a class="img-link" href="single.html"></a>
                                                                <div class="post-content-overlay entry-meta meta-0 font-small transition-ease-04"><a href="category.html"><span class="post-cat background1 color-white">Fashion</span></a></div>
                                                            </div>
                                                        </div>
                                                        <div class="post-content">
                                                            <h4 class="post-title">
                                                                <a href="single.html">The World Caters to Average People and Mediocre Lifestyles</a>
                                                            </h4>
                                                            <div class="entry-meta meta-1 font-small color-grey mt-15 mb-15">
                                                                <span class="post-on"><i class="ti-marker-alt"></i>25 April 2020</span>
                                                                <span class="time-reading"><i class="ti-timer"></i>10 mins read</span>
                                                                <span class="hit-count"><i class="ti-bolt"></i> 159k Views</span>
                                                            </div>
                                                            <p class="font-medium">These people envy me for having a lifestyle they don’t have, but the truth is, sometimes I envy their lifestyle instead.</p>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="post-block-list">
                                                        <ul class="list-post">
                                                            <li class="mb-30">
                                                                <div class="d-flex">
                                                                    <div class="post-thumb d-flex mr-15 border-radius-5 img-hover-scale">
                                                                        <a href="single.html">
                                                                            <img src="http://via.placeholder.com/500x500" alt="">
                                                                        </a>
                                                                    </div>
                                                                    <div class="post-content media-body">
                                                                        <div class="entry-meta meta-0 mb-5">
                                                                            <a href="category.html"><span class="post-in color5 font-small pl-0">World</span></a>
                                                                        </div>
                                                                        <h6 class="post-title mb-10 text-limit-2-row">Traveling Tends to Magnify All Human Emotions</h6>
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
                                                                        <a href="single.html">
                                                                            <img src="http://via.placeholder.com/500x500" alt="">
                                                                        </a>
                                                                    </div>
                                                                    <div class="post-content media-body">
                                                                        <div class="entry-meta meta-0 mb-5">
                                                                            <a href="category.html"><span class="post-in color2 font-small pl-0">Films</span></a>
                                                                        </div>
                                                                        <h6 class="post-title mb-10 text-limit-2-row">The Luxury Of Traveling With Yacht</h6>
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
                                                                        <a href="single.html">
                                                                            <img src="http://via.placeholder.com/500x500" alt="">
                                                                        </a>
                                                                    </div>
                                                                    <div class="post-content media-body">
                                                                        <div class="entry-meta meta-0 mb-5">
                                                                            <a href="category.html"><span class="post-in color3 font-small pl-0">Travel</span></a>
                                                                        </div>
                                                                        <h6 class="post-title mb-10 text-limit-2-row">Last Minute Festive Packages From Superbreak</h6>
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
                                                                        <a href="single.html">
                                                                            <img src="http://via.placeholder.com/500x500" alt="">
                                                                        </a>
                                                                    </div>
                                                                    <div class="post-content media-body">
                                                                        <div class="entry-meta meta-0 mb-5">
                                                                            <a href="category.html"><span class="post-in color4 font-small pl-0">Beauty</span></a>
                                                                        </div>
                                                                        <h6 class="post-title mb-10 text-limit-2-row">Less Is More: Diving into Minimalism in Photography</h6>
                                                                        <div class="entry-meta meta-1 font-x-small color-grey mt-10">
                                                                            <span class="post-on">25 April</span>
                                                                            <span class="hit-count has-dot">126k Views</span>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Tab three -->
                                    <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">
                                        <div class="block-tab-item post-module-1">
                                            <div class="row mb-30">
                                                <div class="col-md-6">
                                                    <div class="post-thumb position-relative thumb-overlay">
                                                        <div class="img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/900x630)">
                                                            <a class="img-link" href="single.html"></a>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6 align-center-vertical">
                                                    <div class="post-content">
                                                        <div class="entry-meta meta-0 font-small mb-15"><a href="category.html"><span class="post-cat background1 color-white">Fashion</span></a></div>
                                                        <h4 class="post-title">
                                                            <a href="single.html">The World Caters to Average People and Mediocre Lifestyles</a>
                                                        </h4>
                                                        <div class="entry-meta meta-1 font-small color-grey mt-15 mb-15">
                                                            <span class="post-on"><i class="ti-marker-alt"></i>25 April 2020</span>
                                                            <span class="time-reading"><i class="ti-timer"></i>10 mins read</span>
                                                            <span class="hit-count"><i class="ti-bolt"></i> 159k Views</span>
                                                        </div>
                                                        <p class="font-medium">These people envy me for having a lifestyle they don’t have, but the truth is, sometimes I envy their lifestyle instead. Struggling to sell one multi-million dollar home currently on the market
                                                            won’t stop actress and singer Jennifer Lopez from expanding her property collection.</p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row list-post">
                                                <div class="col-md-6 d-flex mb-30">
                                                    <div class="post-thumb d-flex mr-15 border-radius-5 img-hover-scale">
                                                        <a href="single.html">
                                                            <img src="http://via.placeholder.com/500x500" alt="">
                                                        </a>
                                                    </div>
                                                    <div class="post-content media-body">
                                                        <div class="entry-meta meta-0 mb-5">
                                                            <a href="category.html"><span class="post-in color5 font-small pl-0">World</span></a>
                                                        </div>
                                                        <h6 class="post-title mb-10 text-limit-2-row">Traveling Tends to Magnify All Human Emotions</h6>
                                                        <div class="entry-meta meta-1 font-x-small color-grey">
                                                            <span class="post-on">25 April</span>
                                                            <span class="hit-count has-dot">26k Views</span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6 d-flex mb-30">
                                                    <div class="post-thumb d-flex mr-15 border-radius-5 img-hover-scale">
                                                        <a href="single.html">
                                                            <img src="http://via.placeholder.com/500x500" alt="">
                                                        </a>
                                                    </div>
                                                    <div class="post-content media-body">
                                                        <div class="entry-meta meta-0 mb-5">
                                                            <a href="category.html"><span class="post-in color2 font-small pl-0">Films</span></a>
                                                        </div>
                                                        <h6 class="post-title mb-10 text-limit-2-row">The Luxury Of Traveling With Yacht</h6>
                                                        <div class="entry-meta meta-1 font-x-small color-grey mt-10">
                                                            <span class="post-on">25 April</span>
                                                            <span class="hit-count has-dot">37k Views</span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6 d-flex">
                                                    <div class="post-thumb d-flex mr-15 border-radius-5 img-hover-scale">
                                                        <a href="single.html">
                                                            <img src="http://via.placeholder.com/500x500" alt="">
                                                        </a>
                                                    </div>
                                                    <div class="post-content media-body">
                                                        <div class="entry-meta meta-0 mb-5">
                                                            <a href="category.html"><span class="post-in color3 font-small pl-0">Travel</span></a>
                                                        </div>
                                                        <h6 class="post-title mb-10 text-limit-2-row">Last Minute Festive Packages From Superbreak</h6>
                                                        <div class="entry-meta meta-1 font-x-small color-grey mt-10">
                                                            <span class="post-on">25 April</span>
                                                            <span class="hit-count has-dot">54k Views</span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6 d-flex">
                                                    <div class="post-thumb d-flex mr-15 border-radius-5 img-hover-scale">
                                                        <a href="single.html">
                                                            <img src="http://via.placeholder.com/500x500" alt="">
                                                        </a>
                                                    </div>
                                                    <div class="post-content media-body">
                                                        <div class="entry-meta meta-0 mb-5">
                                                            <a href="category.html"><span class="post-in color4 font-small pl-0">Beauty</span></a>
                                                        </div>
                                                        <h6 class="post-title mb-10 text-limit-2-row">Less Is More: Diving into Minimalism in Photography</h6>
                                                        <div class="entry-meta meta-1 font-x-small color-grey mt-10">
                                                            <span class="post-on">25 April</span>
                                                            <span class="hit-count has-dot">126k Views</span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Tab four -->
                                    <div class="tab-pane fade" id="nav-last" role="tabpanel" aria-labelledby="nav-last-tab">
                                        <div class="block-tab-item post-module-1">
                                            <div class="row">
                                                <div class="col-md-4">
                                                    <div class="post-thumb position-relative mb-30">
                                                        <div class="thumb-overlay img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/900x630)">
                                                            <a class="img-link" href="single.html"></a>
                                                            <div class="post-content-overlay">
                                                                <div class="entry-meta meta-0 font-small mb-10">
                                                                    <a href="category.html"><span class="post-cat background1 color-white">Travel</span></a>
                                                                </div>
                                                                <h6 class="post-title">
                                                                    <a class="color-white" href="single.html">50 Years After The Moon Landing: How Close Is Space Travel, Really?</a>
                                                                </h6>
                                                                <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                                                    <span class="post-on">02 Jan</span>
                                                                    <span class="hit-count has-dot">23k Views</span>
                                                                    <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="post-thumb position-relative mb-30">
                                                        <div class="thumb-overlay img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/900x630)">
                                                            <a class="img-link" href="single.html"></a>
                                                            <div class="post-content-overlay">
                                                                <div class="entry-meta meta-0 font-small mb-10">
                                                                    <a href="category.html"><span class="post-cat background2 color-white">Cook</span></a>
                                                                </div>
                                                                <h6 class="post-title">
                                                                    <a class="color-white" href="single.html">Tesla’s Cooking Up A New Way To Wire Its Cars, Report Says</a>
                                                                </h6>
                                                                <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                                                    <span class="post-on">02 Jan</span>
                                                                    <span class="hit-count has-dot">23k Views</span>
                                                                    <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="post-thumb position-relative mb-30">
                                                        <div class="thumb-overlay img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/900x630)">
                                                            <a class="img-link" href="single.html"></a>
                                                            <div class="post-content-overlay">
                                                                <div class="entry-meta meta-0 font-small mb-10">
                                                                    <a href="category.html"><span class="post-cat background3 color-white">News</span></a>
                                                                </div>
                                                                <h6 class="post-title">
                                                                    <a class="color-white" href="single.html">Trip To Iqaluit In Nunavut A Canadian Arctic City</a>
                                                                </h6>
                                                                <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                                                    <span class="post-on">02 Jan</span>
                                                                    <span class="hit-count has-dot">23k Views</span>
                                                                    <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="post-thumb position-relative mb-30">
                                                        <div class="thumb-overlay img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/900x630)">
                                                            <a class="img-link" href="single.html"></a>
                                                            <div class="post-content-overlay">
                                                                <div class="entry-meta meta-0 font-small mb-10">
                                                                    <a href="category.html"><span class="post-cat background4 color-white">Wildlife</span></a>
                                                                </div>
                                                                <h6 class="post-title">
                                                                    <a class="color-white" href="single.html">African Nations Are Struggling To Save Their Wildlife</a>
                                                                </h6>
                                                                <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                                                    <span class="post-on">02 Jan</span>
                                                                    <span class="hit-count has-dot">23k Views</span>
                                                                    <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="post-thumb position-relative mb-30">
                                                        <div class="thumb-overlay img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/900x630)">
                                                            <a class="img-link" href="single.html"></a>
                                                            <div class="post-content-overlay">
                                                                <div class="entry-meta meta-0 font-small mb-10">
                                                                    <a href="category.html"><span class="post-cat background5 color-white">World</span></a>
                                                                </div>
                                                                <h6 class="post-title">
                                                                    <a class="color-white" href="single.html">Get the Illusion of Fuller Lashes by “Mascara-stamping.”</a>
                                                                </h6>
                                                                <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                                                    <span class="post-on">02 Jan</span>
                                                                    <span class="hit-count has-dot">23k Views</span>
                                                                    <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="post-thumb position-relative mb-30">
                                                        <div class="thumb-overlay img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/900x630)">
                                                            <a class="img-link" href="single.html"></a>
                                                            <div class="post-content-overlay">
                                                                <div class="entry-meta meta-0 font-small mb-10">
                                                                    <a href="category.html"><span class="post-cat background7 color-white">Travel</span></a>
                                                                </div>
                                                                <h6 class="post-title">
                                                                    <a class="color-white" href="single.html">Trip To Iqaluit In Nunavut A Canadian Arctic City</a>
                                                                </h6>
                                                                <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                                                    <span class="post-on">02 Jan</span>
                                                                    <span class="hit-count has-dot">23k Views</span>
                                                                    <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Tab five -->
                                    <div class="tab-pane fade" id="nav-nav-Sport" role="tabpanel" aria-labelledby="nav-Sports">
                                        <div class="row">
                                            <div class="slider-single col-md-4 mb-30">
                                                <div class="img-hover-scale border-radius-5">
                                                    <a href="single.html">
                                                        <img class="border-radius-5" src="http://via.placeholder.com/500x500" alt="post-slider">
                                                    </a>
                                                </div>
                                                <h6 class="post-title pr-5 pl-5 mb-10 mt-15 text-limit-2-row">
                                                    <a href="single.html">Sony Laptops Are Still Part Of The Sony Family</a>
                                                </h6>
                                                <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                                    <span class="post-on">02 Jan</span>
                                                    <span class="hit-count has-dot">23k Views</span>
                                                    <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                                </div>
                                            </div>
                                            <div class="slider-single col-md-4 mb-30">
                                                <div class="img-hover-scale border-radius-5">
                                                    <a href="single.html">
                                                        <img class="border-radius-5" src="http://via.placeholder.com/500x500" alt="post-slider">
                                                    </a>
                                                </div>
                                                <h6 class="post-title pr-5 pl-5 mb-10 mt-15 text-limit-2-row">
                                                    <a href="single.html">Get The Boot A Birds Eye Look Into Mcse Boot Camps</a>
                                                </h6>
                                                <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                                    <span class="post-on">03 Jan</span>
                                                    <span class="hit-count has-dot">13k Views</span>
                                                    <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                                </div>
                                            </div>
                                            <div class="slider-single col-md-4 mb-30">
                                                <div class="img-hover-scale border-radius-5">
                                                    <a href="single.html">
                                                        <img class="border-radius-5" src="http://via.placeholder.com/500x500" alt="post-slider">
                                                    </a>
                                                </div>
                                                <h6 class="post-title pr-5 pl-5 mb-10 mt-15 text-limit-2-row">
                                                    <a href="single.html">Overcome The Feeling Of Being Overwhelmed</a>
                                                </h6>
                                                <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                                    <span class="post-on">04 Jan</span>
                                                    <span class="hit-count has-dot">33k Views</span>
                                                    <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                                </div>
                                            </div>
                                            <div class="slider-single col-md-4 mb-30">
                                                <div class="img-hover-scale border-radius-5">
                                                    <a href="single.html">
                                                        <img class="border-radius-5" src="http://via.placeholder.com/500x500" alt="post-slider">
                                                    </a>
                                                </div>
                                                <h6 class="post-title pr-5 pl-5 mb-10 mt-15 text-limit-2-row">
                                                    <a href="single.html">3 Simple Tips For Using Sports To Get Ahead Your Competition</a>
                                                </h6>
                                                <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                                    <span class="post-on">05 Jan</span>
                                                    <span class="hit-count has-dot">43k Views</span>
                                                    <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                                </div>
                                            </div>
                                            <div class="slider-single col-md-4 mb-30">
                                                <div class="img-hover-scale border-radius-5">
                                                    <a href="single.html">
                                                        <img class="border-radius-5" src="http://via.placeholder.com/500x500" alt="post-slider">
                                                    </a>
                                                </div>
                                                <h6 class="post-title pr-5 pl-5 mb-10 mt-15 text-limit-2-row">
                                                    <a href="single.html">Get the Illusion of Fuller Lashes by “Mascara-stamping.”</a>
                                                </h6>
                                                <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                                    <span class="post-on">06 Jan</span>
                                                    <span class="hit-count has-dot">53k Views</span>
                                                    <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                                </div>
                                            </div>
                                            <div class="slider-single col-md-4 mb-30">
                                                <div class="img-hover-scale border-radius-5">
                                                    <a href="single.html">
                                                        <img class="border-radius-5" src="http://via.placeholder.com/500x500" alt="post-slider">
                                                    </a>
                                                </div>
                                                <h6 class="post-title pr-5 pl-5 mb-10 mt-15 text-limit-2-row">
                                                    <a href="single.html">Trip To Iqaluit In Nunavut A Canadian Arctic City</a>
                                                </h6>
                                                <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                                    <span class="post-on">07 Jan</span>
                                                    <span class="hit-count has-dot">63k Views</span>
                                                    <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- End Tab content-->
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="widget-area row">
                            <!-- Social Network -->
                            <div class="sidebar-widget widget-social-network mb-30 col-lg-12 col-md-6">
                                <div class="title_style_1">
                                    <h5 class="widget-title mt-5 mb-30">Follow Us</h5>
                                    <div class="social-network">
                                        <div class="follow-us d-flex align-items-center">
                                            <a class="follow-us-facebook clearfix mr-5 mb-10" href="#" target="_blank">
                                                <div class="social-icon">
                                                    <i class="ti-facebook mr-5 v-align-space"></i>
                                                    <i class="ti-facebook mr-5 v-align-space nth-2"></i>
                                                </div>
                                                <span class="social-name">Facebook</span>
                                                <span class="social-count counter-number">65</span><span class="social-count">K</span>
                                            </a>
                                            <a class="follow-us-twitter clearfix ml-5 mb-10" href="#" target="_blank">
                                                <div class="social-icon">
                                                    <i class="ti-twitter-alt mr-5 v-align-space"></i>
                                                    <i class="ti-twitter-alt mr-5 v-align-space nth-2"></i>
                                                </div>
                                                <span class="social-name">Twitter</span>
                                                <span class="social-count counter-number"> 75</span><span class="social-count">K</span>
                                            </a>
                                        </div>
                                        <div class="follow-us d-flex align-items-center">
                                            <a class="follow-us-instagram clearfix mr-5 mb-10" href="#" target="_blank">
                                                <div class="social-icon">
                                                    <i class="ti-instagram mr-5 v-align-space"></i>
                                                    <i class="ti-instagram mr-5 v-align-space nth-2"></i>
                                                </div>
                                                <span class="social-name">Instagram</span>
                                                <span class="social-count counter-number"> 32</span><span class="social-count">K</span>
                                            </a>
                                            <a class="follow-us-youtube clearfix ml-5 mb-10" href="#" target="_blank">
                                                <div class="social-icon">
                                                    <i class="ti-youtube mr-5 v-align-space"></i>
                                                    <i class="ti-youtube mr-5 v-align-space nth-2"></i>
                                                </div>
                                                <span class="social-name">Youtube</span>
                                                <span class="social-count counter-number"> 29</span><span class="social-count">K</span>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Ads -->
                            <div class="sidebar-widget widget-ads mb-30  col-lg-12 col-md-6 align-center-vertical">
                                <a href="https://vimeo.com/333834999" class="play-video" data-animate="zoomIn" data-duration="1.5s" data-delay="0.1s">
                                    <img src="http://via.placeholder.com/432x336" alt="">
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="sidebar-widget">
                    <div class="widget-header position-relative mb-30">
                        <h5 class="widget-title mb-30 text-uppercase color1 font-weight-ultra">Most Comments</h5>
                        <div class="letter-background">M</div>
                    </div>
                    <div class="post-carausel-2 post-module-1 row">
                        <div class="col">
                            <div class="post-thumb position-relative">
                                <div class="thumb-overlay img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/900x630)">
                                    <a class="img-link" href="single.html"></a>
                                    <div class="post-content-overlay">
                                        <div class="entry-meta meta-0 font-small mb-10">
                                            <a href="category.html"><span class="post-cat background2 color-white">Travel</span></a>
                                        </div>
                                        <h6 class="post-title">
                                            <a class="color-white" href="single.html">Tesla’s Cooking Up A New Way To Wire Its Cars, Report Says</a>
                                        </h6>
                                        <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                            <span class="post-on">02 Jan</span>
                                            <span class="hit-count has-dot">23k Views</span>
                                            <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="post-thumb position-relative">
                                <div class="thumb-overlay img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/900x630)">
                                    <span class="top-right-icon background8"><i class="mdi mdi-photo"></i></span>
                                    <a class="img-link" href="single.html"></a>
                                    <div class="post-content-overlay">
                                        <div class="entry-meta meta-0 font-small mb-10">
                                            <a href="category.html"><span class="post-cat background4 color-white">Beauty</span></a>
                                        </div>
                                        <h6 class="post-title">
                                            <a class="color-white" href="single.html">Ratcliffe to be Director of nation talent Trump ignored</a>
                                        </h6>
                                        <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                            <span class="post-on">02 Jan</span>
                                            <span class="hit-count has-dot">23k Views</span>
                                            <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="post-thumb position-relative">
                                <div class="thumb-overlay img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/900x630)">
                                    <a class="img-link" href="single.html"></a>
                                    <div class="post-content-overlay">
                                        <div class="entry-meta meta-0 font-small mb-10">
                                            <a href="category.html"><span class="post-cat background1 color-white">Art</span></a>
                                        </div>
                                        <h6 class="post-title">
                                            <a class="color-white" href="single.html">Nancy multi Chinese business woman trying</a>
                                        </h6>
                                        <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                            <span class="post-on">02 Jan</span>
                                            <span class="hit-count has-dot">23k Views</span>
                                            <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="post-thumb position-relative">
                                <div class="thumb-overlay img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/900x630)">
                                    <span class="top-right-icon background10"><i class="mdi mdi-flash-on"></i></span>
                                    <a class="img-link" href="single.html"></a>
                                    <div class="post-content-overlay">
                                        <div class="entry-meta meta-0 font-small mb-10">
                                            <a href="category.html"><span class="post-cat background7 color-white">Gaming</span></a>
                                        </div>
                                        <h6 class="post-title">
                                            <a class="color-white" href="single.html">The secret to moving this ancient sphinx screening</a>
                                        </h6>
                                        <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                            <span class="post-on">02 Jan</span>
                                            <span class="hit-count has-dot">23k Views</span>
                                            <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="post-thumb position-relative">
                                <div class="thumb-overlay img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/900x630)">
                                    <span class="top-right-icon background7"><i class="mdi mdi-flash-on"></i></span>
                                    <a class="img-link" href="single.html"></a>
                                    <div class="post-content-overlay">
                                        <div class="entry-meta meta-0 font-small mb-10">
                                            <a href="category.html"><span class="post-cat background3 color-white">Garden</span></a>
                                        </div>
                                        <h6 class="post-title">
                                            <a class="color-white" href="single.html">Harbour amid a Slowen down in singer city screening</a>
                                        </h6>
                                        <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                            <span class="post-on">02 Jan</span>
                                            <span class="hit-count has-dot">23k Views</span>
                                            <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Recent Posts End -->
        <!-- Start Youtube -->
        <div class="video-area background_dark area-padding pt-50 pb-50">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="sidebar-widget">
                            <div class="widget-header position-relative mb-30">
                                <div class="row">
                                    <div class="col-7">
                                        <h5 class="widget-title text-uppercase color4 font-weight-ultra">LATEST VIDEOS</h5>
                                        <div class="letter-background">IN MOTION</div>
                                    </div>
                                    <div class="col-5 text-right">
                                        <h6 class="text-uppercase font-medium">
                                            <i class="ti-video-clapper color-white mr-5"></i>
                                            <a class="color-white" href="#">All Videos</a>
                                        </h6>
                                    </div>
                                </div>
                            </div>
                            <div class="block-tab-item post-module-1 post-module-4 mt-50">
                                <div class="row">
                                    <div class="col-lg-5 col-md-6">
                                        <div class="post-thumb position-relative">
                                            <div class="thumb-overlay img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/900x630)">
                                                <span class="top-right-icon background3"><i class="mdi mdi-favorite"></i></span>
                                                <a class="img-link" href="single.html"></a>
                                                <div class="post-content-overlay">
                                                    <div class="entry-meta meta-0 font-small mb-20">
                                                        <a href="category.html"><span class="post-cat background2 color-white">Travel</span></a>
                                                    </div>
                                                    <h2 class="post-title">
                                                        <a class="color-white" href="single.html">Tesla’s Cooking Up A New Way To Wire Its Cars, Report Says</a>
                                                    </h2>
                                                    <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                                        <span class="post-on">02 Jan</span>
                                                        <span class="hit-count has-dot">23k Views</span>
                                                        <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                                    </div>
                                                </div>
                                                <div class="play_btn">
                                                    <a class="play-video" href="https://vimeo.com/333834999" data-animate="zoomIn" data-duration="1.5s" data-delay="0.1s">
                                                        <i class="ti-control-play"></i>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-7 col-md-6">
                                        <div class="row">
                                            <div class="slider-single col-lg-4 col-md-6 mb-30">
                                                <div class="img-hover-scale border-radius-5">
                                                    <span class="top-right-icon background10"><i class="mdi mdi-flash-on"></i></span>
                                                    <a href="single.html">
                                                        <img class="border-radius-5" src="http://via.placeholder.com/500x500" alt="post-slider">
                                                    </a>
                                                    <div class="play_btn play_btn_small">
                                                        <a class="play-video" href="https://vimeo.com/333834999" data-animate="zoomIn" data-duration="1.5s" data-delay="0.1s">
                                                            <i class="ti-control-play"></i>
                                                        </a>
                                                    </div>
                                                </div>
                                                <h6 class="post-title pr-5 pl-5 mb-10 mt-15 text-limit-2-row">
                                                    <a class="color-white" href="single.html">3 Technology Basics You Reviewing Constantly.</a>
                                                </h6>
                                                <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                                    <span class="post-on">03 Jan</span>
                                                    <span class="hit-count has-dot">13k Views</span>
                                                    <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                                </div>
                                            </div>
                                            <div class="slider-single col-lg-4 col-md-6 mb-30">
                                                <div class="img-hover-scale border-radius-5">
                                                    <a href="single.html">
                                                        <img class="border-radius-5" src="http://via.placeholder.com/500x500" alt="post-slider">
                                                    </a>
                                                    <div class="play_btn play_btn_small">
                                                        <a class="play-video" href="https://vimeo.com/333834999" data-animate="zoomIn" data-duration="1.5s" data-delay="0.1s">
                                                            <i class="ti-control-play"></i>
                                                        </a>
                                                    </div>
                                                </div>
                                                <h6 class="post-title pr-5 pl-5 mb-10 mt-15 text-limit-2-row">
                                                    <a class="color-white" href="single.html">Essential Qualities of Highly Successful Music.</a>
                                                </h6>
                                                <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                                    <span class="post-on">02 May</span>
                                                    <span class="hit-count has-dot">123k Views</span>
                                                    <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                                </div>
                                            </div>
                                            <div class="slider-single col-lg-4 col-md-6 mb-30">
                                                <div class="img-hover-scale border-radius-5">
                                                    <a href="single.html">
                                                        <img class="border-radius-5" src="http://via.placeholder.com/500x500" alt="post-slider">
                                                    </a>
                                                    <div class="play_btn play_btn_small">
                                                        <a class="play-video" href="https://vimeo.com/333834999" data-animate="zoomIn" data-duration="1.5s" data-delay="0.1s">
                                                            <i class="ti-control-play"></i>
                                                        </a>
                                                    </div>
                                                </div>
                                                <h6 class="post-title pr-5 pl-5 mb-10 mt-15 text-limit-2-row">
                                                    <a class="color-white" href="single.html">Super Bowl LII Venue Know more about</a>
                                                </h6>
                                                <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                                    <span class="post-on">02 Jan</span>
                                                    <span class="hit-count has-dot">23k Views</span>
                                                    <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                                </div>
                                            </div>
                                            <div class="slider-single col-lg-4 col-md-6">
                                                <div class="img-hover-scale border-radius-5">
                                                        <span class="top-right-icon background2">
                                                            <i class="mdi mdi-audiotrack"></i>
                                                        </span>
                                                    <a href="single.html">
                                                        <img class="border-radius-5" src="http://via.placeholder.com/500x500" alt="post-slider">
                                                    </a>
                                                    <div class="play_btn play_btn_small">
                                                        <a class="play-video" href="https://vimeo.com/333834999" data-animate="zoomIn" data-duration="1.5s" data-delay="0.1s">
                                                            <i class="ti-control-play"></i>
                                                        </a>
                                                    </div>
                                                </div>
                                                <h6 class="post-title pr-5 pl-5 mb-10 mt-15 text-limit-2-row">
                                                    <a class="color-white" href="single.html">The loss is not all that surprising</a>
                                                </h6>
                                                <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                                    <span class="post-on">02 Jan</span>
                                                    <span class="hit-count has-dot">23k Views</span>
                                                    <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                                </div>
                                            </div>
                                            <div class="slider-single col-lg-4 col-md-6 d-none d-lg-block">
                                                <div class="img-hover-scale border-radius-5">
                                                    <a href="single.html">
                                                        <img class="border-radius-5" src="http://via.placeholder.com/500x500" alt="post-slider">
                                                    </a>
                                                    <div class="play_btn play_btn_small">
                                                        <a class="play-video" href="https://vimeo.com/333834999" data-animate="zoomIn" data-duration="1.5s" data-delay="0.1s">
                                                            <i class="ti-control-play"></i>
                                                        </a>
                                                    </div>
                                                </div>
                                                <h6 class="post-title pr-5 pl-5 mb-10 mt-15 text-limit-2-row">
                                                    <a class="color-white" href="single.html">6 Ways to Instantly Improve your Ui Design.</a>
                                                </h6>
                                                <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                                    <span class="post-on">02 Jan</span>
                                                    <span class="hit-count has-dot">23k Views</span>
                                                    <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                                </div>
                                            </div>
                                            <div class="slider-single col-lg-4 col-md-6 d-none d-lg-block">
                                                <div class="img-hover-scale border-radius-5">
                                                    <a href="single.html">
                                                        <img class="border-radius-5" src="http://via.placeholder.com/500x500" alt="post-slider">
                                                    </a>
                                                    <div class="play_btn play_btn_small">
                                                        <a class="play-video" href="https://vimeo.com/333834999" data-animate="zoomIn" data-duration="1.5s" data-delay="0.1s">
                                                            <i class="ti-control-play"></i>
                                                        </a>
                                                    </div>
                                                </div>
                                                <h6 class="post-title pr-5 pl-5 mb-10 mt-15 text-limit-2-row">
                                                    <a class="color-white" href="single.html">Water Partners With Rag & Bone To Consume</a>
                                                </h6>
                                                <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                                    <span class="post-on">06 July</span>
                                                    <span class="hit-count has-dot">23k Views</span>
                                                    <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Start youtube -->
        <!--Editor's Picked Start-->
        <div class="background12 pt-40 pb-40">
            <div class="widgets-post-carausel-1">
                <div class="container">
                    <div class="post-carausel-1 border-radius-10 bg-white">
                        <div class="row no-gutters">
                            <div class="col col-1-5 background6 editor-picked-left d-none d-lg-block">
                                <div class="editor-picked">
                                    <h4>Editor's Picked</h4>
                                    <p class="font-medium color-grey mt-20 mb-30">The featured articles are selected by experienced editors. It is also based on the reader's rating. These posts have a lot of interest.</p>
                                    <a href="single.html" class="read-more">Read More</a>
                                    <div class="post-carausel-1-arrow"></div>
                                </div>
                            </div>
                            <div class="col col-4-5 col-md-12">
                                <div class="post-carausel-1-items row">
                                    <div class="slider-single col">
                                        <h6 class="post-title pr-5 pl-5 mb-10 text-limit-2-row"><a href="single.html">The Writer’s Dilemma — For Money or Love of the Game?</a></h6>
                                        <div class="img-hover-scale border-radius-5 hover-box-shadow">
                                                <span class="top-right-icon background2">
                                                    <i class="mdi mdi-audiotrack"></i>
                                                </span>
                                            <a href="single.html"><img class="border-radius-5" src="http://via.placeholder.com/500x500" alt="post-slider"></a>
                                        </div>
                                        <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                            <span class="post-on">02 Jan</span>
                                            <span class="hit-count has-dot">23k Views</span>
                                            <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                        </div>
                                    </div>
                                    <!--end slider single-->
                                    <div class="slider-single col">
                                        <h6 class="post-title pr-5 pl-5 mb-10 text-limit-2-row"><a href="single.html">Conceptual Art: A Beginner’s Guide</a></h6>
                                        <div class="img-hover-scale border-radius-5 hover-box-shadow">
                                            <a href="single.html"><img class="border-radius-5" src="http://via.placeholder.com/500x500" alt="post-slider"></a>
                                        </div>
                                        <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                            <span class="post-on">14 Feb</span>
                                            <span class="hit-count has-dot">59k Views</span>
                                            <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                        </div>
                                    </div>
                                    <!--end slider single-->
                                    <div class="slider-single col">
                                        <h6 class="post-title pr-5 pl-5 mb-10 text-limit-2-row"><a href="single.html">One of the All-Time Cartooning Greats</a></h6>
                                        <div class="img-hover-scale border-radius-5 hover-box-shadow">
                                                <span class="top-right-icon background10">
                                                    <i class="mdi mdi-camera-alt"></i>
                                                </span>
                                            <a href="single.html">
                                                <img class="border-radius-5" src="http://via.placeholder.com/500x500" alt="post-slider">
                                            </a>
                                        </div>
                                        <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                            <span class="post-on">25 Feb</span>
                                            <span class="hit-count has-dot">72k Views</span>
                                            <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                        </div>
                                    </div>
                                    <!--end slider single-->
                                    <div class="slider-single col">
                                        <h6 class="post-title pr-5 pl-5 mb-10 text-limit-2-row"><a href="single.html">9 Things I Love About Shaving My Head During Quarantine</a></h6>
                                        <div class="img-hover-scale border-radius-5 hover-box-shadow">
                                            <a href="single.html"><img class="border-radius-5" src="http://via.placeholder.com/500x500" alt="post-slider"></a>
                                        </div>
                                        <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                            <span class="post-on">15 May</span>
                                            <span class="hit-count has-dot">159k Views</span>
                                            <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                        </div>
                                    </div>
                                    <!--end slider single-->
                                    <div class="slider-single col">
                                        <h6 class="post-title pr-5 pl-5 mb-10 text-limit-2-row"><a href="single.html">Could He Still Love Me Without My Eating Disorder?</a></h6>
                                        <div class="img-hover-scale border-radius-5 hover-box-shadow">
                                                <span class="top-right-icon background3">
                                                    <i class="mdi mdi-videocam"></i>
                                                </span>
                                            <a href="single.html"><img class="border-radius-5" src="http://via.placeholder.com/500x500" alt="post-slider"></a>
                                        </div>
                                        <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                            <span class="post-on">05 April</span>
                                            <span class="hit-count has-dot">35k Views</span>
                                            <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                        </div>
                                    </div>
                                    <!--end slider single-->
                                    <div class="slider-single col">
                                        <h6 class="post-title pr-5 pl-5 mb-10 text-limit-2-row"><a href="single.html">The Quiet Prejudice of ‘You Are Not Fat, You Have Fat’</a></h6>
                                        <div class="img-hover-scale border-radius-5 hover-box-shadow">
                                            <a href="single.html"><img class="border-radius-5" src="http://via.placeholder.com/500x500" alt="post-slider"></a>
                                        </div>
                                        <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                            <span class="post-on">14 April</span>
                                            <span class="hit-count has-dot">30k Views</span>
                                            <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                        </div>
                                    </div>
                                    <!--end slider single-->
                                    <div class="slider-single col">
                                        <h6 class="post-title pr-5 pl-5 mb-10 text-limit-2-row">
                                            <a href="single.html">Take The Damn Body Compliments</a></h6>
                                        <div class="img-hover-scale border-radius-5 hover-box-shadow">
                                            <a href="single.html">
                                                <img class="border-radius-5" src="http://via.placeholder.com/500x500" alt="post-slider"></a>
                                        </div>
                                        <div class="entry-meta meta-1 font-small color-grey mt-10 pr-5 pl-5">
                                            <span class="post-on">25 April</span>
                                            <span class="hit-count has-dot">26k Views</span>
                                            <a class="float-right" href="#"><i class="ti-heart"></i></a>
                                        </div>
                                    </div>
                                    <!--end slider single-->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--Editor's Picked End-->
        <!--  Recent Articles start -->
        <div class="recent-area pt-50 pb-50 background12">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-md-12">
                        <div class="widget-header position-relative mb-30">
                            <h5 class="widget-title mb-30 text-uppercase color1 font-weight-ultra">Recent Posts</h5>
                            <div class="letter-background">Latest</div>
                        </div>
                        <div class="loop-list">
                            <article class="row mb-50">
                                <div class="col-md-6">
                                    <div class="post-thumb position-relative thumb-overlay mr-20">
                                        <div class="img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/900x630)">
                                            <a class="img-link" href="single.html"></a>
                                            <span class="top-right-icon background8"><i class="mdi mdi-flash-on"></i></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 align-center-vertical">
                                    <div class="post-content">
                                        <div class="entry-meta meta-0 font-small mb-15"><a href="category.html"><span class="post-cat background2 color-white">Fashion</span></a></div>
                                        <h4 class="post-title">
                                            <a href="single.html">The World Caters to Average People and Mediocre Lifestyles</a>
                                        </h4>
                                        <div class="entry-meta meta-1 font-small color-grey mt-15 mb-15">
                                            <span class="post-on"><i class="ti-marker-alt"></i>25 April 2020</span>
                                            <span class="time-reading"><i class="ti-timer"></i>10 mins read</span>
                                            <span class="hit-count"><i class="ti-bolt"></i> 159k Views</span>
                                        </div>
                                        <p class="font-medium">These people envy me for having a lifestyle they don’t have, but the truth is, sometimes I envy their lifestyle instead. Struggling to sell one multi-million dollar home currently.</p>
                                        <a class="readmore-btn font-small text-uppercase font-weight-ultra" href="single.html">Read More<i class="ti-arrow-right ml-5"></i></a>
                                    </div>
                                </div>
                            </article>
                            <article class="row mb-50">
                                <div class="col-md-6">
                                    <div class="post-thumb position-relative thumb-overlay mr-20">
                                        <div class="img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/900x630)">
                                            <a class="img-link" href="single.html"></a>
                                            <span class="top-right-icon background5"><i class="mdi mdi-favorite"></i></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 align-center-vertical">
                                    <div class="post-content">
                                        <div class="entry-meta meta-0 font-small mb-15"><a href="category.html"><span class="post-cat background3 color-white">Technology</span></a></div>
                                        <h4 class="post-title">
                                            <a href="single.html">Why Teamwork Really Makes The Dream Work</a>
                                        </h4>
                                        <div class="entry-meta meta-1 font-small color-grey mt-15 mb-15">
                                            <span class="post-on"><i class="ti-marker-alt"></i>25 April 2020</span>
                                            <span class="time-reading"><i class="ti-timer"></i>10 mins read</span>
                                            <span class="hit-count"><i class="ti-bolt"></i> 159k Views</span>
                                        </div>
                                        <p class="font-medium">We live in a world where disruption and dynamism reign supreme and businesses must be ready to adapt to the many unpredictable changes that come with this.</p>
                                        <a class="readmore-btn font-small text-uppercase font-weight-ultra" href="single.html">Read More<i class="ti-arrow-right ml-5"></i></a>
                                    </div>
                                </div>
                            </article>
                            <article class="row mb-50">
                                <div class="col-md-6">
                                    <div class="post-thumb position-relative thumb-overlay mr-20">
                                        <div class="img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/900x630)">
                                            <a class="img-link" href="single.html"></a>
                                            <span class="top-right-icon background2"><i class="mdi mdi-audiotrack"></i></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 align-center-vertical">
                                    <div class="post-content">
                                        <div class="entry-meta meta-0 font-small mb-15"><a href="category.html"><span class="post-cat background1 color-white">Sport</span></a></div>
                                        <h4 class="post-title">
                                            <a href="single.html">9 Things I Love About Shaving My Head During Quarantine</a>
                                        </h4>
                                        <div class="entry-meta meta-1 font-small color-grey mt-15 mb-15">
                                            <span class="post-on"><i class="ti-marker-alt"></i>25 April 2020</span>
                                            <span class="time-reading"><i class="ti-timer"></i>10 mins read</span>
                                            <span class="hit-count"><i class="ti-bolt"></i> 159k Views</span>
                                        </div>
                                        <p class="font-medium">At the Emmys, broadcast scripted shows created by people of color gained ground relative to those pitched by White show creators, while broadcast scripted shows.</p>
                                        <a class="readmore-btn font-small text-uppercase font-weight-ultra" href="single.html">Read More<i class="ti-arrow-right ml-5"></i></a>
                                    </div>
                                </div>
                            </article>
                        </div>
                        <!--Start pagination -->
                        <div class="pagination-area pt-30 text-center bt-1 border-color-1">
                            <div class="container">
                                <div class="row">
                                    <div class="col-xl-12">
                                        <div class="single-wrap d-flex justify-content-center">
                                            <nav aria-label="Page navigation example">
                                                <ul class="pagination justify-content-start">
                                                    <li class="page-item"><a class="page-link" href="#"><i class="flaticon-left"></i> </a></li>
                                                    <li class="page-item active"><a class="page-link" href="#">01</a></li>
                                                    <li class="page-item"><a class="page-link" href="#">02</a></li>
                                                    <li class="page-item"><a class="page-link" href="#">03</a></li>
                                                    <li class="page-item"><a class="page-link" href="#"><i class="flaticon-right"></i> </a></li>
                                                </ul>
                                            </nav>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- End pagination  -->
                    </div>
                    <div class="col-lg-4 col-md-12">
                        <div class="widget-area">
                            <!-- Social Network -->
                            <div class="sidebar-widget widget-social-network mb-30">
                                <div class="widget-header position-relative mb-30">
                                    <h5 class="widget-title mt-5 mb-30">Follow Us</h5>
                                </div>
                                <div class="social-network">
                                    <div class="follow-us d-flex align-items-center">
                                        <a class="follow-us-facebook clearfix mr-5 mb-10" href="#" target="_blank">
                                            <div class="social-icon">
                                                <i class="ti-facebook mr-5 v-align-space"></i>
                                                <i class="ti-facebook mr-5 v-align-space nth-2"></i>
                                            </div>
                                            <span class="social-name">Facebook</span>
                                            <span class="social-count counter-number">65</span><span class="social-count">K</span>
                                        </a>
                                        <a class="follow-us-twitter clearfix ml-5 mb-10" href="#" target="_blank">
                                            <div class="social-icon">
                                                <i class="ti-twitter-alt mr-5 v-align-space"></i>
                                                <i class="ti-twitter-alt mr-5 v-align-space nth-2"></i>
                                            </div>
                                            <span class="social-name">Twitter</span>
                                            <span class="social-count counter-number">75</span><span class="social-count">K</span>
                                        </a>
                                    </div>
                                    <div class="follow-us d-flex align-items-center">
                                        <a class="follow-us-instagram clearfix mr-5" href="#" target="_blank">
                                            <div class="social-icon">
                                                <i class="ti-instagram mr-5 v-align-space"></i>
                                                <i class="ti-instagram mr-5 v-align-space nth-2"></i>
                                            </div>
                                            <span class="social-name">Instagram</span>
                                            <span class="social-count counter-number">32</span><span class="social-count">K</span>
                                        </a>
                                        <a class="follow-us-youtube clearfix ml-5" href="#" target="_blank">
                                            <div class="social-icon">
                                                <i class="ti-youtube mr-5 v-align-space"></i>
                                                <i class="ti-youtube mr-5 v-align-space nth-2"></i>
                                            </div>
                                            <span class="social-name">Youtube</span>
                                            <span class="social-count counter-number">28</span><span class="social-count">K</span>
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <!--taber-->
                            <div class="sidebar-widget widget-taber mb-30">
                                <div class="widget-taber-content background-white pt-30 pb-30 pl-30 pr-30 border-radius-5">
                                    <nav class="tab-nav float-none mb-20">
                                        <div class="nav nav-tabs" role="tablist">
                                            <a class="nav-item nav-link active" id="nav-popular-tab" data-toggle="tab" href="#nav-popular" role="tab" aria-controls="nav-popular" aria-selected="true">Popular</a>
                                            <a class="nav-item nav-link" id="nav-trending-tab" data-toggle="tab" href="#nav-trending" role="tab" aria-controls="nav-trending" aria-selected="false">Trending</a>
                                            <a class="nav-item nav-link" id="nav-comment-tab" data-toggle="tab" href="#nav-comment" role="tab" aria-controls="nav-comment" aria-selected="false">Comments</a>
                                        </div>
                                    </nav>
                                    <div class="tab-content">
                                        <!--Tab Popular-->
                                        <div class="tab-pane fade show active" id="nav-popular" role="tabpanel" aria-labelledby="nav-popular-tab">
                                            <div class="post-block-list post-module-1">
                                                <ul class="list-post">
                                                    <li class="mb-30">
                                                        <div class="d-flex">
                                                            <div class="post-thumb d-flex mr-15 border-radius-5 img-hover-scale">
                                                                <a href="single.html">
                                                                    <img src="http://via.placeholder.com/500x500" alt="">
                                                                </a>
                                                            </div>
                                                            <div class="post-content media-body">
                                                                <div class="entry-meta meta-0 mb-10">
                                                                    <a href="category.html"><span class="post-in background5 color-white font-small">World</span></a>
                                                                </div>
                                                                <h6 class="post-title mb-10 text-limit-2-row">Traveling Tends to Magnify All Human Emotions</h6>
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
                                                                <a href="single.html">
                                                                    <img src="http://via.placeholder.com/500x500" alt="">
                                                                </a>
                                                            </div>
                                                            <div class="post-content media-body">
                                                                <div class="entry-meta meta-0 mb-10">
                                                                    <a href="category.html"><span class="post-in background7 color-white font-small">Films</span></a>
                                                                </div>
                                                                <h6 class="post-title mb-10 text-limit-2-row">The Luxury Of Traveling With Yacht</h6>
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
                                                                <a href="single.html">
                                                                    <img src="http://via.placeholder.com/500x500" alt="">
                                                                </a>
                                                            </div>
                                                            <div class="post-content media-body">
                                                                <div class="entry-meta meta-0 mb-10">
                                                                    <a href="category.html"><span class="post-in background2 color-white font-small">Travel</span></a>
                                                                </div>
                                                                <h6 class="post-title mb-10 text-limit-2-row">Last Minute Festive Packages From Superbreak</h6>
                                                                <div class="entry-meta meta-1 font-x-small color-grey mt-10">
                                                                    <span class="post-on">25 April</span>
                                                                    <span class="hit-count has-dot">54k Views</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </li>
                                                    <li>
                                                        <div class="d-flex">
                                                            <div class="post-thumb d-flex mr-15 border-radius-5 img-hover-scale">
                                                                <a href="single.html">
                                                                    <img src="http://via.placeholder.com/500x500" alt="">
                                                                </a>
                                                            </div>
                                                            <div class="post-content media-body">
                                                                <div class="entry-meta meta-0 mb-10">
                                                                    <a href="category.html"><span class="post-in background3 color-white font-small">Beauty</span></a>
                                                                </div>
                                                                <h6 class="post-title mb-10 text-limit-2-row">Less Is More: Diving into Minimalism in Photography</h6>
                                                                <div class="entry-meta meta-1 font-x-small color-grey mt-10">
                                                                    <span class="post-on">25 April</span>
                                                                    <span class="hit-count has-dot">126k Views</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <!--Tab Trending-->
                                        <div class="tab-pane fade" id="nav-trending" role="tabpanel" aria-labelledby="nav-trending-tab">
                                            <div class="row">
                                                <div class="col-md-6 col-sm-6 sm-grid-content mb-30">
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
                                                <div class="col-md-6 col-sm-6 sm-grid-content mb-30">
                                                    <div class="post-thumb d-flex border-radius-5 img-hover-scale mb-15">
                                                        <a href="single.html">
                                                            <img src="http://via.placeholder.com/900x630" alt="">
                                                        </a>
                                                    </div>
                                                    <div class="post-content media-body">
                                                        <h6 class="post-title mb-10 text-limit-2-row">6 Ways to Instantly Improve your Ui Design.</h6>
                                                        <div class="entry-meta meta-1 font-x-small color-grey mt-10">
                                                            <span class="post-on">25 April</span>
                                                            <span class="hit-count has-dot">126k Views</span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6 col-sm-6 sm-grid-content mb-30">
                                                    <div class="post-thumb d-flex border-radius-5 img-hover-scale mb-15">
                                                        <a href="single.html">
                                                            <img src="http://via.placeholder.com/900x630" alt="">
                                                        </a>
                                                    </div>
                                                    <div class="post-content media-body">
                                                        <h6 class="post-title mb-10 text-limit-2-row">Water Partners With Rag & Bone To Consume</h6>
                                                        <div class="entry-meta meta-1 font-x-small color-grey">
                                                            <span class="post-on">25 April</span>
                                                            <span class="hit-count has-dot">126k Views</span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6 col-sm-6 sm-grid-content mb-30">
                                                    <div class="post-thumb d-flex border-radius-5 img-hover-scale mb-15">
                                                        <a href="single.html">
                                                            <img src="http://via.placeholder.com/900x630" alt="">
                                                        </a>
                                                    </div>
                                                    <div class="post-content media-body">
                                                        <h6 class="post-title mb-10 text-limit-2-row">The loss is not all that surprising</h6>
                                                        <div class="entry-meta meta-1 font-x-small color-grey mt-10">
                                                            <span class="post-on">25 April</span>
                                                            <span class="hit-count has-dot">126k Views</span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6 col-sm-6 sm-grid-content">
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
                                                <div class="col-md-6 col-sm-6 sm-grid-content">
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
                                        <!--Tab Comments-->
                                        <div class="tab-pane fade" id="nav-comment" role="tabpanel" aria-labelledby="nav-comment-tab">
                                            <div class="post-block-list post-module-1">
                                                <ul class="list-post">
                                                    <li class="mb-30">
                                                        <div class="d-flex">
                                                            <div class="post-thumb d-flex mr-15 border-radius-5 img-hover-scale">
                                                                <a href="single.html">
                                                                    <img src="http://via.placeholder.com/500x500" alt="">
                                                                </a>
                                                            </div>
                                                            <div class="post-content media-body">
                                                                <div class="entry-meta meta-0 mb-10">
                                                                    <a href="category.html"><span class="post-in background2 color-white font-small">World</span></a>
                                                                </div>
                                                                <h6 class="post-title mb-10 text-limit-2-row">Traveling Tends to Magnify All Human Emotions</h6>
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
                                                                <a href="single.html">
                                                                    <img src="http://via.placeholder.com/500x500" alt="">
                                                                </a>
                                                            </div>
                                                            <div class="post-content media-body">
                                                                <div class="entry-meta meta-0 mb-10">
                                                                    <a href="category.html"><span class="post-in background3 color-white font-small">Films</span></a>
                                                                </div>
                                                                <h6 class="post-title mb-10 text-limit-2-row">The Luxury Of Traveling With Yacht</h6>
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
                                                                <a href="single.html">
                                                                    <img src="http://via.placeholder.com/500x500" alt="">
                                                                </a>
                                                            </div>
                                                            <div class="post-content media-body">
                                                                <div class="entry-meta meta-0 mb-10">
                                                                    <a href="category.html"><span class="post-in background7 color-white font-small">Travel</span></a>
                                                                </div>
                                                                <h6 class="post-title mb-10 text-limit-2-row">Last Minute Festive Packages From Superbreak</h6>
                                                                <div class="entry-meta meta-1 font-x-small color-grey mt-10">
                                                                    <span class="post-on">25 April</span>
                                                                    <span class="hit-count has-dot">54k Views</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </li>
                                                    <li>
                                                        <div class="d-flex">
                                                            <div class="post-thumb d-flex mr-15 border-radius-5 img-hover-scale">
                                                                <a href="single.html">
                                                                    <img src="http://via.placeholder.com/500x500" alt="">
                                                                </a>
                                                            </div>
                                                            <div class="post-content media-body">
                                                                <div class="entry-meta meta-0 mb-10">
                                                                    <a href="category.html"><span class="post-in background8 color-white font-small">Beauty</span></a>
                                                                </div>
                                                                <h6 class="post-title mb-10 text-limit-2-row">Less Is More: Diving into Minimalism in Photography</h6>
                                                                <div class="entry-meta meta-1 font-x-small color-grey mt-10">
                                                                    <span class="post-on">25 April</span>
                                                                    <span class="hit-count has-dot">126k Views</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Ads -->
                            <div class="sidebar-widget widget-ads mb-30 text-center">
                                <a href="https://vimeo.com/333834999" class="play-video" data-animate="zoomIn" data-duration="1.5s" data-delay="0.1s">
                                    <img class="d-inline-block" src="http://via.placeholder.com/432x200" alt="">
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--Recent Articles End -->
    </main>

    <tiles:insertAttribute name="footer" />
</div>
<!-- Main Wrap End-->
<div class="dark-mark"></div>
<!-- Vendor JS-->

<tiles:insertAttribute name="jsScripts"/>
</body>
zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz
</html>