<%-- 
    Document   : Listar
    Created on : 16/10/2017, 21:03:30
    Author     : Julio R. Trindade
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista Processo</title>
        <link href="<%=request.getContextPath() %>/css/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        <div id="conteudo">
            <jsp:include page="../partials/_Menu.jsp" /> 
            <h1>Lista de Processo</h1>
            <a href="FrontController?action=FormularioProcesso">(+)Cadastrar novo Processo </a>
            <hr>
            <table>
                <thead>
                    <tr>
                        <th>#</th>
                        <th style="white-space: nowrap">Nº do processo</th>
                        <th>Status</th>
                        <!-- <th style="white-space: nowrap">Nº andamentos</th> -->
                        <th style="white-space: nowrap">Fase</th>
                        <th style="white-space: nowrap">Seu envolvimento neste processo</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="processo" items="${listaProcessos}">
                        <tr>
                            <td></td>
                            <td>
                                <a href="FrontController?action=EditarProcesso&amp;idProcesso=${processo.getId()}" title="Clique para editar">
                                    ${processo.getNumeroProcesso()}
                                </a>
                            </td>
                            <td style="white-space: nowrap">${processo.getStatusString()}</td>
                            <!-- <td>${processo.getAndamentos().size()}</td> -->
                            <td style="white-space: nowrap">${processo.getFaseDescr()}</td>
                            <td style="white-space: nowrap">${processo.getMsgEnvolvimentoPessoa(Integer.parseInt(idPessoa))}</td>
                            <td style="white-space: nowrap">
                                <a href="FrontController?action=FormularioStatusProcesso&amp;idProcesso=${processo.getId()}" title="Clique para editar status do processo">
                                    Editar Status
                                </a>
                            </td>
                            <td style="white-space: nowrap">
                                <a href="FrontController?action=ListarAndamento&amp;idProcesso=${processo.getId()}" title="Clique para cadastrar um andamento">
                                    (+)Incluir andamento
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
           
        </div>
    </body>
</html>
