DELIMITER //

CREATE FUNCTION CalcularSaldoTotalCliente(p_ClienteID INT) RETURNS DECIMAL(10, 2)
BEGIN
    DECLARE v_SaldoTotal DECIMAL(10, 2);

    SELECT SUM(Saldo) INTO v_SaldoTotal
    FROM ContaBancaria
    WHERE ClienteID = p_ClienteID;

    RETURN v_SaldoTotal;
END //

DELIMITER ;

DELIMITER //

CREATE FUNCTION ClientePossuiCartaoCredito(p_ClienteID INT) RETURNS BOOLEAN
BEGIN
    DECLARE v_PossuiCartao BOOLEAN;

    SELECT EXISTS (
        SELECT 1
        FROM CartaoCredito
        WHERE ClienteID = p_ClienteID
    ) INTO v_PossuiCartao;

    RETURN v_PossuiCartao;
END //

DELIMITER ;

DELIMITER //

CREATE TRIGGER GarantirCartaoCreditoParaCliente
BEFORE INSERT ON Cliente
FOR EACH ROW
BEGIN
    IF NEW.ID NOT IN (
        SELECT DISTINCT ClienteID
        FROM CartaoCredito
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cada cliente deve ter pelo menos um cartão de crédito.';
    END IF;
END //

DELIMITER ;
