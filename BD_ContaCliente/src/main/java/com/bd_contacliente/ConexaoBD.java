/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd_contacliente;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Cadilhe
 */
public class ConexaoBD {
    // Informações de conexão com o banco de dados
        String jdbcUrl = "jdbc:mysql://localhost/cartaoCredito"; // Altere para o nome do seu banco de dados
        String usuario = "root"; // Altere para o seu nome de usuário
        String senha = "123456"; // Altere para a sua senha
        Connection conexao;
    
     public void abrirConexao()throws SQLException{
         try{
              conexao = DriverManager.getConnection(jdbcUrl, usuario, senha);
         }catch(SQLException e){
            e.printStackTrace(); 
         }
     }
    
     public void fecharConexao()throws SQLException{
         try{
             conexao.close();
         }catch(SQLException e){
            e.printStackTrace();   
         }
     }
      
}
