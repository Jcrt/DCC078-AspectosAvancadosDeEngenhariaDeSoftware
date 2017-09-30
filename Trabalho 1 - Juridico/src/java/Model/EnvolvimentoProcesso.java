/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Enum.TipoEnvolvimentoEnum;

/**
 *
 * @author Julio R. Trindade
 */
public class EnvolvimentoProcesso {
    private int id;
    private Pessoa pessoaEnvolvimento;
    private TipoEnvolvimentoEnum tipoEnvolvimento;
    
    public EnvolvimentoProcesso(){
        
    }
    
    public EnvolvimentoProcesso(int id, Pessoa p, TipoEnvolvimentoEnum tipo){
        this();
        this.id = id;
        this.pessoaEnvolvimento = p;
        this.tipoEnvolvimento = tipo;
    }

    public int getId() {
        return id;
    }

    public Pessoa getPessoaEnvolvimento() {
        return pessoaEnvolvimento;
    }

    public void setPessoaEnvolvimento(Pessoa pessoaEnvolvimento) {
        this.pessoaEnvolvimento = pessoaEnvolvimento;
    }

    public TipoEnvolvimentoEnum getTipoEnvolvimento() {
        return tipoEnvolvimento;
    }

    public void setTipoEnvolvimento(TipoEnvolvimentoEnum tipoEnvolvimento) {
        this.tipoEnvolvimento = tipoEnvolvimento;
    }
    
    
}
