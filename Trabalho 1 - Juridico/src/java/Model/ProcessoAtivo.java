/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Enum.StatusEnum;

/**
 *
 * @author thassya
 */
public class ProcessoAtivo extends Processo {
    
    public ProcessoAtivo(){
        super();
        super.setStatus(StatusEnum.ATIVO);
    }
    
    public ProcessoAtivo(String numeroProcesso){
        super(numeroProcesso);
        super.setStatus(StatusEnum.ATIVO);
    }
    
    @Override
    public String getStatusString() {
        return "Ativo";
    }
}
