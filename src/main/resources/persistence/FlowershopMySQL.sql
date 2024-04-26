-- Crea la base de datos flower_shop si no existe
DROP DATABASE IF EXISTS flowershop;
CREATE DATABASE IF NOT EXISTS flowershop;

-- Utiliza la base de datos flower_shop
USE flowershop;

-- Crea la tabla Product
CREATE TABLE IF NOT EXISTS Product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    sell_price DOUBLE,
    cost_price DOUBLE,
    stock INT,
    type VARCHAR(50)
);

-- Crea la tabla Tree
CREATE TABLE IF NOT EXISTS Tree (
    product_id INT PRIMARY KEY,
    height INT,
    FOREIGN KEY (product_id) REFERENCES Product(id)
);

-- Crea la tabla Decoration
CREATE TABLE IF NOT EXISTS Decoration (
    product_id INT PRIMARY KEY,
    material VARCHAR(255),
    FOREIGN KEY (product_id) REFERENCES Product(id)
);

-- Crea la tabla Flower
CREATE TABLE IF NOT EXISTS Flower (
    product_id INT PRIMARY KEY,
    colour VARCHAR(255),
    FOREIGN KEY (product_id) REFERENCES Product(id)
);

-- Crea la tabla Ticket
CREATE TABLE IF NOT EXISTS Ticket (
    id INT AUTO_INCREMENT PRIMARY KEY,
    creation_date_time DATETIME,
    total_amount DOUBLE
);

-- Crea la tabla TicketData
CREATE TABLE IF NOT EXISTS TicketData (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ticket_id INT,
    product_id INT,
    quantity INT,
    FOREIGN KEY (ticket_id) REFERENCES Ticket(id),
    FOREIGN KEY (product_id) REFERENCES Product(id)
);