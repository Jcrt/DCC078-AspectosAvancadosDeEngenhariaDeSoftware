<%-- 
    Document   : Lista
    Created on : 05/10/2017, 17:12:00
    Author     : thassya
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pessoas</title>
       <link href="<%=request.getContextPath() %>/css/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="conteudo">
            <jsp:include page="../partials/_Menu.jsp" /> 
            <h1>Lista de Pessoas</h1>
            <a href="FrontController?action=FormularioPessoa"> Cadastrar nova Pessoa</a>
            <hr />
            <table>
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Nome</th>
                        <th>Tipo de pessoa</th>
                        <th>Documento</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="pessoa" items="${listaPessoas}">
                        <tr>
                            <td></td>
                            <td>${pessoa.getNome()}</td>
                            <td>${pessoa.getTipo()}</td>
                            <td>${pessoa.getTipoDocumento()} - ${pessoa.getNumeroDocumento()}</td>
                            <td>${pessoa.getEmail()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
