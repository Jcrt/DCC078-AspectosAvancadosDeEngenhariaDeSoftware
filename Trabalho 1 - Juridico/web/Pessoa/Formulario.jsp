<%-- 
    Document   : Formulario
    Created on : 05/10/2017, 14:43:50
    Author     : thassya
--%>
<jsp:useBean id="bean" class="Bean.PessoaBean" scope="page"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Pessoas</title>
        <style>
            html {background-color: #ddd;}
            #conteudo { margin-left: 50px; width: 50%; }
            .menu {list-style:none; float:left; }
            .menu li {position:relative; float:left; border-right:1px solid #c0c0c0; }
            .menu li a {color:#333; text-decoration:none; padding:5px 10px; display:block;}
            .menu li a:hover{background:#333; color:#fff; -moz-box-shadow:0 3px 10px 0 #CCC; -webkit-box-shadow:0 3px 10px 0 #ccc; text-shadow:0px 0px 5px #fff;}
            nav {padding: 20;}   
        </style>
    </head>
    <body>
        <div id="conteudo">
            <nav>
                <ul class=menu>
                    <li><a href="FrontController?action=Teste">Clique aqui, abestado</a></li>
                    <li><a href=''>Pessoas</a></li>
                    <li><a href=''>Processos</a></li>
                    <li><a href=''>Primos</a></li>
                </ul>
            </nav> 
            
            <h1>Cadastro de Pessoa</h1>
        <form action="../FrontController?action=CadastroPessoa" method="post">
            Entre com seu Nome:
            <input type="text" name="txtNome"/><br/>
            
            Entre com seu Documento: 
            <input type="text" name="txtDocumento"/><br/>
            
            Entre com seu Email:
            <input type="text" name="txtEmail"/><br/>
            
            Escolha o tipo:
            <select id="comboTipoPessoa" name="txtTipoPessoa">
                <option value="">..</option>
                <c:forEach var="empresa" items="${bean.lista}">
                    <option value="${lista.id}">${lista.descricao}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Cadastrar"/>
        </form>
        </div>
    </body>
</html>
