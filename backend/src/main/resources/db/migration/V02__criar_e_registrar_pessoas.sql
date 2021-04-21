CREATE TABLE pessoa(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	logradouro VARCHAR(50),
	numero INTEGER(10),
	complemento VARCHAR(100),
	bairro VARCHAR(20),
	cep VARCHAR(10),
	cidade VARCHAR(50),
	estado VARCHAR(2),	
	ativo BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES ('Cauê Luiz Carvalho', 'Rua Velho Ismael Siqueira', 923, '', 'Abolição', '59612-490', 'Mossoró', 'RN', 1);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES ('Geraldo Joaquim Moraes', 'Rua Nazareno', 316, 'Casa 5', 'Socorro', '54150-230', 'Jaboatão dos Guararapes', 'PE', 0);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES ('Olivia Allana Evelyn da Cruz', 'Rua Antônio Ferreira Rodrigues', 365, 'Bloco 5 Apto 401', 'Pajuçara', '57030-020', 'Maceió', 'AL', 1);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES ('Sérgio Carlos Eduardo da Mata', 'Rua Jovelina Rodrigues Ferreira', 611, 'Casa 2', 'Bandeirinhas', '32657-434', 'Betim', 'MG', 0);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES ('Yuri Roberto de Paula', 'Vila Dom Antônio', 555, '', 'Jardim Guanabara', '60346-540', 'Fortaleza', 'CE', 1);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES ('Helena Caroline da Rosa', 'Rua Dalva de Oliveira', 232, 'Bloco 1 Apto 409', 'Comasa', '89228-340', 'Joinville', 'SC', 0);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES ('Daniel Levi Kauê da Conceição', 'Rua RM 2', 331, '', 'Residencial Guarema', '74573-430', 'Goiânia', 'GO', 1);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES ('Elias Alexandre Brito', 'Rua Venezuela', 247, 'Casa 7', 'Embratel', '76820-800', 'Porto Velho', 'RO', 0);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES ('Stefany Eloá Assis', 'Rua Augusto Ruschi', 171, '', 'Nova Brasília', '29149-413', 'Cariacica', 'ES', 1);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES ('Mateus Luan Marcos Freitas', 'Quadra 04', 477, '', 'Paraibinha', '64606-325', 'Picos', 'PI', 0);





