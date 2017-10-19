/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Julio R. Trindade
 */
public class RolDocumentos {
    private static RolDocumentos rolDocumentos = new RolDocumentos();
    private TipoDocumentoHistorico tipoDocumentoHistorico;
    private TipoDocumentoMatricula tipoDocumentoMatricula;
    private TipoDocumentoCertificado tipoDocumentoCertificado;
    private TipoDocumentoDiploma tipoDocumentoDiploma;
    private TipoDocumentoBoleto tipoDocumentoBoleto;
    
    private RolDocumentos(){
        tipoDocumentoHistorico = new TipoDocumentoHistorico();
        tipoDocumentoMatricula = new TipoDocumentoMatricula();
        tipoDocumentoCertificado = new TipoDocumentoCertificado();
        tipoDocumentoDiploma = new TipoDocumentoDiploma();
        tipoDocumentoBoleto = new TipoDocumentoBoleto();
    }
    
    public static RolDocumentos getInstance(){
        return rolDocumentos;
    }

    public static RolDocumentos getRolDocumentos() {
        return rolDocumentos;
    }

    public static void setRolDocumentos(RolDocumentos rolDocumentos) {
        RolDocumentos.rolDocumentos = rolDocumentos;
    }

    public TipoDocumentoHistorico getTipoDocumentoHistorico() {
        return tipoDocumentoHistorico;
    }

    public void setTipoDocumentoHistorico(TipoDocumentoHistorico tipoDocumentoHistorico) {
        this.tipoDocumentoHistorico = tipoDocumentoHistorico;
    }

    public TipoDocumentoMatricula getTipoDocumentoMatricula() {
        return tipoDocumentoMatricula;
    }

    public void setTipoDocumentoMatricula(TipoDocumentoMatricula tipoDocumentoMatricula) {
        this.tipoDocumentoMatricula = tipoDocumentoMatricula;
    }

    public TipoDocumentoCertificado getTipoDocumentoCertificado() {
        return tipoDocumentoCertificado;
    }

    public void setTipoDocumentoCertificado(TipoDocumentoCertificado tipoDocumentoCertificado) {
        this.tipoDocumentoCertificado = tipoDocumentoCertificado;
    }

    public TipoDocumentoDiploma getTipoDocumentoDiploma() {
        return tipoDocumentoDiploma;
    }

    public void setTipoDocumentoDiploma(TipoDocumentoDiploma tipoDocumentoDiploma) {
        this.tipoDocumentoDiploma = tipoDocumentoDiploma;
    }

    public TipoDocumentoBoleto getTipoDocumentoBoleto() {
        return tipoDocumentoBoleto;
    }

    public void setTipoDocumentoBoleto(TipoDocumentoBoleto tipoDocumentoBoleto) {
        this.tipoDocumentoBoleto = tipoDocumentoBoleto;
    }
    
    
}
