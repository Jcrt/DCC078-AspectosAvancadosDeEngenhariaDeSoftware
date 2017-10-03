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
public class TipoProcessoArquivado implements TipoProcessoEstado {

    @Override
    public String getEstado() {
        return "Arquivado";
    }

    @Override
    public String ativo(TipoProcesso tipo) {
        return "Processo já arquivado. Desculpe-nos o transtorno.";
    }

    @Override
    public String arquivado(TipoProcesso tipo) {
        return "Processo arquivado";
    }

    @Override
    public String baixaProvisoria(TipoProcesso tipo) {
        return "Processo já arquivado. Desculpe-nos o transtorno.";
    }

    @Override
    public String encerrado(TipoProcesso tipo) {
        return "Processo já arquivado. Desculpe-nos o transtorno.";
    }

}
