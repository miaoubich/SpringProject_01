DROP ALL OBJECTS;

CREATE TABLE category (
	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	
	CONSTRAINT pk_category_id PRIMARY KEY (id)
);


INSERT INTO category(name, description, image_url, is_active) VALUES ('Dolls','It is a default description for this product', 'Cat_01', true);
INSERT INTO category(name, description, image_url, is_active) VALUES ('Action Figures','It is a default description for this product', 'Cat_02', true);
INSERT INTO category(name, description, image_url, is_active) VALUES ('Vehicles','It is a default description for this product', 'Cat_03', false);
INSERT INTO category(name, description, image_url, is_active) VALUES ('Games and Puzzles','It is a default description for this product', 'Cat_04', true);
INSERT INTO category(name, description, image_url, is_active) VALUES ('Electronic Toy for young','It is a default description for this product', 'Cat_05', true);
INSERT INTO category(name, description, image_url, is_active) VALUES ('Babies Toys','It is a default description for this product', 'Cat_05', true);
INSERT INTO category(name, description, image_url, is_active) VALUES ('Other Toys','It is a default description for this product', 'Cat_05', true);

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

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDABC123DEFX', 'FROZEN DOLL ELSA', 'Disney', 'The principle character from Frozen II The movie!', 25, 5, true, 1, 3, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDDEF123DEFX', 'TMNT Turtles Roleplay set Donatello', 'Sony', 'Donatello one of the ninja turtle members!', 22, 20, true, 2, 1, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDPQR123WGTX', 'Billy', 'Dens', 'Board game Beaver Billy. For 1-4 players age 4+. The duration of the game is about 20 minutes.', 20, 5, true, 4, 3, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDMNO123PQRX', 'Didactic puzzle', 'Dens', 'A didactic puzzle to help your child practice precision and concentration by inserting different shapes into specific openings.', 10, 30, true, 6, 4, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDABCXYZDEFX', 'HAS: NERF N STRIKE ELITE', 'Nerf', 'Nerf launcher. Fully automatic 27-meter blaster. Suitable for 8 years.', 55, 5, true, 7, 1, 0, 0 );


CREATE TABLE Address(
			id IDENTITY,
			address_line_one VARCHAR(255),
			address_line_two VARCHAR(255),
			city VARCHAR(50),
			state VARCHAR(50),
			country VARCHAR(50),
			shipping BOOLEAN,
			billing BOOLEAN,
			
			CONSTRAINT pk_id PRIMARY KEY(id),
			CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES user_detail (id)

		);