CREATE TABLE balancete (
	id BIGINT(20) PRIMARY KEY,
	descricao VARCHAR(50) NOT NULL,
	file_url VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO balancete (id, descricao, file_url) values (1, 'Balancete Dezembro de 2022', 'teste.pdf');
INSERT INTO balancete (id, descricao, file_url) values (2, 'Balancete Janeiro de 2023', 'teste2.pdf');
