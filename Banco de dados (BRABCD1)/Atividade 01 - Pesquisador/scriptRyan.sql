DROP DATABASE IF EXISTS Pesquisa;
CREATE DATABASE IF NOT EXISTS Pesquisa;
USE Pesquisa;

#Criação das tabelas
CREATE TABLE Instituicao (
    codigo INT PRIMARY KEY,
    nome VARCHAR(100)
);

CREATE TABLE Pesquisador (
    cpf VARCHAR(11) PRIMARY KEY,
    nome VARCHAR(100),
    instituicao_codigo INT,
    FOREIGN KEY (instituicao_codigo) REFERENCES Instituicao(codigo)
);

CREATE TABLE VeiculoPublicacao (
    codigo INT PRIMARY KEY,
    titulo VARCHAR(100),
    local_publicacao VARCHAR(100)
);

CREATE TABLE Artigo (
    codigo INT PRIMARY KEY,
    titulo VARCHAR(100),
    pagina_inicial INT,
    pagina_final INT,
	veiculo_codigo INT,
    FOREIGN KEY (veiculo_codigo) REFERENCES VeiculoPublicacao(codigo)
);

CREATE TABLE Publicacao (
    pesquisador_cpf CHAR(11),
    artigo_codigo INT,
    PRIMARY KEY (pesquisador_cpf, artigo_codigo),
    FOREIGN KEY (pesquisador_cpf) REFERENCES Pesquisador(cpf),
    FOREIGN KEY (artigo_codigo) REFERENCES Artigo(codigo)
);

#Inserção de dados
INSERT INTO Instituicao (codigo, nome) VALUES
	(1, 'Instituto Federal de São Paulo'),
	(2, 'Universidade São Francisco'),
	(3, 'SENAI');

INSERT INTO VeiculoPublicacao (codigo, titulo, local_publicacao) VALUES
	(1, 'Bragança em Pauta', 'Bragança pta'),
	(2, 'Revista Recreio', 'Rio de Janeiro'),
	(3, 'Nome Ciencia', 'Campinas');

INSERT INTO Artigo (codigo, titulo, pagina_inicial, pagina_final, veiculo_codigo) VALUES
	(1, 'IA no dia a dia', 10, 20, 1),
	(2, 'Queryes SQL Lição', 15, 25, 3),
	(3, 'Atividade Pesquisador', 5, 15, 2),
	(4, 'Mechanical Engineering CAD', 30, 40, 1),
	(5, 'Não é um titulo de artigo', 8, 18, 2);

INSERT INTO Pesquisador (cpf, nome, instituicao_codigo) VALUES
	('12345678901', 'João Silva', 1),
	('23456789012', 'Maria Oliveira', 2),
	('34567890123', 'Pedro Santos', 1),
	('45678901234', 'Ana Souza', 3),
	('56789012345', 'Luiza Pereira', 2);

INSERT INTO Publicacao (pesquisador_cpf, artigo_codigo) VALUES
	('12345678901', 1),
	('12345678901', 2),
	('56789012345', 3),
	('34567890123', 4),
	('56789012345', 5);

#Deletar e Atualizar
DELETE FROM Pesquisador WHERE cpf = '45678901234';

UPDATE Pesquisador SET nome = 'Ryan Furtado' WHERE cpf = '23456789012';

#Seleções
SELECT * FROM Pesquisador;

SELECT * FROM Pesquisador WHERE nome LIKE 'R%';

SELECT 
	p.nome AS nome_pesquisador,
    a.titulo AS titulo_artigo
FROM Pesquisador p
JOIN Publicacao pub ON p.cpf = pub.pesquisador_cpf
JOIN Artigo a ON pub.artigo_codigo = a.codigo
WHERE p.cpf = '12345678901';
