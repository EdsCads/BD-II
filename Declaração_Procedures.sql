DELIMITER //

CREATE PROCEDURE RealizarDeposito(
    IN p_NumeroConta INT,
    IN p_ValorDeposito DECIMAL(10, 2)
)
BEGIN
    DECLARE v_TipoConta VARCHAR(20);
    
    -- Obter o tipo de conta (super)
    SELECT TipoConta INTO v_TipoConta
    FROM ContaBancaria
    WHERE NumeroConta = p_NumeroConta;
    
    -- Atualizar o saldo na conta bancária (super)
    UPDATE ContaBancaria
    SET Saldo = Saldo + p_ValorDeposito
    WHERE NumeroConta = p_NumeroConta;
    
    -- Inserir um registro na entidade derivada apropriada
    IF v_TipoConta = 'Conta Corrente' THEN
        INSERT INTO ContaCorrente (NumeroConta, TaxaManutencao)
        VALUES (p_NumeroConta, 0.0); -- Definir a taxa de manutenção para 0 no caso de depósito
    ELSEIF v_TipoConta = 'Conta Poupanca' THEN
        INSERT INTO ContaPoupanca (NumeroConta, TaxaJuros)
        VALUES (p_NumeroConta, 0.0); -- Definir a taxa de juros para 0 no caso de depósito
    END IF;
    
    -- Confirmar a transação
    COMMIT;
END //

DELIMITER ;
