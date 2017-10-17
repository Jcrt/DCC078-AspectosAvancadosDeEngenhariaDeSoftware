<%-- 
    Document   : menu
    Created on : 09/10/2017, 21:33:59
    Author     : thassya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <nav>
            <ul class="menu">
                <li><a href='<%=request.getContextPath() %>/index.jsp'>Inicio</a>
                <li><a href='FrontController?action=ListarPessoas'>Pessoas</a></li>
                <li><a href='FrontController?action=ListarProcessos'>Processos</a></li>
                <li><a href='FrontController?action=Logout'>Sair</a></li>
            </ul>
        </nav> 
    </body>
</html>
