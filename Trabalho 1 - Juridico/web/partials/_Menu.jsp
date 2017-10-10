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
            <ul class=menu>
                <li><a href='<%=request.getContextPath() %>/index.jsp'>Inicio</a>
                <li><a href='<%=request.getContextPath() %>/Pessoa/Formulario.jsp'>Pessoas</a></li>
                <li><a href='<%=request.getContextPath() %>/Processo/Formulario.jsp'>Processos</a></li>
            </ul>
        </nav> 
    </body>
</html>
