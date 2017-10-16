<%-- 
    Document   : Formulario
    Created on : 05/10/2017, 14:43:50
    Author     : thassya
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Pessoas</title>
        <link href="<%=request.getContextPath() %>/css/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        <jsp:include page="../partials/_Menu.jsp" /> 
        
        <div id="conteudo">
           
            <br>
            <br>
            <h1>Cadastro de Pessoa</h1>
            <form action="FrontController?action=CadastroPessoa" method="post">
                Entre com seu Nome:
                <input type="text" name="txtNome"/><br/>

                Entre com seu Documento: 
                <input type="text" name="txtDocumento"/><br/>

                Entre com seu Email:
                <input type="text" name="txtEmail"/><br/>

                Escolha o tipo:
                <select id="comboTipoPessoa" name="txtTipoPessoa">
                    <option value="">..</option>
                    <c:forEach var="tipoPessoa" items="${tipoPessoaLista}">
                        <option value="${tipoPessoa.valor}">${tipoPessoa}</option>
                    </c:forEach>
                </select>
                <br>
                <input type="submit" value="Cadastrar"/>
            </form>
        </div>
    </body>
</html>
