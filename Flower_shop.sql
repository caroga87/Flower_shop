DROP DATABASE IF EXISTS flower_shop;

CREATE DATABASE flower_shop CHARACTER SET utf8mb4;

USE flower_shop;

create table product_types	(
	product_type_id int unsigned not null primary key,
    product_type_name enum('tree', 'flower','decoration')
);

create table products	(
	product_id int unsigned auto_increment primary key not null,
    product_name varchar(100) not null,
    unit_price double not null,
    product_type_id int unsigned not null,
    foreign key(product_type_id) references product_types(product_type_id)
);

create table trees	(
	tree_id int unsigned auto_increment primary key not null,
    height int unsigned not null,
    product_type_id int unsigned not null,
    foreign key (product_type_id) references product_types (product_type_id)
);

create table flowers (
	flower_id int unsigned auto_increment primary key not null,
    colour varchar(50) not null,
	product_type_id int unsigned not null,
    foreign key (product_type_id) references product_types (product_type_id)
);

create table decorations	(
	decoration_id int unsigned auto_increment primary key not null,
    material enum('wood', 'plastic') not null,
	product_type_id int unsigned not null,
    foreign key (product_type_id) references product_types (product_type_id)
);

create table tickets	(
	ticket_id int unsigned auto_increment primary key not null,
    time_created timestamp not null,
    total_amount double not null
);

create table sold_products	(
	sold_product_id int unsigned auto_increment primary key not null,
	ticket_id int unsigned not null,
    product_id int unsigned not null,
    quantity int unsigned not null,
    foreign key (ticket_id) references tickets(ticket_id),
	foreign key (product_id) references products(product_id)
);

create table stock	(
	stock_id int unsigned auto_increment primary key not null,
    product_id int unsigned not null,
    quantity int unsigned not null,
    foreign key(product_id) references products(product_id)
);