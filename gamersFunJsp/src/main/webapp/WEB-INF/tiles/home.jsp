<%--
  Created by IntelliJ IDEA.
  User: odai
  Date: 1/18/2021
  Time: 2:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%--12 the total column
col-md-offset-3 -  offset means 3 from right 3 from left--%>

<c:url var="search" value="/search"/>
<div class="row status-row">
    <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="homepage-status">
            ${statusUpdate.text}
        </div>

    </div>
</div>

<div class="row">
    <div class="col-md-8 col-md-offset-2">
        <form method="post" action="${search}">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="input-group input-group-lg">
                <input type="text" class="form-control" name="s" placeholder="Search Hobbies"/>
                <span class="input-group-btn">
                    <button id="search-button" class="btn btn-primary" type="submit">
                        Find People
                    </button>
                </span>
            </div>
        </form>
    </div>
</div>