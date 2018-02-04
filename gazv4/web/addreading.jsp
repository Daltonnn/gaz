<%@page import="Model.UzytkownikModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if ((session.getAttribute("IdUzytkownik") == null) || (session.getAttribute("IdUzytkownik") == "0")) {
        response.sendRedirect("index.jsp");
    } else {
%>
<%@include file="head.jsp" %>
<jsp:useBean id="user" class="Kontroler.Logowania" scope="request">
    <%String cos = (String) session.getAttribute("userID"); %>
    <div class="row margin-nav mb-5 ">
        <div class="col">
            <h3>Dodaj odczyt</h3>
        </div>
    </div>

    <div class="row mb-5">
        <div class="col-sm">
            <form method="post" action="AddReading" >
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputName">Wartosc</label>
                        <input type="text" name="wartosc" class="form-control"   placeholder="0.00 m&sup3;" pattern="\d+(\.\d{2})?" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col">
                        <label for="inputEmail4">Data od</label>
                        <input type="text" name="data_od" class="form-control"  placeholder="RRRR-MM-DD" pattern="[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]" required>
                    </div>               

                    <div class="form-group col">
                        <label for="inputSurname">Data od</label>
                        <input type="text" name="data_do" class="form-control" placeholder="RRRR-MM-DD" pattern="[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]" required>
                    </div>
                </div>  
                <div class="row">
                    <div class="col">
                        <select name="UserId" id="inputState" class="form-control">                                
                            <option value="null" selected>Wybierz</option>
                            <% for (UzytkownikModel userr : user.getCustomer()) {
                            %>
                            <option value="<%out.print(userr.getIdUzytkownik()); %>"><%out.print(userr.getImie() + " " + userr.getNazwisko()); %></option>
                            <%
                                } %>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <button type="submit" class="btn btn-primary mt-4 float-right">Dodaj</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</jsp:useBean>
<%@include file="footer.jsp" %>
<%}%>