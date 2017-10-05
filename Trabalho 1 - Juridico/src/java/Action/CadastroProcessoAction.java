/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Enum.StatusEnum;
import Model.PessoaAdvogado;
import Model.Processo;
import Persistencia.PessoaAdvogadoDAO;
import Persistencia.ProcessoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thassya
 */
public class CadastroProcessoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nProcesso = request.getParameter("txtNumeroProcesso");
        String advogado = request.getParameter("txtAdvogado");

        if (advogado.equals("") || nProcesso.equals("")) {
            response.sendRedirect("Processo/Formulario.jsp");
        } else {
            try {
                 Processo processo = new Processo();
                 processo.setNumeroProcesso(nProcesso);
                 processo.setStatus(StatusEnum.ATIVO);
                 processo.setDataCadastro(new java.sql.Date(new java.util.Date().getTime()));
                 
//                 PessoaAdvogado adv = PessoaAdvogadoDAO.getInstance().getPessoa(Integer.parseInt(advogado));
//                 processo.setEnvolvidos(adv);                
                 
                ProcessoDAO.getInstance().salvar(processo);
                response.sendRedirect("Sucesso.jsp");
                
            } catch (SQLException e) {
                response.sendRedirect("Erro.jsp");
                e.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CadastroProcessoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
