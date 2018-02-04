<%
    if ((session.getAttribute("IdUzytkownik") == null) || (session.getAttribute("IdUzytkownik") == "0")) {
        response.sendRedirect("index.jsp");
    } else {
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="head.jsp" %>
<jsp:useBean id="typ" class="Kontroler.ShowEditTyp" scope="request">
    <%String typId = (String) session.getAttribute("typID");%>
    <div class="row margin-nav mb-5 ">
        <div class="col">
            <h3>Edytuj typ</h3>
        </div>
    </div>
    <div class="row mb-5">
        <div class="col-sm">
            <form method="post" action="EditTyp" >
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputName">Nazwa</label>
                        <input type="text" name="nazwa" value="<% out.print(typ.getTyp(typId).getNazwa());  %>" class="form-control" required>
                        <input type="text" name="typID" value="<% out.print(typId);  %>" class="d-none" required>
                    </div>
                </div>           
                <button type="submit" class="btn btn-primary float-right">Edytuj</button>
            </form>
        </div>
    </div>

</jsp:useBean>
<%@include file="footer.jsp" %>
<%}%>