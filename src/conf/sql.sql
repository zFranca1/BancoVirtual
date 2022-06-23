Select * FROM usuario;
select * from agencia;
select * from conta;

INSERT INTO `db_banco`.`agencia` (`codigo`, `nome`, `numero`) VALUES ('1', 'banco do brasil', '12345');
INSERT INTO `db_banco`.`agencia` (`codigo`, `nome`, `numero`) VALUES ('2', 'santander', '54321');
INSERT INTO `db_banco`.`agencia` (`codigo`, `nome`, `numero`) VALUES ('3', 'fleeca', '11122');



INSERT INTO `db_banco`.`usuario` (`codigo`, `tipo`, `cpf`, `email`, `nome`, `agencia_codigo`, `senha`) VALUES ('1', 'F', '490.476.518-47', 'joao@franca.com', 'joao pedro', 1, '123');
INSERT INTO `db_banco`.`usuario` (`codigo`, `tipo`, `cpf`, `email`, `nome`, `agencia_codigo`, `senha`) VALUES ('2', 'C', '123.321.111-22', 'thiago@thiago.com', 'thiago', '2', null);
INSERT INTO `db_banco`.`usuario` (`codigo`, `tipo`, `cpf`, `email`, `nome`, `agencia_codigo`, `senha`) VALUES ('3', 'C', '333.222.111-22', 'leandro@leandro.com', 'leandro', '3', null);
INSERT INTO `db_banco`.`usuario` (`codigo`, `tipo`, `cpf`, `email`, `nome`, `agencia_codigo`, `senha`) VALUES ('4', 'C', '222.222.222-11', 'igor@igor.com', 'Igor', '3', null);


INSERT INTO `db_banco`.`conta` (`codigo`, `tipo`, `numero`, `saldo`, `senha`, `senha_confirmacao`, `agencia_codigo`, `cliente_codigo`) VALUES ('1', 'C', '123456789', '300', '123', '221193', '1', '3');
