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
public class FuncionarioReitor extends Funcionario {
    public FuncionarioReitor(Funcionario superior){
        listaDocumentos.add(RolDocumentos.getInstance().getTipoDocumentoDiploma());
        setFuncionarioSuperior(superior);
    }

    @Override
    public String getDescricaoCargo() {
        return "Reitor";
    }
}
