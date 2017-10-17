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
public class ProcessoEncerrado extends Processo {
    
    public ProcessoEncerrado(){
        super();
        super.setStatus(StatusEnum.ENCERRADO);
    }
    
    public ProcessoEncerrado(String numeroProcesso){
        super(numeroProcesso);
        super.setStatus(StatusEnum.ENCERRADO);
    }
    
    @Override
    public String getStatusString() {
        return "Encerrado";
    }
}
