/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author 07228620674
 */
public abstract class Produto {
    protected Promocao promocao;
    protected String nome;
    protected Impressao impressao;
    
    public int getDesconto(){
        return promocao.obterDesconto();
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getPromocao(){
        return promocao.obterPromocao();
    }
    
    public String getTipoImpressao(){
        return impressao.imprimir();
    }
}
