/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Observable;

/**
 *
 * @author Julio R. Trindade
 */
public class Produto extends Observable {
    private int id;
    private String nome;
    private int estoque;
    
    public Produto() {
      
    }

    public Produto(int id, String nome, int estoque) {
        super();
        this.id = id;
        this.nome = nome;
        this.estoque = estoque;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
        setChanged();
        notifyObservers();
    }
    
    
}
