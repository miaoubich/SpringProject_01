CREATE TABLE category (
	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	
	CONSTRAINT pk_category_id PRIMARY KEY (id)
);

DROP ALL OBJECTS;

INSERT INTO category(name, description, image_url, is_active) VALUES ('Toys','It is a default description for this product', 'Cat_01', true);
INSERT INTO category(name, description, image_url, is_active) VALUES ('Cloths','It is a default description for this product', 'Cat_02', true);
INSERT INTO category(name, description, image_url, is_active) VALUES ('Food less 2 years','It is a default description for this product', 'Cat_03', false);
INSERT INTO category(name, description, image_url, is_active) VALUES ('Food Children','It is a default description for this product', 'Cat_04', true);
INSERT INTO category(name, description, image_url, is_active) VALUES ('Cosmetic','It is a default description for this product', 'Cat_05', true);

CREATE TABLE user_detail(
	id IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(50),
	email VARCHAR(100),
	contact_number VARCHAR(15),
	
	CONSTRAINT pk_user_id PRIMARY KEY(id)
);

INSERT INTO user_detail(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Ali', 'Split', 'Admin', 'true', '2304', 'darin@home.com', '0998877665544');

INSERT INTO user_detail(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Bilja', 'Split', 'Supplier', 'true', '1512', 'lina@home.com', '01122334455');

INSERT INTO user_detail(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Darin', 'Split', 'Supplier', 'true', '0203', 'darin_01@home.com', '01952364587');

INSERT INTO user_detail(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Lina', 'Split', 'Supplier', 'true', '3107', 'lina_01@home.com', '094447855633');

INSERT INTO user_detail(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Offline', 'Split', 'Supplier', 'false', '1201', 'home_01@home.com', '091111111111');

CREATE TABLE product(
	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	
	CONSTRAINT pk_product_id PRIMARY KEY(id),
	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail (id)
);