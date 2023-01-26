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

INSERT INTO permissao (codigo, descricao) values (1, 'ROLE_CADASTRAR_CATEGORIA');
INSERT INTO permissao (codigo, descricao) values (2, 'ROLE_PESQUISAR_CATEGORIA');

INSERT INTO permissao (codigo, descricao) values (3, 'ROLE_CADASTRAR_PESSOA');
INSERT INTO permissao (codigo, descricao) values (4, 'ROLE_REMOVER_PESSOA');
INSERT INTO permissao (codigo, descricao) values (5, 'ROLE_PESQUISAR_PESSOA');

INSERT INTO permissao (codigo, descricao) values (6, 'ROLE_CADASTRAR_LANCAMENTO');
INSERT INTO permissao (codigo, descricao) values (7, 'ROLE_REMOVER_LANCAMENTO');
INSERT INTO permissao (codigo, descricao) values (8, 'ROLE_PESQUISAR_LANCAMENTO');

INSERT INTO permissao (codigo, descricao) values (9, 'ROLE_CADASTRAR_BALANCETE');
INSERT INTO permissao (codigo, descricao) values (10, 'ROLE_REMOVER_BALANCETE');
INSERT INTO permissao (codigo, descricao) values (11, 'ROLE_PESQUISAR_BALANCETE');

INSERT INTO permissao (codigo, descricao) values (12, 'ROLE_CADASTRAR_BALANCO');
INSERT INTO permissao (codigo, descricao) values (13, 'ROLE_REMOVER_BALANCO');
INSERT INTO permissao (codigo, descricao) values (14, 'ROLE_PESQUISAR_BALANCO');

INSERT INTO permissao (codigo, descricao) values (15, 'ROLE_CADASTRAR_PLANEJAMENTO');
INSERT INTO permissao (codigo, descricao) values (16, 'ROLE_REMOVER_PLANEJAMENTO');
INSERT INTO permissao (codigo, descricao) values (17, 'ROLE_PESQUISAR_PLANEJAMENTO');

INSERT INTO permissao (codigo, descricao) values (18, 'ROLE_CADASTRAR_EXECUCAO');
INSERT INTO permissao (codigo, descricao) values (19, 'ROLE_REMOVER_EXECUCAO');
INSERT INTO permissao (codigo, descricao) values (20, 'ROLE_PESQUISAR_EXECUCAO');

INSERT INTO permissao (codigo, descricao) values (21, 'ROLE_CADASTRAR_INVENTARIO');
INSERT INTO permissao (codigo, descricao) values (22, 'ROLE_REMOVER_INVENTARIO');
INSERT INTO permissao (codigo, descricao) values (23, 'ROLE_PESQUISAR_INVENTARIO');

INSERT INTO permissao (codigo, descricao) values (24, 'ROLE_CADASTRAR_ASSEMBLEIA');
INSERT INTO permissao (codigo, descricao) values (25, 'ROLE_REMOVER_ASSEMBLEIA');
INSERT INTO permissao (codigo, descricao) values (26, 'ROLE_PESQUISAR_ASSEMBLEIA');

INSERT INTO permissao (codigo, descricao) values (27, 'ROLE_CADASTRAR_JUR_PROCESSO');
INSERT INTO permissao (codigo, descricao) values (28, 'ROLE_REMOVER_JUR_PROCESSO');
INSERT INTO permissao (codigo, descricao) values (29, 'ROLE_PESQUISAR_JUR_PROCESSO');

INSERT INTO permissao (codigo, descricao) values (30, 'ROLE_CADASTRAR_JUR_EVENTO');
INSERT INTO permissao (codigo, descricao) values (31, 'ROLE_REMOVER_JUR_EVENTO');
INSERT INTO permissao (codigo, descricao) values (32, 'ROLE_PESQUISAR_JUR_EVENTO');

-- admin
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 1);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 2);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 3);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 4);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 5);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 6);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 7);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 8);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 9);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 10);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 11);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 12);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 13);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 14);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 15);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 16);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 17);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 18);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 19);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 20);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 21);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 22);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 23);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 24);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 25);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 26);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 27);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 28);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 29);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 30);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 31);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 32);

-- maria
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 2);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 5);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 8);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 9);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 10);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 11);