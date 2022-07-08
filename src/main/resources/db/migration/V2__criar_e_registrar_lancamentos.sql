CREATE TABLE lancamentos (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(250),
    type VARCHAR(250),
    amount DECIMAL(10,2) NOT NULL,
    createdAt TIMESTAMP NOT NULL,
    paid BIT DEFAULT 0,
    categoryId BIGINT NOT NULL,
    	FOREIGN KEY (categoryId)
    	REFERENCES categorias(id)
    	ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO lancamentos (name, description, type, amount, createdAt, paid, categoryId) VALUES("Conta de Luz", "-", "despesa", 100.00, "2021-11-21*13:23:55", 0, 1);
