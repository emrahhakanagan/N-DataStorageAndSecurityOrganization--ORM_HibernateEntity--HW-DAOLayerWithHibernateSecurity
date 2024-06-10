CREATE TABLE orm_hibernate_hw.users (
id BIGSERIAL PRIMARY KEY NOT NULL,
login_phone_number VARCHAR(20) NOT NULL,
password VARCHAR(255) NOT NULL,
roles VARCHAR(255),

CONSTRAINT fk_person FOREIGN KEY (login_phone_number)
REFERENCES orm_hibernate_hw.person (phone_number)
);
