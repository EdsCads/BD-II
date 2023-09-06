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
public class ContaPoupanca {
    private int numeroConta;
    private BigDecimal taxaJuros;

    // Construtores, getters e setters

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public BigDecimal getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(BigDecimal taxaJuros) {
        this.taxaJuros = taxaJuros;
    }
    private static void inserirContaPoupanca(Connection conexao, int numeroConta, BigDecimal taxaJuros) throws SQLException {
        String sql = "INSERT INTO ContaPoupanca (NumeroConta, TaxaJuros) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, numeroConta);
            stmt.setBigDecimal(2, taxaJuros);
            stmt.executeUpdate();
        }
    }
}

