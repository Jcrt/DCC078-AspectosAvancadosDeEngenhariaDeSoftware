/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Enum.TipoEnvolvimentoEnum;
import Persistencia.FaseDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Interface.IAction;

/**
 *
 * @author Julio R. Trindade
 */
public class FormularioFaseAction implements IAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            ArrayList<TipoEnvolvimentoEnum> tpPessoa = TipoEnvolvimentoEnum.listaTodos();
            
            request.setAttribute("tipoPessoaList", tpPessoa);
            request.setAttribute("fasesList", FaseDAO.getInstance().listar());
            
            request.getRequestDispatcher("Fase/Formulario.jsp")
                   .forward(request, response);
        } catch (ServletException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FormularioFaseAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
