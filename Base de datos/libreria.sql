drop database libreria;
create database libreria;
use libreria;

CREATE TABLE boleta (
  num_bol varchar(8) NOT NULL,
  cod_cli varchar(6) NOT NULL,
  pre_tot varchar(10) NOT NULL,
  fecha varchar(15) NOT NULL,
  PRIMARY KEY (num_bol),
  KEY cod_cli (cod_cli)
);


CREATE TABLE cliente (
  cod_cli varchar(6) NOT NULL,
  nom_cli varchar(30) NOT NULL,
  ape_cli varchar(30) NOT NULL,
  sexo_cli varchar(1) NOT NULL,
  dni_cli varchar(8) NOT NULL,
  tel_cli varchar(9) NOT NULL,
  ruc_cli varchar(11) NOT NULL,
  email_cli varchar(30) NOT NULL,
  dir_cli varchar(30) NOT NULL,
  PRIMARY KEY (cod_cli)
);

CREATE TABLE detalleboleta (
  num_bol varchar(10) NOT NULL,
  cod_pro varchar(6) NOT NULL,
  des_pro varchar(30) NOT NULL,
  cant_pro varchar(3) NOT NULL,
  pre_unit varchar(10) NOT NULL,
  pre_venta varchar(10) NOT NULL,
  KEY num_bol (num_bol),
  KEY cod_pro (cod_pro)
) ;


CREATE TABLE detallefactura (
  num_fac varchar(10) NOT NULL,
  cod_pro varchar(6) NOT NULL,
  des_pro varchar(30) NOT NULL,
  cant_pro varchar(3) NOT NULL,
  pre_unit varchar(10) NOT NULL,
  pre_tot varchar(10) NOT NULL,
  KEY num_fac (num_fac),
  KEY cod_pro (cod_pro)
) ;


CREATE TABLE factura (
  num_fac varchar(8) NOT NULL,
  cod_cli varchar(6) NOT NULL,
  ruc_cli varchar(11) NOT NULL,
  subtotal varchar(10) NOT NULL,
  igv varchar(40) NOT NULL,
  total varchar(20) NOT NULL,
  fec_fac varchar(20) NOT NULL,
  PRIMARY KEY (num_fac),
  KEY cod_cli (cod_cli)
) ;


CREATE TABLE producto (
  cod_pro varchar(6) NOT NULL,
  descripcion varchar(30) NOT NULL,
  precio varchar(10) NOT NULL,
  Stock varchar(10) NOT NULL,
  PRIMARY KEY (cod_pro,descripcion)
) ;


ALTER TABLE boleta
  ADD CONSTRAINT boleta_ibfk_1 FOREIGN KEY (cod_cli) REFERENCES cliente (cod_cli);

ALTER TABLE detalleboleta
  ADD CONSTRAINT detalleboleta_ibfk_1 FOREIGN KEY (num_bol) REFERENCES boleta (num_bol),
  ADD CONSTRAINT detalleboleta_ibfk_2 FOREIGN KEY (cod_pro) REFERENCES producto (cod_pro);

ALTER TABLE detallefactura
  ADD CONSTRAINT detallefactura_ibfk_1 FOREIGN KEY (num_fac) REFERENCES factura (num_fac),
  ADD CONSTRAINT detallefactura_ibfk_2 FOREIGN KEY (cod_pro) REFERENCES producto (cod_pro);

ALTER TABLE factura
  ADD CONSTRAINT factura_ibfk_1 FOREIGN KEY (cod_cli) REFERENCES cliente (cod_cli) ;


