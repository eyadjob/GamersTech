<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="st"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<%--@elvariable id="blog" type="gamersFun.com.example.gamersFun.entity.Blogs"--%>
<!DOCTYPE html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>My Account - UltraNews - Bootstrap 4 Magazine Template</title>
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
    <main class="position-relative profilePage">
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
                                    <a class="nav-link active" id="dashboard-tab" data-toggle="tab" href="#dashboard" role="tab" aria-controls="dashboard" aria-selected="false"><i class="ti-panel mr-5"></i>Dashboard</a>
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
                                <sec:authorize access="hasRole('ROLE_BLOGGER')">
                                    <li class="nav-item">
                                        <a class="nav-link" id="add-new-blog-tab" data-toggle="tab" href="#add-blogs" role="tab" aria-controls="add-blogs" aria-selected="true"><i class="ti-id-badge mr-5"></i>
                                                    Add New Blogs
                                        </a>
                                    </li>
                                    <c:choose>
                                        <c:when test="${param.tab eq 'edit-blog'}">
                                            <li class="nav-item">
                                                <a class="nav-link" id="edit-blog-tab" data-toggle="tab" href="#edit-blog" role="tab" aria-controls="add-blogs" aria-selected="true"><i class="ti-id-badge mr-5"></i>
                                                    Edit Blog
                                                </a>
                                            </li>
                                        </c:when>
                                    </c:choose>

                                    <li class="nav-item">
                                        <a class="nav-link" id="show-my-blogs-tab" data-toggle="tab" href="#show-my-blogs" role="tab" aria-controls="edit-blogs" aria-selected="true"><i class="ti-id-badge mr-5"></i>Show My Blogs</a>
                                    </li>
                                </sec:authorize>
                                <li class="nav-item">
                                    <a class="nav-link" href="javascript:$('#logoutForm').submit()"><i class="ti-lock mr-5"></i>Logout</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-9 col-md-8">
                        <div class="tab-content dashboard-content">
                            <div class="tab-pane fade active show" id="dashboard" role="tabpanel" aria-labelledby="dashboard-tab">
                                <div class="card">
                                    <div class="card-header">
                                        <h5 class="mb-0">Dashboard</h5>
                                    </div>
                                    <div class="card-body">
                                        <p>Welcome back ${email} From your account dashboard. you can easily check &amp; view your <a href="javascript:void(0);" onclick="$('#orders-tab').trigger('click')">recent orders</a>, manage your <a href="javascript:void(0);" onclick="$('#address-tab').trigger('click')">shipping and billing addresses</a> and <a href="javascript:void(0);" onclick="$('#account-detail-tab').trigger('click')">edit your password and account details.</a></p>
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
                            <sec:authorize access="hasRole('ROLE_BLOGGER')">
                                <div class="tab-pane fade" id="add-blogs" role="tabpanel" aria-labelledby="add-new-blog">
                                    <div class="card">
                                        <div class="card-header">
                                            <h3><st:message code="blog.header.new.blog"/></h3>
                                        </div>
                                        <div class="card-body">
                                            <c:set var="saveTag" value="${contextRoot}/save-tag"/>
                                            <c:set var="deleteTag" value="${contextRoot}/delete-tag"/>
                                            <form:form action="addBlogs"  enctype="multipart/form-data"  modelAttribute="blog">
                                                <div class="row">

                                                    <div class="form-group col-md-12">
                                                        <p>
                                                            <c:if test="${!empty message}">
                                                                <div class="alert alert-success" role="alert">
                                                                    <st:message code="blog.save.message"/>
                                                                </div>
                                                            </c:if>
                                                            <c:if test="${!empty error}">
                                                                <div class="alert alert-danger" role="alert">
                                                                    <st:message code="blog.error.message"/>
                                                                </div>
                                                            </c:if>
                                                            <c:if test="${!empty tab}">
                                                                <input type="hidden" name="addBlogtab" value="${tab}">
                                                            </c:if>
                                                        </p>
                                                    </div>

                                                    <div class="form-group col-md-12">
                                                        <label>Subject <span class="required">*</span></label>
                                                        <form:input type="text" path="subject" placeholder="Subject ..." class="form-control"/>
                                                    </div>
                                                    <div class="form-group col-md-12">
                                                        <label>Body <span class="required">*</span></label>
                                                        <form:input type="text" path="body" placeholder="Body ..." id="myBlogBody" class="form-control"/>
                                                    </div>
                                                    <div class="form-group col-md-12">
                                                        <label for="formFile" class="form-label">Image for your blog</label>
                                                        <input class="form-control" type="file"  accept="image/*" name="file" id="formFile">
                                                    </div>

                                                    <div class="form-group col-md-12">
                                                        <label>Tags: </label>

                                                    </div>

                                                    <div class="form-group col-md-12">
                                                        <select name="categories[]" id="categoryName" multiple size = 5>
                                                            <c:forEach items="${allCategories}" var="categoryVar">
                                                                <c:set var="currentCategoryValue" value="${categoryVar.getId()}"/>
                                                                <option path="categories"  value="${categoryVar.getId()}" >${categoryVar.getName()}</option>
                                                            </c:forEach>

                                                        </select>
                                                    </div>

                                                    <div class="col-md-12">
                                                        <button type="submit" class="btn btn-fill-out" name="submit" value="Submit">Save</button>
                                                    </div>
                                                </div>
                                            </form:form>

                                        </div>
                                    </div>
                                </div>

                               <c:if test="${param.tab eq 'edit-blog'}">
                                    <div class="tab-pane fade" id="edit-blog" role="tabpanel" aria-labelledby="edit-new-blog">
                                        <div class="card">
                                            <div class="card-header">
                                                        <h3>Edit Blog</h3>
                                            </div>
                                            <div class="card-body">

                                                        <form:form action="editBlog"  enctype="multipart/form-data"  modelAttribute="blog">
                                                            <form:hidden path="id" value="${blog.getId()}"/>
                                                            <div class="row">
                                                                <div class="form-group col-md-12">
                                                                    <p>
                                                                        <c:if test="${!empty param.message}">
                                                                            <div class="alert alert-success" role="alert">
                                                                                <st:message code="blog.updated.message"/>
                                                                            </div>
                                                                         </c:if>
                                                                        <c:if test="${!empty param.error}">
                                                                            <div class="alert alert-danger" role="alert">
                                                                                This is a danger alert—check it out!
                                                                            </div>
                                                                        </c:if>

                                                                    </p>
                                                                </div>
                                                                <div class="form-group col-md-12">
                                                                    <label>Subject <span class="required">*</span></label>
                                                                    <form:input type="text" path="subject" placeholder="Subject ..." class="form-control"/>
                                                                </div>
                                                                <div class="form-group col-md-12">
                                                                    <label>Body <span class="required">*</span></label>
                                                                    <form:input type="text" path="body" placeholder="Body ..." id="myBlogBody" class="form-control"/>
                                                                </div>
                                                                <div class="form-group col-md-12">
                                                                    <label for="formFile" class="form-label">Image for your blog</label>
                                                                    <input class="form-control" type="file"  accept="image/*" name="file" id="formFile">
                                                                </div>

                                                                <div class="form-group col-md-12">
                                                                    <label>Tags: </label>

                                                                </div>
                                                                <div class="form-group col-md-12">
                                                                    <form:select path="categories" multiple="multiple" size="5">
                                                                        <form:options items="${allCategories}" itemValue="id"  itemLabel="name" />
                                                                    </form:select>
                                                                </div>
                                                                <div class="col-md-12">
                                                                    <button type="submit" class="btn btn-fill-out" name="submit" value="Submit">Save</button>
                                                                </div>
                                                            </div>
                                                        </form:form>

                                            </div>
                                        </div>
                                    </div>
                               </c:if>
                                <div class="tab-pane fade" id="show-my-blogs" role="tabpanel" aria-labelledby="show-my-blogs-tab">
                                    <div class="card">
                                        <div class="card-header">
                                            <h5 class="mb-0">Your Blogs</h5>
                                            <c:if test="${!empty message && message eq 'deleted'}">
                                                <div class="alert alert-success delete-alert-success" role="alert">
                                                    Blog deleted successfully ...
                                                </div>
                                            </c:if>
                                            <div class="alert alert-danger delete-alert-error" style="display: none" role="alert">
                                                Blog updated successfully ...
                                            </div>
                                        </div>
                                        <div class="card-body">
                                            <div class="table-responsive">
                                                <table class="table">
                                                    <thead>
                                                    <tr>
                                                        <th>Blogs Created</th>
                                                        <th>Subject</th>
                                                        <th>Body</th>
                                                        <th>Image</th>
                                                        <th></th>
                                                        <th></th>
                                                    </tr>
                                                    </thead>

                                                    <c:url value="${contextRoot}/upload-profile-photo" var="uploadPhotoLink"/>
                                                    <tbody>
                                                    <c:forEach var="blog" items="${blogs}">
                                                        <tr>
                                                            <td>${blog.createdDate}</td>
                                                            <td>${blog.subject}</td>
                                                            <td>${blog.body}</td>
                                                            <c:set var="blogPhoto" value="/blogPhoto/${blog.id}"/>
                                                            <td>
                                                                <img src="${blogPhoto}" id="blogPhotoImg" width="100px" height="100px"/></td>
                                                            <td><a href="/editBlog?id=${blog.id}&tab=edit-blog" class="btn btn-fill-out btn-small d-block">Edit</a></td>
                                                            <td><a href="/deleteBlog?id=${blog.id}" class="btn btn-fill-out btn-small d-block delete-blog">Delete</a></td>
                                                        </tr>
                                                    </c:forEach>

                                                    </tbody>

                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </sec:authorize>
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
<!-- Vendor JS-->
<tiles:insertAttribute name="jsScripts"/>

<script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>

<script>
    tinymce.init({
        selector: '#myBlogBody',
        plugins: "link"
    });
</script>
</body>

</html>