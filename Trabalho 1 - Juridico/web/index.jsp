<%-- 
    Document   : index
    Created on : 05/10/2017, 15:33:56
    Author     : thassya
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle de Processos</title>
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
            <h1>Bem vindo ao Controle de Processos!</h1>
            <h2>A forma mais simples de controlar seus processos e notificar os envolvidos.</h2>

            <nav>
                <ul class=menu>
                    <li><a href="FrontController?action=Teste">Clique aqui, abestado</a></li>
                    <li><a href='Pessoa/Formulario.jsp'>Pessoas</a></li>
                    <li><a href=''>Processos</a></li>
                    <li><a href=''>Primos</a></li>
                </ul>
            </nav> 
            <br/>
            <br/>
            <br/>
            <div>
                
            </div>
        </div>
    </body>
</html>
