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