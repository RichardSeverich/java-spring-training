-- ONE TO ONE SCHEMAS
-- Account
INSERT INTO account (id, cash)
VALUES (1, 1000),
       (2, 2000),
       (3, 3000);
-- Client
INSERT INTO client (id, name, account_id)
VALUES (1, 'Andres Garcia', 1),
       (2, 'Cristiano Gonzalez', 2),
       (3, 'Gerard Fernandez', 3);
