SELECT picture.name, picture.pic_path, photographer.lastname, exif.make FROM picture
JOIN photographer on picture.fk_photographer = photographer.id
JOIN exif on picture.id = exif.fk_picture_id;