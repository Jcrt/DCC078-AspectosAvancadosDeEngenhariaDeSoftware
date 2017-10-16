<%-- 
    Document   : listar
    Created on : 10/10/2017, 00:44:43
    Author     : Julio R. Trindade
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Processo</title>
        <link href="<%=request.getContextPath() %>/css/main.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div id="conteudo">
            <jsp:include page="../partials/_Menu.jsp" /> 
            <h1>Lista de Processo</h1>
            <a href="FrontController?action=FormularioProcesso">(+) Cadastrar novo Processo </a>
            <hr />
            <table>
                <thead>
                    <tr>
                        <th>#</th>
                        <th style="white-space: nowrap">Nº do processo</th>
                        <th>Status</th>
                        <th style="white-space: nowrap">Nº andamentos</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="processos" items="${listaProcessos}">
                        <tr>
                            <td></td>
                            <td>
                                <a href="FrontController?action=EditarProcesso&idProcesso=${processos.getId()}" title="Clique para editar">${processos.getNumeroProcesso()}</a>
                            </td>
                            <td>${processos.getStatusString()}</td>
                            <td>${processos.getAndamentos().size()}</td>
                            <td style="white-space: nowrap">
                                <a href="FrontController?action=FormularioStatusProcesso&idProcesso=${processos.getId()}" title="Clique para editar status do processo">
                                    Editar Status do Processo
                                </a>
                            </td>
                            <td style="white-space: nowrap">
                                <a href="FrontController?action=ListarAndamento&idProcesso=${processos.getId()}" title="Clique para cadastrar um andamento">
                                    Incluir andamento
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
           
        </div>
    </body>
</html>
