<%-- 
    Document   : showusers
    Created on : 2018-01-11, 19:27:43
    Author     : Sebastian
--%>

<%@page import="org.apache.catalina.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.UzytkownikModel"%>
<%@page import="javax.servlet.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if ((session.getAttribute("IdUzytkownik") == null) || (session.getAttribute("IdUzytkownik") == "0")) {
        response.sendRedirect("index.jsp");
    } else {
%>
<%@include file="head.jsp" %>

<div class="row margin-nav mb-5">
    <div class="col-sm">
        <jsp:useBean id="user" class="Kontroler.Logowania" scope="request">
            <div class="table-responsive-sm">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Imie</th>
                            <th scope="col">Nazwisko</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            int i = 1;
                            for (UzytkownikModel userr : user.getUsers()) {
                        %>                      
                        <tr>
                            <th scope="row"><%out.print(i); %></th>
                            <td><%out.print(userr.getImie()); %></td>
                            <td><%out.print(userr.getNazwisko()); %></td>                            
                            <td>
                                <form method="post" action="ShowEdit" >
                                    <input class="d-none" value="<% out.print(userr.getIdUzytkownik()); %>" name="userID"/>
                                    <button type="submit" class="btn btn-primary">Edytuj</button>                                
                                </form>
                            </td>
                        </tr>
                        <%
                                i++;
                            }%>
                    </tbody>
                </table>
            </div>
        </jsp:useBean>
    </div>
</div>

<%@include file="footer.jsp" %>
<%}%>