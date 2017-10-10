<%-- 
    Document   : Lista
    Created on : 05/10/2017, 17:12:00
    Author     : thassya
--%>

<jsp:useBean id="bean" class="Bean.PessoaBean" scope="page"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pessoas</title>
       <link href="../css/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="conteudo">
            <jsp:include page="../partials/_Menu.jsp" /> 
            <br>
            <br>
            <table>
                <tr>
                    <th>Nome</th>
                    <th>Tipo</th>
                    <th>Documento</th>
                    <th>Email</th>
                </tr>
                <c:forEach var="pessoa" items="${listaPessoas}">
                    <tr>
                        <td>${tipoPessoa.valor}</td>
                        <td>${tipoPessoa.tipo}</td>
                        <td>${tipoPessoa.documento}</td>
                        <td>${tipoPessoa.email}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
