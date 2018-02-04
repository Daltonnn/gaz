<%
    if ((session.getAttribute("IdUzytkownik") == null) || (session.getAttribute("IdUzytkownik") == "0")) {
        response.sendRedirect("index.jsp");
    } else {
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="head.jsp" %>
<div class="row margin-nav mb-5">
    <div class="col">
        <h3>Dodaj typ</h3>
    </div>
</div>
<div class="row">
    <div class="col-sm">
        <form method="post" action="AddTyp" >
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputName">Nazwa</label>
                    <input type="text" name="nazwa" class="form-control"  placeholder="Pracownik" required>                       
                </div>
            </div>           
            <button type="submit" class="btn btn-primary float-right">Dodaj</button>
        </form>
    </div>
</div>
<%@include file="footer.jsp" %>
<%}%>