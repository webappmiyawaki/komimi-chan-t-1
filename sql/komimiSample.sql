CREATE DATABASE komimi_chan_t_1;

DROP TABLE comment;
DROP TABLE request;
DROP TABLE talent_base_info;
DROP TABLE talent_live_info;
DROP TABLE user_info;
DROP TABLE user_base_info;
DROP TABLE user_favorite;
DROP TABLE user_request;
DROP TABLE user_purchase_history;
DROP TABLE product_by_talent;


CREATE TABLE user_base_info(
    user_id VARCHAR(100),
    user_name VARCHAR(100),
    user_password VARCHAR(100),
	img_address VARCHAR(100)
);

CREATE TABLE user_favorite(
  user_id VARCHAR(100),
  user_favorite_talent VARCHAR(100),
  user_comment VARCHAR(100)
);

CREATE TABLE user_request(
    request_no SERIAL,
    user_id VARCHAR(100),
    request_text VARCHAR(100)
);

CREATE TABLE talent_base_info(
    talent_id VARCHAR(100),
    talent_name VARCHAR(100),
    talent_img_address VARCHAR(100),
    talent_birth_place VARCHAR(100),
    talent_birthday DATE,
    talent_blood_type VARCHAR(100),
    talent_group_name VARCHAR(100),
    talent_info08 VARCHAR(100)
   	twitter VARCHAR(100),
	youtube VARCHAR(100),
);

CREATE TABLE talent_live_info(
  talent_id VARCHAR(100),
  talent_live_info01 VARCHAR(100),
  talent_live_info02 VARCHAR(100),
  talent_live_info03 VARCHAR(100),
  talent_live_info04 VARCHAR(100),
  talent_live_info05 VARCHAR(100)
);

CREATE TABLE product_by_talent(
    product_id VARCHAR(100),
    talent_id VARCHAR(100),
    product_type VARCHAR(100),
    product_name VARCHAR(100),
    product_price INTEGER,
    registration_date DATE
);

CREATE TABLE user_purchase_history(
    history_no SERIAL,
    user_id VARCHAR(100),
    product_id VARCHAR(100),
    registration_date DATE
);


SELECT * FROM talent_base_info;
TRUNCATE talent_base_info;

INSERT INTO user_purchase_history(user_id,product_id,registration_date) VALUES(1,1,NULL);
INSERT INTO user_purchase_history(user_id,product_id,registration_date) VALUES(1,2,NULL);
INSERT INTO user_purchase_history(user_id,product_id,registration_date) VALUES(1,3,NULL);
INSERT INTO user_purchase_history(user_id,product_id,registration_date) VALUES(1,4,NULL);
INSERT INTO user_purchase_history(user_id,product_id,registration_date) VALUES(1,5,NULL);

SELECT * FROM user_purchase_history;
TRUNCATE user_purchase_history;