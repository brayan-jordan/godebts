CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    data_nascimento DATE NOT NULL,
    telefone VARCHAR(13) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(50) NOT NULL,
    data_hora_cadastro DATETIME,
    PRIMARY KEY (id)
);