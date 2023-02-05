package app;


import model.dao.DaoFactory;
import model.dao.UsuarioDao;
import model.entities.Usuario;


import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner sc =  new Scanner(System.in);
        Usuario usuario5 = new Usuario(5, "Antoio Jośe", "antonio@gmail.com","admin");

        UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();

        System.out.println("\n******Teste1 findById*******");
        Usuario usuario = usuarioDao.findById(2);
        System.out.println(usuario);

        System.out.println();

        System.out.println("\n******Teste2 findAll*******");
        List<Usuario> usuarios = usuarioDao.findAll();
        for (Usuario user: usuarios) {
            System.out.println(user);
        }

        /*
        System.out.println("******Teste update*******");
        usuario = usuarioDao.findById(6);
        usuario.setId(5);
        usuarioDao.update(usuario);
        System.out.println("Update completo");*/

        /*
        System.out.println("\n*****Teste deleById*******");
        System.out.print("Entre com o id para excluir: ");
        int id =  sc.nextInt();
        usuarioDao.deleteById(id);
        System.out.println("Delete completo");*/
        /*
        System.out.println("\n****Teste Insert*******");
        usuarioDao.insert(usuario5);
        System.out.println("Insert concluido");*/

        sc.close();









    }
}