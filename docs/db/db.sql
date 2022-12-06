CREATE TABLE car (
	id integer PRIMARY KEY AUTOINCREMENT,
	model_id integer NOT NULL REFERENCES model(id),
	fuel_type varchar NOT NULL,
	transmission varchar NOT NULL,
	year integer NOT NULL,
	color varchar NOT NULL,
	comfort_lvl integer NOT NULL,
	price integer NOT NULL
);

CREATE TABLE contract (
	id integer PRIMARY KEY,
	car_id integer NOT NULL  REFERENCES car(id),
	person_id integer NOT NULL  REFERENCES person(id),
	start_time datetime NOT NULL,
	end_time datetime NOT NULL
);

CREATE TABLE person (
	id integer PRIMARY KEY AUTOINCREMENT,
	first_name varchar NOT NULL,
	last_name varchar NOT NULL,
	phone_number integer NOT NULL,
	passport_id varchar NOT NULL,
	password varchar NOT NULL,
	email varchar NOT NULL
);

CREATE TABLE model (
	id integer PRIMARY KEY AUTOINCREMENT,
	brend varchar NOT NULL,
	model varchar NOT NULL
);




