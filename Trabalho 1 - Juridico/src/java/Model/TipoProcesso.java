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
public class TipoProcesso {
 
    
    private TipoProcessoEstado estado;

    public TipoProcesso() {
        this.estado = new TipoProcessoAtivo();
    }

    public TipoProcessoEstado getEstado() {
        return estado;
    }

    public void setEstado(TipoProcessoEstado estado) {
        this.estado = estado;
    }

    public String ativo() {
        return estado.ativo(this);
    }

    public String arquivado() {
        return estado.arquivado(this);
    }

    public String baixaProvisoria() {
        return estado.baixaProvisoria(this);
    }

    public String encerrado() {
        return estado.encerrado(this);
    }
}
