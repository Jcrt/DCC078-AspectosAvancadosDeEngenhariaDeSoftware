/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Enum.StatusEnum;
import Enum.TipoEnvolvimentoEnum;
import Model.*;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 07228620674
 */
public class TesteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Processo p = new Processo();
        
        Pessoa p1 = new PessoaAdvogado(1, "Advogado");
        Pessoa p2 = new PessoaCliente(2, "Cliente");
        
        EnvolvimentoProcesso e1 = new EnvolvimentoProcesso(1, p1, TipoEnvolvimentoEnum.ADVOGADO);
        EnvolvimentoProcesso e2 = new EnvolvimentoProcesso(2, p2, TipoEnvolvimentoEnum.CLIENTE);

        p.addEnvolvido(e1);
        p.addEnvolvido(e2);
        
        p.setStatus(StatusEnum.ATIVO);
        
    }   
}
