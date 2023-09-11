package com.bd_contacliente;
/*
 * @author Cadilhe
 */

import java.sql.SQLException;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class main {
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    public static void main(String[] args)throws Exception{
 // Informações de conexão com o banco de dados
        String jdbcUrl = "jdbc:mysql://localhost:3306/cartaocredito"; // Altere para o nome do seu banco de dados
        String usuario = "root"; // Altere para o seu nome de usuário
        String senha = ""; // Altere para a sua senha
        Class.forName(DRIVER_CLASS);
        try (Connection conexao = DriverManager.getConnection(jdbcUrl, usuario, senha)) {
            // Chamar o procedimento armazenado RealizarDeposito
            chamarProcedimentoDeposito(conexao, 1001, BigDecimal.valueOf(500.00));
        } catch (SQLException e) {
            e.printStackTrace();
        }    
    }


    private static void chamarProcedimentoDeposito(Connection conexao, int numeroConta, BigDecimal valorDeposito) throws SQLException {
        // Preparar a chamada para o procedimento
        String sql = "{call RealizarDeposito(?, ?)}";
        try (CallableStatement stmt = conexao.prepareCall(sql)) {
            stmt.setInt(1, numeroConta);
            stmt.setBigDecimal(2, valorDeposito);
            stmt.execute();
        }
    }

}