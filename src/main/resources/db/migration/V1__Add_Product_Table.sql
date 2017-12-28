CREATE TABLE `product` (
  `id`                 BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `sku`         VARCHAR(20)  NOT NULL,
  `title`     VARCHAR(40)  NOT NULL,
  `spec`     VARCHAR(20)  NOT NULL,
  `brand`     VARCHAR(20)  NOT NULL,
  `created_date` TIMESTAMP
);
