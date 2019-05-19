<html>
<head>
    <title>Excursions</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/styles/stylesheet.css">

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
            <li class="nav-item">
                <a class="nav-link" href="/exhibits">Exhibits</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/excursions">Excursions</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/employees">Employees</a>
            </li>
        </ul>
    </nav>
</div>
<div id="main-div" >
    <div id="excursions-container" class ="row">
        <div class="col-md-1"></div>
        <div class = "col-md-10 row excursion-info">
            <div class="col-md-4">
                <h3>Excursion name</h3>
            </div>
            <div class="col-md-8">
                <p>Excursion start</p>
                <p>Excursion duration</p>
                <p>Guide</p>
            </div>
        </div>
        <div class="col-md-1"></div>

        <div class="col-md-1"></div>
        <div class = "col-md-10 row excursion-info">
            <div class="col-md-4">
                <h3>Excursion name</h3>
            </div>
            <div class="col-md-8">
                <p>Excursion start</p>
                <p>Excursion duration</p>
                <p>Guide</p>
            </div>
        </div>
        <div class="col-md-1"></div>



    </div>

</div>

<div id ="footer">

</div>

</body>
</html>