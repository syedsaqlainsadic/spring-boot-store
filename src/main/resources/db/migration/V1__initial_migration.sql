create table users (
    id bigint PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL ,
    email VARCHAR(100) NOT NULL ,
    password VARCHAR(255) NOT NULL
);
create table addresses (
    id bigint PRIMARY KEY AUTO_INCREMENT,
    street VARCHAR(50) NOT NULL ,
    city VARCHAR(100) NOT NULL ,
    zip VARCHAR(255) NOT NULL,
    user_id bigint NOT NULL,
    Constraint fk_addresses_users FOREIGN KEY (user_id) REFERENCES users(id)
);


alter TABLE users add state varchar(255) not null ;


alter table users drop column state ;

alter table addresses add state varchar(255) not null ;



create table profiles (
    id bigint PRIMARY KEY AUTO_INCREMENT,
    bio VARCHAR(255) NOT NULL ,
    phone_number VARCHAR(100) NOT NULL ,
    date_of_birth DATE NOT NULL ,
    loyalty_points INT NOT NULL 
);



create table categories (
    id tinyint PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

create table products (
    id bigint PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    price decimal(10,2) NOT NULL,
    category_id tinyint,
    Constraint fk_category 
        FOREIGN KEY (category_id) REFERENCES categories(id)
            on DELETE RESTRICT
);


alter table Products 
    add `description` TEXT NULL;

alter Table Products 
    modify `description` TEXT NOT NULL;


CREATE TABLE wishlist (
    user_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, product_id),
    CONSTRAINT fk_wishlist_user
        FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_wishlist_product
        FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE
);


ALTER TABLE users 
ADD UNIQUE (email);

DELIMITER $$

CREATE PROCEDURE findProductsByPrice(
    IN minPrice DECIMAL(10, 2),
    IN maxPrice DECIMAL(10, 2)
)
BEGIN
    SELECT id, name, description, price , category_id FROM products
    WHERE price BETWEEN minPrice AND maxPrice 
    order by name;
END$$

DELIMITER ;

