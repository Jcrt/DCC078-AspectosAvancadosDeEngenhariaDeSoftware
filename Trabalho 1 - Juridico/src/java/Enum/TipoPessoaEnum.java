/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enum;

/**
 *
 * @author thassya
 */
public enum TipoPessoaEnum {
    ADVOGADO(1), 
    CLIENTE(2), 
    CONTRARIO(3), 
    OUTROS(4);
    
    private final int valor;
    
    TipoPessoaEnum(int valor){
        this.valor = valor;
    }
    
    public int getValor()
    {
        return valor;
    }
}
