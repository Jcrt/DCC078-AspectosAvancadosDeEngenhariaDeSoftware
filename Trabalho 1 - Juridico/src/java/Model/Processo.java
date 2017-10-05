/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Enum.StatusEnum;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author 07228620674
 */
public class Processo extends Observable {
    private int id;
    private String numeroProcesso;
    private List<Observer> envolvidos; 
    private StatusEnum status;
    private List<Andamento> andamentos;
    private Date dataCadastro;
    private Date dataBaixa;
    private Date dataEncerramento;
    
    public Processo(){
        this.envolvidos = new ArrayList<>();
        this.andamentos = new ArrayList<>();
        this.status = StatusEnum.ATIVO;
    }
    
    public void addEnvolvido(Observer p){
        this.envolvidos.add(p);
        this.addObserver(p);
    }
    
    public void addAndamento(Andamento a){
        this.andamentos.add(a);
        setChanged();
        notifyObservers();
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public List<Observer> getEnvolvidos() {
        return envolvidos;
    }

    public void setEnvolvidos(List<Observer> envolvidos) {
        this.envolvidos = envolvidos;
    }

    public int getStatus() {
        return status.getValor();
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
        setChanged();
        notifyObservers();
    }

    public List<Andamento> getAndamentos() {
        return andamentos;
    }

    public void setAndamentos(List<Andamento> andamentos) {
        this.andamentos = andamentos;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(Date dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    public Date getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(Date dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }
}
