GRANT ALL PRIVILEGES ON *.* TO 'PGJ'@'localhost' IDENTIFIED BY 'pgj' WITH GRANT OPTION;
COMMIT;

CREATE DATABASE PGJ;

CREATE TABLE PGJ.CRIME(
  id int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name varchar(50) NOT NULL,
  status varchar(1) NOT NULL DEFAULT "A",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)DEFAULT CHARSET=utf8;

CREATE TABLE PGJ.CRIME_CATEGORY (
  id int(10) NOT NULL AUTO_INCREMENT,
  crime_id int(10) NOT NULL,
  name varchar(50) NOT NULL,
  status varchar(1) NOT NULL DEFAULT "A",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  KEY CRIME_ID_KEY (crime_id),
  CONSTRAINT CRIME_CATEGORY_CRIME FOREIGN KEY (crime_id) REFERENCES PGJ.CRIME (id)
) DEFAULT CHARSET=utf8;

CREATE TABLE PGJ.CRIME_SUBCATEGORY (
  id int(10) NOT NULL AUTO_INCREMENT,
  crime_category_id int(10) NOT NULL,
  name varchar(50) NOT NULL,
  status varchar(1) NOT NULL DEFAULT "A",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  KEY CRIME_CATEGORY_ID_KEY (crime_category_id),
  CONSTRAINT CRIME_SUBCAT_CRIME_CAT FOREIGN KEY (crime_category_id) REFERENCES PGJ.CRIME_SUBCATEGORY (id)
) DEFAULT CHARSET=utf8;

CREATE TABLE PGJ.TOWN (
  id int(10) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  status varchar(1) NOT NULL DEFAULT "A",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
) DEFAULT CHARSET=utf8;

CREATE TABLE PGJ.JUDGE_GROUP (
  id int(10) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  description varchar(250),
  status varchar(1) NOT NULL DEFAULT "A",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
) DEFAULT CHARSET=utf8;

CREATE TABLE PGJ.JUDGE (
  id int(10) NOT NULL AUTO_INCREMENT,
  judge_group_id int(10) NOT NULL,
  name varchar(50) NOT NULL,
  status varchar(1) NOT NULL DEFAULT "A",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  KEY JUDGE_GROUP_ID_KEY (judge_group_id),
  CONSTRAINT JUDGE_GROUP_JUDGE FOREIGN KEY (judge_group_id) REFERENCES PGJ.JUDGE_GROUP(id)
) DEFAULT CHARSET=utf8;

CREATE TABLE PGJ.DEPENDENCE (
  id int(10) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  street_and_no varchar(50) NOT NULL,
  suburb varchar(50) NOT NULL,
  town_id int(10) NOT NULL,
  postal_code varchar(10) NOT NULL,
  between_st varchar(100),
  latitude varchar(30),
  longitude varchar(30),
  cuadrant varchar(10),
  
  status varchar(1) NOT NULL DEFAULT "A",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  
  PRIMARY KEY (id),
  KEY TOWN_DEPENDENCE_TOW_ID_KEY (town_id),
  CONSTRAINT DEPENDENCE_TOWN FOREIGN KEY (town_id) REFERENCES PGJ.TOWN(id)
) DEFAULT CHARSET=utf8;

CREATE TABLE PGJ.LAB (
  id int(10) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  description varchar(100) NOT NULL,
  lab_type varchar(1) NOT NULL DEFAULT "L",
  status varchar(1) NOT NULL DEFAULT "A",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
) DEFAULT CHARSET=utf8;

CREATE TABLE CALL_TYPE (
  id int(10) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  status varchar(1) NOT NULL DEFAULT 'A',
  last_update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE PGJ.SEX (
  id int(10) NOT NULL AUTO_INCREMENT,
  code varchar(50) NOT NULL,
  description varchar(100) NOT NULL,
  status varchar(1) NOT NULL DEFAULT "A",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
) DEFAULT CHARSET=utf8;

CREATE TABLE PGJ.RELATIONSHIP (
  id int(10) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  status varchar(1) NOT NULL DEFAULT "A",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
) DEFAULT CHARSET=utf8;

-- INICIO DE DEFINICION DE TABLAS DE CONTENIDO

CREATE TABLE PGJ.DILIGENCE (
  id int(10) NOT NULL AUTO_INCREMENT,
  dependence_id int(10) NOT NULL,
  name varchar(50) NOT NULL,
  street_and_no varchar(50) NOT NULL,
  suburb varchar(50) NOT NULL,
  town_id int(10) NOT NULL,
  postal_code varchar(10) NOT NULL,
  between_st varchar(100),
  latitude varchar(30),
  longitude varchar(30),
  cuadrant varchar(10),
  
  status varchar(1) NOT NULL DEFAULT "A",
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  
  PRIMARY KEY (id),
  KEY DEPENDENCE_DILIGENCE_DEPENDENCE_ID_KEY (dependence_id),
  KEY TOWN_DILIGENCE_TOWN_ID_KEY (town_id),
  
  CONSTRAINT DILIGENCE_DEPENDENCE FOREIGN KEY (dependence_id) REFERENCES PGJ.DEPENDENCE(id),
  CONSTRAINT DILIGENCE_TOWN FOREIGN KEY (town_id) REFERENCES PGJ.TOWN(id)
) DEFAULT CHARSET=utf8;

CREATE TABLE PGJ.REPORT (
  id int(10) NOT NULL AUTO_INCREMENT,
  date DATE NOT NULL,
  time varchar(5) NOT NULL,
  event_time varchar(5) NOT NULL,
  call_type_id int(10) NOT NULL,
  judge_group_id int(10) NOT NULL, -- GRUPO PERITOS
  no_judges int(1) NOT NULL,
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

