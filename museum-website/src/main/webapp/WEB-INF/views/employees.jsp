<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<script src="${pageContext.request.contextPath}/scripts/employees.js"></script>

    <div id="excursions-container" class ="row">
        <c:forEach items="${employees}" var="employee">
            <div class="col-md-1"></div>
            <div class = "col-md-10 row excursion-info">
                <div class="col-md-3">
                    <img class="img-fluid rounded" src="${pageContext.request.contextPath}/static/img/<c:out value="${employee.image}"/>" >
                </div>
                <div class="col-md-8">
                    <h3><c:out value="${employee.firstname}"/>
                        <c:out value="${employee.lastname}"/></h3>
                    <p><c:out value="${employee.position}"/></p>

                </div>
            </div>
            <div class="col-md-1"></div>
        </c:forEach>
    </div>

