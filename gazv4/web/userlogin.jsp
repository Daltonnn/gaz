<%@page import="Model.LaczModel"%>
<%
    if ((session.getAttribute("IdUzytkownik") == null) || (session.getAttribute("IdUzytkownik") == "0")) {
        response.sendRedirect("index.jsp");
    } else {
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="head.jsp" %>
<% String idString = session.getAttribute("IdUzytkownik").toString(); %>
<jsp:useBean id="user" class="Kontroler.ShowEditUser" scope="request">
    
    <div class="row margin-nav mb-5">
        <div class="col-sm">
            <h3>Witaj <%out.print(user.getUser(idString).getImie() + " " + user.getUser(idString).getNazwisko());%> !</h3>
        </div>
        
        <div class="col-sm">
            <h3>Taryfa: <% if (user.getUser(idString).getTaryfa() != null) {
                            out.print(user.getUser(idString).getTaryfa().getNazwa());
                        } else {
                            out.print("Brak");
                        }%></h3>
        </div>
        <div class="col-md">
            <form method="post" action="ShowEdit" class="float-right" >
                                    <input class="d-none" value="<% out.print(session.getAttribute("IdUzytkownik").toString()); %>" name="userID"/>
                                    <button type="submit" class="btn btn-primary">Profil</button>                                
                                </form>
        </div>
    </div>   
        
        
    <% if (!user.getUser(idString).getLaczModelCollection().isEmpty() && user.getUser(idString).getTaryfa() != null) {%>
    <div class="row mb-5">
        <div class="col-sm">
            <script>
                window.onload = function () {

                    var chart = new CanvasJS.Chart("chartContainer", {
                        animationEnabled: true,
                        theme: "light2",
                        title: {
                            text: ""
                        },
                        axisY: {
                            includeZero: false
                        },
                        data: [{
                                type: "line",
                                dataPoints: [
                <% for (LaczModel odczyt : user.getUser(idString).getLaczModelCollection()) { 
                 double cos = odczyt.getIdOdczyt().getWartosc().multiply(user.getUser(idString).getTaryfa().getCenaJed()).add(user.getUser(idString).getTaryfa().getCenaLicz()).doubleValue(); %>
                                    {label: "<%out.print(odczyt.getIdOdczyt().getDataDo().getDay()+"-"+odczyt.getIdOdczyt().getDataDo().getMonth()+1);%>",y: <% out.print(String.format("%.0f", cos)); %>},
                <% } %>
                                ]
                            }]
                    });
                    chart.render();

                }
            </script>
            <div id="chartContainer" style="height: 370px; width: 100%;"></div>
            <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
        </div>
    </div>
    <div class="row mt-4">
        <div class="col-sm">
            <div class="table-responsive-sm">
                <h3>Twój pobór gazu</h3>
                <table class="table">
                    
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Data od</th>
                            <th scope="col">Data do</th>
                            <th scope="col">Ilosc</th>
                            <th scope="col">Wartosc</th>                            
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
