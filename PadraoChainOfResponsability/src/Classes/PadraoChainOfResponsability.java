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
public class PadraoChainOfResponsability {
    public static void main(String [] args){
        
        FuncionarioReitor reitor = new FuncionarioReitor(null);
        FuncionarioDiretor diretor = new FuncionarioDiretor(reitor);
        FuncionarioCoordenador coordenador = new FuncionarioCoordenador(diretor);
        FuncionarioSecretaria secretaria = new FuncionarioSecretaria(coordenador);
        
        System.out.println(
                secretaria.assinarDocumento(new Documento(RolDocumentos.getInstance().getTipoDocumentoHistorico())));
        System.out.println(
                secretaria.assinarDocumento(new Documento(RolDocumentos.getInstance().getTipoDocumentoMatricula())));
        System.out.println(
                secretaria.assinarDocumento(new Documento(RolDocumentos.getInstance().getTipoDocumentoCertificado())));
        System.out.println(
                secretaria.assinarDocumento(new Documento(RolDocumentos.getInstance().getTipoDocumentoDiploma())));
        System.out.println(
                secretaria.assinarDocumento(new Documento(RolDocumentos.getInstance().getTipoDocumentoBoleto())));
        
    }
}
