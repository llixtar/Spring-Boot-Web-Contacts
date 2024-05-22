
CREATE DATABASE demo_db;

CREATE TABLE IF NOT EXISTS contacts
( id INTEGER NOT NULL AUTO_INCREMENT,
  image VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  surname VARCHAR(255) NOT NULL,
  phone VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);


INSERT INTO
	contacts (image, name, surname, phone)
VALUES
	('dog.jpg', 'Butcher', 'Saliva', '+38 050 576 3836'),
	('cat.jpg', 'Tom', 'Lazy', '+38 099 457 0965'),
	('rabbit.jpg', 'Bunny', 'Fast', '+38 63 381 9408');


