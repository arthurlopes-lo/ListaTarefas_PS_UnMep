package dao;

import dto.Tarefa;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Arthur Lopes
 */
public class TarefaDAO {
    
    //Declarando variáveis fora do método para usá-las mais vezes
    Connection conexaoTarefa;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Tarefa> lista_tarefas = new ArrayList<>();
    
    //Método de conexão para o Nova Tarefa (CREATE)
    public void salvarNovaTarefa(Tarefa tarefa_dto){
        
        String sql_salvar = "insert into tarefas (titulo, descricao, stats, prazo) values (?, ?, ?, ?)";
        conexaoTarefa = new ConexaoDAO().conectaBD();
        
        try {
            
            //Usando o pstm para enviar os dados coletados para o BD
            pstm = conexaoTarefa.prepareStatement(sql_salvar);
            pstm.setString(1, tarefa_dto.getTitulo());
            pstm.setString(2, tarefa_dto.getDescricao());
            pstm.setString(3, tarefa_dto.getStatus());
            pstm.setString(4, tarefa_dto.getPrazo());
            
            //Executa pstm
            pstm.execute();
            pstm.close();
            
            JOptionPane.showMessageDialog(null, "Nova Tarefa registrada com sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível registrar a nova tarefa (TarefaDAO metodo salvarNovaTarefa) relatório do erro: "+erro);
        }
        
    }
    
    //Método de conexão para Exibir Tarefa na tabela (READ)
    public ArrayList<Tarefa> listarTarefas(){
    
        String sql_busca = "select id_tarefa, titulo, descricao, stats, prazo from tarefas"; 
        conexaoTarefa = new ConexaoDAO().conectaBD();
        
            try {
                pstm = conexaoTarefa.prepareStatement(sql_busca);
                rs = pstm.executeQuery();
                
                while(rs.next()){
                    Tarefa tarefa_dto = new Tarefa();
                    tarefa_dto.setId_tarefa(rs.getInt("id_tarefa"));
                    tarefa_dto.setTitulo(rs.getString("titulo"));
                    tarefa_dto.setDescricao(rs.getString("descricao"));
                    tarefa_dto.setStatus(rs.getString("stats"));
                    tarefa_dto.setPrazo(rs.getString("prazo"));   
                    
                    lista_tarefas.add(tarefa_dto);
                }
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null,"Não foi possível listar as tarefas do BD (ClasseDAO metodo buscarTarefas) :" +erro);
            }
            return lista_tarefas; 
}
    
    //Método de conexão para Editar uma Tarefa (UPDATE)
    public void editarTarefa(Tarefa edita_tarefa){
        
        String sql_editar = "update tarefas set titulo = ?, descricao = ?, stats = ?, prazo = ? where id_tarefa = ?";
        conexaoTarefa = new ConexaoDAO().conectaBD();
        
        try {          
            //Usando o pstm para enviar os dados coletados para o BD
            pstm = conexaoTarefa.prepareStatement(sql_editar);
            pstm.setString(1, edita_tarefa.getTitulo());
            pstm.setString(2, edita_tarefa.getDescricao());
            pstm.setString(3, edita_tarefa.getStatus());
            pstm.setString(4, edita_tarefa.getPrazo());
            pstm.setInt(5, edita_tarefa.getId_tarefa());
            
            //Executa pstm
            pstm.execute();
            pstm.close();
            
            JOptionPane.showMessageDialog(null, "A Tarefa foi editada com sucesso!");           
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível editar a tarefa (TarefaDAO metodo editarTarefa) relatório do erro: "+erro);
        }       
    }
    
    //Método de conexão para Deletar uma Tarefa na (DELETE)
    public void deletarTarefa(Tarefa deleta_tarefa){
        
        String sql_deletar = "delete from tarefas where id_tarefa = ?";
        conexaoTarefa = new ConexaoDAO().conectaBD();
        
        try {          
            //Usando o pstm para enviar os dados coletados para o BD
            pstm = conexaoTarefa.prepareStatement(sql_deletar);
            pstm.setInt(1, deleta_tarefa.getId_tarefa());
            
            
            //Executa pstm
            pstm.execute();
            pstm.close();
            
            JOptionPane.showMessageDialog(null, "A Tarefa foi deletada com sucesso!");           
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir a tarefa (TarefaDAO metodo deletarTarefa) relatório do erro: "+erro);
        }       
    }   
    
    //Método de conexão para listar apenas as tarefas 'Pendentes' (QUERY)
    public ArrayList<Tarefa> listarPendentes(){
    
        String sql_busca = "select id_tarefa, titulo, descricao, stats, prazo from tarefas where stats = 'Pendente'"; 
        conexaoTarefa = new ConexaoDAO().conectaBD();
        
            try {
                pstm = conexaoTarefa.prepareStatement(sql_busca);
                rs = pstm.executeQuery();
                
                while(rs.next()){
                    Tarefa tarefa_dto = new Tarefa();
                    tarefa_dto.setId_tarefa(rs.getInt("id_tarefa"));
                    tarefa_dto.setTitulo(rs.getString("titulo"));
                    tarefa_dto.setDescricao(rs.getString("descricao"));
                    tarefa_dto.setStatus(rs.getString("stats"));
                    tarefa_dto.setPrazo(rs.getString("prazo"));   
                    
                    lista_tarefas.add(tarefa_dto);
                }
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null,"Não foi possível listar as tarefas do BD (ClasseDAO metodo listarPendentes) :" +erro);
            }
            return lista_tarefas; 
}
    
    //Método de conexão para listar apenas as tarefas em 'Executando' (QUERY)
    public ArrayList<Tarefa> listarExecutando(){
    
        String sql_busca = "select id_tarefa, titulo, descricao, stats, prazo from tarefas where stats = 'Executando'"; 
        conexaoTarefa = new ConexaoDAO().conectaBD();
        
            try {
                pstm = conexaoTarefa.prepareStatement(sql_busca);
                rs = pstm.executeQuery();
                
                while(rs.next()){
                    Tarefa tarefa_dto = new Tarefa();
                    tarefa_dto.setId_tarefa(rs.getInt("id_tarefa"));
                    tarefa_dto.setTitulo(rs.getString("titulo"));
                    tarefa_dto.setDescricao(rs.getString("descricao"));
                    tarefa_dto.setStatus(rs.getString("stats"));
                    tarefa_dto.setPrazo(rs.getString("prazo"));   
                    
                    lista_tarefas.add(tarefa_dto);
                }
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null,"Não foi possível listar as tarefas do BD (ClasseDAO metodo listarExecutando) :" +erro);
            }
            return lista_tarefas; 
}
    
    //Método de conexão para listar apenas as tarefas 'Concluidas' (QUERY)
    public ArrayList<Tarefa> listarConcluido(){
    
        String sql_busca = "select id_tarefa, titulo, descricao, stats, prazo from tarefas where stats = 'Concluida'"; 
        conexaoTarefa = new ConexaoDAO().conectaBD();
        
            try {
                pstm = conexaoTarefa.prepareStatement(sql_busca);
                rs = pstm.executeQuery();
                
                while(rs.next()){
                    Tarefa tarefa_dto = new Tarefa();
                    tarefa_dto.setId_tarefa(rs.getInt("id_tarefa"));
                    tarefa_dto.setTitulo(rs.getString("titulo"));
                    tarefa_dto.setDescricao(rs.getString("descricao"));
                    tarefa_dto.setStatus(rs.getString("stats"));
                    tarefa_dto.setPrazo(rs.getString("prazo"));   
                    
                    lista_tarefas.add(tarefa_dto);
                }
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null,"Não foi possível listar as tarefas do BD (ClasseDAO metodo listarConcluido) :" +erro);
            }
            return lista_tarefas; 
}  
}
