/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Model.Andamento;
import Persistencia.AndamentoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Interface.IAction;

/**
 *
 * @author Julio R. Trindade
 */
public class ListarAndamentoAction implements IAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            
            String idProcesso = request.getParameter("idProcesso");
            
            if(idProcesso.length() > 0){
                AndamentoDAO aDAO = AndamentoDAO.getInstance();
                List<Andamento> andamentos =
                    aDAO.getAndamentosPorPorcesso(Integer.parseInt(idProcesso));
                request.setAttribute("listaAndamentos", andamentos);
                request.setAttribute("idProcesso", idProcesso);
                
                RequestDispatcher rd = request.getRequestDispatcher("Andamento/Listar.jsp");
                rd.forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListarAndamentoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListarAndamentoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(ListarAndamentoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
