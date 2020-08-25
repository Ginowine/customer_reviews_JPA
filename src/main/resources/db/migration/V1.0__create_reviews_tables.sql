-- noinspection SqlNoDataSourceInspectionForFile

CREATE TABLE `product`(
    `product_id` INT PRIMARY KEY AUTO_INCREMENT,
    `product_name` VARCHAR(200) ,
    `product_amt` DOUBLE NOT NULL);

CREATE TABLE `review` (
                         `review_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                         `reviewer_name` varchar(20) NOT NULL ,
                         `review_description` varchar(200) NOT NULL ,
                         `review_title` varchar(20) NOT NULL ,
                         `created_time` varchar(20) NOT NULL ,
                         `product_id` INT,
                         CONSTRAINT fk_product
                         FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)

);

CREATE TABLE `comment` (
                           `comment_id` INT NOT NULL AUTO_INCREMENT,
                           `test` varchar(500) NOT NULL ,
                           `created_time` varchar(20) not null ,
                           `review_id` INT,
                           CONSTRAINT fk_review
                           FOREIGN KEY (`review_id`) REFERENCES review(`review_id`),
                           PRIMARY KEY (`comment_id`)
);


