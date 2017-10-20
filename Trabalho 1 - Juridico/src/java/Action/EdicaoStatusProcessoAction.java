/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Enum.StatusEnum;
import Model.Processo;
import Persistencia.ProcessoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Interface.IAction;

/**
 *
 * @author Julio R. Trindade
 */
public class EdicaoStatusProcessoAction implements IAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String idProcesso = request.getParameter("idProcesso");
            String newStatus = request.getParameter("cbbStatus");
            
            ProcessoDAO pDAO = ProcessoDAO.getInstance();
            Processo p = pDAO.getProcesso(Integer.parseInt(idProcesso));
            p.setStatus(StatusEnum.getEnumByInt(Integer.parseInt(newStatus)));
            
            pDAO.updateStatusProcesso(p);
            pDAO.putNotificacoesEnvolvidos(p);
            
            response.sendRedirect("FrontController?action=ListarProcessos");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EdicaoStatusProcessoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
