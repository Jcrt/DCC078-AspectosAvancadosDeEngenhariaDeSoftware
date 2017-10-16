/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author thassya
 */
public class ProcessoArquivado extends Processo { 
    
     public ProcessoArquivado(){
        
    }
    
    public ProcessoArquivado(String numeroProcesso){
        super(numeroProcesso);
    }
    
    @Override
    public String getStatusString() {
        return "Arquivado";
    }
}
