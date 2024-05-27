ALTER TABLE orm_hibernate_hw.orders ADD CONSTRAINT fk_customers
    FOREIGN KEY (customer_name, customer_surname, customer_age)
    REFERENCES orm_hibernate_hw.person (name, surname, age);