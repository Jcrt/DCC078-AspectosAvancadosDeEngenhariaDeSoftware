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
public class ProcessoArquivado extends Processo { 
    
    public ProcessoArquivado(){
        super();
        super.setStatus(StatusEnum.ARQUIVADO);
    }
    
    public ProcessoArquivado(String numeroProcesso){
        super(numeroProcesso);
        super.setStatus(StatusEnum.ARQUIVADO);
    }
    
    @Override
    public String getStatusString() {
        return "Arquivado";
    }
}
