CREATE TABLE categorias (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(250)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO categorias (name, description) VALUES("Casa", "-");
INSERT INTO categorias (name, description) VALUES("Trabalho", "-");