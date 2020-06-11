INSERT INTO photographer(FIRSTNAME, LASTNAME, NOTES, BIRTHDATE)
VALUES ('Sasan', 'Jaghori', 'Best Photographer ever!', '1998/08/12'),
       ('Deniz', 'Oezalp', 'Not so bad!', '1994/01/10');

INSERT INTO picture(name, fk_photographer, pic_path)
VALUES ('parrot.jpg', 1, './images/parrot.jpg'),
       ('parrot_potrait.jpg', 1, './images/parrot_portrait.jpg'),
       ('portrait_girl.jpg', 2, './images/portrait_girl.jpg'),
       ('pyrenees.jpg', 2, './images/pyrenees.jpg');

INSERT INTO iptc(fk_picture_id, keywords, copyrightNotice, headline)
VALUES (1, 'nature, bird', 'No Copyright', 'Beautiful Parrot showing off'),
       (2, 'bird', 'No Copyright', 'Parrot Portrait'),
       (3, 'woman', 'No Copyright', 'Portrait of a Woman'),
       (4,'space, geographie', 'No Copyright', 'Image from Space');

INSERT INTO exif(fk_picture_id, make, fNumber, exposureTime, isoValue, flash, exposurePrograms)
VALUES (1, 'Canon EOS 2000D SLR', 5.6, 0.004, 5000, TRUE, 2),
       (2, 'Sony DSC-H300', 2, 0.002, 2000, TRUE, 3),
       (3, 'Nikon D7500', 4, 0.003, 3000, FALSE, 7),
       (4, 'Instax mini 9', 1.4, 0.001, 100, FALSE, 8);

COMMIT;