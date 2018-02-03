<%
    if ((session.getAttribute("IdUzytkownik") == null) || (session.getAttribute("IdUzytkownik") == "0")) {
        response.sendRedirect("index.jsp");
    } else {
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="head.jsp" %>

<%@include file="footer.jsp" %>
<%}%>
