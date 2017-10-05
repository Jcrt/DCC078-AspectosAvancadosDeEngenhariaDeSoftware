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
        <style>
            html {background-color: #ddd;}
            #conteudo { margin-left: 50px; width: 50%; }
            .menu {list-style:none; float:left; }
            .menu li {position:relative; float:left; border-right:1px solid #c0c0c0; }
            .menu li a {color:#333; text-decoration:none; padding:5px 10px; display:block;}
            .menu li a:hover{background:#333; color:#fff; -moz-box-shadow:0 3px 10px 0 #CCC; -webkit-box-shadow:0 3px 10px 0 #ccc; text-shadow:0px 0px 5px #fff;}
            nav {padding: 20;}  
            h1 {padding: 10px; margin-top: 50px; display:block;}
            input[type=text], select { width: 100%; padding: 12px 20px; margin: 8px 0;  display: inline-block;}
            input[type=submit] {padding: 14px 20px;margin: 8px 0;border: none; cursor: pointer; background-color:#c0c0c0;}
        </style>
    </head>
    <body>
          <div id="conteudo">
            <nav>
                <ul class=menu>
                    <li><a href="FrontController?action=Teste">Clique aqui, abestado</a></li>
                    <li><a href='Pessoa/Formulario.jsp'>Pessoas</a></li>
                    <li><a href='Processo/Formulario.jsp'>Processos</a></li>
                    <li><a href=''>Primos</a></li>
                </ul>
            </nav> 
            <br>
            <br>
            <h1>Cadastro de Processo</h1>
            <form action="../FrontController?action=CadastroProcesso" method="post">
                Entre com seu Nome:
                <input type="text" name="txtNome"/><br/>

                Entre com seu Documento: 
                <input type="text" name="txtDocumento"/><br/>

                Entre com seu Email:
                <input type="text" name="txtEmail"/><br/>

                Escolha o tipo:
                <select id="comboTipoPessoa" name="txtTipoPessoa">
                    <option value="">..</option>
                    <c:forEach var="tipoPessoa" items="${bean.tipoPessoa}">
                        <option value="${tipoPessoa.valor}">${tipoPessoa}</option>
                    </c:forEach>
                </select>
                <br>
                <input type="submit" value="Cadastrar"/>
            </form>
        </div>
    </body>
</html>
