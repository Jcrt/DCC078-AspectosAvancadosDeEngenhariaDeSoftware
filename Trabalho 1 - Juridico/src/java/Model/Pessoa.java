/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Interface.IPessoa;

/**
 *
 * @author 07228620674
 */
public abstract class Pessoa implements IPessoa {

    private int id;
    private String nome;
    private String numeroDocumento;
    private String email;

    @Override
    public abstract int getTipo();

    public Pessoa() {

    }

    public Pessoa(int id, String nome) {
        this();
        this.id = id;
        this.nome = nome;
    }

    public Pessoa(int id, String nome, String numeroDocumento, String email) {
        this();
        this.id = id;
        this.nome = nome;
        this.numeroDocumento = numeroDocumento;
        this.email = email;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getTipoDocumento() {
        return "CPF: ";
    }
}
