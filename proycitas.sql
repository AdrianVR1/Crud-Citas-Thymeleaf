create database citasbd;
use citasbd;

create table pacientes (
idpacientes int auto_increment,
nombre varchar(50),
apellido varchar(50),
fechanac date,
direccion varchar(250),
telefono varchar(15),
primary key(idpacientes)
);

create table especialidad(
idespecialidad int auto_increment,
nombre varchar(50),
primary key(idEspecialidad)
);

create table doctores(
iddoctores int auto_increment,
nombre varchar(50),
apellido varchar(50),
telefono varchar(15),
idespecialidad int,
primary key(iddoctores),
foreign key(idespecialidad) references especialidad(idespecialidad)
);

create table citas(
idcitas int auto_increment,
fecha date,
motivo varchar(300),
observaciones varchar(100),
idpacientes int,
iddoctores int,
idespecialidad int,
primary key (idcitas),
foreign key(idpacientes) references pacientes(idpacientes),
foreign key(iddoctores) references doctores(iddoctores),
foreign key(idespecialidad) references especialidad(idespecialidad)
);
select * from citas;

INSERT INTO pacientes (nombre, apellido, fechanac, direccion, telefono)
VALUES
   ('Juan', 'Martínez', '1990-05-15', 'Calle Principal 123', '123456789'),
    ('María', 'Gómez', '1985-10-25', 'Avenida Central 456', '987654321'),
    ('Jose', 'Galvez', '1985-10-25', 'Avenida Central 456', '987654321');
     
INSERT INTO especialidad (nombre)
VALUES
   ('Dental'),
   ('Obstetricia'),
   ('Pediatria'),
   ('Radiologia');


 INSERT INTO doctores (nombre, apellido, telefono, idespecialidad) VALUES
('Juan', 'González', '1234567890', 1),  
('María', 'López', '9876543210', 2),    
('Carlos', 'Martínez', '5551234567', 3);
    
    
    INSERT INTO citas (fecha, motivo, observaciones, idpacientes, iddoctores,idespecialidad)
VALUES 
    ('2024-05-10', 'Control anual', 'Todo en orden', 1,2,2), 
    ('2024-04-20', 'Consulta Dental', 'Recetar medicación', 2,3,3), 
    ('2024-06-05', 'Consulta Dental', 'Caries', 3,1,1); 