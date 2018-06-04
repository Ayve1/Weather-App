/*
* Creates database pollution_db
* user: pollution_db with password: pollution_db
*/

create database pollution_db
go
	use pollution_db
go
	EXEC sp_addlogin @loginame='pollution_db',@passwd='pollution_db',@defdb=pollution_db
	EXEC sp_adduser @loginame='pollution_db'
	EXEC sp_addrolemember @rolename = 'db_owner',@membername='pollution_db' 
go

CREATE TABLE district (
	id VARCHAR(18) NOT NULL CONSTRAINT pk_district PRIMARY KEY,
	name VARCHAR(19) NOT NULL
)

CREATE TABLE component (
	id VARCHAR(5) NOT NULL CONSTRAINT pk_component PRIMARY KEY,
	name VARCHAR(22) NOT NULL
)

CREATE TABLE measurement (
	id INT NOT NULL IDENTITY PRIMARY KEY,
	component_id VARCHAR(5) NOT NULL CONSTRAINT fk_component FOREIGN KEY REFERENCES component(id),
	district_id VARCHAR(18) NOT NULL CONSTRAINT fk_district FOREIGN KEY REFERENCES district(id),
	datetime DATETIME NOT NULL,
	value FLOAT NOT NULL 
)

/*
* populates district table
*/
INSERT INTO district VALUES ('mazowieckie', 'mazowieckie')
INSERT INTO district VALUES ('dolnoslaskie', 'dolnośląskie')
INSERT INTO district VALUES ('kujawsko', 'kujawsko-pomorskie')
INSERT INTO district VALUES ('lubelskie', 'lubelskie')
INSERT INTO district VALUES ('lubuskie', 'lubuskie')
INSERT INTO district VALUES ('lodzkie', 'łódzkie')
INSERT INTO district VALUES ('malopolskie', 'małopolskie')
INSERT INTO district VALUES ('opolskie', 'opolskie')
INSERT INTO district VALUES ('podkarpackie', 'podkarpackie')
INSERT INTO district VALUES ('podlaskie', 'podlaskie')
INSERT INTO district VALUES ('pomorskie', 'pomorskie')
INSERT INTO district VALUES ('slaskie', 'śląskie')
INSERT INTO district VALUES ('swietokrzyskie', 'świętokrzyskie')
INSERT INTO district VALUES ('warminsko', 'warmińsko-mazurskie')
INSERT INTO district VALUES ('wielkopolskie', 'wielkopolskie')
INSERT INTO district VALUES ('zachodniopomorskie', 'zachodniopomorskie')

/*
* populates component table
*/
INSERT INTO component VALUES ('c6h6', 'benzen (C6H6)')
INSERT INTO component VALUES ('co', 'tlenek węgla (CO)')
INSERT INTO component VALUES ('no2', 'dwutlenek azotu (NO2)')
INSERT INTO component VALUES ('o3', 'ozon (O3)')
INSERT INTO component VALUES ('so2', 'dwutlenek siarki (SO2)')
INSERT INTO component VALUES ('pm10', 'pył zawieszony PM10')
INSERT INTO component VALUES ('pm2.5', 'pył zawieszony PM2.5')

