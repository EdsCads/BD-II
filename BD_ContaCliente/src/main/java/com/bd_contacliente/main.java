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

<<<<<<< HEAD
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
=======
    public static void main(String[] args) {

        // Criar um cliente
        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNome("João da Silva");
        cliente.setEndereco("Rua Principal, 123");
        cliente.setEmail("joao@example.com");
        cliente.setTelefone("123-456-7890");

        // Criar uma conta bancária para o cliente
        ContaBancaria contaBancaria = new ContaBancaria();
        contaBancaria.setNumeroConta(1001);
        contaBancaria.setSaldo(BigDecimal.valueOf(1000.00));
        contaBancaria.setTipoConta("Corrente");
        contaBancaria.setClienteID(cliente.getId());

        // Criar um cartão de crédito para o cliente
        CartaoCredito cartaoCredito = new CartaoCredito();
        cartaoCredito.setNumeroCartao(123456789);
        cartaoCredito.setLimiteCredito(BigDecimal.valueOf(5000.00));
        cartaoCredito.setDataVencimento(new Date());
        cartaoCredito.setClienteID(cliente.getId());

        // Criar uma conta corrente associada à conta bancária
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setNumeroConta(contaBancaria.getNumeroConta());
        contaCorrente.setTaxaManutencao(BigDecimal.valueOf(10.00));

        // Criar uma conta poupança associada à conta bancária
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setNumeroConta(contaBancaria.getNumeroConta());
        contaPoupanca.setTaxaJuros(BigDecimal.valueOf(0.03)); // 3% de taxa de juros
        
        ConexaoBD conexao = new ConexaoBD();
        try{conexao.abrirConexao();}catch(SQLException e){}
        
            conexao.conexao.
                
        try{conexao.fecharConexao();}catch(SQLException e){}
    
    

>>>>>>> 57a7adf2d9a5c1c9fd33c29571b3f0c18f0731a8
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