CREATE TABLE product(
                        product_id long(20) NOT NULL AUTO_INCREMENT,
                        product_name varchar(20) NOT NULL ,
                        product_amt double(20) NOT NULL ,
                        PRIMARY KEY (product_id)
);

CREATE TABLE review(
                       review_id long(20) NOT NULL AUTO_INCREMENT,
                       reviewer_name varchar(20) NOT NULL ,
                       review_description varchar(200) NOT NULL ,
                       review_title varchar(20) NOT NULL ,
                       created_time varchar(20) not null ,
                       product_id long(20),
                       PRIMARY KEY (review_id),
                       CONSTRAINT fk_product
                       FOREIGN KEY (product_id) REFERENCES product(product_id)

);

CREATE TABLE comment (
                         comment_id long(20) NOT NULL AUTO_INCREMENT,
                         test varchar(500) NOT NULL ,
                         created_time varchar(20) not null ,
                         review_id long(20) NOT NULL ,
                         CONSTRAINT fk_review
                         FOREIGN KEY (review_id) REFERENCES review(review_id),
                         PRIMARY KEY (comment_id)
);


