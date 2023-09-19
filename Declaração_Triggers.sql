DELIMITER //
CREATE FUNCTION InserirCliente(
    p_Nome VARCHAR(255),
    p_Endereco VARCHAR(255),
    p_Email VARCHAR(255),
    p_Telefone VARCHAR(20)
)
RETURNS INT
BEGIN
    INSERT INTO Cliente (Nome, Endereco, Email, Telefone)
    VALUES (p_Nome, p_Endereco, p_Email, p_Telefone);
    
    RETURN LAST_INSERT_ID();
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