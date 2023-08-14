CREATE TABLE driver(
    id SERIAL PRIMARY KEY,
    name TEXT,
    age SMALLINT,
    driverLicense BOOLEAN,
    car_id INTEGER REFERENCES car (id)
);

CREATE TABLE car(
    id SERIAL PRIMARY KEY,
    brand TEXT,
    price MONEY
);




