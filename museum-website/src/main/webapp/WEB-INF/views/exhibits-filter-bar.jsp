<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div class ="row">

    <div class="col-md-3">
        Filter by
        <select id="select-filter">
            <option value="author" selected> Author </option>
            <option value="hall"> Hall </option>
        </select>
    </div>
    <div class="col-md-3 author-filter filter-el" >
        Author:
        <select id="authorId" name="authorId">
            <option value="" selected="selected">AllAuthors</option>
            <c:forEach items="${authors}" var="author">
                <option value="<c:out value="${author.id}"/>">
                    <c:out value="${author.firstname}"/> <c:out value="${author.lastname}"/>
                </option>
            </c:forEach>
        </select>

    </div>
    <div class="col-md-3 author-filter filter-el">
        <button id="author-filter-button"> Do filter</button>
    </div>
    <div class="col-md-3 hall-filter filter-el">
        <select id="hallId" name="hallId" >
            <option value="" selected="selected">All Halls</option>
            <c:forEach items="${halls}" var="hall">
                <option value="<c:out value="${hall.id}"/>">
                    <c:out value="${hall.name}"/>
                </option>
            </c:forEach>
        </select>
    </div>
    <div class="col-md-3 hall-filter filter-el">
        <button id="hall-filter-button"> Do filter</button>
    </div>
</div>
