<%
    if ((session.getAttribute("IdUzytkownik") == null) || (session.getAttribute("IdUzytkownik") == "0")) {
        response.sendRedirect("index.jsp");
    } else {
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="head.jsp" %>
<jsp:useBean id="typ" class="Kontroler.ShowEditTyp" scope="request">
    <%String typId = session.getAttribute("typID").toString(); %>
    <div class="row margin-nav mb-5 ">
        <div class="col">
            <h3>Typ</h3>
        </div>
    </div>
    <div class="row ">
        <div class="col">
            <p>Nazwa: <% out.print(typ.getTyp(typId).getNazwa()); %></p>
        </div>
    </div>
    <div class="row">
        <div class="col-sm">
            <a href="edittyp.jsp" class="btn btn-primary float-right">Edytuj</a>
        </div>
    </div>
</jsp:useBean>

<%@include file="footer.jsp" %>
<%}%>

