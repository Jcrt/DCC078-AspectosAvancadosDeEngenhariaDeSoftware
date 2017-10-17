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
public class ProcessoBaixaProvisória extends Processo {
    
    public ProcessoBaixaProvisória(){
        super();
        super.setStatus(StatusEnum.BAIXAPROVISORIA);
    }
    
    public ProcessoBaixaProvisória(String numeroProcesso){
        super(numeroProcesso);
        super.setStatus(StatusEnum.BAIXAPROVISORIA);
    }
    
    @Override
    public String getStatusString() {
        return "Baixa Provisória";
    }
}
