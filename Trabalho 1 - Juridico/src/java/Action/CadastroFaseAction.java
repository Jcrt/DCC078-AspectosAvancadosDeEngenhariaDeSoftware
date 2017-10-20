/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Enum.TipoEnvolvimentoEnum;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Interface.IAction;
import Model.Fase;
import Persistencia.FaseDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

/**
 *
 * @author Julio R. Trindade
 */
public class CadastroFaseAction implements IAction{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String descricao = request.getParameter("txtDescricao");
        String tipoEnvolvimento = request.getParameter("cbbTipoEnvolvimento");
        
        if(descricao != null && tipoEnvolvimento != null){
            try {
                Fase f = new Fase(TipoEnvolvimentoEnum.getEnumByInt(Integer.parseInt(tipoEnvolvimento)),
                        descricao);
                FaseDAO.getInstance().salvar(f);
                request.getRequestDispatcher("FrontController?action=ListarFases").forward(request, response);
            } catch (SQLException | ClassNotFoundException | ServletException ex) {
                Logger.getLogger(CadastroFaseAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
