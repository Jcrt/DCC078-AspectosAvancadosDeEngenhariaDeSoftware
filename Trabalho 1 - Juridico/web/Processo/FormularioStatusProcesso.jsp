<%-- 
    Document   : FormularioStatusProcesso
    Created on : 16/10/2017, 20:49:45
    Author     : Julio R. Trindade
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Status Processo</title>
        <link href="<%=request.getContextPath() %>/css/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="conteudo">
            <jsp:include page="../partials/_Menu.jsp" /> 

            <h1>Edição de status de Processo</h1>
            <form action="FrontController?action=EdicaoStatusProcesso" method="post">
                <input type="hidden" name="idProcesso" value="${idProcesso}" />
                Selecione o novo status do processo:
                <select name="cbbStatus">
                    <c:forEach var="statuses" items="${statusLista}">
                        <option value="${statuses.getValor()}" <c:if test="${statuses.getValor().equals(statusOld)}" > selected </c:if>>${statuses.getEnumDescr(statuses)}</option>
                    </c:forEach>
                </select>
                <br/>
                <input type="submit" value="Salvar"/>
                <button type="button" onclick="history.back(-1)">
                    Voltar
                </button>
            </form>
        </div>
    </body>
</html>
