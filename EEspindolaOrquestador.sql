CREATE TABLE Usuario(
    IdUsuario NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    Folio VARCHAR(1000),
    Nombre VARCHAR(50) NOT NULL,
    ApellidoPaterno VARCHAR(50) NOT NULL,
    ApellidoMaterno VARCHAR(50) NOT NULL,
    FechaNacimiento DATE NOT NULL,
    Username VARCHAR(50) NOT NULL,
    Email VARCHAR(50) NOT NULL,
    Password VARCHAR(50) NOT NULL,
    Status CHAR(1)
);

ALTER TABLE Usuario
MODIFY Status DEFAULT 1 NOT NULL;

ALTER TABLE Usuario
MODIFY Password VARCHAR(100);

INSERT INTO Usuario(Folio, Nombre, ApellidoPaterno, ApellidoMaterno, FechaNacimiento, Username, Email, Password) 
VALUES('07868985','Samantha','Parra','Fuentes',TO_DATE('2000-12-12', 'yyyy-MM-dd'),'Sam','samantha@hotmail.com','1234');

INSERT INTO Usuario(Folio, Nombre, ApellidoPaterno, ApellidoMaterno, FechaNacimiento, Username, Email, Password) 
VALUES('87645234','Valentina','Lopez','Ramirez',TO_DATE('2001-11-11', 'yyyy-MM-dd'),'Vale','valentina@hotmail.com','qwerty');

INSERT INTO Usuario(Folio, Nombre, ApellidoPaterno, ApellidoMaterno, FechaNacimiento, Username, Email, Password) 
VALUES('ÑLJSGDSDG0874Q0425','Dante','Lopez','Vazquez',TO_DATE('2002-10-10', 'yyyy-MM-dd'),'Danonino','dante@hotmail.com','0000');

INSERT INTO Usuario(Folio, Nombre, ApellidoPaterno, ApellidoMaterno, FechaNacimiento, Username, Email, Password) 
VALUES('LKJSFGLK12359869','Cacho','Alcantara','Fuentes',TO_DATE('2003-09-09', 'yyyy-MM-dd'),'Enano','cachito@hotmail.com','1234');

INSERT INTO Usuario(Folio, Nombre, ApellidoPaterno, ApellidoMaterno, FechaNacimiento, Username, Email, Password) 
VALUES('LKJG234LYG467G23K','Mechas','Espindola','Alcantara',TO_DATE('1999-01-01', 'yyyy-MM-dd'),'Estopas','mechas@hotmail.com','1111');


// ALTER TABLE Usuario
// ADD Rol VARCHAR(20) DEFAULT 'USER' NOT NULL;


SELECT * FROM ViewUsuario;

CREATE VIEW ViewUsuario AS
    SELECT IdUsuario, Folio, Nombre, ApellidoPaterno, ApellidoMaterno, FechaNacimiento, Username, Email, Password, Status
    FROM Usuario;