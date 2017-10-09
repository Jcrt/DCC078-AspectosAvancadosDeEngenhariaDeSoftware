package Action;

import Persistencia.PessoaDAO;
import Interface.IPessoa;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Julio R. Trindade
 */
public class LoginAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
        boolean loggedIn = (boolean) (session.getAttribute("loggedIn") != null ? (boolean) session.getAttribute("loggedIn") : false);
        
        String login = (String) request.getParameter("login");
        String senha = (String) request.getParameter("senha");
        
        if(!loggedIn && login != null && senha != null && !login.isEmpty() && !senha.isEmpty()){
            PessoaDAO pDAO = PessoaDAO.getInstance();
            try {
                IPessoa pessoa = pDAO.validaLogin(login.trim(), senha.trim());
                if(pessoa != null){
                    session.setAttribute("loggedIn", true);
                    session.setAttribute("idPessoa", pessoa.getId());
                    session.setAttribute("nomePessoa", pessoa.getNome());
                    response.sendRedirect("index.jsp");
                } else{
                    try {
                        request.setAttribute("MsgErroLogin", "Dados de Login errados");
                        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                        rd.forward(request, response);
                    } catch (ServletException ex) {
                        Logger.getLogger(LoginAction.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(LoginAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(loggedIn){
            response.sendRedirect("index.jsp");
        }
        else{
            response.sendRedirect("login.jsp");
        }
    }
}
