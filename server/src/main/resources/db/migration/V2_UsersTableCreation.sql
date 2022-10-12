CREATE TYPE ROLE AS ENUM ('CENTRAL', 'DEFAULT');
CREATE TABLE ocado_initiatives.users (
    userId SERIAL,
    role ROLE NOT NULL,
    PRIMARY KEY (userId)
);