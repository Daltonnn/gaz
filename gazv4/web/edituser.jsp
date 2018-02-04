<%@page import="Model.TypModel"%>
<%@page import="Model.TaryfaModel"%>
<%
    if ((session.getAttribute("IdUzytkownik") == null) || (session.getAttribute("IdUzytkownik") == "0")) {
        response.sendRedirect("index.jsp");
    } else {
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="head.jsp" %>
<jsp:useBean id="user" class="Kontroler.ShowEditUser" scope="request">
    <% String cos = (String) session.getAttribute("userID");
        String idTyp = session.getAttribute("IdTyp").toString();
    %>
    <div class="row margin-nav mb-5 ">
        <div class="col">
            <h3>Edytuj użtkownika</h3>
        </div>
    </div>
    <div class="row mb-5">
        <div class="col-sm">
            <form method="post" action="EditUser" >

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputName">Imie</label>
                        <input type="text" name="imie" class="form-control" id="inputName" value="<% out.print(user.getUser(cos).getImie());  %>"  required>
                        <input type="text"  name="idUser"  class="d-none" value="<% out.print(user.getUser(cos).getIdUzytkownik());%>"/>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputSurname">Nazwisko</label>
                        <input type="text" name="nazwisko" class="form-control" id="inputSurname" value="<% out.print(user.getUser(cos).getNazwisko());  %>"  required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputEmail4">Email</label>
                        <input type="email" name="email" class="form-control" id="inputEmail" value="<% out.print(user.getUser(cos).getEmail());  %>"  required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputPassword4">Hasło</label>
                        <input type="password"name="haslo" class="form-control" id="inputPassword" value="<% out.print(user.getUser(cos).getHaslo());  %>"  required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputStreet">Ulica</label>
                        <input type="text" name="ulica" class="form-control" id="inputStreet" value="<% out.print(user.getUser(cos).getUlica());  %>"  required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputNumber">Numer</label>
                        <input type="text" name="nrBud" class="form-control" id="inputNumber" value="<% out.print(user.getUser(cos).getNrMiesz());  %>"  required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputCity">Miasto</label>
                        <input type="text" name="miasto" class="form-control" id="inputCity" value="<% out.print(user.getUser(cos).getMiasto());  %>"  required>
                    </div>                   
                    <div class="form-group col-md-2">
                        <label for="inputZip">Kod pocztowy</label>
                        <input type="text"name="kodPoczt" class="form-control" id="inputZip" placeholder="00-000" pattern="[0-9][0-9]-[0-9][0-9][0-9]" value="<% out.print(user.getUser(cos).getKodPoczt());  %>" required>
                    </div>
                </div>
                <% if (idTyp.equals("2") || idTyp.equals("3")) { %>
                <div class="row">
                    <div class="form-group col-md">
                        <label for="inputZip">Potwierdzenie</label>

                        <input type="checkbox" value="true"  name="potwierdz" <% if (user.getUser(cos).getPotwierdz() == Boolean.TRUE) {
                                out.print("checked");
                            }%> >                       
                    </div>
                    <div class="col-sm">
                        <jsp:useBean id="taryfa" class="Kontroler.AddTariff" scope="request">
                            <select name="taryfa" id="inputState" class="form-control">                                
                                <option value="null" selected>Wybierz</option>
                                <% for (TaryfaModel teryfy : taryfa.getTaryfa()) {
                                        if (user.getUser(cos).getTaryfa() != null && teryfy.getIdTaryfa() == user.getUser(cos).getTaryfa().getIdTaryfa()) { %>                                  
                                <option value="<%out.print(teryfy.getIdTaryfa()); %>" selected><%out.print(teryfy.getNazwa()); %></option>
                                <%      } else { %>
                                <option value="<%out.print(teryfy.getIdTaryfa()); %>"><%out.print(teryfy.getNazwa()); %></option>
                                <%      }
                                    } %>
                            </select>
                        </jsp:useBean>
                    </div>
                    <div class="col-sm">
                        <jsp:useBean id="typ" class="Kontroler.AddTyp" scope="request">
                            <select name="typ" id="inputState" class="form-control">                                
                                <!--<option value="null" selected>Wybierz</option>-->
                                <% for (TypModel type : typ.getTypes()) {
                                        if (type.getIdTyp() == user.getUser(cos).getTyp().getIdTyp()) { %>                                  
                                <option value="<%out.print(type.getIdTyp()); %>" selected><%out.print(type.getNazwa()); %></option>
                                <%      } else { %>
                                <option value="<%out.print(type.getIdTyp()); %>"><%out.print(type.getNazwa()); %></option>
                                <%      }
                                    } %>
                            </select>
                        </jsp:useBean>
                    </div>
                </div>
                    <% } %>
                <div class="row mt-4">
                    <div class="col">
                        <button type="submit" class="btn btn-primary float-right">Edytuj</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</jsp:useBean>

<%@include file="footer.jsp" %>

<%}%>