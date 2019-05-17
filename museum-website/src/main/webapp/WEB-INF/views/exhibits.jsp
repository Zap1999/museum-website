
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Exhibits</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div id="header-div">
        <nav class="navbar navbar-expand-sm bg-info navbar-light">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="/exhibits">Exhibits</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/excursions">Excursions</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/employees">Employees</a>
                </li>
            </ul>
        </nav>
    </div>
    <div id="main-div" class ="row">
        
        <c:forEach items="${exhibits}" var="exhibit">
        <div class = "col-md-4">
            <div class="card">
                <img class="card-img-top"  src="${pageContext.request.contextPath}/static/img/default-image.jpg" alt="Card image">
                <div class="card-body">
                    <h4 class="card-title"><c:out value="${exhibit.name}"/></h4>
                    <p class="card-text">Material</p>
                    <p class="card-text">Technique</p>
                    <p class="card-text">Hall</p>
                </div>

            </div>
        </div>
        </c:forEach>


    </div>

    <div id ="footer">

    </div>

</body>
</html>