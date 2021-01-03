CREATE TABLE pessoa (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(64) NOT NULL,
	cpf VARCHAR(11) UNIQUE NOT NULL,
	email VARCHAR(64) UNIQUE NOT NULL,
	data_nascimento DATE
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
	INSERT INTO pessoa (nome, cpf, email, data_nascimento) values
	 ('Laerson Castro', '00100200304', 'laersonjr@gmail.com', '2021-01-02');
	INSERT INTO pessoa (nome, cpf, email, data_nascimento) values
	 ('Laerson Castro Novo', '12345678911', 'laersonjr@hotmail.com', '2021-01-02');