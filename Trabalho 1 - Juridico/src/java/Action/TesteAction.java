/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Enum.StatusEnum;
import Enum.TipoEnvolvimentoEnum;
import Model.*;
import Persistencia.ProcessoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 07228620674
 */
public class TesteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Processo processo = new ProcessoAtivo("2013.009.22.1223.122.22");
        
        Pessoa p1 = new PessoaAdvogado(1, "Advogado");
        Pessoa p2 = new PessoaCliente(2, "Cliente");
        
        EnvolvimentoProcesso e1 = new EnvolvimentoProcesso(1, p1, TipoEnvolvimentoEnum.ADVOGADO);
        EnvolvimentoProcesso e2 = new EnvolvimentoProcesso(2, p2, TipoEnvolvimentoEnum.CLIENTE);
        
        Andamento a = new AndamentoNaoLido("Teste de andamento que tem que ter mais de 30 caracteres para eu ver se os pontinhos vão ser adicionados");

        processo.addEnvolvido(e1);
        processo.addEnvolvido(e2);
        
        processo.setStatus(StatusEnum.ATIVO);
        processo.addAndamento(a);
        
        ProcessoDAO pDAO = ProcessoDAO.getInstance();
        try {
            pDAO.putNotificacoesEnvolvidos(processo);
        } catch (SQLException ex) {
            Logger.getLogger(TesteAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TesteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
