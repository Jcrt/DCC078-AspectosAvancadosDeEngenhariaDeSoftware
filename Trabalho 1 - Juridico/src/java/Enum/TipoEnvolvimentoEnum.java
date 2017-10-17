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
    
    public static String getEnumDescr(TipoEnvolvimentoEnum valor){
        String descr = " - ";
        switch(valor){
            case CLIENTE:
                descr = "Cliente";
            break;
            case CONTRARIO:
                descr = "Contrário";
            break;
            case ADVOGADO:
                descr = "Advogado";
            break;
            case OUTROS:
                descr = "Outros";
            break;
        }
        return descr;
    }
    
    public static TipoEnvolvimentoEnum getEnumByInt(int valor){
        TipoEnvolvimentoEnum valorCerto = null;
        for(TipoEnvolvimentoEnum s : values()){
            if(s.getValor() == valor)
                valorCerto = s;
        }
        return valorCerto;
    }
    
    public int getValor()
    {
        return valor;
    }
}
