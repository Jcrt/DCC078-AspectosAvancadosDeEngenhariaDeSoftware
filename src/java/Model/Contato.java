/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author 07228620674
 */
public class Contato {
    private int codigo;
    private String nome;
    private String email;
    
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
}
