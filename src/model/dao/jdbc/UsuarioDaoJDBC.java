package model.dao.jdbc;

import db.DbException;
import model.dao.UsuarioDao;
import model.entities.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;

public class UsuarioDaoJDBC implements UsuarioDao {

    private Connection connection;

    public UsuarioDaoJDBC(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void insert(Usuario usuario) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(
                    "INSERT INTO usuarios "
                            + "(nome, email, senha) "
                            + "VALUES "
                            + "(?, ?, ?)");

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(stmt);
        }


    }

    @Override
    public void update(Usuario usuario) {

    }

    @Override
    public void deleteById(Usuario usuario) {

    }

    @Override
    public Usuario findById(Integer id) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.prepareStatement(
                    "SELECT * FROM usuarios "
                    + "WHERE id = ?");

            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Usuario usuario =  new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                return usuario;
            }
            return null;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(stmt);
            DB.closeResultSet(rs);
        }


    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> usuarios = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet set = null;

        try {
            stmt = connection.prepareStatement(
                    "select * from usuarios ");
            try {
                set = stmt.executeQuery();
                while (set.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(set.getInt("id"));
                    usuario.setNome(set.getString("nome"));
                    usuario.setEmail(set.getString("email"));
                    usuario.setSenha(set.getString("senha"));
                    usuarios.add(usuario);
                }
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return usuarios;
    }
}
