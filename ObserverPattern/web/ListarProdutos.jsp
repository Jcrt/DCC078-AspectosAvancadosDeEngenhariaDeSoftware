<%-- 
    Document   : ListarProdutos
    Created on : 14/09/2017, 20:08:44
    Author     : 07228620674
--%>

<%@page import="java.util.List"%>
<%@page import="Models.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de produtos</title>
    </head>
    <body>
        <h2> 
            Lista de produtos
        </h2>
        <hr />
        <form action="FrontController?action=AlterarEstoqueProduto" method="post">
            <p>
                <label for="idProduto">Selecione o produto:</label>
                <select name="idProduto" id="idProduto">
                    <option value="">Selecione...</option>
                    <c:forEach items="${ProdutosList}" var="prod"> 
                        <option value="<c:out value="${prod.getId()}" />"><c:out value="${prod.getNome()}" /></option>
                    </c:forEach>
                </select>
            </p>
            <p>
                <label for="estoque">Quantidade: </label>
                <input type="text" name="estoque" id="estoque" value="" />
            </p>
            <p>
                <input type="submit" value="Salvar Estoque" />
            </p>
        </form>
    </body>
</html>
