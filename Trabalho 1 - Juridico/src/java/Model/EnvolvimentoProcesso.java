/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Enum.TipoEnvolvimentoEnum;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Julio R. Trindade
 */
public class EnvolvimentoProcesso implements Observer {
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

    @Override
    public void update(Observable processo, Object arg) {
        System.out.println("teste");
    }
}
