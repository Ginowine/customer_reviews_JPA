CREATE TABLE 'comment' (
                         comment_id numeric(20) NOT NULL AUTO_INCREMENT,
                         text varchar(500) NOT NULL ,
                         createdtime datetime DEFAULT CURRENT_TIMESTAMP,
                         review_id varchar(20) NOT NULL ,
                         CONSTRAINT fk_review
                         FOREIGN KEY (review_id) REFERENCES review(review_id),
                         PRIMARY KEY (comment_id)
);

CREATE TABLE review(
                       review_id numeric(20) NOT NULL AUTO_INCREMENT,
                       ReviewerName varchar(20) NOT NULL ,
                       ReviewDescription text(200) NOT NULL ,
                       ReviewTitle varchar(20) NOT NULL ,
                       CreatedTime datetime DEFAULT current_timestamp,
                       Product_id varchar(20) NOT NULL ,
                       PRIMARY KEY (review_id),
                       CONSTRAINT fk_product
                       FOREIGN KEY (Product_id) REFERENCES product(product_id)

);

CREATE TABLE product(
                        product_id numeric(20) NOT NULL AUTO_INCREMENT,
                        ProductName varchar(20) NOT NULL ,
                        ProductAmount double(20) NOT NULL ,
                        PRIMARY KEY (product_id)
);

