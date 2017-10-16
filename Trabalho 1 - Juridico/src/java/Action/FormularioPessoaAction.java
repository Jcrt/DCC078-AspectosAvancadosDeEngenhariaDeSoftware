/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Enum.TipoPessoaEnum;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

/**
 *
 * @author Julio R. Trindade
 */
public class FormularioPessoaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            ArrayList<TipoPessoaEnum> tipoPessoa = new ArrayList<>();
            tipoPessoa = TipoPessoaEnum.listaTodos();
            request.setAttribute("tipoPessoaLista", tipoPessoa);
            
            RequestDispatcher rd = request.getRequestDispatcher("Pessoa/Formulario.jsp");
            rd.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(FormularioPessoaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
