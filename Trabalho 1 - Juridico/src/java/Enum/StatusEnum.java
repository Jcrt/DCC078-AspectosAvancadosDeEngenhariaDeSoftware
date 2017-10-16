/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author 07228620674
 */
public enum StatusEnum {
    ATIVO(1), 
    ARQUIVADO(2), 
    BAIXAPROVISORIA(3), 
    ENCERRADO(4);
    
    private final int valor;
    
    StatusEnum(int valor){
        this.valor = valor;
    }
    
    public int getValor()
    {
        return valor;
    }
    
    public static ArrayList<StatusEnum> listaTodos(){
        ArrayList<StatusEnum> lista = new ArrayList<>();
        lista.addAll(Arrays.asList(values()));
        return lista;
    }
}
