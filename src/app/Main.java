package app;


import model.dao.DaoFactory;
import model.dao.UsuarioDao;
import model.entities.Usuario;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();
        List<Usuario> usuarios;
        System.out.println("Teste1 findAll");
        usuarios = usuarioDao.findAll();
        usuarios.forEach(System.out::println);


    }
}