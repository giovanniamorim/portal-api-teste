CREATE TABLE usuario (
	codigo BIGINT(20) PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	senha VARCHAR(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE permissao (
	codigo BIGINT(20) PRIMARY KEY,
	descricao VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE usuario_permissao (
	codigo_usuario BIGINT(20) NOT NULL,
	codigo_permissao BIGINT(20) NOT NULL,
	PRIMARY KEY (codigo_usuario, codigo_permissao),
	FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo),
	FOREIGN KEY (codigo_permissao) REFERENCES permissao(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuario (codigo, nome, email, senha) values (1, 'Administrador', 'admin@algamoney.com', '$2a$10$AjIhHcIKm/gbxOFXTTdCMuofMJaJ/n8D7xrGVpHt63JOWo1S1YXr.');
INSERT INTO usuario (codigo, nome, email, senha) values (2, 'Maria Silva', 'maria@algamoney.com', '$2a$10$AjIhHcIKm/gbxOFXTTdCMuofMJaJ/n8D7xrGVpHt63JOWo1S1YXr.');

INSERT INTO permissao (codigo, descricao) values (1, 'ROLE_CREATE');
INSERT INTO permissao (codigo, descricao) values (2, 'ROLE_READ');
INSERT INTO permissao (codigo, descricao) values (3, 'ROLE_UPDATE');
INSERT INTO permissao (codigo, descricao) values (4, 'ROLE_DELETE');


-- admin
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 1);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 2);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 3);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 4);


-- maria
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 2);
