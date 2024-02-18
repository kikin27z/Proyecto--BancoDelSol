CREATE DATABASE IF NOT EXISTS `banco_del_sol`;
USE `banco_del_sol`;

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes` (
    `id_cliente` BIGINT NOT NULL AUTO_INCREMENT,
    `nombres` VARCHAR(50) NOT NULL,
    `apellido_paterno` VARCHAR(30) NOT NULL,
    `apellido_materno` VARCHAR(30) NOT NULL,
    `fecha_nacimiento` DATE NOT NULL,
    `usuario` VARCHAR(30) NOT NULL UNIQUE,
    `contrasena` VARCHAR(100) NOT NULL ,
    PRIMARY KEY (`id_cliente`)
);

DROP TABLE IF EXISTS `domicilios`;
CREATE TABLE `domicilios` (
    `id_domicilio` BIGINT NOT NULL AUTO_INCREMENT,
    `calle` VARCHAR(50) NOT NULL,
    `colonia` VARCHAR(50) NOT NULL,
    `codigo_postal` VARCHAR(5) NOT NULL,
    `numero_exterior` VARCHAR(10) NOT NULL,
    `ciudad` VARCHAR(20) NOT NULL,
    `id_cliente` BIGINT NOT NULL,
    PRIMARY KEY (`id_domicilio`),
    FOREIGN KEY (`id_cliente`) REFERENCES `clientes`(`id_cliente`)
);



DROP TABLE IF EXISTS `cuentas`;
CREATE TABLE `cuentas` (
    `id_cuenta` BIGINT NOT NULL AUTO_INCREMENT,
    `fecha_apertura` DATE  NULL,
    `nombre_cuenta` VARCHAR(15) NOT NULL,
    `numero_cuenta` VARCHAR(16) NOT NULL UNIQUE,
    `saldo` DOUBLE NOT NULL DEFAULT 0,
    `id_cliente` BIGINT NOT NULL,
    PRIMARY KEY (`id_cuenta`),
    FOREIGN KEY (`id_cliente`) REFERENCES `clientes`(`id_cliente`)
);

DROP TABLE IF EXISTS `transacciones`;
CREATE TABLE `transacciones` (
    `id_transaccion` BIGINT NOT NULL AUTO_INCREMENT,
    `fecha` DATETIME NULL DEFAULT NOW(),
    `monto` DOUBLE NOT NULL,
    `id_cuenta` BIGINT NOT NULL,
    PRIMARY KEY (`id_transaccion`),
    FOREIGN KEY (`id_cuenta`) REFERENCES `cuentas`(`id_cuenta`)
);

DROP TABLE IF EXISTS `retiros`;
CREATE TABLE `retiros` (
    `id_retiro` BIGINT NOT NULL AUTO_INCREMENT,
    `contrasena` VARCHAR(8) NOT NULL,
    `folio` VARCHAR(16) NOT NULL,
    `estado` VARCHAR(50) DEFAULT 'en espera' CHECK (estado IN ('caducado', 'en espera', 'realizado')),
    `id_transaccion` BIGINT NOT NULL,
    PRIMARY KEY (`id_retiro`),
    FOREIGN KEY (`id_transaccion`) REFERENCES `transacciones`(`id_transaccion`)
);

DROP TABLE IF EXISTS `transferencias`;
CREATE TABLE `transferencias` (
    `id_transferencia` BIGINT NOT NULL AUTO_INCREMENT,
    `id_transaccion` BIGINT NOT NULL,
    `motivo` VARCHAR(30) NULL DEFAULT "Sin motivo",
    `cuenta_destino` VARCHAR(16) NOT NULL,
    PRIMARY KEY (`id_transferencia`),
    FOREIGN KEY (`id_transaccion`) REFERENCES `transacciones`(`id_transaccion`),
    FOREIGN KEY (`cuenta_destino`) REFERENCES `cuentas`(`numero_cuenta`)
);