<%@page import="java.math.BigDecimal"%>
<%@page import="Model.LaczModel"%>
<%@page import="Model.OdczytModel"%>
<%@page import="Model.TaryfaModel"%>
<%
    if ((session.getAttribute("IdUzytkownik") == null) || (session.getAttribute("IdUzytkownik") == "0")) {
        response.sendRedirect("index.jsp");
    } else {
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="head.jsp" %>
<% String idString = session.getAttribute("userID").toString(); %>
<jsp:useBean id="user" class="Kontroler.ShowEditUser" scope="request">
    <div class="row margin-nav mb-5">
        <div class="col-sm">
            <div class="row">
                <div class="col-sm">
                    <p>Imie: <% out.print(user.getUser(idString).getImie()); %></p>
                    <p></p>
                </div>
                <div class="col-sm">
                    <p>Nazwisko: <%  out.print(user.getUser(idString).getNazwisko()); %></p>
                    <p></p>
                </div>
                <div class="col-sm">
                    <p>Email: <% out.print(user.getUser(idString).getEmail()); %></p>
                    <p></p>
                </div>
            </div>   
            <div class="row">
                <div class="col-sm">
                    <p>Miasto: <% out.print(user.getUser(idString).getMiasto()); %></p>
                    <p></p>
                </div>
                <div class="col-sm">
                    <p>Ulica: <% out.print(user.getUser(idString).getUlica()); %></p>
                    <p></p>
                </div>
                <div class="col-sm">
                    <p>Numer: <% out.print(user.getUser(idString).getNrMiesz()); %></p>
                    <p></p>
                </div>
            </div>  
            <div class="row">
                <div class="col-sm">
                    <p>Kod pocztowy: <% out.print(user.getUser(idString).getKodPoczt()); %></p>
                    <p></p>

                </div>
                <div class="col-sm">
                    <p>Taryfa: <% if (user.getUser(idString).getTaryfa() != null) {
                            out.print(user.getUser(idString).getTaryfa().getNazwa());
                        } else {
                            out.print("Brak");
                        }%></p>
                    <p></p>
                </div>               
            </div> 
            <div class="row">
                <div class="col-sm">
                    <a href="edituser.jsp" class="btn btn-primary float-right">Edytuj</a>
                </div> 
            </div>


            <% if (!user.getUser(idString).getLaczModelCollection().isEmpty() && user.getUser(idString).getTaryfa() != null) {%>
            <div class="row mt-4">
                <div class="col">
                    <div class="table-responsive-sm">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Data od</th>
                                    <th scope="col">Data do</th>
                                    <th scope="col">Ilosc</th>
                                    <th scope="col">Wartosc</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    int i = 1;
                                    for (LaczModel odczyt : user.getUser(idString).getLaczModelCollection()) { %>
                                <tr>
                                    <th scope="row"><%out.print(i); %></th>
                                    <td><%out.print(odczyt.getIdOdczyt().getDataOd().getDate() + "-" + (odczyt.getIdOdczyt().getDataOd().getMonth() + 1) + "-" + (odczyt.getIdOdczyt().getDataOd().getYear() + 1900)); %></td>
                                    <td><%out.print(odczyt.getIdOdczyt().getDataDo().getDate() + "-" + (odczyt.getIdOdczyt().getDataDo().getMonth() + 1) + "-" + (odczyt.getIdOdczyt().getDataDo().getYear() + 1900)); %></td>                            
                                    <td><%out.print(odczyt.getIdOdczyt().getWartosc().toString()); %></td>
                                    <% double cos = odczyt.getIdOdczyt().getWartosc().multiply(user.getUser(idString).getTaryfa().getCenaJed()).add(user.getUser(idString).getTaryfa().getCenaLicz()).doubleValue(); %>
                                    <td><% out.print(String.format("%.2f", cos)); %></td>
                                    <td><form method="post" action="DeleteReading" class="float-right" >
                                            <input class="d-none" value="<% out.print(odczyt.getIdOdczyt().getIdOdczyt()); %>" name="odczytID"/>
                                            <input class="d-none" value="<% out.print(idString); %>" name="userID"/>
                                            <button type="submit" class="btn btn-primary float-right">Usuń</button>                                
                                        </form></td>
                                </tr>
                                <% i++;
                                }%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <% } %>

        </div>
    </div> 
</div>
</jsp:useBean>

<%@include file="footer.jsp" %>
<%}%>
