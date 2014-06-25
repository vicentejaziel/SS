GRANT ALL PRIVILEGES ON *.* TO 'PGJ'@'localhost' IDENTIFIED BY 'pgj' WITH GRANT OPTION;
COMMIT;

DROP DATABASE IF EXISTS PGJ;

CREATE DATABASE PGJ;

CREATE TABLE PGJ.CALL_TYPE(
  id int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT "Identificador �nico del Registro.",
  name varchar(50) NOT NULL COMMENT "Nombre del tipo llamada.",
  status varchar(1) NOT NULL DEFAULT "A" COMMENT "Estatus del Registro. A - Activo / I - Inactivo.",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT "�ltima Fecha de actualizaci�n del registro."
)DEFAULT CHARSET=utf8 COMMENT "Tabla de cat�logo de Tipos de llamada para reporte de eventualidad";


CREATE TABLE PGJ.CAR(
  id int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT "Identificador �nico del Registro.",
  owner_name varchar(100) NOT NULL COMMENT "Nombre del propietario del vehiculo",
  owner_address varchar(200) NOT NULL COMMENT "Direccion del propietario del vehiculo",
  trademark varchar(100) NOT NULL COMMENT "Marca del vehiculo",
  type varchar(100) NOT NULL COMMENT "Tipo del vehiculo",
  model varchar(10) NOT NULL COMMENT "Modelo del vehiculo",
  plaque varchar(10) NOT NULL COMMENT "Placas del vehiculo",
  serial_no varchar(30) NOT NULL COMMENT "Numero de serie del vehiculo",
  color varchar(30) NOT NULL COMMENT "Color del vehiculo",
  steal_type varchar(30) NOT NULL COMMENT "Tipo de robo del vehiculo",
  status varchar(1) NOT NULL DEFAULT "A" COMMENT "Estatus del Registro. A - Activo / I - Inactivo.",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT "�ltima Fecha de actualizaci�n del registro."
)DEFAULT CHARSET=utf8 COMMENT "Tabla de vehiculos presentes en eventualidades";

CREATE TABLE PGJ.CRIME(
  id int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT "Identificador �nico del Registro.",
  name varchar(50) NOT NULL COMMENT "Nombre del tipo de delito.",
  status varchar(1) NOT NULL DEFAULT "A" COMMENT "Estatus del Registro. A - Activo / I - Inactivo.",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT "�ltima Fecha de actualizaci�n del registro."
)DEFAULT CHARSET=utf8 COMMENT "Tabla de cat�logo de Delitos";

CREATE TABLE PGJ.CRIME_CATEGORY (
  id int(10) NOT NULL AUTO_INCREMENT COMMENT "Identificador �nico del Registro.",
  crime_id int(10) NOT NULL COMMENT "Llave Foranea. Tabla PGJ.CRIME. Tipo de Delito al que pertenece la categor�a.",
  name varchar(50) NOT NULL COMMENT "Nombre de la Categor�a.",
  status varchar(1) NOT NULL DEFAULT "A" COMMENT "Estatus del Registro. A - Activo / I - Inactivo.",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT "�ltima Fecha de actualizaci�n del registro.",
  PRIMARY KEY (id),
  KEY CRIME_ID_KEY (crime_id),
  CONSTRAINT CRIME_CATEGORY_CRIME FOREIGN KEY (crime_id) REFERENCES PGJ.CRIME (id)
) DEFAULT CHARSET=utf8 COMMENT "Tabla de cat�logo de Categor�as por tipo de Delito.";

CREATE TABLE PGJ.CRIME_SUBCATEGORY (
  id int(10) NOT NULL AUTO_INCREMENT COMMENT "Identificador �nico del Registro.",
  crime_category_id int(10) NOT NULL COMMENT "Llave Foranea. Tabla PGJ.CRIME_CATEGORY. Sub Categor�a correspondiente a categor�a de Delito.",
  name varchar(50) NOT NULL COMMENT "Nombre de la Sub Categor�a.",
  status varchar(1) NOT NULL DEFAULT "A"  ,
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT "�ltima Fecha de actualizaci�n del registro.",
  PRIMARY KEY (id),
  KEY CRIME_CATEGORY_ID_KEY (crime_category_id),
  CONSTRAINT CRIME_SUBCAT_CRIME_CAT FOREIGN KEY (crime_category_id) REFERENCES PGJ.CRIME_SUBCATEGORY (id)
) DEFAULT CHARSET=utf8 COMMENT "Tabla de cat�logo de Sub Categor�as por Categor�a de Tipo de Delito";

CREATE TABLE PGJ.DEPENDENCE (
  id int(10) NOT NULL AUTO_INCREMENT COMMENT "Identificador �nico del Registro.",
  name varchar(50) COMMENT "Nombre de la dependencia o nosocomio.",
  street_and_no varchar(50) COMMENT "Calle y N�mero donde se encuentra ubicada la dependencia",
  suburb varchar(50) COMMENT "Colonia donde se encuentra ubicada la dependencia",
  town_id int(10) COMMENT "Llave Foranea. Tabla PGJ.TOWN. Identificador del municipio al que pertenece la dependencia.",
  postal_code varchar(10) COMMENT "Codigo postal de la dependencia",
  between_st varchar(100) COMMENT "Calles entre las cuales se encuentra ubicada la dependencia",
  latitude varchar(30) COMMENT "Valor de latitud de ubicacion de Dependencia",
  longitude varchar(30) COMMENT "Valor de longitud de ubicacion de Dependencia",
  cuadrant varchar(10) COMMENT "Cuadrante de Ubicacion de dependencia",
  status varchar(1) NOT NULL DEFAULT "A" COMMENT "Estatus del Registro. A - Activo / I - Inactivo.",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT "�ltima Fecha de actualizaci�n del registro.",
  
  PRIMARY KEY (id),
  KEY TOWN_DEPENDENCE_TOW_ID_KEY (town_id),
  CONSTRAINT DEPENDENCE_TOWN FOREIGN KEY (town_id) REFERENCES PGJ.TOWN(id)
) DEFAULT CHARSET=utf8 COMMENT "Tabla de Catalogo de Dependencias";

CREATE TABLE PGJ.DILIGENCE (
  id int(10) NOT NULL AUTO_INCREMENT COMMENT "Identificador �nico del Registro.",
  dependence_id int(10) NOT NULL COMMENT "Llave Foranea. Tabla Dependence. Dependencia asociada a la diligencia",
  street_and_no varchar(50) COMMENT "Calle y N�mero donde se suscito la diligencia",
  suburb varchar(50) COMMENT "Colonia donde se suscito la diligencia",
  town_id int(10) COMMENT "Llave Foranea. Tabla PGJ.TOWN. Identificador del municipio donde se suscito la diligencia.",
  postal_code varchar(10) COMMENT "Codigo postal donde se suscito la diligencia",
  between_st varchar(100) COMMENT "Calles entre las cuales se suscito la diligencia",
  latitude varchar(30) COMMENT "Valor de latitud donde se suscito la diligencia",
  longitude varchar(30) COMMENT "Valor de longitud donde se suscito la diligencia",
  cuadrant varchar(10) COMMENT "Cuadrante de Ubicacion de diligencia",
  status varchar(1) NOT NULL DEFAULT "A" COMMENT "Estatus del Registro. A - Activo / I - Inactivo.",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT "�ltima Fecha de actualizaci�n del registro.",
  
  PRIMARY KEY (id),
  KEY DEPENDENCE_DILIGENCE_DEPENDENCE_ID_KEY (dependence_id),
  KEY TOWN_DILIGENCE_TOWN_ID_KEY (town_id),
  
  CONSTRAINT DILIGENCE_DEPENDENCE FOREIGN KEY (dependence_id) REFERENCES PGJ.DEPENDENCE(id),
  CONSTRAINT DILIGENCE_TOWN FOREIGN KEY (town_id) REFERENCES PGJ.TOWN(id)
) DEFAULT CHARSET=utf8;


CREATE TABLE PGJ.EVIDENCE (
  id int(10) NOT NULL AUTO_INCREMENT COMMENT "Identificador �nico del Registro.",
  bar_code varchar(50) COMMENT "Valor de codigo de barras. (Implementacion en proximos despliegues)",
  report_id int(10) NOT NULL COMMENT "Llave For�nea. Tabla PGJ.REPORT. Identificador del reporte en el cual fue recolectado el indicio",
  lab_id int(10) NOT NULL COMMENT "Llave For�nea. Tabla PGJ.LAB. Identificador del Laboratorio al cual ser� asignado el indicio para su an�lisis",
  description varchar(1500) NOT NULL COMMENT "Descripcion del Indicio",
  image_path varchar(200) NOT NULL COMMENT "Ruta de imagen de Evidencia. (Si existe).",
  creation_date int(10) NOT NULL COMMENT "Fecha de Recolecci�n del Indicio.",
  is_procesed varchar(1) NOT NULL DEFAULT "N" COMMENT "Bandera para Identificar si el registro ya fue procesado",
  result varchar(500) COMMENT "Dictamen del an�lisis del Indicio",
  status varchar(1) NOT NULL DEFAULT "A" COMMENT "Estatus del Registro. A - Activo / I - Inactivo.",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT "�ltima Fecha de actualizaci�n del registro.",
  
  PRIMARY KEY (id),
  
  KEY EVIDENCE_REPORT_ID_KEY (report_id),
  KEY EVIDENCE_LAB_ID_KEY (lab_id),
  
  CONSTRAINT EVIDENCE_REPORT FOREIGN KEY (report_id) REFERENCES PGJ.REPORT(id),
  CONSTRAINT EVIDENCE_LAB FOREIGN KEY (lab_id) REFERENCES PGJ.LAB(id)
) DEFAULT CHARSET=utf8 COMMENT "Tabla de Almacenamiento de Indicios y Evidencia.";

CREATE TABLE PGJ.JUDGE (
  id int(10) NOT NULL AUTO_INCREMENT COMMENT "Identificador �nico del Registro.",
  judge_group_id int(10) NOT NULL COMMENT "Llave Foranea. Tabla PGJ.JUDGE_GROUP. Identificador del Grupo al que pertenece el Perito.",
  name varchar(50) NOT NULL COMMENT "Nombre del Perito",
  status varchar(1) NOT NULL DEFAULT "A" COMMENT "Estatus del Registro. A - Activo / I - Inactivo.",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT "�ltima Fecha de actualizaci�n del registro.",
  PRIMARY KEY (id),
  KEY JUDGE_GROUP_ID_KEY (judge_group_id),
  CONSTRAINT JUDGE_GROUP_JUDGE FOREIGN KEY (judge_group_id) REFERENCES PGJ.JUDGE_GROUP(id)
) DEFAULT CHARSET=utf8 COMMENT "Tabla de Cat�logos de Peritos.";

CREATE TABLE PGJ.JUDGE_GROUP (
  id int(10) NOT NULL AUTO_INCREMENT COMMENT "Identificador �nico del Registro.",
  name varchar(50) NOT NULL COMMENT "Nombre del Grupo de Peritos.",
  description varchar(250) COMMENT "Descripci�n del Grupo de Peritos.",
  status varchar(1) NOT NULL DEFAULT "A" COMMENT "Estatus del Registro. A - Activo / I - Inactivo.",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT "�ltima Fecha de actualizaci�n del registro.",
  PRIMARY KEY (id)
) DEFAULT CHARSET=utf8 COMMENT "Tabla de Cat�logos de Grupos de Peritos.";

CREATE TABLE PGJ.LAB (
  id int(10) NOT NULL AUTO_INCREMENT COMMENT "Identificador �nico del Registro.",
  name varchar(50) NOT NULL COMMENT "Nombre del Departamento o Laboratorio.",
  description varchar(100) NOT NULL COMMENT "Descripcion del departamento o Laboratorio",
  lab_type varchar(1) NOT NULL DEFAULT "L" COMMENT "Tipo de Departamento. L - Laboratorio / A Departamento de Administraci�n",
  status varchar(1) NOT NULL DEFAULT "A" COMMENT "Estatus del Registro. A - Activo / I - Inactivo.",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT "�ltima Fecha de actualizaci�n del registro.",
  PRIMARY KEY (id)
) DEFAULT CHARSET=utf8 COMMENT "Tabla de Cat�logo de Departamentos y Laboratorios";

CREATE TABLE PGJ.MARITAL_STATUS (
  id int(10) NOT NULL AUTO_INCREMENT COMMENT "Identificador �nico del Registro.",
  name varchar(50) NOT NULL COMMENT "Descripcion del estado civil.",
  status varchar(1) NOT NULL DEFAULT "A" COMMENT "Estatus del Registro. A - Activo / I - Inactivo.",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT "�ltima Fecha de actualizaci�n del registro.",
  PRIMARY KEY (id)
) DEFAULT CHARSET=utf8 COMMENT "Tabla de Cat�logo de estado civil de los implicados en el reporte.";

CREATE TABLE PGJ.MODUS_OPERANDI (
  id int(10) NOT NULL AUTO_INCREMENT COMMENT "Identificador �nico del Registro.",
  name varchar(50) NOT NULL COMMENT "Descripcion del Modus Operandi del Robo.",
  status varchar(1) NOT NULL DEFAULT "A" COMMENT "Estatus del Registro. A - Activo / I - Inactivo.",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT "�ltima Fecha de actualizaci�n del registro.",
  PRIMARY KEY (id)
) DEFAULT CHARSET=utf8 COMMENT "Tabla de Cat�logo de posibles modos de operaci�n de Robo.";


CREATE TABLE PGJ.PERSON (
  id int(10) NOT NULL AUTO_INCREMENT COMMENT "Identificador �nico del Registro.",
  
  type varchar(1) NOT NULL COMMENT "Tipo de Registro de Persona. V - Victima / P Presunto",
  report_detail_id	int(10) NOT NULL COMMENT	"Llave For�nea. PGJ.REPORT_DETAIL. Identificador del detalle al que pertenece el registro",
  
  name	varchar(50) NOT NULL COMMENT "Nombre de la Persona.",
  age	int(10)	NOT NULL COMMENT "Edad de la persona",
  sex_id	int(10) NOT NULL COMMENT	"Llave For�nea. Tabla PGJ.SEX. Identificador del sexo de la persona.",
  marital_status_id	int(10) NOT NULL	COMMENT "Llave For�nea. Tabla PGJ.MARITAL_STATUS.Identificador del estado civil de la persona.",
  aka	varchar(20)	COMMENT "Descripci�n del alias de la persona.",
  address	varchar(200) COMMENT 	"Domicilio de la persona.",
  complexion	varchar(50)	COMMENT "Complexi�n F�sica de la persona.",
  hair_color	varchar(30)	COMMENT "Color de Cabello de la persona.",
  skin_color	varchar(30)	COMMENT "Color de piel de la persona.",
  height	int(10)	COMMENT "Altura en cent�metros de la persona.",
  has_tatoos	varchar(1)	COMMENT "Bandera para identificar si la persona tiene tatuajes.",
  has_record	varchar(1)	COMMENT "Bandera para identificar si la persona tiene Antecedentes penales.",
  job	varchar(50)	COMMENT "Ocupaci�n de la persona.",
  workplace	varchar(50)	COMMENT "Lugar de Trabajo de la persona.",
  id_name	varchar(50)	COMMENT "Persona que Identifica el cad�ver o familiar de la v�ctima seg�n sea el caso",
  id_relationship_id	int(10)	COMMENT "Llave For�nea. Tabla PGJ.RELATIONSHIP. Relaci�n de Identificador con la persona seg�n sea el caso",
  id_ocupation	varchar(50)	COMMENT "Ocupaci�n de la Persona Relaci�n",
  id_address	varchar(100) COMMENT "Domicilio de la Persona Relaci�n",
  status varchar(1) NOT NULL DEFAULT "A" COMMENT "Estatus del Registro. A - Activo / I - Inactivo.",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT "�ltima Fecha de actualizaci�n del registro.",
  PRIMARY KEY (id),
  
  KEY PERSON_SEX_ID_KEY (sex_id),
  KEY PERSON_MARITAL_STATUS_ID_KEY(marital_status_id),
  CONSTRAINT PERSON_SEX FOREIGN KEY (sex_id) REFERENCES PGJ.SEX(id),
  CONSTRAINT PERSON_MARITAL_STATUS FOREIGN KEY (marital_status_id) REFERENCES PGJ.MARITAL_STATUS(id)
)DEFAULT CHARSET=utf8 COMMENT "Tabla de Almacenamiento de Personas, victimas y presuntos";


CREATE TABLE PGJ.RELATIONSHIP (
  id int(10) NOT NULL AUTO_INCREMENT COMMENT "Identificador �nico del Registro.",
  name varchar(100) NOT NULL COMMENT "Descripcion de la relacion",
  status varchar(1) NOT NULL DEFAULT "A" COMMENT "Estatus del Registro. A - Activo / I - Inactivo.",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT "�ltima Fecha de actualizaci�n del registro.",
  PRIMARY KEY (id)
) DEFAULT CHARSET=utf8 COMMENT "Tabla de Cat�logo de Parentescos.";


CREATE TABLE PGJ.REPORT (
  id int(10) NOT NULL AUTO_INCREMENT,
  date DATE NOT NULL,
  time varchar(5) NOT NULL,
  event_time varchar(5) NOT NULL,
  call_type_id int(10) NOT NULL,
  judge_group_id int(10) NOT NULL, -- GRUPO PERITOS
  no_judges int(1) NOT NULL,
  transport_unit varchar(30) NOT NULL,
  diligence_id int(10) NOT NULL, -- ID DILIGENCIA
  crime_id int(10) NOT NULL,     -- ID CRIMEN
  crime_category_id int(10) NOT NULL, -- ID CRIMEN_CATEGORIA
  crime_subcategory_id int(10) NOT NULL, -- ID CRIMEN_SUBCATEGORIA
  agency varchar(30),
  AMP varchar(30),
  report_relation varchar(10),
  av_number varchar(10),
  is_relevant varchar(1) NOT NULL DEFAULT "N",
  evidence_content varchar(1) NOT NULL DEFAULT "N",
  secundary_scene_no int(1) NOT NULL,
  is_suspects varchar(1) NOT NULL,
  status varchar(1) NOT NULL DEFAULT "A",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  
  PRIMARY KEY (id),
  KEY REPORT_CALL_TYPE_CALL_TYPE_ID_KEY (call_type_id),
  KEY REPORT_JUDGE_GROUP_JUDGE_GROUP_ID_KEY (judge_group_id),
  KEY REPORT_DILIGENCE_DILIGENCE_ID_KEY (diligence_id),
  KEY REPORT_CRIME_CRIME_ID_KEY (crime_id),
  KEY REPORT_CRIME_CAT_CRIME_CAT_ID_KEY (crime_category_id),
  KEY REPORT_CRIME_SUBCAT_CRIME_SUBCAT_ID_KEY (crime_subcategory_id),
  
  CONSTRAINT REPORT_CALL_TYPE FOREIGN KEY (call_type_id) REFERENCES PGJ.CALL_TYPE(id),
  CONSTRAINT REPORT_JUDGE_GROUP FOREIGN KEY (judge_group_id) REFERENCES PGJ.JUDGE_GROUP(id),
  CONSTRAINT REPORT_DILIGENCE FOREIGN KEY (diligence_id) REFERENCES PGJ.DILIGENCE(id),
  CONSTRAINT REPORT_CRIME FOREIGN KEY (crime_id) REFERENCES PGJ.CRIME(id),
  CONSTRAINT REPORT_CRIME_CATEGORY FOREIGN KEY (crime_category_id) REFERENCES PGJ.CRIME_CATEGORY(id),
  CONSTRAINT REPORT_CRIME_SUBCATEGORY FOREIGN KEY (crime_subcategory_id) REFERENCES PGJ.CRIME_SUBCATEGORY(id)
) DEFAULT CHARSET=utf8;







CREATE TABLE PGJ.REPORT_JUDGES (
  id int(10) NOT NULL AUTO_INCREMENT,
  report_id int(10) NOT NULL,
  judge_id int(10) NOT NULL,
  status varchar(1) NOT NULL DEFAULT "A",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  
  PRIMARY KEY (id),
  
  KEY REPORT_JUDGES_REPORT_ID_KEY (report_id),
  KEY REPORT_JUDGES_JUDGES_ID_KEY (judge_id),
  
  CONSTRAINT REPORT_JUDGE_REPORT FOREIGN KEY (report_id) REFERENCES PGJ.REPORT(id),
  CONSTRAINT REPORT_JUDGE_JUDGE FOREIGN KEY (judge_id) REFERENCES PGJ.JUDGE(id)
) DEFAULT CHARSET=utf8;

CREATE TABLE PGJ.REPORT_SCENES (
  id int(10) NOT NULL AUTO_INCREMENT,
  report_id int(10) NOT NULL,
  scene_description varchar(250) NOT NULL,
  status varchar(1) NOT NULL DEFAULT "A",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  
  PRIMARY KEY (id),
  
  KEY REPORT_SCENES_REPORT_ID_KEY (report_id),  
  CONSTRAINT REPORT_SCENES_REPORT FOREIGN KEY (report_id) REFERENCES PGJ.REPORT(id)
) DEFAULT CHARSET=utf8;

CREATE TABLE PGJ.TOWN (
  id int(10) NOT NULL AUTO_INCREMENT COMMENT "Identificador �nico del Registro.",
  name varchar(50) NOT NULL COMMENT "Nombre del Municipio.",
  status varchar(1) NOT NULL DEFAULT "A" COMMENT "Estatus del Registro. A - Activo / I - Inactivo.",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT "�ltima Fecha de actualizaci�n del registro.",
  PRIMARY KEY (id)
) DEFAULT CHARSET=utf8 COMMENT "Tabla de listado de Municipios del Estado de Nuevo Le�n.";

CREATE TABLE PGJ.SEX (
  id int(10) NOT NULL AUTO_INCREMENT,
  code varchar(50) NOT NULL,
  description varchar(100) NOT NULL,
  status varchar(1) NOT NULL DEFAULT "A",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
) DEFAULT CHARSET=utf8;