
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
                    <a class="nav-link" href="#">Exhibits</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/excurtions">Excursions</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/guides">Guides</a>
                </li>
            </ul>
        </nav>
    </div>
    <div id="main-div" class ="row">
        <div class = "col-md-4" >
            <div class="card">
                <img class="card-img-top"  src="${pageContext.request.contextPath}/img/default-image.jpg" alt="Card image">
                <div class="card-body">
                    <h4 class="card-title">John Doe</h4>
                    <p class="card-text">Some example text.</p>
                </div>

            </div>
        </div>


        <div class = "col-md-4">
            <div class="card">
                <img class="card-img-top"  src="${pageContext.request.contextPath}/img/default-image.jpg" alt="Card image">
                <div class="card-body">
                    <h4 class="card-title">John Doe</h4>
                    <p class="card-text">Some example text.</p>
                </div>

            </div>
        </div>

        <div class = "col-md-4">
            <div class="card">
                <img class="card-img-top"  src="${pageContext.request.contextPath}/img/default-image.jpg" alt="Card image">
                <div class="card-body">
                    <h4 class="card-title">John Doe</h4>
                    <p class="card-text">Some example text.</p>
                </div>

            </div>
        </div>

    </div>

    <div id ="footer">

    </div>

</body>
</html>