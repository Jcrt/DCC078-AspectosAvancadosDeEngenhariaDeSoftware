/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Model.Processo;
import Persistencia.ProcessoDAO;
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
public class ListarProcessosAction implements IAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            ProcessoDAO pDAO = ProcessoDAO.getInstance();
            List<Processo> listProc = pDAO.listar();
            int idPessoa = (int) request.getSession(true).getAttribute("idPessoa");
            
            request.setAttribute("listaProcessos", listProc);
            request.setAttribute("idPessoa", idPessoa);
            
            listProc.forEach((p) -> {
                p.makeChainFase();
                System.out.println(p.getQuemPodeMudarFase());
            });
            
            RequestDispatcher rd = request.getRequestDispatcher("Processo/Listar.jsp");
            rd.forward(request, response);
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListarProcessosAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListarProcessosAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(ListarProcessosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
