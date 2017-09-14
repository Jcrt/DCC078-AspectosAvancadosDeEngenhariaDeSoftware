/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author 07228620674
 */
public class Contato implements Observer {
    private int codigo;
    private String nome;
    private String email;
    private List<Observable> produtosDesejados;
    
    public Contato(){
        
    }
    
    public Contato(String nome, String email) {
        super();
        this.nome = nome;
        this.email = email;
    }
    
    public Contato(int codigo, String nome, String email) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
    }
    
    @Override
    public void update(Observable produto, Object arg) {
        if(produto instanceof Produto){
            Produto p = (Produto) produto;
            System.out.println("Observador: " + this.nome + "; "
                    + "Produto: " + p.getNome() + "; "
                    + "Estoque: " + String.valueOf(p.getEstoque())
            );
        }
    }
    
    public void putProdutosDesejados(Observable o){
        if(this.produtosDesejados == null)
            this.produtosDesejados = new ArrayList();
        this.produtosDesejados.add(o);
        o.addObserver(this);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public List<Observable> getProdutosDesejados() {
        return produtosDesejados;
    }

    public void setProdutosDesejados(List<Observable> produtosDesejados) {
        this.produtosDesejados = produtosDesejados;
    }
}
