CREATE DATABASE picdb;
USE picdb;

CREATE TABLE IF NOT EXISTS photographer
(
    id        INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(100) NOT NULL,
    lastname  VARCHAR(50)  NOT NULL,
    notes     TEXT,
    birthdate DATE
);

CREATE TABLE IF NOT EXISTS picture
(
    id              INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name            VARCHAR(30)  NOT NULL,
    fk_photographer INT UNSIGNED,
    FOREIGN KEY (fk_photographer) REFERENCES photographer (id),
    pic_path        VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS iptc
(
    id              INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    fk_picture_id   INT UNSIGNED,
    keywords        VARCHAR(255),
    copyrightNotice VARCHAR(255),
    headline        VARCHAR(255),
    FOREIGN KEY (fk_picture_id) REFERENCES picture (id)
);

CREATE TABLE IF NOT EXISTS exif
(
    id               INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    fk_picture_id    INT UNSIGNED,
    make             VARCHAR(255),
    fNumber          FLOAT,
    exposureTime     DOUBLE,
    isoValue         DOUBLE,
    flash            BOOLEAN,
    exposurePrograms TINYINT,
    FOREIGN KEY (fk_picture_id) REFERENCES picture (id)
);

commit;

DROP DATABASE picdb;

SELECT * FROM picture
JOIN iptc on picture.id = iptc.fk_picture_id
JOIN photographer p on picture.fk_photographer = p.id
WHERE keywords like "%%" or lastname like "";