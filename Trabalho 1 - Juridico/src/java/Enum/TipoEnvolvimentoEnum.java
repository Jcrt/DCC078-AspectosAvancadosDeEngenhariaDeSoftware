/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enum;

/**
 *
 * @author Julio R. Trindade
 */
public enum TipoEnvolvimentoEnum {
    CLIENTE(1), 
    CONTRARIO(2), 
    ADVOGADO(3), 
    OUTROS(4);
    
    private final int valor;
    
    TipoEnvolvimentoEnum(int valor){
        this.valor = valor;
    }
    
    public int getValor()
    {
        return valor;
    }
}
