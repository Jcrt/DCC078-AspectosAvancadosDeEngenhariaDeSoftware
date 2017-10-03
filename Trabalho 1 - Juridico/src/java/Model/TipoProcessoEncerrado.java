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
public class TipoProcessoEncerrado implements TipoProcessoEstado {

    @Override
    public String getEstado() {
        return "Encerrado";
    }

    
    @Override
    public String ativo(TipoProcesso tipo) {
        return "Processo está encerrado!";
    }

    @Override
    public String arquivado(TipoProcesso tipo) {
        tipo.setEstado(new TipoProcessoArquivado());
        return "Processo está arquivado agora";
    }

    @Override
    public String baixaProvisoria(TipoProcesso tipo) {
        return "Este processo já foi encerrado!";
    }

    @Override
    public String encerrado(TipoProcesso tipo) {
        return "Processo encerrado.";
    }

}
