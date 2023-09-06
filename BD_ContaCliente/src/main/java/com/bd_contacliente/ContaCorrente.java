/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd_contacliente;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Cadilhe
 */
public class ContaCorrente {

    private int numeroConta;
    private BigDecimal taxaManutencao;

    // Construtores, getters e setters

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public BigDecimal getTaxaManutencao() {
        return taxaManutencao;
    }

    public void setTaxaManutencao(BigDecimal taxaManutencao) {
        this.taxaManutencao = taxaManutencao;
    }
    
    private static void inserirContaCorrente(Connection conexao, int numeroConta, BigDecimal taxaManutencao) throws SQLException {
        String sql = "INSERT INTO ContaCorrente (NumeroConta, TaxaManutencao) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, numeroConta);
            stmt.setBigDecimal(2, taxaManutencao);
            stmt.executeUpdate();
        }
    }
}
