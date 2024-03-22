



DROP TABLE IF EXISTS MOVIMIENTOS;
DROP TABLE IF EXISTS CUENTAS;
DROP TABLE IF EXISTS SUCURSALES;
DROP TABLE IF EXISTS BANCOS;

Create TABLE   BANCOS(
COD_BANCO   INT PRIMARY KEY,
NF_BANCO    VARCHAR(10),
NOMBRE_BANC VARCHAR(30),
DOM_FISCAL  VARCHAR(35),
POBLACION   VARCHAR(35)
);

Create TABLE  SUCURSALES(
COD_BANCO   INT,
COD_SUCUR   INT,
NOMBRE_SUC  VARCHAR(35),
DIREC_SUC   VARCHAR(35),
LOC_SUC     VARCHAR(20),
PROV_SUC    VARCHAR(20),
PRIMARY KEY (COD_BANCO,COD_SUCUR)
);	

Create TABLE   CUENTAS(
COD_BANCO   INT,
COD_SUCUR   INT,
NUM_CTA     INT ,
FECHA_ALTA  DATE,
NOMBRE_CTA  VARCHAR(35),
DIREC_CTA   VARCHAR(35),
POBLA_CTA   VARCHAR(20),
SALDO_DEBE  INT,
SALDO_HABER INT,
PRIMARY KEY (COD_BANCO,COD_SUCUR,NUM_CTA)
);

CREATE TABLE  MOVIMIENTOS(
COD_BANCO   INT,
COD_SUCUR   INT,
NUM_CTA     INT, 
FECHA_MOV   DATE,
TIPO_MOV    CHAR(1), 
IMPORTE     INT
);


INSERT INTO BANCOS VALUES(1111,'122322223','BANCO DE ESPAÑA','GRAN VIA','MADRID');
INSERT INTO BANCOS VALUES(1112,'222322223','BANCO DE GUADALAJARA','MAYOR', 
					'GUADALAJARA');
INSERT INTO BANCOS VALUES(1113,'322322223','BANCO POPULAR','LA PLAZA','TOLEDO');
INSERT INTO BANCOS VALUES(1114,'422322223','CAJA CM','RIO DULCE','ALBACETE');


INSERT INTO sucursales VALUES(1111, 5000,'* SUCURSAL 1*', 'ANCHA 24', 
	'TOLEDO','TOLEDO');
INSERT INTO sucursales VALUES(1111, 5001,'* SUCURSAL 2*', 'PILON 33',
 'PASTRANA','GUADALAJARA');

INSERT INTO sucursales VALUES(1112, 6000,'* SUCURSAL 6000*', 'MAYOR 55',
 'ALCALA','ALCALA');

INSERT INTO sucursales VALUES(1113, 4000,'* SUCURSAL 4000*', 'ERAS 77',
 'ARANJUEZ','MADRID');


INSERT INTO CUENTAS VALUES(1111, 5000,123456789,STR_TO_DATE('24-May-2023', '%d-%M-%Y'), 'JUAN','TOLEDO',
		'TOLEDO', 200,400);
INSERT INTO CUENTAS VALUES(1111, 5000,123456788,STR_TO_DATE('23-May-2022', '%d-%M-%Y'), 'PEDRO','TOLEDO',
		'TOLEDO', 0,220);
INSERT INTO CUENTAS VALUES(1111, 5001,123456787,STR_TO_DATE('12-May-2020', '%d-%M-%Y'), 'ANA','GUADALAJARA',
		'GUADALAJARA', 198,0);
INSERT INTO CUENTAS VALUES(1111, 5001,123456786,STR_TO_DATE('02-May-2018', '%d-%M-%Y'), 'MANUEL','GUADALAJARA',
		'GUADALAJARA', 0,998);

INSERT INTO CUENTAS VALUES(1111, 5001,123456785,STR_TO_DATE('24-Apr-2023', '%d-%M-%Y'), 'ANDRES','ALCALA',
		'ALCALA', 0,0);

INSERT INTO CUENTAS VALUES(1112, 6000,33334444, STR_TO_DATE('15-Jun-2018', '%d-%M-%Y'),'ISABEL','MADRID', 
		'MADRID', 5100,3000);
INSERT INTO CUENTAS VALUES(1112, 6000,33334440, STR_TO_DATE('06-Aug-2018', '%d-%M-%Y'),'MARIA','MADRID', 
		'MADRID', 200,200);


INSERT INTO MOVIMIENTOS VALUES(1112, 6000,33334444, STR_TO_DATE('24-Jan-2021', '%d-%M-%Y'),'I', 1000); 
INSERT INTO MOVIMIENTOS VALUES(1112, 6000,33334444, STR_TO_DATE('23-Feb-2019', '%d-%M-%Y'),'I', 2000); 
INSERT INTO MOVIMIENTOS VALUES(1112, 6000,33334444, STR_TO_DATE('22-Mar-2005', '%d-%M-%Y'),'R', 100); 
INSERT INTO MOVIMIENTOS VALUES(1112, 6000,33334444, STR_TO_DATE('21-May-2005', '%d-%M-%Y'),'R', 5000); 

INSERT INTO MOVIMIENTOS VALUES(1112, 6000,33334440, STR_TO_DATE('20-May-2005', '%d-%M-%Y'),'R',200);
INSERT INTO MOVIMIENTOS VALUES(1112, 6000,33334440, STR_TO_DATE('10-May-2005', '%d-%M-%Y'),'I',200);

INSERT INTO MOVIMIENTOS VALUES(1111, 5000,123456789,STR_TO_DATE('12-May-2017', '%d-%M-%Y'), 'I',100);
INSERT INTO MOVIMIENTOS VALUES(1111, 5000,123456789,STR_TO_DATE('14-Apr-2020', '%d-%M-%Y'), 'R',200);
INSERT INTO MOVIMIENTOS VALUES(1111, 5000,123456789,STR_TO_DATE('27-May-2021', '%d-%M-%Y'), 'I',300);

INSERT INTO MOVIMIENTOS VALUES(1111, 5000,123456788,STR_TO_DATE('28-Oct-2021', '%d-%M-%Y'),'I',200);

INSERT INTO MOVIMIENTOS VALUES(1111, 5001,123456787,STR_TO_DATE('13-Sep-2023', '%d-%M-%Y'), 'R',198);

INSERT INTO MOVIMIENTOS VALUES(1111, 5001,123456786,STR_TO_DATE('15-Nov-2023', '%d-%M-%Y'),'I',998);


COMMIT;

DROP TABLE IF EXISTS CLIENTES2;

CREATE TABLE Clientes2 (
  CodigoCliente tinyint(2) NOT NULL,
  NombreCliente varchar(50) NOT NULL,
  NombreContacto varchar(30) DEFAULT NULL,
  ApellidoContacto varchar(30) DEFAULT NULL,
  Telefono varchar(15) NOT NULL,
  Fax varchar(15) NOT NULL,
  LineaDireccion1 varchar(50) NOT NULL,
  LineaDireccion2 varchar(50) DEFAULT NULL,
  Ciudad varchar(50) NOT NULL,
  Region varchar(50) DEFAULT NULL,
  Pais varchar(50) DEFAULT NULL,
  CodigoPostal varchar(10) DEFAULT NULL,
  CodigoEmpleadoRepVentas tinyint(2) DEFAULT NULL,
  LimiteCredito float(15,2) DEFAULT NULL
)ENGINE=InnoDB;

INSERT INTO Clientes2 VALUES (1,'DGPRODUCTIONS GARDEN','Daniel G','GoldFish','5556901745','5556901746','False Street 52 2 A',NULL,'San Francisco',NULL,'USA','24006',19,3000);
INSERT INTO Clientes2 VALUES (3,'Gardening Associates','Anne','Wright','5557410345','5557410346','Wall-e Avenue',NULL,'Miami','Miami','USA','24010',19,6000);
INSERT INTO Clientes2 VALUES (4,'Gerudo Valley','Link','Flaute','5552323129','5552323128','Oaks Avenue nº22',NULL,'New York',NULL,'USA','85495',22,12000);
INSERT INTO Clientes2 VALUES (5,'Tendo Garden','Akane','Tendo','55591233210','55591233211','Null Street nº69',NULL,'Miami',NULL,'USA','696969',22,600000);
INSERT INTO Clientes2 VALUES (6,'Lasas S.A.','Antonio','Lasas','34916540145','34914851312','C/Leganes 15',NULL,'Fuenlabrada','Madrid','España','28945',8,154310);
INSERT INTO Clientes2 VALUES (7,'Beragua','Jose','Bermejo','654987321','916549872','C/pintor segundo','Getafe','Madrid','Madrid','España','28942',11,20000);
INSERT INTO Clientes2 VALUES (8,'Club Golf Puerta del hierro','Paco','Lopez','62456810','919535678','C/sinesio delgado','Madrid','Madrid','Madrid','España','28930',11,40000);
INSERT INTO Clientes2 VALUES (9,'Naturagua','Guillermo','Rengifo','689234750','916428956','C/majadahonda','Boadilla','Madrid','Madrid','España','28947',11,32000);
INSERT INTO Clientes2 VALUES (10,'DaraDistribuciones','David','Serrano','675598001','916421756','C/azores','Fuenlabrada','Madrid','Madrid','España','28946',11,50000);
INSERT INTO Clientes2 VALUES (11,'Madrileña de riegos','Jose','Tacaño','655983045','916689215','C/Lagañas','Fuenlabrada','Madrid','Madrid','España','28943',11,20000);
INSERT INTO Clientes2 VALUES (12,'Lasas S.A.','Antonio','Lasas','34916540145','34914851312','C/Leganes 15',NULL,'Fuenlabrada','Madrid','España','28945',8,154310);
INSERT INTO Clientes2 VALUES (13,'Camunas Jardines S.L.','Pedro','Camunas','34914873241','34914871541','C/Virgenes 45','C/Princesas 2 1ºB','San Lorenzo del Escorial','Madrid','España','28145',8,16481);
INSERT INTO Clientes2 VALUES (14,'Dardena S.A.','Juan','Rodriguez','34912453217','34912484764','C/Nueva York 74',NULL,'Madrid','Madrid','España','28003',8,321000);
INSERT INTO Clientes2 VALUES (15,'Jardin de Flores','Javier','Villar','654865643','914538776','C/ Oña 34',NULL,'Madrid','Madrid','España','28950',30,40000);
INSERT INTO Clientes2 VALUES (16,'Flores Marivi','Maria','Rodriguez','666555444','912458657','C/Leganes24',NULL,'Fuenlabrada','Madrid','España','28945',5,1500);
INSERT INTO Clientes2 VALUES (17,'Flowers, S.A','Beatriz','Fernandez','698754159','978453216','C/Luis Salquillo4',NULL,'Montornes del valles','Barcelona','España','24586',5,3500);
INSERT INTO Clientes2 VALUES (18,'Naturajardin','Victoria','Cruz','612343529','916548735','Plaza Magallón 15',NULL,'Madrid','Madrid','España','28011',30,5050);
INSERT INTO Clientes2 VALUES (19,'Golf S.A.','Luis','Martinez','916458762','912354475','C/Estancado',NULL,'Santa cruz de Tenerife','Islas Canarias','España','38297',12,30000);
INSERT INTO Clientes2 VALUES (20,'AYMERICH GOLF MANAGEMENT, SL','Mario','Suarez','964493072','964493063','C/Letardo',NULL,'Barcelona','Cataluña','España','12320',12,20000);
INSERT INTO Clientes2 VALUES (21,'Aloha','Cristian','Rodrigez','916485852','914489898','C/Roman 3',NULL,'Canarias','Canarias','España','35488',12,50000);
INSERT INTO Clientes2 VALUES (22,'El Prat','Francisco','Camacho','916882323','916493211','Avenida Tibidabo',NULL,'Barcelona','Cataluña','España','12320',12,30000);
INSERT INTO Clientes2 VALUES (23,'Sotogrande','Maria','Santillana','915576622','914825645','C/Paseo del Parque',NULL,'Sotogrande','Cadiz','España','11310',12,60000);
INSERT INTO Clientes2 VALUES (24,'Vivero Humanes','Federico','Gomez','654987690','916040875','C/Miguel Echegaray 54',NULL,'Humanes','Madrid','España','28970',30,7430);
INSERT INTO Clientes2 VALUES (25,'Fuenla City','Tony','Muñoz Mena','675842139','915483754','C/Callo 52',NULL,'Fuenlabrada','Madrid','España','28574',5,4500);
INSERT INTO Clientes2 VALUES (26,'Jardines y Mansiones CACTUS SL','Eva María','Sánchez','916877445','914477777','Polígono Industrial Maspalomas, Nº52','Móstoles','Madrid','Madrid','España','29874',9,76000);
INSERT INTO Clientes2 VALUES (27,'Jardinerías Matías SL','Matías','San Martín','916544147','917897474','C/Francisco Arce, Nº44','Bustarviejo','Madrid','Madrid','España','37845',9,100500);
INSERT INTO Clientes2 VALUES (28,'Agrojardin','Benito','Lopez','675432926','916549264','C/Mar Caspio 43',NULL,'Getafe','Madrid','España','28904',30,8040);
INSERT INTO Clientes2 VALUES (29,'Top Campo','Joseluis','Sanchez','685746512','974315924','C/Ibiza 32',NULL,'Humanes','Madrid','España','28574',5,5500);
INSERT INTO Clientes2 VALUES (30,'Jardineria Sara','Sara','Marquez','675124537','912475843','C/Lima 1',NULL,'Fuenlabrada','Madrid','España','27584',5,7500);
INSERT INTO Clientes2 VALUES (31,'Campohermoso','Luis','Jimenez','645925376','916159116','C/Peru 78',NULL,'Fuenlabrada','Madrid','España','28945',30,3250);
INSERT INTO Clientes2 VALUES (32,'france telecom','FraÃ§ois','Toulou','(33)5120578961','(33)5120578961','6 place d Alleray 15Ã¨me',NULL,'Paris',NULL,'France','75010',16,10000);
INSERT INTO Clientes2 VALUES (33,'Musée du Louvre','Pierre','Delacroux','(33)0140205050','(33)0140205442','Quai du Louvre',NULL,'Paris',NULL,'France','75058',16,30000);
INSERT INTO Clientes2 VALUES (35,'Tutifruti S.A','Jacob','Jones','2 9261-2433','2 9283-1695','level 24, St. Martins Tower.-31 Market St.',NULL,'Sydney','Nueva Gales del Sur','Australia','2000',31,10000);
INSERT INTO Clientes2 VALUES (36,'FLORES S.L.','Antonio','Romero','654352981','685249700','Avenida España',NULL,'Madrid','Fuenlabrada','España','29643',18,6000);
INSERT INTO Clientes2 VALUES (37,'THE MAGIC GARDEN','Richard','Mcain','926523468','9364875882','Lihgting Park',NULL,'London','London','United Kingdom','65930',18,10000);
INSERT INTO Clientes2 VALUES (38,'El Jardin Viviente S.L','Justin','Smith','2 8005-7161','2 8005-7162','176 Cumberland Street The rocks',NULL,'Sydney','Nueva Gales del Sur','Australia','2003',31,8000);

COMMIT;







