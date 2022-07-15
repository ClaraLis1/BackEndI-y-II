
create table IF NOT EXISTS domicilio(id Long auto_increment primary key,calle varchar(255),numero varchar (255),localidad varchar (255),provincia varchar (255));
create table IF NOT EXISTS paciente(id Long auto_increment primary key,nombre varchar(255),apellido varchar (255),dni varchar (255),fecha_ingreso DATE,domicilio_id Long);
create table IF NOT EXISTS odontologo(id Long auto_increment primary key,nombre varchar(255),apellido varchar (255),matricula int);
