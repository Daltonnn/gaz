<%@page import="Model.TaryfaModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if ((session.getAttribute("IdUzytkownik") == null) || (session.getAttribute("IdUzytkownik") == "0")) {
        response.sendRedirect("index.jsp");
    } else {
%>
<%@include file="head.jsp" %>

<div class="row margin-nav mb-5 ">
        <div class="col">
            <h3>Taryfa</h3>
        </div>
    </div>
<div class="row mb-5">
    <div class="col-sm">
        <a href="addtariff.jsp" class="btn btn-primary">Dodaj</a>
    </div>
</div>
<div class="row ">
    <div class="col-sm">
        <jsp:useBean id="taryfa" class="Kontroler.AddTariff" scope="request">
            <div class="table-responsive-sm">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Nazwa</th>                            
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            int i = 1;
                            for (TaryfaModel teryfy : taryfa.getTaryfa()) {
                        %>
                        <tr>
                            <th scope="row"><%out.print(i); %></th>
                            <td><%out.print(teryfy.getNazwa()); %></td>                                                       
                            <td>
                                <form method="post" action="ShowEditTariff" >
                                    <input class="d-none" value="<% out.print(teryfy.getIdTaryfa()); %>" name="tariffID"/>
                                    <button type="submit" class="btn btn-primary float-right">Wyświetl</button>                                
                                </form>
                            </td>
                        </tr>
                        <%      i++;
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </jsp:useBean>
    </div>
</div>

<%@include file="footer.jsp" %>
<%}%>
