<%
    if ((session.getAttribute("IdUzytkownik") == null) || (session.getAttribute("IdUzytkownik") == "0")) {
        response.sendRedirect("index.jsp");
    } else {
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="head.jsp" %>
<jsp:useBean id="taryfa" class="Kontroler.ShowEditTariff" scope="request">
    <%String cos = (String) session.getAttribute("tariffID"); %>
    
    <div class="row margin-nav mb-5">
    <div class="col-sm">
        <form method="post" action="EditTariff" >
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputName">Nazwa</label>
                    <input type="text" name="nazwa" value="<% out.print(taryfa.getTariff(cos).getNazwa());  %>" class="form-control" required>
                     <input type="text" name="tariffID" value="<% out.print(taryfa.getTariff(cos).getIdTaryfa());  %>" class="d-none" required>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputEmail4">Opłata stała</label>
                    <input type="text" name="cena_sta" value="<% out.print(taryfa.getTariff(cos).getCenaLicz());  %>" class="form-control"   pattern="[0-9][0-9][0-9].[0-9][0-9]" required>
                </div>                
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputSurname">Cena za m<SUP>3</SUP></label>
                    <input type="text" name="cena_jed" value="<% out.print(taryfa.getTariff(cos).getCenaJed());  %>" class="form-control" pattern="[0-9][0-9][0-9].[0-9][0-9]" required>
                </div>
            </div>            
            <button type="submit" class="btn btn-primary float-right">Edytuj</button>
        </form>
    </div>
</div>    
    </jsp:useBean>

<%@include file="footer.jsp" %>
<%}%>