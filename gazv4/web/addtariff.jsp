<%-- 
    Document   : addtariff
    Created on : 2018-01-30, 17:33:13
    Author     : Sebastian
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if ((session.getAttribute("IdUzytkownik") == null) || (session.getAttribute("IdUzytkownik") == "0")) {
        response.sendRedirect("index.jsp");
    } else {
%>
<%@include file="head.jsp" %>
<div class="row margin-nav mb-5">
    <div class="col-sm">
        <form method="post" action="addtariff" >
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputName">Nazwa</label>
                    <input type="text" name="nazwa" class="form-control"   placeholder="Taryfa A" required>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputEmail4">Opłata stała</label>
                    <input type="text" name="cena_sta" class="form-control"  placeholder="200.00" pattern="[0-9][0-9][0-9].[0-9][0-9]" required>
                </div>                
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputSurname">Cena za m<SUP>3</SUP></label>
                    <input type="text" name="cena_jed" class="form-control" placeholder="3.20" pattern="[0-9][0-9][0-9].[0-9][0-9]" required>
                </div>
            </div>            
            <button type="submit" class="btn btn-primary">Dodaj</button>
        </form>
    </div>
</div>

<%@include file="footer.jsp" %>
<%}%>