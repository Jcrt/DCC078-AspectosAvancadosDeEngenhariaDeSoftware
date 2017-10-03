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
public abstract class Andamento {
    private int id;
    private String descricao;
    private Date data;
    public abstract String getStatusLido();
    
    public Andamento(){
        
    }

    public Andamento(int id, String descricao, Date data) {
        this();
        this.id = id;
        this.descricao = descricao;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}