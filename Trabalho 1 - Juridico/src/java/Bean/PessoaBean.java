/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Enum.TipoPessoaEnum;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thassya
 */
public class PessoaBean {
    public ArrayList<TipoPessoaEnum>  getTipoPessoa() throws ClassNotFoundException, SQLException {
        ArrayList<TipoPessoaEnum> tipoPessoa = new ArrayList<TipoPessoaEnum>();
        tipoPessoa = TipoPessoaEnum.listaTodos();
        return tipoPessoa;       
    }
    
}
