/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Enum.StatusEnum;
import Enum.TipoEnvolvimentoEnum;
import Model.EnvolvimentoProcesso;
import Model.Processo;
import Model.ProcessoAtivo;
import Persistencia.PessoaDAO;
import Persistencia.ProcessoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Interface.IAction;
import Persistencia.FaseDAO;

/**
 *
 * @author thassya
 */
public class CadastroProcessoAction implements IAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nProcesso = request.getParameter("txtNumeroProcesso");
        String comboFase = request.getParameter("comboFase");
        PessoaDAO pDAO = PessoaDAO.getInstance();
        FaseDAO fDAO = FaseDAO.getInstance();
        
        try {
            Processo processo = new ProcessoAtivo(nProcesso);
            processo.setStatus(StatusEnum.ATIVO);
            processo.setDataCadastro(new java.sql.Date(new java.util.Date().getTime()));
            processo.setFase(fDAO.getById(Integer.parseInt(comboFase)));

            String idCliente = request.getParameter("comboCliente");
            String idContrario = request.getParameter("comboContrario");
            String idAdvogado = request.getParameter("comboAdvogado");
            String idOutro = request.getParameter("comboOutro");
            
            List<Observer> envolvidos = new ArrayList<>();
            
            if(idCliente.length() > 0){
                envolvidos.add(
                        new EnvolvimentoProcesso(pDAO.getPessoaById(Integer.parseInt(idCliente)), 
                                TipoEnvolvimentoEnum.CLIENTE
                        )
                );
            }
            
            if(idAdvogado.length() > 0){
                envolvidos.add(
                        new EnvolvimentoProcesso(pDAO.getPessoaById(Integer.parseInt(idAdvogado)), 
                                TipoEnvolvimentoEnum.ADVOGADO
                        )
                );
            }
            
            if(idContrario.length() > 0){
                envolvidos.add(
                        new EnvolvimentoProcesso(pDAO.getPessoaById(Integer.parseInt(idContrario)), 
                                TipoEnvolvimentoEnum.CONTRARIO
                        )
                );
            }
            
            if(idOutro.length() > 0){
                envolvidos.add(
                        new EnvolvimentoProcesso(pDAO.getPessoaById(Integer.parseInt(idOutro)), 
                                TipoEnvolvimentoEnum.OUTROS
                        )
                );
            }
            
            processo.setEnvolvidos(envolvidos);
            ProcessoDAO.getInstance().salvar(processo);
            response.sendRedirect("Sucesso.jsp");

        } catch (SQLException e) {
            response.sendRedirect("Erro.jsp");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroProcessoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
