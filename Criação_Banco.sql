CREATE DATABASE IF NOT EXISTS cartaoCredito;
USE cartaoCredito;
-- Criação da tabela Cliente
CREATE TABLE Cliente (
    ID INT PRIMARY KEY,
    Nome VARCHAR(255),
    Endereco VARCHAR(255),
    Email VARCHAR(255),
    Telefone VARCHAR(20)
);

-- Criação da tabela ContaBancaria
CREATE TABLE ContaBancaria (
    NumeroConta INT PRIMARY KEY,
    Saldo DECIMAL(10, 2),
    TipoConta VARCHAR(20),
    ClienteID INT,
    FOREIGN KEY (ClienteID) REFERENCES Cliente(ID)
);

-- Criação da tabela CartaoCredito
CREATE TABLE CartaoCredito (
    NumeroCartao INT PRIMARY KEY,
    LimiteCredito DECIMAL(10, 2),
    DataVencimento DATE
);

-- Criação da relação de especialização: ContaCorrente
CREATE TABLE ContaCorrente (
    NumeroConta INT PRIMARY KEY,
    TaxaManutencao DECIMAL(5, 2),
    FOREIGN KEY (NumeroConta) REFERENCES ContaBancaria(NumeroConta)
);

-- Criação da relação de especialização: ContaPoupanca
CREATE TABLE ContaPoupanca (
    NumeroConta INT PRIMARY KEY,
    TaxaJuros DECIMAL(5, 2),
    FOREIGN KEY (NumeroConta) REFERENCES ContaBancaria(NumeroConta)
);
