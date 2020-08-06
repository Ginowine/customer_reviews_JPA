CREATE TABLE comments (
                          ID int(20) NOT NULL AUTO_INCREMENT,
                          Text varchar(200) NOT NULL ,
                          CreatedTime datetime DEFAULT CURRENT_TIMESTAMP,
                          PRIMARY KEY (ID)
);

CREATE TABLE reviews(
                        ID int(20) NOT NULL AUTO_INCREMENT,
                        ReviewerName varchar(20) NOT NULL ,
                        ReviewDescription text(200) NOT NULL ,
                        ReviewTitle varchar(20) NOT NULL ,
                        CreatedTime datetime DEFAULT current_timestamp,
                        Comment_ID int(20) NOT NULL,
                        Product_ID varchar(20) NOT NULL ,
                        CONSTRAINT fk_product
                        FOREIGN KEY (Product_ID) REFERENCES products(ID) ON DELETE CASCADE ,

                        CONSTRAINT fk_comment
                        FOREIGN KEY (Comment_ID) REFERENCES comments(ID) ON DELETE CASCADE,
                        PRIMARY KEY (ID)
);

CREATE TABLE products(
                         ID bigint(20) NOT NULL AUTO_INCREMENT,
                         ProductName varchar(20) NOT NULL ,
                         ProductAmount double(20) NOT NULL ,
                         PRIMARY KEY (ID)
);

