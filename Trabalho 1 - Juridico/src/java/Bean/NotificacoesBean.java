/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Persistencia.PessoaDAO;
import Model.Notificacoes;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Julio R. Trindade
 */
public class NotificacoesBean {
    
    private int idPessoa;

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }
    
    
    public List<Notificacoes> getNotificacoesPorPessoa() throws ClassNotFoundException, SQLException{
        return PessoaDAO.getInstance().getNotificacoes(this.idPessoa);
    }
}
