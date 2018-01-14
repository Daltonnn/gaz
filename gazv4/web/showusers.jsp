<%-- 
    Document   : showusers
    Created on : 2018-01-11, 19:27:43
    Author     : Sebastian
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.UzytkownikModel"%>
<%@page import="javax.servlet.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    if ((session.getAttribute("IdUzytkownik") == null) || (session.getAttribute("IdUzytkownik") == "0")) {
        response.sendRedirect("index.jsp");

    } else {

%>



<%@include file="head.jsp" %>
<div class="row margin-nav mb-5">
    <div class="col-sm">
        <jsp:useBean id="user" class="Kontroler.Logowania" scope="session">

            
            <%
                List<UzytkownikModel> cos = (List) user.getUsers();
                for (UzytkownikModel userModel : cos) {
                    out.print("<p>Uzytkownik " + userModel.getImie() + " " + userModel.getNazwisko() + "</p>");
                }
            %>
        </jsp:useBean>
    </div>
</div>

<%@include file="footer.jsp" %>
<%}%>