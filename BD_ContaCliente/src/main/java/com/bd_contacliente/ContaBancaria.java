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
public class ContaBancaria {
    private int numeroConta;
    private BigDecimal saldo;
    private String tipoConta;
    private int clienteID;

    // Construtores, getters e setters

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }
    private static void inserirContaBancaria(Connection conexao, int numeroConta, BigDecimal saldo, String tipoConta, int clienteID) throws SQLException {
        String sql = "INSERT INTO ContaBancaria (NumeroConta, Saldo, TipoConta, ClienteID) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, numeroConta);
            stmt.setBigDecimal(2, saldo);
            stmt.setString(3, tipoConta);
            stmt.setInt(4, clienteID);
            stmt.executeUpdate();
        }
    }
    
}
