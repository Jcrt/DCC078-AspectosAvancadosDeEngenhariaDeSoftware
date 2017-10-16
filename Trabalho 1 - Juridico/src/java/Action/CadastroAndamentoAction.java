/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Model.*;
import Persistencia.AndamentoDAO;
import Persistencia.ProcessoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julio R. Trindade
 */
public class CadastroAndamentoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String idProcesso = request.getParameter("idProcesso");
            String txtAndamento = request.getParameter("txtAndamento");
            
            AndamentoDAO aDAO = AndamentoDAO.getInstance();
            ProcessoDAO pDAO = ProcessoDAO.getInstance();
            
            AndamentoNaoLido andamento = new AndamentoNaoLido(txtAndamento);
            andamento.setIdProcesso(Integer.parseInt(idProcesso));
            
            aDAO.salvar(andamento);
            
            //OBSERVER
            Processo p = pDAO.getProcesso(Integer.parseInt(idProcesso));
            
            p.addAndamento(andamento);
            pDAO.putNotificacoesEnvolvidos(p);
            
            response.sendRedirect("FrontController?action=ListarProcessos");
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroAndamentoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroAndamentoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
