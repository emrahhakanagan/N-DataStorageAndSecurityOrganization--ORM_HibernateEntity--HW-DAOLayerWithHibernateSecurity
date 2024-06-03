CREATE TABLE orm_hibernate_hw.person (
id BIGSERIAL NOT NULL,
name VARCHAR(100) NOT NULL,
surname VARCHAR(100) NOT NULL,
age INT NOT NULL,
phone_number VARCHAR(20) NOT NULL,
city_of_living VARCHAR(100),

CONSTRAINT person_pkey PRIMARY KEY (name, surname, age),
CONSTRAINT unique_phone_number UNIQUE (phone_number)
);