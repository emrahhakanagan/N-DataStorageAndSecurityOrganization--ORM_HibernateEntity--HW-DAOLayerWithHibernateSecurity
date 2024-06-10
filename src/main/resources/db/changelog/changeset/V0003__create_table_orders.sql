CREATE TABLE orm_hibernate_hw.orders (
id BIGSERIAL PRIMARY KEY NOT NULL,
amount DOUBLE PRECISION NOT NULL,
payment_type VARCHAR(100),
date DATE NOT NULL,
customer_name VARCHAR(100) NOT NULL,
customer_surname VARCHAR(100) NOT NULL,
customer_age INT NOT NULL,

CONSTRAINT fk_person FOREIGN KEY (customer_name, customer_surname, customer_age)
REFERENCES orm_hibernate_hw. (name, surname, age)
);
