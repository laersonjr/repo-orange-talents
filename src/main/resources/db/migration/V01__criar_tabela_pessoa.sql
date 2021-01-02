CREATE TABLE pessoa (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(64) NOT NULL,
	cpf VARCHAR(14) UNIQUE NOT NULL,
	email VARCHAR(64) UNIQUE NOT NULL,
	data_nascimento DATE
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
	INSERT INTO pessoa (nome, cpf, email, data_nascimento) values ('Laerson Castro', '00775627470', 'laersonjr@gmail.com', '2020-12-30');
	INSERT INTO pessoa (nome, cpf, email, data_nascimento) values ('Laerson Castro Novo', '12345678911', 'laersonjr@hotmail.com', '2020-12-30');