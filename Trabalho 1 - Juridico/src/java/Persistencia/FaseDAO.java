/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Enum.TipoEnvolvimentoEnum;
import Interface.IDAO;
import Model.Fase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julio R. Trindade
 */
public class FaseDAO implements IDAO<Fase> {
    
    private static FaseDAO instance;
    
    private FaseDAO(){
        
    }
    
    public static FaseDAO getInstance(){
        if(instance == null)
            instance = new FaseDAO();
        return instance;
    }

    @Override
    public void salvar(Fase model) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "INSERT INTO fase (descricao, tipoEnvolvimentoEnum) VALUES (?,?);";

            ps = conn.prepareStatement(sql);
            ps.setString(1, model.getDescricao());
            ps.setInt(2, model.getTipoResponsavel().getValor());

            ps.execute();

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, ps);
        }
    }

    @Override
    public void atualizar(Fase objeto) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Fase> listar() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "SELECT id, descricao, tipoEnvolvimentoEnum FROM fase ORDER BY descricao";
        ArrayList<Fase> fases = new ArrayList<>();
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                fases.add(
                    new Fase(
                            rs.getInt("id"),
                            rs.getString("descricao"),
                            TipoEnvolvimentoEnum.getEnumByInt(rs.getInt("tipoEnvolvimentoEnum"))
                    )
                );
            }
        } catch (ClassNotFoundException | SQLException e) {
            closeResources(conn, ps);
            throw e;
        }
        return fases;
    }

    @Override
    public Fase getById(int id) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "SELECT id, descricao, tipoEnvolvimentoEnum "
                + "FROM fase "
                + "WHERE id = ?";
        Fase fase = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                fase = new Fase(
                        rs.getInt("id"),
                        rs.getString("descricao"),
                        TipoEnvolvimentoEnum.getEnumByInt(rs.getInt("tipoEnvolvimentoEnum"))
                );
            }
        } catch (ClassNotFoundException | SQLException e) {
            closeResources(conn, ps);
        }
        return fase;
    }
    
    private void closeResources(Connection conn, Statement st) {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (SQLException e) {

        }
    }
}
