CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    data_nascimento DATE NOT NULL,
    telefone VARCHAR(13) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL,
    data_hora_cadastro DATETIME,
    PRIMARY KEY (id)
);

CREATE TABLE role (
    nome varchar(20),
    primary key (nome)
);

CREATE TABLE role_usuarios (
    id bigint not null auto_increment,
    role_nome varchar(60),
    usuarios_id bigint not null,
    primary key (id)
);

ALTER TABLE role_usuarios ADD CONSTRAINT fk_role_usuarios
FOREIGN KEY (usuarios_id) REFERENCES usuarios(id);

ALTER TABLE role_usuarios ADD CONSTRAINT fk_role_nome
FOREIGN KEY (role_nome) REFERENCES role (nome);

INSERT INTO role VALUES ("ROLE_USER");