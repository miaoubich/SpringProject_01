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
		
***************************************************************************************
From hibernate:
***************

 INFO  HHH000412: Hibernate Core {5.2.7.Final} 17:52:08.957 org.hibernate.Version 
INFO  HHH000206: hibernate.properties not found 17:52:08.965 org.hibernate.cfg.Environment 
INFO  HCANN000001: Hibernate Commons Annotations {5.0.1.Final} 17:52:09.039 o.h.annotations.common.Version 
INFO  HHH000400: Using dialect: org.hibernate.dialect.H2Dialect 17:52:09.515 org.hibernate.dialect.Dialect 
INFO  HV000001: Hibernate Validator 6.1.0.Final 17:52:10.371 o.h.validator.internal.util.Version 
Hibernate: 
    
    drop table Address if exists
Hibernate: 
    
    drop table Cart if exists
Hibernate: 
    
    drop table Category if exists
Hibernate: 
    
    drop table Product if exists
Hibernate: 
    
    drop table user_detail if exists
Hibernate: 
    
    create table Address (
       id integer generated by default as identity,
        address_line_one varchar(255),
        address_line_two varchar(255),
        billing boolean not null,
        city varchar(255),
        country varchar(255),
        postal_code varchar(255),
        shipping boolean not null,
        state varchar(255),
        user_id integer,
        primary key (id)
    )
Hibernate: 
    
    create table Cart (
       id integer generated by default as identity,
        cart_lines integer,
        grand_total double,
        uId integer,
        primary key (id)
    )
Hibernate: 
    
    create table Category (
       id integer generated by default as identity,
        is_active boolean,
        image_url varchar(255),
        description varchar(255),
        name varchar(255),
        primary key (id)
    )
Hibernate: 
    
    create table Product (
       id integer generated by default as identity,
        is_active boolean,
        brand varchar(255),
        category_id integer,
        code varchar(255),
        description varchar(255),
        name varchar(255),
        purchases integer not null,
        quantity integer not null,
        supplier_id integer,
        unit_price double,
        views integer not null,
        primary key (id)
    )
Hibernate: 
    
    create table user_detail (
       id integer generated by default as identity,
        contact_number varchar(255),
        email varchar(255),
        enabled boolean not null,
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        role varchar(255),
        primary key (id)
    )
Hibernate: 
    
    alter table Cart 
       add constraint FKf9j3qsn4omjhb5r7bi4ni0km1 
       foreign key (uId) 
       references user_detail
INFO  HHH000476: Executing import script 'org.hibernate.tool.schema.internal.exec.ScriptSourceInputNonExistentImpl@4f20a5e0' 17:52:10.909 o.h.t.s.internal.SchemaCreatorImpl 
Hibernate: 
    insert 
    into
        user_detail
        (id, contact_number, email, enabled, first_name, last_name, password, role) 
    values
        (null, ?, ?, ?, ?, ?, ?, ?)
Hibernate: 
    insert 
    into
        Address
        (id, address_line_one, address_line_two, billing, city, country, postal_code, shipping, state, user_id) 
    values
        (null, ?, ?, ?, ?, ?, ?, ?, ?, ?)
Hibernate: 
    insert 
    into
        Cart
        (id, cart_lines, grand_total, uId) 
    values
        (null, ?, ?, ?)
Hibernate: 
    insert 
    into
        Address
        (id, address_line_one, address_line_two, billing, city, country, postal_code, shipping, state, user_id) 
    values
        (null, ?, ?, ?, ?, ?, ?, ?, ?, ?)
