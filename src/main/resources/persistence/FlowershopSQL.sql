-- Crea la base de datos flower_shop si no existe
DROP DATABASE IF EXISTS flower_shop;
CREATE DATABASE IF NOT EXISTS flower_shop;

-- Utiliza la base de datos flower_shop
USE flower_shop;

-- Crea la tabla Product
CREATE TABLE IF NOT EXISTS Product (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    sell_price DOUBLE,
    cost_price DOUBLE,
    stock INT,
    type VARCHAR(50)
);

-- Crea la tabla Tree
CREATE TABLE IF NOT EXISTS Tree (
    tree_id INT PRIMARY KEY,
    height INT,
    FOREIGN KEY (tree_id) REFERENCES Product(product_id)
);

-- Crea la tabla Decoration
CREATE TABLE IF NOT EXISTS Decoration (
    decoration_id INT PRIMARY KEY,
    material VARCHAR(255),
    FOREIGN KEY (decoration_id) REFERENCES Product(product_id)
);

-- Crea la tabla Flower
CREATE TABLE IF NOT EXISTS Flower (
    flower_id INT PRIMARY KEY,
    colour VARCHAR(255),
    FOREIGN KEY (flower_id) REFERENCES Product(product_id)
);

-- Crea la tabla Ticket
CREATE TABLE IF NOT EXISTS Ticket (
    ticket_id INT AUTO_INCREMENT PRIMARY KEY,
    creation_date_time DATETIME,
    total_amount DOUBLE
);

-- Crea la tabla TicketData
CREATE TABLE IF NOT EXISTS TicketData (
    ticketdata_id INT AUTO_INCREMENT PRIMARY KEY,
    ticket_id INT,
    product_id INT,
    quantity INT,
    FOREIGN KEY (ticket_id) REFERENCES Ticket(ticket_id),
    FOREIGN KEY (product_id) REFERENCES Product(product_id)
);
INSERT INTO Product (name, sell_price, cost_price, stock, type)
VALUES 
    ('Rose', 10.99, 5.99, 50, 'Flower'),
    ('Tulip', 8.99, 4.99, 40, 'Flower'),
    ('Daisy', 7.99, 3.99, 60, 'Flower'),
    ('Sunflower', 12.99, 6.99, 30, 'Flower'),
    ('Lily', 9.99, 5.49, 45, 'Flower'),
    ('Orchid', 14.99, 8.49, 25, 'Flower'),
    ('Carnation', 6.99, 3.49, 55, 'Flower'),
    ('Daffodil', 7.49, 4.49, 70, 'Flower'),
    ('Hydrangea', 11.49, 6.99, 35, 'Flower'),
    ('Peony', 13.49, 7.99, 20, 'Flower');

-- Obtener los IDs de los productos insertados
SET @start_product_id = (SELECT MAX(product_id) - 9 FROM Product);

-- Insertar información de las flores en la tabla Flower
INSERT INTO Flower (flower_id, colour)
VALUES 
    (@start_product_id, 'Red'),
    (@start_product_id + 1, 'Yellow'),
    (@start_product_id + 2, 'White'),
    (@start_product_id + 3, 'Yellow'),
    (@start_product_id + 4, 'Pink'),
    (@start_product_id + 5, 'Purple'),
    (@start_product_id + 6, 'Pink'),
    (@start_product_id + 7, 'Yellow'),
    (@start_product_id + 8, 'Blue'),
    (@start_product_id + 9, 'Pink');
    
SELECT p.product_id, p.name AS product_name, p.sell_price, p.cost_price, p.stock, f.colour
FROM Product p
INNER JOIN Flower f ON p.product_id = f.flower_id;

ALTER TABLE Decoration
MODIFY COLUMN material ENUM('wood', 'plastic');

INSERT INTO Product (name, sell_price, cost_price, stock, type)
VALUES 
    ('Ceramic Vase', 29.99, 14.99, 50, 'Decoration'),
    ('Glass Jar', 19.99, 9.99, 40, 'Decoration'),
    ('Terracotta Pot', 24.99, 12.99, 60, 'Decoration'),
    ('Bamboo Basket', 34.99, 17.99, 30, 'Decoration'),
    ('Metal Planter', 39.99, 19.99, 45, 'Decoration'),
    ('Wicker Tray', 22.99, 11.99, 55, 'Decoration'),
    ('Crystal Bowl', 49.99, 24.99, 35, 'Decoration'),
    ('Porcelain Figurine', 27.99, 13.99, 65, 'Decoration'),
    ('Wooden Frame', 32.99, 16.99, 25, 'Decoration'),
    ('Marble Sculpture', 59.99, 29.99, 20, 'Decoration');

-- Obtener los IDs de los productos insertados
SET @start_product_id = (SELECT MAX(product_id) - 9 FROM Product);

-- Añadir datos de material a la tabla Decoration
INSERT INTO Decoration (decoration_id, material)
VALUES 
    (@start_product_id, 'wood'),
    (@start_product_id + 1, 'plastic'),
    (@start_product_id + 2, 'wood'),
    (@start_product_id + 3, 'wood'),
    (@start_product_id + 4, 'plastic'),
    (@start_product_id + 5, 'wood'),
    (@start_product_id + 6, 'plastic'),
    (@start_product_id + 7, 'plastic'),
    (@start_product_id + 8, 'wood'),
    (@start_product_id + 9, 'plastic');
   
SELECT p.product_id, p.name AS product_name, p.sell_price, p.cost_price, p.stock, d.material
FROM Product p
INNER JOIN Decoration d ON p.product_id = d.decoration_id;

INSERT INTO Product (name, sell_price, cost_price, stock, type)
VALUES 
    ('Pine Tree', 79.99, 39.99, 20, 'Tree'),
    ('Oak Tree', 89.99, 44.99, 25, 'Tree'),
    ('Maple Tree', 99.99, 49.99, 30, 'Tree'),
    ('Birch Tree', 69.99, 34.99, 15, 'Tree'),
    ('Willow Tree', 59.99, 29.99, 18, 'Tree'),
    ('Fir Tree', 69.99, 34.99, 22, 'Tree'),
    ('Cherry Tree', 109.99, 54.99, 35, 'Tree'),
    ('Apple Tree', 119.99, 59.99, 40, 'Tree'),
    ('Palm Tree', 129.99, 64.99, 25, 'Tree'),
    ('Cypress Tree', 99.99, 49.99, 20, 'Tree');

-- Obtener los IDs de los productos insertados
SET @start_product_id = (SELECT MAX(product_id) - 9 FROM Product);

-- Añadir datos de altura a la tabla Tree
INSERT INTO Tree (tree_id, height)
VALUES 
    (@start_product_id, 200),
    (@start_product_id + 1, 250),
    (@start_product_id + 2, 180),
    (@start_product_id + 3, 220),
    (@start_product_id + 4, 200),
    (@start_product_id + 5, 180),
    (@start_product_id + 6, 230),
    (@start_product_id + 7, 210),
    (@start_product_id + 8, 270),
    (@start_product_id + 9, 190);
    
    SELECT 
    P.product_id,
    P.name AS product_name,
    P.sell_price,
    P.cost_price,
    P.stock,
    P.type,
    CASE
        WHEN T.tree_id IS NOT NULL THEN 'Tree'
        WHEN D.decoration_id IS NOT NULL THEN 'Decoration'
        WHEN F.flower_id IS NOT NULL THEN 'Flower'
        ELSE 'Unknown'
    END AS category,
    T.height AS tree_height,
    D.material AS decoration_material,
    F.colour AS flower_colour
FROM Product P
LEFT JOIN Tree T ON P.product_id = T.tree_id
LEFT JOIN Decoration D ON P.product_id = D.decoration_id
LEFT JOIN Flower F ON P.product_id = F.flower_id;