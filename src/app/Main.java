package app;


import model.dao.DaoFactory;
import model.dao.UsuarioDao;



import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {

        UsuarioDao usuario = DaoFactory.createUsuarioDao();
        System.out.println(usuario.findById(2));




    }
}