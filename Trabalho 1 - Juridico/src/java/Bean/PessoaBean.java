/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Enum.TipoPessoaEnum;
import Model.PessoaAdvogado;
import Persistencia.PessoaAdvogadoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    public List<PessoaAdvogado> getAdvogados() throws ClassNotFoundException, SQLException{
        List<PessoaAdvogado> advogados = new ArrayList<PessoaAdvogado>();
        advogados = PessoaAdvogadoDAO.getInstance().listar();
        return advogados;       
    }
}
