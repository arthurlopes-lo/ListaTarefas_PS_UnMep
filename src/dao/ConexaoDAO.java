package dao;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Arthur Lopes
 */

public class ConexaoDAO {
    
    //Método do tipo Connection para fazer a conexão com o BD
    public Connection conectaBD(){         
        Connection conexao = null; //Variável conexao do tipo connection        
        try {
            
            //Armazenei toda a informação do banco e base de dados em uma só variável chamada "url"
            String url = "jdbc:mysql://localhost:3306/lista_tarefas?user=root&password="; 
            
            //Acessar o driver manager e passar as informações em "url" 
            conexao = DriverManager.getConnection(url); 
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Falha na conexão com o banco de dados (Classe ConexaoDAO)! Relatório do erro: " +erro.getMessage());           
        } 
        return conexao;
    }     
}