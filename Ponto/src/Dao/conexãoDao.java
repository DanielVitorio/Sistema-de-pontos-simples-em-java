package Dao;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tecnico.daniel
 */
public class conexãoDao {

    public Connection conectaBD() {

        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost/usuarios?user=usuario&password=senha";//aqui você irá colocar o usuario e senha do banco de dados
            conn = DriverManager.getConnection(url);

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "erro na conexão com o banco de dados, erro: " + erro.getMessage());//mensagem de erro no arquivo
        }
        return conn;
    } //conjunto que irá iniciar a conexão com o banco de dados e se der falha irá retornar um erro
}
