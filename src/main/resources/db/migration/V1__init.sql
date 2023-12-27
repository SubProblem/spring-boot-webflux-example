CREATE TABLE users(
    id SERIAL NOT NULL PRIMARY KEY,
    firstname VARCHAR(250),
    lastname VARCHAR(250),
    age INTEGER,
    email VARCHAR(250),
    password VARCHAR(250)
)


