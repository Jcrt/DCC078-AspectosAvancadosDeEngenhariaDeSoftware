<%-- 
    Document   : login
    Created on : 09/10/2017, 14:04:07
    Author     : Julio R. Trindade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login - Controle de Processos</title>
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="login">
            <table>
                <thead>
                    <tr>
                        <td>
                            <h2>Faça seu login</h2>
                            <hr />
                        </td>
                    </tr>
               
                    <tr>
                        <td>
                            <form method="post" action="FrontController?action=Login">
                                <label for="login">Login</label>
                                <input type="text" id="login" name="login" />

                                <label for="senha">Senha</label>
                                <input type="password" id="senha" name="senha" /> 
                                
                                <hr />
                                
                                <button type="submit">
                                    Entrar
                                </button>

                                <button type="reset">
                                    Apagar dados
                                </button>
                            </form>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
