create table orm_hibernate_hw.person (
name VARCHAR(255) NOT NULL UNIQUE ,
surname VARCHAR(255) NOT NULL UNIQUE ,
age INT NOT NULL UNIQUE ,
phone_number VARCHAR(20) NOT NULL,
city_of_living VARCHAR(100),
CONSTRAINT person_pkey PRIMARY KEY (name, surname, age)
);
