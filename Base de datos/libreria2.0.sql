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

insert into boleta values ("00000001","CC0001",20.0,"01/12/2017");
insert into boleta values ("00000002","CC0002",42.0,"02/12/2017");
insert into boleta values ("00000003","CC0003",12.0,"03/12/2017");
insert into boleta values ("00000004","CC0004",2.3,"04/12/2017");
insert into boleta values ("00000005","CC0005",21.4,"05/12/2017");
insert into boleta values ("00000006","CC0006",80.0,"06/12/2017");
insert into boleta values ("00000007","CC0007",8.0,"07/12/2017");
insert into boleta values ("00000008","CC0008",40.0,"08/12/2017");
insert into boleta values ("00000009","CC0009",20.0,"09/12/2017");
insert into boleta values ("00000010","CC0010",15.0,"10/12/2017");
insert into boleta values ("00000011","CC0009",12.8,"11/02/2018");
insert into boleta values ("00000012","CC0008",3.2,"12/02/2018");
insert into boleta values ("00000013","CC0007",2.2,"09/03/2018");
insert into boleta values ("00000014","CC0006",8.0,"10/03/2018");
insert into boleta values ("00000015","CC0005",3.0,"22/03/2018");
insert into boleta values ("00000016","CC0004",12.0,"10/04/2018");
insert into boleta values ("00000017","CC0003",7.5,"18/04/2018");
insert into boleta values ("00000018","CC0002",3.0,"20/04/2018");
insert into boleta values ("00000019","CC0001",4.0,"07/05/2018");
insert into boleta values ("00000020","CC0009",2.20,"08/05/2018");

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

insert into cliente values ("CC0001","Juan","Perez","M",28714632,436558,7531594526,"juan@gmail.com","Surco");
insert into cliente values ("CC0002","Rodrigo","Ayarza","M",65714632,4362098,159357456,"rodrigo@gmail.com","Callao");
insert into cliente values ("CC0003","Jose","Bolognesi","M",49563462,4862019,741369456,"jose@gmail.com","La molina");
insert into cliente values ("CC0004","Milton","Ayala","M",45895632,4863258,157953486,"miton@gmail.com","Ventanilla");
insert into cliente values ("CC0005","Fernando","Huaman","M",19564848,6581209,789852159,"fernando@gmail.com","Cercado");
insert into cliente values ("CC0006","Renzo","Bustamante","M",84561348,1467951,145632789,"renzo@gmail.com","Jesus maria");
insert into cliente values ("CC0007","Pedro","Chacon","M",59124836,2354768,159357486,"pedro@gmail.com","San juan de lurigancho");
insert into cliente values ("CC0008","Maria","Asturia","F",28912318,4566159,159753258,"maria@gmail.com","Breña");
insert into cliente values ("CC0009","Rosa","Limas","F",12593626,1237559,01203545653,"rosa@gmail.com","Ventanilla");
insert into cliente values ("CC0010","Carmen","Licera","F",48560219,1254586,01495510232,"carmen@gmail.com","San borja");

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

insert into factura values ("00000001","CC0001",753159452,20.0,1.8,21.8,"01/01/2018");
insert into factura values ("00000002","CC0002",159357456,40.0,1.8,41.8,"02/01/2018");
insert into factura values ("00000003","CC0003",741369456,10.0,1.8,11.8,"10/01/2018");
insert into factura values ("00000004","CC0004",157953486,20.0,1.8,21.8,"11/01/2018");
insert into factura values ("00000005","CC0005",789852159,20.0,1.8,21.8,"14/01/2018");
insert into factura values ("00000006","CC0006",145632789,80.0,1.8,81.8,"16/02/2018");
insert into factura values ("00000007","CC0007",159357486,80.0,1.8,81.8,"17/02/2018");
insert into factura values ("00000008","CC0008",159753258,40.0,1.8,41.8,"18/02/2018");
insert into factura values ("00000009","CC0009",012035456,20.0,1.8,21.8,"19/02/2018");
insert into factura values ("00000010","CC0010",014955102,10.0,1.8,11.8,"20/02/2018");
insert into factura values ("00000011","CC0001",753159452,30.0,1.8,31.8,"11/03/2018");
insert into factura values ("00000012","CC0002",159357456,50.0,1.8,51.8,"12/03/2018");
insert into factura values ("00000013","CC0003",741369456,60.0,1.8,61.8,"13/03/2018");
insert into factura values ("00000014","CC0004",157953486,70.0,1.8,71.8,"14/03/2018");
insert into factura values ("00000015","CC0005",789852159,80.0,1.8,81.8,"15/03/2018");
insert into factura values ("00000016","CC0006",145632789,90.0,1.8,91.8,"16/05/2018");
insert into factura values ("00000017","CC0007",159357486,10.0,1.8,11.8,"17/05/2018");
insert into factura values ("00000018","CC0008",159753258,20.0,1.8,21.8,"18/05/2018");
insert into factura values ("00000019","CC0009",012035456,30.0,1.8,31.8,"19/05/2018");
insert into factura values ("00000020","CC0010",014955102,40.0,1.8,41.8,"20/05/2018");

CREATE TABLE producto (
  cod_pro varchar(6) NOT NULL,
  descripcion varchar(30) NOT NULL,
  precio varchar(10) NOT NULL,
  Stock varchar(10) NOT NULL,
  PRIMARY KEY (cod_pro,descripcion)
) ;

insert into producto values ("CC0001","lapiz",0.5,50);
insert into producto values ("CC0002","lapicero",1.0,50);
insert into producto values ("CC0003","caja de colores",5.0,50);
insert into producto values ("CC0004","cuaderno stanford",6.0,50);
insert into producto values ("CC0005","cuaderno alpha",5.5,50);
insert into producto values ("CC0006","cuaderno college",5.0,50);
insert into producto values ("CC0007","folder",2.5,50);
insert into producto values ("CC0008","folder manila",0.5,50);
insert into producto values ("CC0009","plumon pizarra",3.5,50);
insert into producto values ("CC0010","plumon papel",3.5,50);
insert into producto values ("CC0011","papelote",0.5,50);
insert into producto values ("CC0012","papelote rayado",0.5,50);
insert into producto values ("CC0013","papelote cuadriculado",0.5,50);
insert into producto values ("CC0014","papelote blanco",0.5,50);
insert into producto values ("CC0015","cartulina",0.5,50);
insert into producto values ("CC0016","cartulina color",0.8,50);
insert into producto values ("CC0017","tempera unidad",1.5,50);
insert into producto values ("CC0018","caja tempera",8.0,50);
insert into producto values ("CC0019","hojas bond (100u)",5.0,50);
insert into producto values ("CC0020","borrador",0.5,50);
insert into producto values ("CC0021","tajador",0.5,50);
insert into producto values ("CC0022","corrector",2.5,50);
insert into producto values ("CC0023","regla 10cm",0.5,50);
insert into producto values ("CC0024","regla 20cm",1.0,50);
insert into producto values ("CC0025","regla 30cm",1.5,50);
insert into producto values ("CC0026","regla metalica 30cm",2.0,50);
insert into producto values ("CC0027","goma pequeña",0.5,50);
insert into producto values ("CC0028","goma mediana",1.0,50);
insert into producto values ("CC0029","goma grande",3.5,50);
insert into producto values ("CC0030","silicona",5.5,50);
insert into producto values ("CC0031","tijera",1.0,50);
insert into producto values ("CC0032","pincel",0.5,50);
insert into producto values ("CC0033","plastilina",3.0,50);
insert into producto values ("CC0034","crayola",3.0,50);
insert into producto values ("CC0035","calcualdora casio",20.0,50);
insert into producto values ("CC0036","calcualdora cientifica",80.0,50);
insert into producto values ("CC0037","impresion b/n",0.1,50);
insert into producto values ("CC0038","impresion color",0.2,50);
insert into producto values ("CC0039","cuchilla",1.2,50);
insert into producto values ("CC0040","papel de regalo",0.8,50);

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


