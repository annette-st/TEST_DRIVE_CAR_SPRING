<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Test Drive Club</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,900|Raleway:400,300,700,900" rel="stylesheet">

    <!-- Bootstrap CSS File -->
    <link href="../../../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Libraries CSS Files -->
    <link href="../../../lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">

    <link href="../../../css/style.css" rel="stylesheet">


</head>

<body>

<!-- NAVBAR -->
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">TEST-DRIVE CLUB</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="index">HOME</a></li>
                <li><a href="cars-info">CARS INFO</a></li>
                <li><a href="shop">YOUR CART</a></li>
                <li><a href="signUp">SIGN UP</a></li>
            </ul>
        </div>
    </div>
</div>
<!-- navbar -->

<!-- HEADER -->
<div id="headerwrap">
    <div class="container">
        <div class="row centered">
            <div class="col-lg-8 col-lg-offset-2">
                <h1>Test-Drive your dream car</h1>
            </div>
        </div>
    </div>
</div>
<!-- header -->

<!-- CONTAINER WITH INFO -->
<div class="container w">
    <div class="row centered">
        <br><br>
        <div class="col-lg-4">
            <i class="fa fa-heart"></i>
            <h4>CUSTOMER CHOISE</h4>
            <p>Our service is most common among
                customers who want to buy an
                expensive car that is worthy of them.
                Become one of them and enjoy driving!
            </p>

        </div>

        <div class="col-lg-4">
            <i class="fa fa-laptop"></i>
            <h4>COMFORTABLE USAGE</h4>
            <p>We provide all the necessary conditions
                for a comfortable test drive of the car
                you like. In a short time you will be
                able to understand your choice.</p>
        </div>

        <div class="col-lg-4">
            <i class="fa fa-trophy"></i>
            <h4>SUPPORT</h4>
            <p>We are always ready to help you with
                the choice of a car suitable for you,
                as well as to answer all your questions.
                You can always contact us for help.</p>
        </div>
    </div>
    <br>
    <br>
</div>
<!-- container with info -->


<div id="lg">
    <div class="container">
        <div class="row centered">
            <h4>OUR AWESOME CLIENTS</h4>
            <div id="feedback" class="card text-center" *ngFor="let event of eventActivities">
                <#list feeds as feed>
                    <div id="feed_one" class="card-block">
                        <h4 class="card-title">${feed.first_name}</h4>
                        <p class="card-text text-center">${feed.content}</p>
                    </div>
                </#list>
            </div>
        </div>
    </div>
</div>


<div id="r">
    <div class="container">
        <div class="row centered">
            <div class="col-lg-8 col-lg-offset-2">
                <h4>SOMETIMES THE RIGHT PATH IS NOT THE EASTEST ONE. JUST CHOOSE YOUR CAR!</h4>
                <p>The cars we drive say a lot about us!</p>
            </div>
        </div>
    </div>
</div>

<!-- FOOTER -->
<div id="f">
    <div class="container">
        <div class="row centered">
            <p>Subscribe to the developer!</p>
            <a href="https://vk.com/annchouss_s"><i class="fa fa-vk"></i></a><a href="https://www.instagram.com/anyana_t/"><i class="fa fa-instagram"></i></a><a href="#"></a>
        </div>
    </div>
</div>
<!-- Footer -->

<!-- COPYRIGHTS -->
<div id="copyrights">
    <div class="container">
        <p>
            Created by <strong>Anna Tugbaeva</strong>. Contact me!
        </p>
        <div class="credits">
            <strong>+7(917)897-35-32</strong>
        </div>
    </div>
</div>
<!-- copyrights -->

</body>
</html>
