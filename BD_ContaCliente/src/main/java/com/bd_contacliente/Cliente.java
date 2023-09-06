/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd_contacliente;

/**
 *
 * @author Cadilhe
 */
    import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
    import java.util.Date;

public class Cliente {
    private int id;
    private String nome;
    private String endereco;
    private String email;
    private String telefone;

    // Construtores, getters e setters

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }
    private static void inserirCliente(Connection conexao, int id, String nome, String endereco, String email, String telefone) throws SQLException {
        String sql = "INSERT INTO Cliente (ID, Nome, Endereco, Email, Telefone) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, nome);
            stmt.setString(3, endereco);
            stmt.setString(4, email);
            stmt.setString(5, telefone);
            stmt.executeUpdate();
        }
    }
}




