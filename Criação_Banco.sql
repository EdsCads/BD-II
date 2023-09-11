CREATE DATABASE IF NOT EXISTS cartaoCredito;
use cartaoCredito;
         
-- Criação da tabela Cliente
CREATE TABLE Cliente (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(255),
    Endereco VARCHAR(255),
    Email VARCHAR(255),
    Telefone VARCHAR(20)
);

-- Criação da tabela ContaBancaria
CREATE TABLE ContaBancaria (
    NumeroConta INT PRIMARY KEY AUTO_INCREMENT,
    Saldo DECIMAL(10, 2),
    TipoConta VARCHAR(20),
    ClienteID INT,
    FOREIGN KEY (ClienteID) REFERENCES Cliente(ID)
);

-- Criação da tabela CartaoCredito
CREATE TABLE CartaoCredito (
    NumeroCartao INT PRIMARY KEY AUTO_INCREMENT,
    LimiteCredito DECIMAL(10, 2),
    DataVencimento DATE,
    ClienteID INT,
    FOREIGN KEY (ClienteID) REFERENCES Cliente(ID)
);

-- Criação da relação de especialização: ContaCorrente
CREATE TABLE ContaCorrente (
    NumeroConta INT PRIMARY KEY AUTO_INCREMENT,
    TaxaManutencao DECIMAL(5, 2),
    FOREIGN KEY (NumeroConta) REFERENCES ContaBancaria(NumeroConta)
);

-- Criação da relação de especialização: ContaPoupanca
CREATE TABLE ContaPoupanca (
    NumeroConta INT PRIMARY KEY AUTO_INCREMENT,
    TaxaJuros DECIMAL(5, 2),
    FOREIGN KEY (NumeroConta) REFERENCES ContaBancaria(NumeroConta)
);
