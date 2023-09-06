/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd_contacliente;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Cadilhe
 */
public class CartaoCredito {
    private int numeroCartao;
    private BigDecimal limiteCredito;
    private Date dataVencimento;
    private int clienteID;

    // Construtores, getters e setters

    public int getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(int numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public BigDecimal getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(BigDecimal limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }
    private static void inserirCartaoCredito(Connection conexao, int numeroCartao, BigDecimal limiteCredito, Date dataVencimento, int clienteID) throws SQLException {
        String sql = "INSERT INTO CartaoCredito (NumeroCartao, LimiteCredito, DataVencimento, ClienteID) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, numeroCartao);
            stmt.setBigDecimal(2, limiteCredito);
            stmt.setDate(3, new java.sql.Date(dataVencimento.getTime()));
            stmt.setInt(4, clienteID);
            stmt.executeUpdate();
        }
    }
}
