<%@page import="Model.UzytkownikModel"%>
<%
    if ((session.getAttribute("IdUzytkownik") == null) || (session.getAttribute("IdUzytkownik") == "0")) {
        response.sendRedirect("index.jsp");
    } else {
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="head.jsp" %>
<jsp:useBean id="odczyt" class="Kontroler.ShowEditReading" scope="request">
    <%String idOdczyt = session.getAttribute("odczytIDd").toString();       
    %>
    <div class="row margin-nav mb-5 ">
        <div class="col">
            <h3>Edytuj odczyt</h3>
        </div>
    </div>
    <div class="row mb-5">
        <div class="col-sm">
            <form method="post" action="EditReading" >
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputName">Wartosc</label>                             
                        <input type="text" name="wartosc" class="form-control"   value="<% out.print(odczyt.getReading(idOdczyt).getWartosc().toString()); %>" pattern="\d+(\.\d{2})?"  required>
                        <input type="text" name="odczytIDd" value="<% out.print(odczyt.getReading(idOdczyt).getIdOdczyt());  %>" class="d-none" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col">
                        <label for="inputEmail4">Data od</label>
                        <input type="text" name="data_od" class="form-control" value="<% out.print((odczyt.getReading(idOdczyt).getDataOd().getYear()+1900)+"-"+(odczyt.getReading(idOdczyt).getDataOd().getMonth()+1)+"-"+odczyt.getReading(idOdczyt).getDataOd().getDate()); %>"  placeholder="RRRR-MM-DD" pattern="[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]" required>
                    </div>               

                    <div class="form-group col">
                        <label for="inputSurname">Data od</label>
                        <input type="text" name="data_do" class="form-control" value="<% out.print((odczyt.getReading(idOdczyt).getDataDo().getYear()+1900)+"-"+(odczyt.getReading(idOdczyt).getDataDo().getMonth()+1)+"-"+odczyt.getReading(idOdczyt).getDataDo().getDate()); %>" placeholder="RRRR-MM-DD" pattern="[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]" required>
                    </div>
                </div> 
               
                <div class="row">
                    <div class="col">
                        <button type="submit" class="btn btn-primary mt-4 float-right">Edytuj</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    
    </jsp:useBean>

<%@include file="footer.jsp" %>
<%}%>
