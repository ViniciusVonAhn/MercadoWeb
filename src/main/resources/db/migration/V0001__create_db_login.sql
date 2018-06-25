CREATE TABLE usuario (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	senha VARCHAR(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE permissao (
	id INT AUTO_INCREMENT PRIMARY KEY,
	descricao VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE usuario_permissao (
	id_usuario INT NOT NULL,
	id_permissao INT NOT NULL,
	PRIMARY KEY (id_usuario, id_permissao),
	FOREIGN KEY (id_usuario) REFERENCES usuario(id),
	FOREIGN KEY (id_permissao) REFERENCES permissao(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuario (id, nome, senha) values (1, 'Admin', '{bcrypt}$2a$10$mo44B11jalNRuKbL3LbqSO6FSfSMS6.NInDv6kI7OxVetV1mMQzt2');
INSERT INTO usuario (id, nome, senha) values (2, 'User', '{bcrypt}$2a$10$UqtpDXm9zJtB5dxoY9W4CeQ5X/CkTx2CRJv4hx3NAHEr2rngBiKda');

INSERT INTO permissao (id,descricao) values (1,'ROLE_ADMIN');
INSERT INTO permissao (id,descricao) values (2,'ROLE_USER');

INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 1);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 2);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (2, 2);
