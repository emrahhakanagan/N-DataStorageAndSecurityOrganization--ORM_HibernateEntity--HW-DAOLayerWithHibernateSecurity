create table orm_hibernate_hw.person (
id BIGSERIAL,
name VARCHAR(255) NOT NULL,
surname VARCHAR(255) NOT NULL,
age INT NOT NULL,
phone_number VARCHAR(20) NOT NULL,
city_of_living VARCHAR(100),
CONSTRAINT person_pkey PRIMARY KEY (name, surname, age)
);
