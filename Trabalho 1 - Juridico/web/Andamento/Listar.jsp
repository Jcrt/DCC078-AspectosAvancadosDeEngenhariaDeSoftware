<%-- 
    Document   : Listar
    Created on : 16/10/2017, 18:40:53
    Author     : Julio R. Trindade
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserir andamento</title>
        <link href="<%=request.getContextPath() %>/css/main.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div id="conteudo">
            <jsp:include page="../partials/_Menu.jsp" /> 
            <h1>Inserir andamento</h1>
            <form method="post" action="FrontController?action=CadastroAndamento">
                <input type="hidden" name="idProcesso" value="${idProcesso}">
                <label for="txtAndamento" />
                <textarea name="txtAndamento" id="txtAndamento"></textarea>
                <br />
                <input type="submit" value="Salvar" />
                <button type="button" onclick="history.back(-1)">
                    Voltar
                </button>
            </form>
            <hr />
            <table>
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Andamentos</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="andamento" items="${listaAndamentos}">
                        <tr>
                            <td></td>
                            <td>${andamento.getDescricao()}</td>
                            <td>${andamento.getDateFormatted()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
