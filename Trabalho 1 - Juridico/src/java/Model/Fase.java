/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Enum.TipoEnvolvimentoEnum;
import java.util.Objects;

/**
 *
 * @author Julio R. Trindade
 */
public class Fase {
    private int id;
    private TipoEnvolvimentoEnum tipoResponsavel;
    private String descricao;
    
    public Fase(){
        
    }
    
    public Fase(TipoEnvolvimentoEnum tp, String descr){
        this.tipoResponsavel = tp;
        this.descricao = descr;
    }
    
    public Fase(int id, String descr, TipoEnvolvimentoEnum tp){
        this(tp, descr);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoEnvolvimentoEnum getTipoResponsavel() {
        return tipoResponsavel;
    }
    
    public String getTipoResponsavelStr(){
        return TipoEnvolvimentoEnum.getEnumDescr(this.tipoResponsavel);
    }

    public void setTipoResponsavel(TipoEnvolvimentoEnum tipoResponsavel) {
        this.tipoResponsavel = tipoResponsavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public boolean equals(Object fase){
        if(fase instanceof Fase){
            Fase f = (Fase) fase;
            return f.id == this.id && f.descricao.equals(this.descricao);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.tipoResponsavel);
        hash = 97 * hash + Objects.hashCode(this.descricao);
        return hash;
    }
}
