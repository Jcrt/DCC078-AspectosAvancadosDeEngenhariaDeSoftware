<%-- 
    Document   : Formulario
    Created on : 05/10/2017, 17:25:23
    Author     : thassya
--%>

<jsp:useBean id="bean" class="Bean.PessoaBean" scope="page"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Processo</title>
        <link href="../css/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="conteudo">
            <jsp:include page="../partials/_Menu.jsp" /> 
            
            <br>
            <br>
            <h1>Cadastro de Processo</h1>
            <form action="../FrontController?action=CadastroProcesso" method="post">
                Entre com Número do Processo:
                <input type="text" name="txtNumeroProcesso"/><br/>

                Vincule um Advogado:
                <select id="comboAdvogado" name="txtAdvogado">
                    <option value="">..</option>
                    <c:forEach var="tipoPessoa" items="${bean.advogados}">
                        <option value="${tipoPessoa.id}">${tipoPessoa.nome}</option>
                    </c:forEach>
                </select>
                <br>
                <input type="submit" value="Cadastrar"/>
            </form>
        </div>
    </body>
</html>
