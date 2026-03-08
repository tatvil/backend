CREATE DATABASE formula1 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE formula1;

-- ======================
-- TEMPORADAS
-- ======================
CREATE TABLE temporadas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    anio YEAR NOT NULL UNIQUE
) ENGINE=InnoDB;

-- ======================
-- PILOTOS
-- ======================
CREATE TABLE pilotos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE,
    nacionalidad VARCHAR(100),
    numero INT,
    codigo VARCHAR(3)
) ENGINE=InnoDB;

-- ======================
-- ESCUDERIAS
-- ======================
CREATE TABLE escuderias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    pais VARCHAR(100),
    motor VARCHAR(100)
) ENGINE=InnoDB;

-- ======================
-- PILOTO - ESCUDERIA (por temporada)
-- ======================
CREATE TABLE piloto_escuderia (
    id INT AUTO_INCREMENT PRIMARY KEY,
    piloto_id INT NOT NULL,
    escuderia_id INT NOT NULL,
    temporada_id INT NOT NULL,

    FOREIGN KEY (piloto_id) REFERENCES pilotos(id) ON DELETE CASCADE,
    FOREIGN KEY (escuderia_id) REFERENCES escuderias(id) ON DELETE CASCADE,
    FOREIGN KEY (temporada_id) REFERENCES temporadas(id) ON DELETE CASCADE,

    UNIQUE (piloto_id, temporada_id)
) ENGINE=InnoDB;

-- ======================
-- CIRCUITOS
-- ======================
CREATE TABLE circuitos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    ciudad VARCHAR(150),
    pais VARCHAR(100),
    latitud DECIMAL(9,6),
    longitud DECIMAL(9,6),
    altitud_metros INT,
    longitud_km DECIMAL(5,3),
    vueltas INT
) ENGINE=InnoDB;

-- ======================
-- CARRERAS
-- ======================
CREATE TABLE carreras (
    id INT AUTO_INCREMENT PRIMARY KEY,
    temporada_id INT NOT NULL,
    circuito_id INT NOT NULL,
    nombre_gp VARCHAR(150) NOT NULL,
    fecha DATE NOT NULL,
    tipo ENUM('normal','sprint') DEFAULT 'normal',

    FOREIGN KEY (temporada_id) REFERENCES temporadas(id) ON DELETE CASCADE,
    FOREIGN KEY (circuito_id) REFERENCES circuitos(id) ON DELETE CASCADE
) ENGINE=InnoDB;

-- ======================
-- RESULTADOS
-- ======================
CREATE TABLE resultados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    carrera_id INT NOT NULL,
    piloto_id INT NOT NULL,
    posicion INT,
    puntos DECIMAL(5,2),
    tiempo VARCHAR(50),
    abandono BOOLEAN DEFAULT FALSE,
    vuelta_rapida BOOLEAN DEFAULT FALSE,

    FOREIGN KEY (carrera_id) REFERENCES carreras(id) ON DELETE CASCADE,
    FOREIGN KEY (piloto_id) REFERENCES pilotos(id) ON DELETE CASCADE,

    UNIQUE (carrera_id, piloto_id)
) ENGINE=InnoDB;

-- ======================
-- ÍNDICES PARA ESTADÍSTICAS
-- ======================
CREATE INDEX idx_resultados_piloto ON resultados(piloto_id);
CREATE INDEX idx_resultados_carrera ON resultados(carrera_id);
CREATE INDEX idx_carreras_temporada ON carreras(temporada_id);