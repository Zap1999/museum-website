<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div class ="row">

    <div class="col-md-3">
        Filter by
    </div>
    <div class="col-md-3">
        Author:
        <select id="authorId" name="authorId">
            <option value="">AllAuthors</option>
            <c:forEach items="${authors}" var="author">
                <option value="<c:out value="${author.id}"/>">
                    <c:out value="${author.firstname}"/> <c:out value="${author.lastname}"/>
                </option>
            </c:forEach>
        </select>

    </div>
    <div>
        <button id="filter-button" > Do filter</button>
    </div>
</div>
