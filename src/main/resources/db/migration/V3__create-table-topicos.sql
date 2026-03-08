CREATE TABLE topicos(
    id bigint NOT NULL auto_increment,
    titulo VARCHAR(100) NOT NULL,
    mensaje VARCHAR(250) NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    status VARCHAR(50),
    usuario_id bigint NOT NULL,
    curso_id bigint NOT NULL,

    PRIMARY KEY(id),
    CONSTRAINT fk_topicos_usuario_id FOREIGN KEY(usuario_id) REFERENCES usuarios(id),
    CONSTRAINT fk_topicos_curso_id FOREIGN KEY(curso_id) REFERENCES cursos(id)
);