/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author 07228620674
 */
public class AndamentoLeituraDados {
    private int id;
    private Pessoa leitor;
    private Date data;
    
    public AndamentoLeituraDados(){
        
    }
    
    public AndamentoLeituraDados(int id, Pessoa leitor, Date data){
        this.id = id;
        this.leitor = leitor;
        this.data = data;
    }
}
