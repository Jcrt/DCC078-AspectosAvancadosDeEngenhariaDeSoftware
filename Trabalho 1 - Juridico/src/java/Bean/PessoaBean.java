/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Enum.TipoPessoaEnum;
import java.sql.SQLException;
import java.util.Map;

/**
 *
 * @author thassya
 */
public class PessoaBean {
    public Map<Integer, TipoPessoaEnum> getTipoPessoa() throws ClassNotFoundException, SQLException {
        Map<Integer, TipoPessoaEnum> tipoPessoa = TipoPessoaEnum.listaTodos();
        return tipoPessoa;       
    }
    
}
