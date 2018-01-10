<%-- 
    Document   : login
    Created on : 2018-01-10, 20:53:30
    Author     : Sebastian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <%
            if ( (session.getAttribute("IdUzytkownik") == null) || (session.getAttribute("IdUzytkownik") == "0")) {
                response.sendRedirect("index.jsp");
               
            }else{
        %>
<%@include file="head.jsp" %>
<%@include file="footer.jsp" %>
<%}%>
