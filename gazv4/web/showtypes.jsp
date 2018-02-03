<%@page import="Model.TypModel"%>
<%
    if ((session.getAttribute("IdUzytkownik") == null) || (session.getAttribute("IdUzytkownik") == "0")) {
        response.sendRedirect("index.jsp");
    } else {
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="head.jsp" %>
<div class="row margin-nav mb-5">
    <div class="col-sm">
        <a href="addtyp.jsp" class="btn btn-primary">Dodaj</a>
    </div>
</div>
<div class="row ">
    <div class="col-sm">
        <jsp:useBean id="typ" class="Kontroler.AddTyp" scope="request">
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
                            for (TypModel types : typ.getTypes()) {
                        %>
                        <tr>
                            <th scope="row"><%out.print(i); %></th>
                            <td><%out.print(types.getNazwa()); %></td>                                                       
                            <td>
                                <form method="post" action="ShowEditTyp" >
                                    <input class="d-none" value="<% out.print(types.getIdTyp()); %>" name="tariffID"/>
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