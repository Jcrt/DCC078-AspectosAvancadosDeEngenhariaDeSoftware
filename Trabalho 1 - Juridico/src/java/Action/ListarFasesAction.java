/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Interface.IAction;
import Persistencia.FaseDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julio R. Trindade
 */
public class ListarFasesAction implements IAction{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.setAttribute("fasesList", FaseDAO.getInstance().listar());
            request.getRequestDispatcher("Fase/Listar.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException | ServletException ex) {
            Logger.getLogger(ListarFasesAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
