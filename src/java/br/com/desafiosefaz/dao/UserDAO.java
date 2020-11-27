/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.desafiosefaz.dao;

import br.com.desafiosefaz.jdbc.ConnectionFactory;
import br.com.desafiosefaz.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author eudes
 */
public class UserDAO {    
    
    private Connection con;
        
    public UserDAO(){
        this.con = new ConnectionFactory().getConnetion();
    }
    
    
    // Cadastra User
    public void cadastraUser(User obj){
        try {
            String sql = "inset into tb_user (nome,email,telefone,celular,tipo,senha,ddd) "
                    + "   values(?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,obj.getNome());
            stmt.setString(2,obj.getEmail());
            stmt.setString(3,obj.getTelefone());
            stmt.setString(4,obj.getCelular());
            stmt.setString(5,obj.getTipo());
            stmt.setString(7,obj.getSenha());
            stmt.setInt(7,obj.getDDD());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Cadastrado");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Erro: " + erro);
        }
          
    }
    // Alterar User
    public void alterarUser(User obj){
        
        try {
            String sql = "update tb_user nome=?,email=?,telefone=?,celular=?,tipo=?,senha=?,ddd=? where email=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,obj.getNome());
            stmt.setString(2,obj.getEmail());
            stmt.setString(3,obj.getTelefone());
            stmt.setString(4,obj.getCelular());
            stmt.setString(5,obj.getTipo());
            stmt.setString(7,obj.getSenha());
            stmt.setInt(7,obj.getDDD());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Alterado");
        } catch (Exception e) {
        }
    }
    // Excluir User
    public void excluirUser(User obj){
        
         try {
            String sql = "delet from tb_user nome=?,email=?,telefone=?,celular=?,tipo=?,senha=?,ddd=? where email=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,obj.getNome());
            stmt.setString(2,obj.getEmail());
            stmt.setString(3,obj.getTelefone());
            stmt.setString(4,obj.getCelular());
            stmt.setString(5,obj.getTipo());
            stmt.setString(7,obj.getSenha());
            stmt.setInt(7,obj.getDDD());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Excluido");
        } catch (Exception e) {
        }
    }
    // Listar User
    public List<User> listarUser(){
        try {
            List<User> lista = new ArrayList<>();
            String sql = "select* from tb_user";
            PreparedStatement stmt= con.prepareCall(sql);
            ResultSet rs= stmt.executeQuery();
            
            while(rs.next()){
                User obj = new User();
                obj.setNome(rs.getString("nome"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setTipo(rs.getString("tipo"));
                obj.setSenha(rs.getString("senha"));
                obj.setDDD(rs.getInt("ddd"));
                
                lista.add(obj);         
                
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro"+e);
            return null;
        }
 
    }
}
