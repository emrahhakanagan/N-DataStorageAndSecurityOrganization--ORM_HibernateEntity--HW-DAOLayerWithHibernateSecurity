create table orm_hibernate_hw.orders (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    date DATE NOT NULL,
    amount DOUBLE PRECISION NOT NULL,
    payment_type VARCHAR(255)
);