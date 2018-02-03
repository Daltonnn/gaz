<%-- 
    Document   : head
    Created on : 2018-01-07, 22:22:13
    Author     : Sebastian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pl">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title></title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
        crossorigin="PWSZ">
    <link rel="stylesheet" type="text/css" href=".\css\style.css">
</head>

<body>

    <nav class="navbar navbar-expand-lg fixed-top navbar-light bg-orange">
        <div class="container">
            <a class="navbar-brand text-white logo" href="index.jsp"></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav mr-auto">                    
                    <li class="nav-item">
                        <a class="nav-link text-white" href="ofertadom.jsp">Oferta dla domu</a>
                    </li>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="ofertafirma.jsp">Oferta dla firmy</a>
                    </li>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="onas.jsp">O nas</a>
                    </li>
                </ul> 
                <% if((session.getAttribute("IdUzytkownik") == null) || (session.getAttribute("IdUzytkownik") == "0")){ %>
                <button type="button" class="btn btn-primary " data-toggle="modal" data-target=".bd-example-modal-sm">Zaloguj</button>
                <% }else{%>
                <a href="login.jsp" class="btn btn-primary mr-2">Profil</a>
                <form action="LogOut" method="post">
                <button type="submit" formaction="LogOut" class="btn btn-primary"  data-target=".bd-example-modal-sm">Wyloguj</button>
                </form>
                <%}%>

            </div>
        </div>
    </nav>


    <div class="container sideh">
        <div class="modal fade bd-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <form action="Logowania" method="post" class="form-signin">
                        <h2 class="form-signin-heading">Logowanie</h2>                       
                        <input id="inputEmail" name="inputEmail" class="form-control" placeholder="Email" required="" autofocus="" type="email" required>                       
                        <input id="inputPassword" name="inputPassword" class="form-control" placeholder="Password" required="" type="password" required>
                        <div class="checkbox">
                            <label>
                                <input value="remember-me" type="checkbox"> Pamietaj hasło
                            </label>
                        </div>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Zaloguj</button>
                        <a class="text-white text-center" href="sign_in.jsp">Zarejestruj się</a>
                    </form>
                </div>
            </div>
        </div>
