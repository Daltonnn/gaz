<%-- 
    Document   : sign_in
    Created on : 2018-01-07, 22:46:45
    Author     : Sebastian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="head.jsp" %>
<div class="row margin-nav mb-5">
    <div class="col-sm">
        <form method="post" action="SignIn" >
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputName">Imie</label>
                    <input type="text" name="imie" class="form-control" id="inputName"  placeholder="Adam" required>
                </div>
                <div class="form-group col-md-6">
                    <label for="inputSurname">Nazwisko</label>
                    <input type="text" name="nazwisko" class="form-control" id="inputSurname" placeholder="Nowak" required>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputEmail4">Email</label>
                    <input type="email" name="email" class="form-control" id="inputEmail" placeholder="Email" required>
                </div>
                <div class="form-group col-md-6">
                    <label for="inputPassword4">Hasło</label>
                    <input type="password"name="haslo" class="form-control" id="inputPassword" placeholder="Hasło" required>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputStreet">Ulica</label>
                    <input type="text" name="ulica" class="form-control" id="inputStreet" placeholder="Wiejska" required>
                </div>
                <div class="form-group col-md-6">
                    <label for="inputNumber">Numer</label>
                    <input type="text" name="nrBud" class="form-control" id="inputNumber" placeholder="10/12" required>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputCity">Miasto</label>
                    <input type="text" name="miasto" class="form-control" id="inputCity" placeholder="Warszawa" required>
                </div>
                <!--<div class="form-group col-md-4">
                    <label for="inputState">Województwo</label>
                    <select id="inputState" class="form-control">
                        <option selected>Wybierz</option>
                        <option value="Dolnośląskie">Dolnośląskie</option>
                        <option value="Kujawsko-Pomorskie">Kujawsko-Pomorskie</option>
                        <option value="Lubelskie">Lubelskie</option>
                        <option value="Lubuskie">Lubuskie</option>
                        <option value="Łódzkie">Łódzkie</option>
                        <option value="Małopolskie">Małopolskie</option>
                        <option value="Mazowieckie"> Mazowieckie</option>
                        <option value="Opolskie">Opolskie</option>
                        <option value="Podkarpackie">Podkarpackie</option>
                        <option value="Podlaskie">Podlaskie</option>
                        <option value="Pomorskie">Pomorskie</option>
                        <option value="Śląskie">Śląskie</option>
                        <option value="Świętokrzyskie">Świętokrzyskie</option>
                    </select>
                </div>-->
                <div class="form-group col-md-2">
                    <label for="inputZip">Kod pocztowy</label>
                    <input type="text"name="kodPoczt" class="form-control" id="inputZip" placeholder="00-000" pattern="[0-9][0-9]-[0-9][0-9][0-9]" required>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Zarejestruj</button>
        </form>
    </div>
</div>
<%@include file="footer.jsp" %>
