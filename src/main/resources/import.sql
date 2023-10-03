INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Jose', 'Roca', 'jos@gmail.com', '2022-08-10', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Maria', 'Lopez', 'maria@gmail.com', '2022-08-11', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Juan', 'Perez', 'juan@gmail.com', '2022-08-12', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Ana', 'Gomez', 'ana@gmail.com', '2022-08-13', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Carlos', 'Martinez', 'carlos@gmail.com', '2022-08-14', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Luis', 'Sanchez', 'luis@gmail.com', '2022-08-15', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Laura', 'Fernandez', 'laura@gmail.com', '2022-08-16', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Pedro', 'Gonzalez', 'pedro@gmail.com', '2022-08-17', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Marta', 'Ramirez', 'marta@gmail.com', '2022-08-18', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Sergio', 'Ortega', 'sergio@gmail.com', '2022-08-19', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Elena', 'Hernandez', 'elena@gmail.com', '2022-08-20', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Raul', 'Diaz', 'raul@gmail.com', '2022-08-21', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Patricia', 'Morales', 'patricia@gmail.com', '2022-08-22', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Roberto', 'Silva', 'roberto@gmail.com', '2022-08-23', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Martha', 'Lara', 'martha@gmail.com', '2022-08-24', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Fernando', 'Herrera', 'fernando@gmail.com', '2022-08-25', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Diana', 'Cruz', 'diana@gmail.com', '2022-08-26', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Hugo', 'Cortes', 'hugo@gmail.com', '2022-08-27', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Olga', 'Montes', 'olga@gmail.com', '2022-08-28', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Adrian', 'Rios', 'adrian@gmail.com', '2022-08-29', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Monica', 'Reyes', 'monica@gmail.com', '2022-08-30', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Armando', 'Guerra', 'armando@gmail.com', '2022-08-31', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Rosa', 'Cabrera', 'rosa@gmail.com', '2022-09-01', '');




INSERT INTO productos (nombre, precio, create_at) VALUES ('Lavadora automática', 399.99, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Refrigerador de doble puerta', 599.50, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Microondas de convección', 129.75, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Licuadora de alta potencia', 89.00, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Aspiradora sin bolsa', 129.99, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Horno eléctrico', 149.99, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Cafetera programable', 39.75, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Plancha de vapor', 29.99, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Batidora de mano', 49.95, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Ventilador de torre', 79.00, NOW());

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES ('Factura de equipos de hogar', null, 1, NOW());
INSERT INTO facturas_items(cantidad, factura_id, producto_id) VALUES (1, 1, 1);
INSERT INTO facturas_items(cantidad, factura_id, producto_id) VALUES (3, 1, 4);
INSERT INTO facturas_items(cantidad, factura_id, producto_id) VALUES (2, 1, 3);
INSERT INTO facturas_items(cantidad, factura_id, producto_id) VALUES (4, 1, 6);

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES ('Factura de equipo', 'Alguna nota importante', 1, NOW());
INSERT INTO facturas_items(cantidad, factura_id, producto_id) VALUES (3, 2, 5);

INSERT INTO users(username, password, enabled) VALUES ('linber', '$2a$10$/13jSJW1WZnREZZrcVwDXOT9gteWY5EkjReyI5EovGaEMLklC0D9q', 1);
INSERT INTO users(username, password, enabled) VALUES ('admin', '$2a$10$6rkl.OySiMXkQt.7sKA3I.BPDYb4zBZb22gzNAUs.JE4YMYOYESFe', 1);

INSERT INTO authorities(user_id, authority) VALUES (1, 'ROLE_USER');
INSERT INTO authorities(user_id, authority) VALUES (2, 'ROLE_ADMIN');
INSERT INTO authorities(user_id, authority) VALUES (2, 'ROLE_USER');