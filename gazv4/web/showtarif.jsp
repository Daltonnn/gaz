<%@page import="Model.UzytkownikModel"%>
<%@page import="Model.TaryfaModel"%>
<%
    if ((session.getAttribute("IdUzytkownik") == null) || (session.getAttribute("IdUzytkownik") == "0")) {
        response.sendRedirect("index.jsp");
    } else {
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="head.jsp" %>
<jsp:useBean id="taryfa" class="Kontroler.ShowEditTariff" scope="request">
    <%String cos = (String) session.getAttribute("tariffID"); %>

    <div class="row margin-nav ">
        <div class="col-sm">
            <p>Nazwa taryfy: <% out.print(taryfa.getTariff(cos).getNazwa());  %>   </p>     
        </div>
    </div>    
    <div class="row">
        <div class="col-sm">
            <p>Opłata stała: <% out.print(taryfa.getTariff(cos).getCenaLicz());  %> </p>
        </div>
    </div>   
    <div class="row">
        <div class="col-sm">
            <p> Cena za m<sup>3</sup>: <% out.print(taryfa.getTariff(cos).getCenaJed());%>   </p>    
        </div>
    </div>   
    <div class="row">
        <div class="col-sm">
            <a href="edittariff.jsp" class="btn btn-primary float-right">Edytuj</a>
        </div>
    </div>

    <% if (!taryfa.getTariff(cos).getUzytkownikModelCollection().isEmpty()) {%>
    <div class="row mt-4">
        <div class="col">
            <div class="table-responsive-sm">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Imie</th>
                            <th scope="col">Nazwisko</th>                           
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            int i = 1;
                            for (UzytkownikModel user : taryfa.getTariff(cos).getUzytkownikModelCollection()) { %>
                        <tr>
                            <th scope="row"><%out.print(i); %></th>
                            <td><%out.print(user.getImie()); %></td>
                            <td><%out.print(user.getNazwisko()); %></td> 
                        </tr>
                        <% i++;
                            }%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <% } %>
</jsp:useBean>

<%@include file="footer.jsp" %>
<%}%>


