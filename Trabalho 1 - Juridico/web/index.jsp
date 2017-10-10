<%-- 
    Document   : index
    Created on : 05/10/2017, 15:33:56
    Author     : thassya
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle de Processos</title>
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="conteudo">

           <jsp:include page="partials/_Menu.jsp" /> 
            <h1>Bem vindo ao Controle de Processos, <%=request.getSession(true).getAttribute("nomePessoa")%>!</h1>
            <h2>A forma mais simples de controlar seus processos e notificar os envolvidos.</h2>
            
            <br/>
            <br/>
            <br/>
            <div>
                <jsp:include page="partials/_ListaNotificacoes.jsp"/>
            </div>
        </div>
    </body>
</html>
