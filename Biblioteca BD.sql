
CREATE DATABASE sistema_bibliotecas;
USE sistema_bibliotecas;
CREATE TABLE `sistema_bibliotecas`.`categoria` (
  `codigo_categoria` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codigo_categoria`));

CREATE TABLE `sistema_bibliotecas`.`libro` (
  `isbn` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `autor` VARCHAR(45) NOT NULL,
  `categoria` INT NOT NULL,
  `costo` DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (`isbn`),
  INDEX `categoriaFK_idx` (`categoria` ASC) VISIBLE,
  CONSTRAINT `categoriaFK`
    FOREIGN KEY (`categoria`)
    REFERENCES `sistema_bibliotecas`.`categoria` (`codigo_categoria`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `sistema_bibliotecas`.`biblioteca` (
  `idbiblioteca` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idbiblioteca`));

CREATE TABLE `sistema_bibliotecas`.`libros_biblioteca` (
  `idlibros_biblioteca` INT NOT NULL AUTO_INCREMENT,
  `biblioteca` INT NOT NULL,
  `existencias` INT NOT NULL,
  `isbn` INT NOT NULL,
  PRIMARY KEY (`idlibros_biblioteca`),
  INDEX `bibliotecaFK_idx` (`biblioteca` ASC) VISIBLE,
  INDEX `libroFK_idx` (`isbn` ASC) VISIBLE,
  CONSTRAINT `bibliotecaFK`
    FOREIGN KEY (`biblioteca`)
    REFERENCES `sistema_bibliotecas`.`biblioteca` (`idbiblioteca`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `libroFK`
    FOREIGN KEY (`isbn`)
    REFERENCES `sistema_bibliotecas`.`libro` (`isbn`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `sistema_bibliotecas`.`usuario_recepcion` (
  `codigo_usuario_recepcion` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `constrasenia` VARCHAR(100) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `biblioteca` INT NOT NULL,
  PRIMARY KEY (`codigo_usuario_recepcion`),
  INDEX `bibliotecaFK_idx` (`biblioteca` ASC) VISIBLE,
  CONSTRAINT `biblio_recepcionFK`
    FOREIGN KEY (`biblioteca`)
    REFERENCES `sistema_bibliotecas`.`biblioteca` (`idbiblioteca`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `sistema_bibliotecas`.`usuario_final` (
  `codigo_usuario_final` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `nombre_usuario` VARCHAR(45) NOT NULL,
  `contrasenia` VARCHAR(100) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `saldo` DECIMAL(6,2) NOT NULL,
  `premiun` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`codigo_usuario_final`));

CREATE TABLE `sistema_bibliotecas`.`transporte_usuario` (
  `codigo_transporte` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `nombre_usuario` VARCHAR(45) NOT NULL,
  `contrasenia` VARCHAR(100) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codigo_transporte`));

CREATE TABLE `sistema_bibliotecas`.`solicitud_prestamo` (
  `codigo_solicitud_prestamo` INT NOT NULL AUTO_INCREMENT,
  `usuario` INT NOT NULL,
  `recepcionista` INT NOT NULL,
  `biblioteca` INT NOT NULL,
  `transportista` INT NULL,
  `isbn` INT NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `tipo_entrega` VARCHAR(45) NOT NULL,
  `fecha` DATE NOT NULL,
  PRIMARY KEY (`codigo_solicitud_prestamo`),
  INDEX `solicitud_usuarioFK_idx` (`usuario` ASC) VISIBLE,
  INDEX `solicitud_recepcionFK_idx` (`recepcionista` ASC) VISIBLE,
  CONSTRAINT `solicitud_usuarioFK`
    FOREIGN KEY (`usuario`)
    REFERENCES `sistema_bibliotecas`.`usuario_final` (`codigo_usuario_final`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `solicitud_recepcionFK`
    FOREIGN KEY (`recepcionista`)
    REFERENCES `sistema_bibliotecas`.`usuario_recepcion` (`codigo_usuario_recepcion`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
 CREATE TABLE `sistema_bibliotecas`.`prestamo` (
  `codigo_prestamo` INT NOT NULL AUTO_INCREMENT,
  `recepcionista` INT NOT NULL,
  `bibloteca` INT NOT NULL,
  `usuario` INT NOT NULL,
  `isbn` INT NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `multa` DECIMAL(6,2) NULL,
  `fecha_prestamo` DATE NOT NULL,
  `fecha_devolucion` DATE NULL,
  PRIMARY KEY (`codigo_prestamo`),
  INDEX `prestamo_recepcionFK_idx` (`recepcionista` ASC) VISIBLE,
  INDEX `prestamo_usuarioFK_idx` (`usuario` ASC) VISIBLE,
  CONSTRAINT `prestamo_recepcionFK`
    FOREIGN KEY (`recepcionista`)
    REFERENCES `sistema_bibliotecas`.`usuario_recepcion` (`codigo_usuario_recepcion`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `prestamo_usuarioFK`
    FOREIGN KEY (`usuario`)
    REFERENCES `sistema_bibliotecas`.`usuario_final` (`codigo_usuario_final`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `sistema_bibliotecas`.`transporte_biblioteca` (
  `codigo_transporte_biblioteca` INT NOT NULL AUTO_INCREMENT,
  `recepcionista` INT NOT NULL,
  `biblioteca_origen` INT NOT NULL,
  `biblioteca_destino` INT NOT NULL,
  `transportista` INT NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `fecha` DATE NOT NULL,
  PRIMARY KEY (`codigo_transporte_biblioteca`),
  INDEX `trasporte_biblioFK_idx` (`recepcionista` ASC) VISIBLE,
  INDEX `transporte_transportistaFK_idx` (`transportista` ASC) VISIBLE,
  CONSTRAINT `trasporte_biblioFK`
    FOREIGN KEY (`recepcionista`)
    REFERENCES `sistema_bibliotecas`.`usuario_recepcion` (`codigo_usuario_recepcion`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `transporte_transportistaFK`
    FOREIGN KEY (`transportista`)
    REFERENCES `sistema_bibliotecas`.`transporte_usuario` (`codigo_transporte`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
CREATE TABLE `sistema_bibliotecas`.`libros_transporte` (
  `idlibros_transporte` INT NOT NULL AUTO_INCREMENT,
  `codigo_transporteBiblio` INT NOT NULL,
  `isbn` INT NOT NULL,
  `unidades` INT NOT NULL,
  PRIMARY KEY (`idlibros_transporte`),
  INDEX `libro_transporteFK_idx` (`codigo_transporteBiblio` ASC) VISIBLE,
  CONSTRAINT `libro_transporteFK`
    FOREIGN KEY (`codigo_transporteBiblio`)
    REFERENCES `sistema_bibliotecas`.`transporte_biblioteca` (`codigo_transporte_biblioteca`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `sistema_bibliotecas`.`transporte_usuario_final` (
  `cdogio_transporte_final` INT NOT NULL AUTO_INCREMENT,
  `usuario` INT NOT NULL,
  `transportista` INT NOT NULL,
  `biblioteca` INT NOT NULL,
  `isbn` INT NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `fecha` DATE NOT NULL,
  PRIMARY KEY (`cdogio_transporte_final`),
  INDEX `transporte_usuarioTFK_idx` (`transportista` ASC) VISIBLE,
  CONSTRAINT `transporte_usuarioTFK`
    FOREIGN KEY (`transportista`)
    REFERENCES `sistema_bibliotecas`.`transporte_usuario` (`codigo_transporte`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
    CREATE TABLE `sistema_bibliotecas`.`incidencia` (
  `codigo_incidencia` INT NOT NULL AUTO_INCREMENT,
  `prestamo` INT NOT NULL,
  `tipo_incidencia` VARCHAR(45) NOT NULL,
  `cantidad_pagada` DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (`codigo_incidencia`),
  INDEX `prestamoFK_idx` (`prestamo` ASC) VISIBLE,
  CONSTRAINT `prestamoFK`
  FOREIGN KEY (`prestamo`)
  REFERENCES `sistema_bibliotecas`.`prestamo` (`codigo_prestamo`)
  ON DELETE CASCADE
  ON UPDATE CASCADE
  
  );

CREATE TABLE `sistema_bibliotecas`.`revocacion` (
  `codigo_revocacion` INT NOT NULL AUTO_INCREMENT,
  `usuario` INT NOT NULL,
  `detalle` VARCHAR(500) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codigo_revocacion`),
  INDEX `revocacionFK_idx` (`usuario` ASC) VISIBLE,
  CONSTRAINT `revocacionFK`
    FOREIGN KEY (`usuario`)
    REFERENCES `sistema_bibliotecas`.`usuario_final` (`codigo_usuario_final`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `sistema_bibliotecas`.`usuario_admin` (
  `codigo_admin` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `nombre_usuario` VARCHAR(45) NOT NULL,
  `contrasenia` VARCHAR(100) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codigo_admin`));
/*
SELECT * FROM categoria;
SELECT * FROM libro;
SELECT * FROM biblioteca;
SELECT * FROM libro_biblioteca;
SELECT * FROM usuario_admin;
SELECT * FROM usuario_recepcion;
SELECT * FROM transporte_usuario;
SELECT * FROM solicitud_prestamo;
SELECT * FROM prestamo;
SELECT * FROM transporte_biblioteca;
SELECT * FROM libros_transporte;
SELECT * FROM transporte_usuario_final;
SELECT * FROM incidencia;
SELECT * FROM revocacion;
*/