<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ attribute name="page" required="true" type="org.springframework.data.domain.Page" %>
<%@ attribute name="url" required="true" %>
<%--Number of page numbers to display at once.--%>
<%@ attribute name="size" required="false" %>
<c:set var="block" value="${empty param.b ? 0 : param.b}" />
<c:set var="size" value="${empty size ? 10 : size}" />
<c:set var="startPage" value="${block * size + 1}" />
<c:set var="endPage" value="${(block + 1) * size}" />
<c:set var="endPage" value="${endPage > page.totalPages ? page.totalPages : endPage}" />
<%--
For debugging
<p>block: ${block}</p>
<p>Size : ${size}</p>
<p>startPage: ${startPage}</p>
<p>endPage : ${endPage}</p>
--%>

<c:set var="paramListSeparator" value="${fn:contains(url,'?') ? '&' : '?'}"/>
<c:if test="${page.totalPages != 1}">

    <div class="pagination">
        <c:if test="${block != 0}">
            <a href="${url}${paramListSeparator}b=${block-1}&p=${(block - 1) * size + 1}">&lt;&lt;</a>
        </c:if>

        <c:forEach  begin="${startPage}" end="${endPage}" var="pageNumber">
            <c:choose>
                <c:when test="${page.number != pageNumber - 1}">
                    <a href="${url}${paramListSeparator}p=${pageNumber}&b=${block}"><c:out value="${pageNumber}"/></a>

                </c:when>
                <c:otherwise>
                    <strong> <c:out value="${pageNumber}"/></strong>
                </c:otherwise>
            </c:choose>
            <c:if test="${pageNumber != endPage}">
                |
            </c:if>
        </c:forEach>
        <c:if test="${endPage != page.totalPages}">
            <a href="${url}${paramListSeparator}b=${block+1}&p=${(block + 1) * size + 1}">&gt;&gt;</a>
        </c:if>
    </div>

</c:if>