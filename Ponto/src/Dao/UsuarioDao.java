package Dao;

import Dto.UsuarioDTO;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tecnico.daniel
 */
public class UsuarioDao {

    Connection conn;

    public ResultSet autenticacaoUsuario(UsuarioDTO objUsuarioDTO) throws SQLException {
        conn = new conexãoDao().conectaBD();

        try {

            String sql = "select * from usuario where nome_usuario = ? and senha_usuario = MD5(?)";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, objUsuarioDTO.getNome_usuario());
            pstm.setString(2, objUsuarioDTO.getSenha_usuario());

            ResultSet rs = pstm.executeQuery();
             return rs;
      
        } catch (SQLServerException erro) {
            JOptionPane.showMessageDialog(null, "Ponto. com erro no 'UsuarioDAO', erro: " + erro);//mensagem de erro no arquivo
            return null;
        }
    } // calss que irá fazer a verificação na tabela do mysql e verificar se o usuario corresponde com a senha

    
    
}
