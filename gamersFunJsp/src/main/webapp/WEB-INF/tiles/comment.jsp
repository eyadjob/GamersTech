<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <c:forEach var="node" items="${attribute.comments}">
        <div class="comment-list">
                ${level}
            <div class="single-comment justify-content-between d-flex" style="margin-left: 100px">
                <div class="userEntity justify-content-between d-flex">
                    <div class="thumb">
                        <img src="http://via.placeholder.com/223x223" alt="">
                    </div>
                    <div class="desc">
                        <p class="comment">
                                ${node.text}  [${node.id}]
                        </p>
                        <div class="d-flex justify-content-between">
                            <div class="d-flex align-items-center">
                                <h5>
                                    <a href="#">${node.user.userName}</a>
                                </h5>
                                <p class="date">${node.createdDate} </p>
                            </div>
                            <div class="reply-btn">
                                <a href="#" class="btn-reply text-uppercase">reply</a>
                            </div>
                        </div>
                    </div>

                </div>

            </div>
        </div>
        <c:set var="attribute" value="${node}" scope="request"/>
        <c:set var="level" value="${empty level ? 1 : level + 1}" scope="request"/>
        <c:choose>
            <c:when test="${empty margin}">
                <c:set var="margin" value="${100}" scope="request"/>
            </c:when>
            <c:otherwise>
                <c:set var="margin" value="${margin*level}" scope="request"/>
            </c:otherwise>
        </c:choose>
        <c:if test="${not empty node.comments}">
            go to inner level
        </c:if>
        <jsp:include page="comment.jsp"/>
    </c:forEach>
