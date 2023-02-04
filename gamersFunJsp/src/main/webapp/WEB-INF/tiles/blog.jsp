<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="st"%>
<%@ taglib prefix="pg" tagdir="/WEB-INF/tags" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<%--@elvariable id="blog" type="gamersFun.com.example.gamersFun.entity.Blogs"--%>
<!DOCTYPE html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>UltraNews - Bootstrap 4 Magazine Template</title>
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" type="image/x-icon" href="${contextRoot}/imgs/favicon.png">
    <!-- UltraNews CSS  -->
    <link rel="stylesheet" href="${contextRoot}/css/style.css">
    <link rel="stylesheet" href="${contextRoot}/css/shop.css">
    <link rel="stylesheet" href="${contextRoot}/css/widgets.css">
    <link rel="stylesheet" href="${contextRoot}/css/color.css">
    <link rel="stylesheet" href="${contextRoot}/css/responsive.css">
    <link rel="stylesheet" href="${contextRoot}/css/jquery.tagit.css">

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
            <!--main content-->
            <div class="main_content sidebar_right pb-50 pt-50">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8 col-md-12 col-sm-12">
                            <div class="entry-header entry-header-1 mb-30">
                                <div class="entry-meta meta-0 font-small mb-15"><a href="category.html"><span class="post-cat background2 color-white">Technology</span></a></div>
                                <h1 class="post-title">
                                    <a href="single.html">${blog.subject}</a>
                                </h1>
                                <div class="entry-meta meta-1 font-small color-grey mt-15 mb-15">
                                    <span class="post-by">By <a href="author.html">${blog.profile.user.userName}</a></span>
                                    <span class="post-on has-dot">9 April 2020</span>
                                    <span class="time-reading has-dot">8 mins read</span>
                                    <span class="hit-count"><i class="ti-bolt"></i> 129k Views</span>
                                </div>
                                <div class="bt-1 border-color-1 mt-30 mb-30"></div>
                                <div class="single-social-share clearfix ">
                                    <div class="entry-meta meta-1 font-small color-grey float-left mt-10">
                                        <span class="hit-count"><i class="ti-comment mr-5"></i>82 comments</span>
                                        <span class="hit-count"><i class="ti-heart mr-5"></i>68 likes</span>
                                        <span class="hit-count"><i class="ti-star mr-5"></i>8/10</span>
                                    </div>
                                    <ul class="d-inline-block list-inline float-right">
                                        <li class="list-inline-item"><a class="social-icon facebook-icon text-xs-center color-white" target="_blank" href="#"><i class="ti-facebook"></i></a></li>
                                        <li class="list-inline-item"><a class="social-icon twitter-icon text-xs-center color-white" target="_blank" href="#"><i class="ti-twitter-alt"></i></a></li>
                                        <li class="list-inline-item"><a class="social-icon pinterest-icon text-xs-center color-white" target="_blank" href="#"><i class="ti-pinterest"></i></a></li>
                                        <li class="list-inline-item"><a class="social-icon instagram-icon text-xs-center color-white" target="_blank" href="#"><i class="ti-instagram"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                            <!--end entry header-->
                            <figure class="single-thumnail">
                                <div class="featured-slider-1 border-radius-5">
                                    <div class="featured-slider-1-items">
                                        <div class="slider-single">
                                            <img src="http://via.placeholder.com/900x630" alt="">
                                        </div>
                                        <div class="slider-single">
                                            <img src="http://via.placeholder.com/900x630" alt="">
                                        </div>
                                        <div class="slider-single">
                                            <img src="http://via.placeholder.com/900x630" alt="">
                                        </div>
                                    </div>
                                </div>
                                <div class="arrow-cover"></div>
                                <div class="credit mt-15 font-small color-grey">
                                    <i class="ti-credit-card mr-5"></i><span>Image credit: Behance</span>
                                </div>
                            </figure>
                            <%--<div class="single-excerpt">
                                <p class="font-large">Tolerably much and ouch the in began alas more ouch some then accommodating flimsy wholeheartedly after hello slightly the that cow pouted much a goodness bound rebuilt poetically jaguar groundhog</p>
                            </div>--%>
                            <div class="entry-main-content">
                                ${blog.body}
                            </div>
                            <div class="entry-bottom mt-50 mb-30">
                                <div class="tags">
                                    <a href="category.html" rel="tag">couple</a>
                                    <a href="category.html" rel="tag">in love</a>
                                    <a href="category.html" rel="tag">romantice</a>
                                </div>
                            </div>
                            <div class="single-social-share clearfix ">
                                <div class="entry-meta meta-1 font-small color-grey float-left mt-10">
                                    <span class="hit-count"><i class="ti-comment"></i>82 comments</span>
                                    <span class="hit-count"><i class="ti-heart"></i>68 likes</span>
                                    <span class="hit-count"><i class="ti-star"></i>8/10</span>
                                </div>
                                <ul class="d-inline-block list-inline float-right">
                                    <li class="list-inline-item"><a class="social-icon facebook-icon text-xs-center color-white" target="_blank" href="#"><i class="ti-facebook"></i></a></li>
                                    <li class="list-inline-item"><a class="social-icon twitter-icon text-xs-center color-white" target="_blank" href="#"><i class="ti-twitter-alt"></i></a></li>
                                    <li class="list-inline-item"><a class="social-icon pinterest-icon text-xs-center color-white" target="_blank" href="#"><i class="ti-pinterest"></i></a></li>
                                    <li class="list-inline-item"><a class="social-icon instagram-icon text-xs-center color-white" target="_blank" href="#"><i class="ti-instagram"></i></a></li>
                                </ul>
                            </div>
                            <div class="bt-1 border-color-1 mt-30 mb-30"></div>
                            <!--author box-->
                            <div class="author-bio">
                                <div class="author-image mb-30">
                                    <a href="author.html"><img src="http://via.placeholder.com/223x223" alt="" class="avatar"></a>
                                </div>
                                <div class="author-info">
                                    <h3><span class="vcard author"><span class="fn"><a href="author.html" title="Posts by Robert" rel="author">${blog.profile.user.userName}</a></span></span>
                                    </h3>
                                    <h5>About author</h5>
                                    <div class="author-description">You should write because you love the shape of stories and sentences and the creation of different words on a page. </div>
                                    <a href="author.html" class="author-bio-link">View all posts</a>
                                    <div class="author-social">
                                        <ul class="author-social-icons">
                                            <li class="author-social-link-facebook"><a href="#" target="_blank"><i class="ti-facebook"></i></a></li>
                                            <li class="author-social-link-twitter"><a href="#" target="_blank"><i class="ti-twitter-alt"></i></a></li>
                                            <li class="author-social-link-pinterest"><a href="#" target="_blank"><i class="ti-pinterest"></i></a></li>
                                            <li class="author-social-link-instagram"><a href="#" target="_blank"><i class="ti-instagram"></i></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <!--related posts-->
                            <div class="related-posts">
                                <h3 class="mb-30">Related posts</h3>
                                <div class="loop-list">
                                    <article class="row mb-30">
                                        <div class="col-md-4">
                                            <div class="post-thumb position-relative thumb-overlay">
                                                <div class="img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/900x630)">
                                                    <a class="img-link" href="single.html"></a>
                                                    <span class="top-right-icon background8"><i class="mdi mdi-flash-on"></i></span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-8 align-center-vertical">
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
                                            </div>
                                        </div>
                                    </article>
                                    <article class="row mb-30">
                                        <div class="col-md-4">
                                            <div class="post-thumb position-relative thumb-overlay">
                                                <div class="img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/900x630)">
                                                    <a class="img-link" href="single.html"></a>
                                                    <span class="top-right-icon background5"><i class="mdi mdi-favorite"></i></span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-8 align-center-vertical">
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
                                            </div>
                                        </div>
                                    </article>
                                    <article class="row mb-30">
                                        <div class="col-md-4">
                                            <div class="post-thumb position-relative thumb-overlay">
                                                <div class="img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/900x630)">
                                                    <a class="img-link" href="single.html"></a>
                                                    <span class="top-right-icon background2"><i class="mdi mdi-audiotrack"></i></span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-8 align-center-vertical">
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
                                            </div>
                                        </div>
                                    </article>
                                </div>
                            </div>
                            <!--Comments-->
                            <div class="comments-area">
                                <h3 class="mb-30">03 Comments</h3>
                                <div class="comment-list">
                                    <div class="single-comment justify-content-between d-flex">
                                        <div class="userEntity justify-content-between d-flex">
                                            <div class="thumb">
                                                <img src="http://via.placeholder.com/223x223" alt="">
                                            </div>
                                            <div class="desc">
                                                <p class="comment">
                                                    Vestibulum euismod, leo eget varius gravida, eros enim interdum urna, non rutrum enim ante quis metus. Duis porta ornare nulla ut bibendum
                                                </p>
                                                <div class="d-flex justify-content-between">
                                                    <div class="d-flex align-items-center">
                                                        <h5>
                                                            <a href="#">Robert</a>
                                                        </h5>
                                                        <p class="date">December 4, 2020 at 3:12 pm </p>
                                                    </div>
                                                    <div class="reply-btn">
                                                        <a href="#" class="btn-reply text-uppercase">reply</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="comment-list">
                                    <div class="single-comment justify-content-between d-flex">
                                        <div class="userEntity justify-content-between d-flex">
                                            <div class="thumb">
                                                <img src="http://via.placeholder.com/223x223" alt="">
                                            </div>
                                            <div class="desc">
                                                <p class="comment">
                                                    Sed ac lorem felis. Ut in odio lorem. Quisque magna dui, maximus ut commodo sed, vestibulum ac nibh. Aenean a tortor in sem tempus auctor
                                                </p>
                                                <div class="d-flex justify-content-between">
                                                    <div class="d-flex align-items-center">
                                                        <h5>
                                                            <a href="#">Maria</a>
                                                        </h5>
                                                        <p class="date">December 4, 2020 at 3:12 pm </p>
                                                    </div>
                                                    <div class="reply-btn">
                                                        <a href="#" class="btn-reply text-uppercase">reply</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="comment-list">
                                    <div class="single-comment justify-content-between d-flex">
                                        <div class="userEntity justify-content-between d-flex">
                                            <div class="thumb">
                                                <img src="http://via.placeholder.com/223x223" alt="">
                                            </div>
                                            <div class="desc">
                                                <p class="comment">
                                                    Donec in ullamcorper quam. Aenean vel nibh eu magna gravida fermentum. Praesent eget nisi pulvinar, sollicitudin eros vitae, tristique odio.
                                                </p>
                                                <div class="d-flex justify-content-between">
                                                    <div class="d-flex align-items-center">
                                                        <h5>
                                                            <a href="#">Robert</a>
                                                        </h5>
                                                        <p class="date">December 4, 2020 at 3:12 pm </p>
                                                    </div>
                                                    <div class="reply-btn">
                                                        <a href="#" class="btn-reply text-uppercase">reply</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--comment form-->
                            <div class="comment-form">
                                <h3 class="mb-30">Leave a Reply</h3>
                                <form class="form-contact comment_form" action="#" id="commentForm">
                                    <div class="row">
                                        <div class="col-12">
                                            <div class="form-group">
                                                <textarea class="form-control w-100" name="comment" id="comment" cols="30" rows="9" placeholder="Write Comment"></textarea>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <input class="form-control" name="name" id="name" type="text" placeholder="Name">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <input class="form-control" name="email" id="email" type="email" placeholder="Email">
                                            </div>
                                        </div>
                                        <div class="col-12">
                                            <div class="form-group">
                                                <input class="form-control" name="website" id="website" type="text" placeholder="Website">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <button type="submit" class="button button-contactForm">Post Comment</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <!--col-lg-8-->
                        <!--Right sidebar-->
                        <div class="col-lg-4 col-md-12 col-sm-12 primary-sidebar sticky-sidebar">
                            <div class="widget-area pl-30">
                                <!--Widget about-->
                                <div class="sidebar-widget widget-about mb-50 pt-30 pr-30 pb-30 pl-30 background12 border-radius-5">
                                    <h5 class="mb-20">Hello, I'm Robert<img class="about-author-img float-right ml-30" src="http://via.placeholder.com/223x223" alt=""></h5>
                                    <p class="font-medium">You should write because you love the shape of stories and sentences and the creation of different words on a page. Writing comes from reading, and reading is the finest teacher of how to write.</p>
                                    <ul class="header-social-network d-inline-block list-inline color-white mb-20">
                                        <li class="list-inline-item"><a class="social-icon facebook-icon text-xs-center" target="_blank" href="#"><i class="ti-facebook"></i></a></li>
                                        <li class="list-inline-item"><a class="social-icon twitter-icon text-xs-center" target="_blank" href="#"><i class="ti-twitter-alt"></i></a></li>
                                        <li class="list-inline-item"><a class="social-icon pinterest-icon text-xs-center" target="_blank" href="#"><i class="ti-pinterest"></i></a></li>
                                        <li class="list-inline-item"><a class="social-icon instagram-icon text-xs-center" target="_blank" href="#"><i class="ti-instagram"></i></a></li>
                                    </ul>
                                    <p>
                                        <a class="readmore-btn font-small text-uppercase font-weight-ultra" href="contact.html">Contact me<i class="ti-arrow-right ml-5"></i></a>
                                    </p>
                                </div>
                                <!--Widget social-->
                                <div class="sidebar-widget widget-social-network mb-50">
                                    <div class="widget-header position-relative mb-20 pb-10">
                                        <h5 class="widget-title mb-10">Follow Us</h5>
                                        <div class="bt-1 border-color-1"></div>
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
                                <!--Widget latest posts style 1-->
                                <div class="sidebar-widget widget_alitheme_lastpost mb-50">
                                    <div class="widget-header position-relative mb-20 pb-10">
                                        <h5 class="widget-title mb-10">Latest Posts</h5>
                                        <div class="bt-1 border-color-1"></div>
                                    </div>
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
                                                <h6 class="post-title mb-10 text-limit-2-row">Water Partners With Rag &amp; Bone To Consume</h6>
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
                                <!--Widget categories-->
                                <div class="sidebar-widget widget_categories mb-50">
                                    <div class="widget-header position-relative mb-20 pb-10">
                                        <h5 class="widget-title mb-10">Categories</h5>
                                        <div class="bt-1 border-color-1"></div>
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
                                <!--Widget latest posts style 2-->
                                <div class="sidebar-widget widget_alitheme_lastpost mb-50">
                                    <div class="widget-header position-relative mb-20 pb-10">
                                        <h5 class="widget-title mb-10">Trending Posts</h5>
                                        <div class="bt-1 border-color-1"></div>
                                    </div>
                                    <div class="post-block-list">
                                        <article class="mb-30">
                                            <div class="post-thumb position-relative thumb-overlay mb-30">
                                                <div class="img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/900x630)">
                                                    <a class="img-link" href="single.html"></a>
                                                    <span class="top-right-icon background8"><i class="mdi mdi-camera-alt"></i></span>
                                                </div>
                                            </div>
                                            <div class="post-content">
                                                <div class="entry-meta meta-0 font-small mb-15">
                                                    <a href="category.html"><span class="post-cat background9 color-white">Beauty</span></a>
                                                </div>
                                                <h4 class="post-title">
                                                    <a href="single.html">The litigants on the screen are not actors</a>
                                                </h4>
                                                <div class="entry-meta meta-1 font-small color-grey mt-15 mb-15">
                                                    <span class="post-on">15 April 2020</span>
                                                    <span class="time-reading has-dot">12 mins read</span>
                                                    <span class="hit-count"><i class="ti-bolt"></i> 19k Views</span>
                                                </div>
                                            </div>
                                        </article>
                                        <article class="mb-30">
                                            <div class="post-thumb position-relative thumb-overlay hover-box-shadow-2 mb-30">
                                                <div class="img-hover-slide border-radius-5 position-relative" style="background-image: url(http://via.placeholder.com/900x630)">
                                                    <a class="img-link" href="single.html"></a>
                                                </div>
                                            </div>
                                            <div class="post-content">
                                                <div class="entry-meta meta-0 font-small mb-15">
                                                    <a href="category.html"><span class="post-cat background3 color-white">Global</span></a>
                                                </div>
                                                <h4 class="post-title">
                                                    <a href="single.html">Essential Qualities of Highly Successful Music</a>
                                                </h4>
                                                <div class="entry-meta meta-1 font-small color-grey mt-15 mb-15">
                                                    <span class="post-on">9 April 2020</span>
                                                    <span class="time-reading has-dot">8 mins read</span>
                                                    <span class="hit-count"><i class="ti-bolt"></i> 129k Views</span>
                                                </div>
                                            </div>
                                        </article>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--End sidebar-->
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