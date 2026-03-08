CREATE TABLE usuarios(
    id bigint NOT NULL auto_increment,
    nombre VARCHAR(100) NOT NULL,
    correo_electronico VARCHAR(100) NOT NULL UNIQUE,
    contrasena VARCHAR(100) NOT NULL,

    PRIMARY KEY(id)
);