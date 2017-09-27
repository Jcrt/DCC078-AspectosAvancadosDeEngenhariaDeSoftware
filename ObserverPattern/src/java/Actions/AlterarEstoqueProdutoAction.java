/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.ContatoDAO;
import DAO.ProdutoDAO;
import Models.Contato;
import Models.Produto;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julio R. Trindade
 */
public class AlterarEstoqueProdutoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Produto p;
        try {
            int idProduto = Integer.parseInt((String) request.getParameter("idProduto"));
            int estoque = Integer.parseInt((String) request.getParameter("estoque"));
            
            ProdutoDAO pDAO = ProdutoDAO.getInstance();
            ContatoDAO cDAO = ContatoDAO.getInstance();
            
            p = pDAO.ler(idProduto);
            
            List<Contato> c = cDAO.listarObservadorProduto(p);
            
            p.setEstoque(estoque);
            pDAO.alterarEstoque(p);
            
            request.setAttribute("MsgOperacao", "Estoque do produto " + p.getNome() + " alterado com sucesso!");
        } catch (Exception e) {
            request.setAttribute("MsgOperacao", "Erro na alteração do estoque do produto");
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("FrontController?action=ListarProdutos");
        try {
            rd.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(AlterarEstoqueProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
