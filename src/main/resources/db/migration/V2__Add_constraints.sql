-- Añadir constraints a usuarios
ALTER TABLE usuarios
ADD CONSTRAINT uk_usuario_email UNIQUE (email),
MODIFY COLUMN nombre VARCHAR(255) NOT NULL;

-- Añadir índice a proyectos
CREATE INDEX idx_proyectos_lenguaje ON proyectos(lenguaje);