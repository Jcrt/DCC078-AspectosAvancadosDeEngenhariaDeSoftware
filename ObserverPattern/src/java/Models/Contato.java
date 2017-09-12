/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

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

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Observable> getProdutosDesejados() {
        return produtosDesejados;
    }

    public void setProdutosDesejados(List<Observable> produtosDesejados) {
        this.produtosDesejados = produtosDesejados;
    }
    
}
