/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enum;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

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
    private static final ArrayList<TipoPessoaEnum> lista = new ArrayList<TipoPessoaEnum>();
    
//    private static final Map<Integer, TipoPessoaEnum> map = new HashMap<Integer, TipoPessoaEnum>();
//    static {
//        for (TipoPessoaEnum s : EnumSet.allOf(TipoPessoaEnum.class)) {
//            map.put(s.getValor(), s);
//        }
//    }    
//    public static Map<Integer, TipoPessoaEnum> mapTodos() {
//        return map;
//    }

    public static ArrayList<TipoPessoaEnum> listaTodos(){
        for (TipoPessoaEnum e : values()) {
            lista.add(e);
        }
        return lista;
    }
    
    TipoPessoaEnum(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static TipoPessoaEnum getTipoPessoaDeInt(int tipo) {
        for (TipoPessoaEnum e : values()) {
            if (e.getValor() == tipo) {
                return e;
            }
        }
        return null;
    }
}
