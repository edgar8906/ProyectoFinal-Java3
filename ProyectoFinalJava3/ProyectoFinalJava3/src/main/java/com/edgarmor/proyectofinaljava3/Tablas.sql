create table Agencia (idAgencia integer primary key auto_increment,
                  nomAgencia varchar(50) );

create table Proveedores (idProv  integer primary key auto_increment,
                           nomProv varchar(50)  );

create table Autos (idAuto integer primary key auto_increment, idAgencia integer, idProv integer,
                           nomAuto varchar(50),
                           costo  float,
                           foreign key (idAgencia) references Agencia (idAgencia),
                           foreign key (idProv) references Proveedores (idProv)  );

select * from Autos;


