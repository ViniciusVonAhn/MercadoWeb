CREATE TABLE usuario (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	senha VARCHAR(250) NOT NULL,
	role VARCHAR(100)
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

INSERT INTO usuario (id, nome, senha, role) values (1, 'admin', 'admin', 'ROLE_ADMIN');
INSERT INTO usuario (id, nome, senha, role) values (2, 'user', 'user', 'ROLE_USER');

INSERT INTO permissao (id,descricao) values (1,'ROLE_ADMIN');
INSERT INTO permissao (id,descricao) values (2,'ROLE_USER');

INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 1);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 2);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (2, 2);
