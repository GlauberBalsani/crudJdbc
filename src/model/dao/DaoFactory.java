package model.dao;

import db.DB;
import model.dao.jdbc.UsuarioDaoJDBC;

import java.sql.SQLException;

public class DaoFactory {
    public static UsuarioDao createUsuarioDao() throws SQLException {
        return new UsuarioDaoJDBC(DB.getConnection());
    }
}
