<%-- 
    Document   : Listar
    Created on : 19/10/2017, 20:42:57
    Author     : Julio R. Trindade
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
            <h1>Lista de Fases</h1>
            <a href="FrontController?action=FormularioFase">(+)Cadastrar nova fase</a>
            <hr />
            <table>
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Descricao</th>
                        <th>Tipo de envolvido responsável</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="fase" items="${fasesList}">
                        <tr>
                            <td></td>
                            <td>${fase.getDescricao()}</td>
                            <td>${fase.getTipoResponsavelStr()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
