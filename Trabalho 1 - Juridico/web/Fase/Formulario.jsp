<%-- 
    Document   : Formulario
    Created on : 19/10/2017, 20:42:10
    Author     : Julio R. Trindade
--%>

<%@page import="Enum.TipoEnvolvimentoEnum" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserir Fase</title>
        <link href="<%=request.getContextPath() %>/css/main.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div id="conteudo">
            <jsp:include page="../partials/_Menu.jsp" /> 
            <h1>Inserir Fase</h1>
            <form method="post" action="FrontController?action=CadastroFase">
                <label for="txtDescricao" />Descrição</label>
                <input type="text" name="txtDescricao" id="txtDescricao" />
                <br />
                <label for="cbbTipoEnvolvimento" />Tipo de responsável</label>
                <select name="cbbTipoEnvolvimento" id="cbbTipoEnvolvimento"> 
                    <c:forEach var="tipoPessoa" items="${tipoPessoaList}">
                        <option value="${tipoPessoa.getValor()}">${tipoPessoa}</option>
                    </c:forEach>
                </select>
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
                        <th>Fases já cadastradas</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="fases" items="${fasesList}">
                        <tr>
                            <td></td>
                            <td style="white-space: nowrap">${fases.getDescricao()}</td>
                            <td style="white-space: nowrap">${fases.getTipoResponsavelStr()}</td>
                        </tr> 
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>