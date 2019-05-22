<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div id="main-div" >
    <div id="excursions-container" class ="row">

        <c:forEach items="${excursions}" var="excursion">
            <div class="col-md-1"></div>
            <div class = "col-md-10 row excursion-info">
                <div class="col-md-4">
                    <h3>Excursion name</h3>
                </div>
                <div class="col-md-8">
                    <p>Excursion start: <c:out value="${excursion.start}"/></p>
                    <p>Excursion duration: <c:out value="${excursion.duration}"/> min</p>
                    <p>Guide: <c:out value="${excursion.employee.firstname}"/>
                        <c:out value="${excursion.employee.lastname}"/>
                    </p>
                </div>
            </div>
            <div class="col-md-1"></div>
        </c:forEach>

    </div>

</div>
