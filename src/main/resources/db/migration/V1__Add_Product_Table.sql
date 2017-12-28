CREATE TABLE `product` (
  `id`                 BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `sku`         VARCHAR(20)  NOT NULL,
  `title`     VARCHAR(40)  NOT NULL,
  `spec`     VARCHAR(20)  NOT NULL,
  `brand`     VARCHAR(20)  NOT NULL,
  `created_date` TIMESTAMP
);
INSERT INTO product (id,sku, title, spec, brand, created_date) VALUES(1,'111', 'iphone 6s', 'black', 'apple', NULL );