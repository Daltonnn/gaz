<%-- 
    Document   : index
    Created on : 2018-01-07, 22:27:16
    Author     : Sebastian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="head.jsp" %>
<div class="row margin-nav">
    <div class="col-sm">               
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active slider-h">
                    <img class="d-block w-100" src="./img/WP_000015.jpg" alt="First slide">
                </div>
                <div class="carousel-item slider-h">
                    <img class="d-block w-100" src="./img/WP_000016.jpg" alt="Second slide">
                </div>
                <div class="carousel-item slider-h">
                    <img class="d-block w-100" src="./img/WP_000018.jpg" alt="Third slide">
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
</div>

<div class="row mt-4">
    <div class="col-sm">
        <div class="seg-darkRed">

        </div>
    </div>
    <div class="col-sm ">
        <div class="seg-MediumVioletRed">

        </div>
    </div>
    <div class="col-sm">
        <div class="seg-Orange">

        </div>
    </div>
</div>

<div class="row mt-4">
    <div class="col-sm-4">
        <div class="seg-MediumVioletRed">

        </div>
    </div>
    <div class="col-sm-8">
        <div class="seg-darkRed">

        </div>
    </div>
</div>

<div class="row mt-4 mb-4">
    <div class="col-sm-8">
        <div class="seg-darkRed">

        </div>
    </div>
    <div class="col-sm-4">
        <div class="seg-MediumVioletRed">

        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
