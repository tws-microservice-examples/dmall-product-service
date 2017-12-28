CREATE TABLE `product` (
  `id`                 BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `sku`         VARCHAR(20)  NOT NULL,
  `title`     VARCHAR(200)  NOT NULL,
  `spec`     VARCHAR(100)  NOT NULL,
  `brand`     VARCHAR(100)  NOT NULL,
  `created_date` TIMESTAMP
);
INSERT INTO product (id,sku, title, spec, brand, created_date) VALUES(1,'6009907', 'Apple - iPhone X 64GB - Silver (Verizon)', '64GB - Silver (Verizon)', 'apple', NULL );
INSERT INTO product (id,sku, title, spec, brand, created_date) VALUES(2,'6009901', 'Apple - iPhone X 64GB - Space Gray (Verizon)', '64GB - Space Gray (Verizon)', 'apple', NULL );
INSERT INTO product (id,sku, title, spec, brand, created_date) VALUES(3,'6009887', 'Apple - iPhone X 256GB - Space Gray (Verizon)', '256GB - Space Gray (Verizon)', 'apple', NULL );