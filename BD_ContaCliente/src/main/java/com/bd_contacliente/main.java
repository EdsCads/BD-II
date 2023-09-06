package com.bd_contacliente;
/*
 * @author Cadilhe
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.util.Date;

public class main {

    public static void main(String[] args) {

        ConexaoBD conexao = new ConexaoBD();
        try{conexao.abrirConexao();}catch(SQLException e){}
        
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

        
        try{conexao.fecharConexao();}catch(SQLException e){}
    
    

    }
}