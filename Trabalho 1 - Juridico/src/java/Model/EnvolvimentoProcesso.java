/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Enum.StatusEnum;
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
    private int idProcesso;
    
    public EnvolvimentoProcesso(){
        
    }
    
    public EnvolvimentoProcesso(int id, Pessoa p, TipoEnvolvimentoEnum tipo){
        this();
        this.id = id;
        this.pessoaEnvolvimento = p;
        this.tipoEnvolvimento = tipo;
    }
    
     public EnvolvimentoProcesso(int id, Pessoa p, TipoEnvolvimentoEnum tipo, int idProcesso){
        this();
        this.id = id;
        this.pessoaEnvolvimento = p;
        this.tipoEnvolvimento = tipo;
        this.idProcesso = idProcesso;
    }

    public int getId() {
        return id;
    }

    public Pessoa getPessoaEnvolvimento() {
        return pessoaEnvolvimento;
    }
    public int getIdPessoaEnvolvimento() {
        return pessoaEnvolvimento.getId();
    }

    public void setPessoaEnvolvimento(Pessoa pessoaEnvolvimento) {
        this.pessoaEnvolvimento = pessoaEnvolvimento;
    }

    public int getTipoEnvolvimento() {
        return tipoEnvolvimento.getValor();
    }

    public void setTipoEnvolvimento(TipoEnvolvimentoEnum tipoEnvolvimento) {
        this.tipoEnvolvimento = tipoEnvolvimento;
    }

    public int getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(int idProcesso) {
        this.idProcesso = idProcesso;
    }
    
    @Override
    public void update(Observable processo, Object arg) {
        String msg = "";
        Processo p = (Processo) processo;
        if(arg instanceof StatusEnum){
            msg = "O Status do processo " + p.getNumeroProcesso() + " fol alterado para " + arg.toString();
        } else if(arg instanceof Andamento){
            msg = "Um andamento foi inserido no processo " + p.getNumeroProcesso() + ". [\""+ ((Andamento) arg).getDescricao().substring(1, 30) + "...\"]";
        }
        
        System.out.println(msg);
    }
}
