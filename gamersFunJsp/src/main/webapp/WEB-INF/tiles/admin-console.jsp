<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>My Account - UltraNews - Bootstrap 4 Magazine Template</title>
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
    <!-- Main Wrap Start -->
    <tiles:insertAttribute name="header"/>
    <main class="position-relative">
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
        <!--archive header-->
        <div class="archive-header shop-header header-bg2 pt-50 pb-50 mb-80">
            <div class="container">
                <div class="row align-items-center h-100">
                    <div class="col-md-6 mx-auto">
                        <h2><span class="color6">My Account</span></h2>
                    </div>
                    <div class="col-md-6 mx-auto text-center text-md-right">
                        <div class="breadcrumb">
                            <a href="index.html"><i class="ti-home mr-5"></i>Home</a><span></span>
                            <a href="shop-category.html">Pages</a><span></span> My Account
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--main content-->
        <div class="main_content shop pb-80">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-md-4">
                        <div class="dashboard-menu ">
                            <ul class="nav flex-column" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" id="add-page-tab" data-toggle="tab" href="#addNewPage" role="tab" aria-controls="dashboard" aria-selected="false"><i class="ti-panel mr-5"></i>Add New Page</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="orders-tab" data-toggle="tab" href="#orders" role="tab" aria-controls="orders" aria-selected="false"><i class="ti-shopping-cart-full mr-5"></i>Orders</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="address-tab" data-toggle="tab" href="#address" role="tab" aria-controls="address" aria-selected="true"><i class="ti-location-pin mr-5"></i>My Address</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="account-detail-tab" data-toggle="tab" href="#account-detail" role="tab" aria-controls="account-detail" aria-selected="true"><i class="ti-id-badge mr-5"></i>Account details</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="login.html"><i class="ti-lock mr-5"></i>Logout</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-9 col-md-8">
                        <div class="tab-content dashboard-content">
                            <div class="tab-pane fade active show" id="addNewPage" role="tabpanel" aria-labelledby="addNewsPage-tab">
                                <div class="card">
                                    <div class="card-header">
                                        <h5 class="mb-0">Add New Gaming Page Here</h5>
                                    </div>
                                    <div class="card-body">

                                        <h1>Categories List</h1>
                                        <jsp:useBean id="allCategories" type="java.util.ArrayList" scope="request"  />
                                        <table border="1">
                                            <tr>
                                                <td>Category Id:</td>
                                                <td>Category Name:</td>
                                            </tr>
                                            <core:forEach items="${allCategories}" var="categoriesVar">
                                                <tr>
                                                    <td>${categoriesVar.getId()}</td>
                                                    <td>${categoriesVar.getName()}</td>
                                                </tr>
                                            </core:forEach>
                                        </table>
                                        <p>From your account dashboard. you can easily check &amp; view your <a href="javascript:void(0);" onclick="$('#orders-tab').trigger('click')">recent orders</a>, manage your <a href="javascript:void(0);" onclick="$('#address-tab').trigger('click')">shipping and billing addresses</a> and <a href="javascript:void(0);" onclick="$('#account-detail-tab').trigger('click')">edit your password and account details.</a></p>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="orders" role="tabpanel" aria-labelledby="orders-tab">
                                <div class="card">
                                    <div class="card-header">
                                        <h5 class="mb-0">Your Orders</h5>
                                    </div>
                                    <div class="card-body">
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead>
                                                <tr>
                                                    <th>Order</th>
                                                    <th>Date</th>
                                                    <th>Status</th>
                                                    <th>Total</th>
                                                    <th>Actions</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <tr>
                                                    <td>#1357</td>
                                                    <td>March 45, 2020</td>
                                                    <td>Processing</td>
                                                    <td>$125.00 for 2 item</td>
                                                    <td><a href="#" class="btn btn-fill-out btn-small d-block">View</a></td>
                                                </tr>
                                                <tr>
                                                    <td>#2468</td>
                                                    <td>June 29, 2020</td>
                                                    <td>Completed</td>
                                                    <td>$364.00 for 5 item</td>
                                                    <td><a href="#" class="btn btn-fill-out btn-small d-block">View</a></td>
                                                </tr>
                                                <tr>
                                                    <td>#2366</td>
                                                    <td>August 02, 2020</td>
                                                    <td>Completed</td>
                                                    <td>$280.00 for 3 item</td>
                                                    <td><a href="#" class="btn btn-fill-out btn-small d-block">View</a></td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="address" role="tabpanel" aria-labelledby="address-tab">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="card mb-3 mb-lg-0">
                                            <div class="card-header">
                                                <h5 class="mb-0">Billing Address</h5>
                                            </div>
                                            <div class="card-body">
                                                <address>3522 Interstate<br> 75 Business Spur,<br> Sault Ste. <br>Marie, MI 49783</address>
                                                <p>New York</p>
                                                <a href="#" class="btn btn-fill-out btn-small">Edit</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="card">
                                            <div class="card-header">
                                                <h5 class="mb-0">Shipping Address</h5>
                                            </div>
                                            <div class="card-body">
                                                <address>4299 Express Lane<br>
                                                    Sarasota, <br>FL 34249 USA <br>Phone: 1.941.227.4444</address>
                                                <p>Sarasota</p>
                                                <a href="#" class="btn btn-fill-out btn-small">Edit</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="account-detail" role="tabpanel" aria-labelledby="account-detail-tab">
                                <div class="card">
                                    <div class="card-header">
                                        <h3>Account Details</h3>
                                    </div>
                                    <div class="card-body">
                                        <p>Already have an account? <a href="login.html">Log in instead!</a></p>
                                        <form method="post" name="enq">
                                            <div class="row">
                                                <div class="form-group col-md-6">
                                                    <label>First Name <span class="required">*</span></label>
                                                    <input required="" class="form-control" name="name" type="text">
                                                </div>
                                                <div class="form-group col-md-6">
                                                    <label>Last Name <span class="required">*</span></label>
                                                    <input required="" class="form-control" name="phone">
                                                </div>
                                                <div class="form-group col-md-12">
                                                    <label>Display Name <span class="required">*</span></label>
                                                    <input required="" class="form-control" name="dname" type="text">
                                                </div>
                                                <div class="form-group col-md-12">
                                                    <label>Email Address <span class="required">*</span></label>
                                                    <input required="" class="form-control" name="email" type="email">
                                                </div>
                                                <div class="form-group col-md-12">
                                                    <label>Current Password <span class="required">*</span></label>
                                                    <input required="" class="form-control" name="password" type="password">
                                                </div>
                                                <div class="form-group col-md-12">
                                                    <label>New Password <span class="required">*</span></label>
                                                    <input required="" class="form-control" name="npassword" type="password">
                                                </div>
                                                <div class="form-group col-md-12">
                                                    <label>Confirm Password <span class="required">*</span></label>
                                                    <input required="" class="form-control" name="cpassword" type="password">
                                                </div>
                                                <div class="col-md-12">
                                                    <button type="submit" class="btn btn-fill-out" name="submit" value="Submit">Save</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
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