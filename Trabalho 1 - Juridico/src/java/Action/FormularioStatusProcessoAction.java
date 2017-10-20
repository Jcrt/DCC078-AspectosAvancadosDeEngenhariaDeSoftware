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
import java.util.ArrayList;
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
public class FormularioStatusProcessoAction implements IAction{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            ArrayList<StatusEnum> status = StatusEnum.listaTodos();
            String idProcesso = request.getParameter("idProcesso");
            
            ProcessoDAO pDAO = ProcessoDAO.getInstance();
            Processo p = pDAO.getProcesso(Integer.parseInt(idProcesso));
            
            request.setAttribute("idProcesso", idProcesso);
            request.setAttribute("statusLista", status);
            request.setAttribute("statusOld", p.getStatus());
            
            RequestDispatcher rd = request.getRequestDispatcher("Processo/FormularioStatusProcesso.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException | ServletException | SQLException ex) {
            Logger.getLogger(FormularioStatusProcessoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
