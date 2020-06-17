INSERT INTO photographer(FIRSTNAME, LASTNAME, NOTES, BIRTHDATE)
VALUES ('Sasan', 'Jaghori', 'Best Photographer ever!', '1998/08/12'),
       ('Deniz', 'Oezalp', 'Not so bad!', '1994/01/10'),
       ('John', 'Cena', 'Unseen Talent!', '1970/12/16'),
       ('Keanu', 'Reeves', 'Breathtaking!', '1960/02/22'),
       ('Max', 'Muster', 'Best Example!', '1989/03/15'),
       (NULL, 'John', NULL, '1950/07/11'),
       (NULL, 'Jane', NULL, '1952/08/14');

INSERT  INTO picture(name, fk_photographer, pic_path)
VALUES ('parrot.jpg', 1, './images/parrot.jpg'),
       ('parrot_potrait.jpg', 1, './images/parrot_portrait.jpg'),
       ('portrait_girl.jpg', 2, './images/portrait_girl.jpg'),
       ('pyrenees.jpg', 2, './images/pyrenees.jpg'),
       ('nature.jpeg', 3, './images/nature.jpeg'),
       ('grumpy.jpg', 2, './images/grumpy.jpg'),
       ('mirror.jpg', 2, './images/mirror.jpg');

INSERT INTO iptc(fk_picture_id, keywords, copyrightNotice, headline)
VALUES (1, 'nature, bird', 'No Copyright', 'Beautiful Parrot showing off'),
       (2, 'bird', 'No Copyright', 'Parrot Portrait'),
       (3, 'woman', 'No Copyright', 'Portrait of a Woman'),
       (4,'space, geography', 'No Copyright', 'Image from Space'),
       (5,'nature', 'No Copyright', 'Beautiful Nature'),
       (6,'cat', 'No Copyright', 'Grumpy Cat'),
       (7,'mirror', 'No Copyright', NULL);

INSERT INTO exif(fk_picture_id, make, fNumber, exposureTime, isoValue, flash, exposurePrograms)
VALUES (1, 'Canon EOS 2000D SLR', 5.6, 0.004, 5000, TRUE, 2),
       (2, 'Sony DSC-H300', 2, 0.002, 2000, TRUE, 3),
       (3, 'Nikon D7500', 4, 0.003, 3000, FALSE, 7),
       (4, 'Instax mini 9', 1.4, 0.001, 100, FALSE, 8),
       (5, 'Canon EOS 4000D', 1.4, 0.001, 100, FALSE, 3),
       (6, 'Panasonic LUMIX', 2.4, 0.003, 1000, FALSE, 4),
       (7, 'Canon SX620', NULL, 0.003, 1000, NULL, NULL);
COMMIT;