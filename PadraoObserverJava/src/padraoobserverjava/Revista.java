/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padraoobserverjava;

import java.util.Observable;

/**
 *
 * @author 07228620674
 */
public class Revista extends Observable {
    private int edicao;
    
    public void setEdicao(int novaEdicao){
        this.edicao = novaEdicao;
        setChanged();
        notifyObservers();
    }
    
    public int getEdicao(){
        return this.edicao;
    }
}
