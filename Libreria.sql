create database Libreria;

create  table Libros(
 idlibro int primary key auto_increment, 
 libro varchar(50),
 autor varchar(50),
 paginas int,
 precio decimal


 );