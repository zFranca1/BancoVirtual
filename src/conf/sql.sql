Select * FROM usuario;
select * from agencia;

INSERT INTO `db_banco`.`agencia` (`codigo`, `nome`, `numero`) VALUES ('1', 'banco do brasil', '12345');
INSERT INTO `db_banco`.`agencia` (`codigo`, `nome`, `numero`) VALUES ('2', 'santander', '54321');
INSERT INTO `db_banco`.`agencia` (`codigo`, `nome`, `numero`) VALUES ('3', 'fleeca', '11122');



INSERT INTO `db_banco`.`usuario` (`codigo`, `tipo`, `cpf`, `email`, `nome`, `agencia_codigo`, `senha`) VALUES ('1', 'F', '490.476.518-47', 'joao@franca.com', 'joao pedro', 1, '123');
