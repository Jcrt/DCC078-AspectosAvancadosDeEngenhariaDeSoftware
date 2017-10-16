<%-- 
    Document   : Formulario
    Created on : 05/10/2017, 17:25:23
    Author     : thassya
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Processo</title>
        <link href="<%=request.getContextPath() %>/css/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="conteudo">
            <jsp:include page="../partials/_Menu.jsp" /> 

            <h1>Cadastro de Processo</h1>
            <form action="FrontController?action=CadastroProcesso" method="post">
                Entre com Número do Processo:
                <input type="text" name="txtNumeroProcesso"/><br/>

                Vincule um Cliente
                <select id="comboCliente" name="comboCliente">
                    <option value="">..</option>
                    <c:forEach var="cliente" items="${clientes}">
                        <option value="${cliente.getId()}">${cliente.getNome()}</option>
                    </c:forEach>
                </select>
                <br />
                
                Vincule um Contrário
                <select id="comboContrario" name="comboContrario">
                    <option value="">..</option>
                    <c:forEach var="contrario" items="${contrarios}">
                        <option value="${contrario.getId()}">${contrario.getNome()}</option>
                    </c:forEach>
                </select>
                <br />
                
                Vincule um Advogado:
                <select id="comboAdvogado" name="comboAdvogado">
                    <option value="">..</option>
                    <c:forEach var="advogado" items="${advogados}">
                        <option value="${advogado.getId()}">${advogado.getNome()}</option>
                    </c:forEach>
                </select>
                <br />
                
                Vincule um Outro
                <select id="comboOutro" name="comboOutro">
                    <option value="">..</option>
                    <c:forEach var="outro" items="${outros}">
                        <option value="${outro.getId()}">${outro.getNome()}</option>
                    </c:forEach>
                </select>
                <br />
 
                <input type="submit" value="Cadastrar"/>
                <button type="button" onclick="history.back(-1)">
                    Voltar
                </button>
            </form>
        </div>
    </body>
</html>
