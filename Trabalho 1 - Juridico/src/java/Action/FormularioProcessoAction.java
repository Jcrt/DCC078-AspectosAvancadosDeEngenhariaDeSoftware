/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Enum.TipoPessoaEnum;
import Interface.IPessoa;
import Persistencia.PessoaDAO;
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
import Model.Fase;
import Persistencia.FaseDAO;

/**
 *
 * @author Julio R. Trindade
 */
public class FormularioProcessoAction implements IAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            PessoaDAO pDAO = PessoaDAO.getInstance();
            
            List<IPessoa> pCli = pDAO.listar(TipoPessoaEnum.CLIENTE);
            List<IPessoa> pAdv = pDAO.listar(TipoPessoaEnum.ADVOGADO);
            List<IPessoa> pCon = pDAO.listar(TipoPessoaEnum.CONTRARIO);


            List<IPessoa> pOut = pDAO.listar(TipoPessoaEnum.OUTROS);
            List<Fase> fases = FaseDAO.getInstance().listar();
             
            request.setAttribute("clientes", pCli);
            request.setAttribute("contrarios", pCon);
            request.setAttribute("advogados", pAdv);
            request.setAttribute("outros", pOut);
            request.setAttribute("fasesList", fases);
            
            RequestDispatcher rd = request.getRequestDispatcher("Processo/Formulario.jsp");
            rd.forward(request, response);
            
        } catch (ClassNotFoundException | SQLException | ServletException ex) {
            Logger.getLogger(FormularioProcessoAction.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
