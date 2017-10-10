<%-- 
    Document   : _ListaNotificacoes
    Created on : 09/10/2017, 17:10:15
    Author     : Julio R. Trindade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="notificacoesBean" class="Bean.NotificacoesBean" scope="request"/>
<jsp:setProperty name="notificacoesBean" property="idPessoa" value='<%= session.getAttribute("idPessoa") %>' />  

<!DOCTYPE html>
<html>
    <body>
        <div>
            <h2>Suas notificações</h2>
            <hr />
            <table>
                <thead>
                    <th>Número do processo</th>
                    <th>Mensagem</th>
                </thead>
                <tbody>
                    <c:forEach var="notificacoes" items="${notificacoesBean.getNotificacoesPorPessoa()}">
                        <tr>
                            <td>${notificacoes.numeroProcesso}</td>
                            <td>${notificacoes.mensagem}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
