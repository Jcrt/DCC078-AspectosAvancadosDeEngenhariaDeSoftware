/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Enum.StatusEnum;
import Enum.TipoEnvolvimentoEnum;
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
    private Fase fase;
    private boolean isSuccessBuildChain;
    
    public String getStatusString() {
        return "Ativo";
    }
    
    public Processo(){
        this.envolvidos = new ArrayList<>();
        this.andamentos = new ArrayList<>();
        this.status = StatusEnum.ATIVO;
        this.isSuccessBuildChain = false;
    }

    public Fase getFase() {
        return fase;
    }
    
    public String getFaseDescr(){
        if(this.fase == null)
            return " - ";
        else
            return this.fase.getDescricao();
    }
    
    public void setFase(Fase fase) {
        this.fase = fase;
    }
    
    public Processo(String numProc){
        this();
        this.numeroProcesso = numProc;
    }
    
    public void addEnvolvido(Observer p){
        this.envolvidos.add(p);
        this.addObserver(p);
    }
    
    public void addAndamento(Andamento a){
        this.andamentos.add(a);
        setChanged();
        notifyObservers(a);
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId(){
        return this.id;
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
        envolvidos.forEach((o) -> {
            this.addObserver(o);
        });
    }

    public int getStatus() {
        return status.getValor();
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
        setChanged();
        notifyObservers(status);
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
    
    public String getMsgEnvolvimentoPessoa(int idPessoa){
        String msg = "-";
        for(Observer e : this.envolvidos){
            EnvolvimentoProcesso env = (EnvolvimentoProcesso) e;
            if(env.getPessoaEnvolvimento().getId() == idPessoa)
                msg = "Você é o '" + 
                    TipoEnvolvimentoEnum.getEnumDescr(TipoEnvolvimentoEnum.getEnumByInt(env.getTipoEnvolvimento())) + 
                    "' deste processo";  
        }    
        return msg;      
    }
    
    public void makeChainFase(){
        
        try {
            ArrayList<Pessoa> pList = new ArrayList<>(4);
        
            for(Observer envolvido : envolvidos){
                EnvolvimentoProcesso env = (EnvolvimentoProcesso) envolvido;
                Pessoa p = env.getPessoaEnvolvimento();
                
                if(p instanceof PessoaAdvogado){
                    pList.add(0, p);
                } else if(p instanceof PessoaCliente){
                    pList.add(1, p);
                } else if(p instanceof PessoaContrario){
                    pList.add(2, p);
                } else if(p instanceof PessoaOutro){
                    pList.add(3, p);
                }
            }
            
            /*envolvidos.stream().map((envolvido) -> (EnvolvimentoProcesso) envolvido).map((env) -> env.getPessoaEnvolvimento()).forEachOrdered((p) -> {
                if(p instanceof PessoaAdvogado){
                    pList.add(0, p);
                } else if(p instanceof PessoaCliente){
                    pList.add(1, p);
                } else if(p instanceof PessoaContrario){
                    pList.add(2, p);
                } else if(p instanceof PessoaOutro){
                    pList.add(3, p);
                }
            });*/

            for(int i = 0; i < pList.size() - 1; i++){
                if(i + 1 < pList.size())
                    pList.get(i).setProxAlteradorFase(pList.get(i + 1));
            }
            
            isSuccessBuildChain = true;
        } catch (Exception e) {
            isSuccessBuildChain = false;
        }
        
    }
    
    public String getQuemPodeMudarFase(){
        String mensagem = "Não se aplica";
        if(isSuccessBuildChain && this.fase != null){
            for(Observer o : envolvidos){
                EnvolvimentoProcesso e = (EnvolvimentoProcesso) o;
                Pessoa p = e.getPessoaEnvolvimento();
                if(p instanceof PessoaAdvogado){
                   return p.getAlteradorFase(this.fase);
                }
            }
        } 
        return mensagem;
    }
    
    public String getQuemPodeMudarFase(int idPessoa){
        String mensagem = "Não se aplica";
        if(isSuccessBuildChain && this.fase != null){
            for(Observer o : envolvidos){
                EnvolvimentoProcesso e = (EnvolvimentoProcesso) o;
                Pessoa p = e.getPessoaEnvolvimento();
                if(p instanceof PessoaAdvogado){
                   return p.getAlteradorFase(this.fase, idPessoa, this.id);
                }
            }
        } 
        return mensagem;
    }
}
