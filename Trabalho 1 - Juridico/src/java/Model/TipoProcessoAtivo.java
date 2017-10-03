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
public class TipoProcessoAtivo implements TipoProcessoEstado {

    @Override
    public String getEstado() {
        return "Ativo";
    }

    @Override
    public String ativo(TipoProcesso tipo) {
        return "Processo está ativo!";
    }

    @Override
    public String arquivado(TipoProcesso tipo) {
        tipo.setEstado(new TipoProcessoArquivado());
        return "Processo está arquivado agora";
    }

    @Override
    public String baixaProvisoria(TipoProcesso tipo) {
        tipo.setEstado(new TipoProcessoBaixaProvisória());
        return "Processo atualmente com baixa provisória";
    }

    @Override
    public String encerrado(TipoProcesso tipo) {
        tipo.setEstado(new TipoProcessoEncerrado());
        return "Processo encerrado judicialmente.";
    }

}
