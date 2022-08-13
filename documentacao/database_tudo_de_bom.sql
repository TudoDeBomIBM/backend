
create database tudoDeBom;
use tudodebom;

describe produto;

CREATE TABLE `produto` (
	`id_produto` INT NOT NULL AUTO_INCREMENT,
	`nome_produto` varchar(50) NOT NULL,
	`preco_produto` DECIMAL(6,2) NOT NULL,
	`desc_produto` varchar(100) NOT NULL,
	`flag_remedio` char(1) NOT NULL,
	`flag_generico` char(1) NOT NULL,
	`estoque_produto` INT NOT NULL,
	PRIMARY KEY (`id_produto`)
);

CREATE TABLE `cliente` (
	`id_cliente` INT NOT NULL AUTO_INCREMENT,
	`nome_cliente` varchar(50) NOT NULL,
	`cpf_cliente` varchar(11) NOT NULL,
	`email_cliente` varchar(50) NOT NULL,
	`senha_cliente` varchar(20) NOT NULL,
	`tel_cliente` varchar(12) NOT NULL,
	`endereco_cliente` varchar(20) NOT NULL,
	PRIMARY KEY (`id_cliente`)
);

CREATE TABLE `itemPedido` (
	`id_itemPedido` INT NOT NULL AUTO_INCREMENT,
	`qtd_produtos` INT NOT NULL,
	`precoUnitario` DECIMAL(6,2) NOT NULL,
	`precoTotal` DECIMAL(6,2) NOT NULL,
	`descontos` DECIMAL(6,2) NOT NULL,
	`data` DATETIME NOT NULL,
	PRIMARY KEY (`id_itemPedido`)
);

ALTER TABLE `cliente` ADD CONSTRAINT `cliente_fk0` FOREIGN KEY (`id_cliente`) REFERENCES `itemPedido`(`id_itemPedido`);

ALTER TABLE `itemPedido` ADD CONSTRAINT `itemPedido_fk0` FOREIGN KEY (`id_itemPedido`) REFERENCES `produto`(`id_produto`);



