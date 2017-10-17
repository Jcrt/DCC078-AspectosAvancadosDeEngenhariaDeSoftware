/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Enum.StatusEnum;
import Enum.TipoEnvolvimentoEnum;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Julio R. Trindade
 */
public class EnvolvimentoProcesso implements Observer {
    private int id;
    private int idProcesso;
    private Pessoa pessoaEnvolvimento;
    private TipoEnvolvimentoEnum tipoEnvolvimento;
    private List<String> notificacoes;
    
    public EnvolvimentoProcesso(){
        this.notificacoes = new ArrayList<>();
    }
    
    public EnvolvimentoProcesso(Pessoa p, TipoEnvolvimentoEnum tipo){
        this();
        this.pessoaEnvolvimento = p;
        this.tipoEnvolvimento = tipo;
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
    
    public void addNotificacoes(String not){
        this.notificacoes.add(not);
    }
    
    public List<String> getNotificacoes(){
        return this.notificacoes;
    }
    
    @Override
    public void update(Observable processo, Object arg) {
        String msg = "";
        Processo p = (Processo) processo;
        if(arg instanceof StatusEnum){
            msg = "O Status do processo " + p.getNumeroProcesso() + " fol alterado para " + StatusEnum.getEnumDescr((StatusEnum) arg) + ".";
        } else if(arg instanceof Andamento){
            Andamento anda = (Andamento)arg;
            String strMsg = anda.getDescricao().length() < 30 ? anda.getDescricao() : anda.getDescricao().substring(0, 30);
            msg = "Um andamento foi inserido no processo " + p.getNumeroProcesso() + ". [\""+ strMsg + "...\"]";
        }
        
        if(msg.length() > 0){
            this.addNotificacoes(msg);
        }
    }
}
