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

drop trigger if exists GarantirCartaoCreditoParaCliente;
DELIMITER //

CREATE TRIGGER GarantirCartaoCreditoParaCliente
AFTER INSERT 
ON Cliente FOR EACH ROW
BEGIN
	DECLARE IDCLI INT;
    DECLARE DATAVENC DATE;
    DECLARE LIMITE DECIMAL(10,2);
    IF NEW.ID NOT IN (
        SELECT DISTINCT ClienteID
        FROM cartaocredito
    ) THEN
		SET IDCLI = NEW.ID;
        SET DATAVENC = date_add(curdate(),INTERVAL 16 MONTH);
        SET LIMITE = 500.00;
                
        INSERT INTO cartaocredito 
        VALUES ("",LIMITE,DATAVENC,IDCLI);
    END IF;

END //

DELIMITER ;