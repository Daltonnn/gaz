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

    <div class="row margin-nav mb-5">
        <div class="col-sm">
            <form method="post" action="AddReading" >
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputName">Wartosc</label>
                        <input type="text" name="wartosc" class="form-control"   placeholder="m<sub>3</sub>" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputEmail4">Data od</label>
                        <input type="text" name="data_od" class="form-control"  placeholder="RRRR-MM-DD" pattern="[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]" required>
                    </div>                
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputSurname">Data od</label>
                        <input type="text" name="data_do" class="form-control" placeholder="RRRR-MM-DD" pattern="[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]" required>
                    </div>
                </div>  
                <select name="UserId" id="inputState" class="form-control">                                
                    <option value="null" selected>Wybierz</option>
                    <% for (UzytkownikModel userr : user.getCustomer()) {
                    %>
                    <option value="<%out.print(userr.getIdUzytkownik()); %>"><%out.print(userr.getImie() + " " + userr.getNazwisko()); %></option>
                    <%
                                    } %>
                </select>

                <button type="submit" class="btn btn-primary">Dodaj</button>
            </form>
        </div>
    </div>
</jsp:useBean>
<%@include file="footer.jsp" %>
<%}%>