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
public interface TipoProcessoEstado {
    public String getEstado();
    public String ativo(TipoProcesso tipo);
    public String arquivado(TipoProcesso tipo);
    public String baixaProvisoria(TipoProcesso tipo);
    public String encerrado(TipoProcesso tipo);
}
