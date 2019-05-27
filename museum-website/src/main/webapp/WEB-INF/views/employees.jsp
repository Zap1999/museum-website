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
                    <c:if test = "${employee.position.toString().equalsIgnoreCase('GUIDE')}">
                        <label style="margin-left: 30px">From</label>
                        <input id="dateStartSelect-${employee.id}" type="datetime-local" name="dateSelect" style="margin-left: 20px"
                               min="2000-06-07T00:00" max="2060-06-14T00:00" required>
                        <label style="margin-left: 30px">To</label>
                        <input id="dateFinishSelect-${employee.id}" type="datetime-local" name="dateSelect" style="margin-left: 20px"
                               min="2000-06-07T00:00" max="2060-06-14T00:00" required>
                        <button id="workTimeSearchButton-${employee.id}" onclick="getWorkTime(this.id)">Get work time</button>
                        <br>
                        <label id="workTime-${employee.id}">Work time: ---</label>
                        <br>
                        <label>Excursions done: ---</label>
                    </c:if>
                </div>
            </div>
            <div class="col-md-1"></div>
        </c:forEach>
    </div>

