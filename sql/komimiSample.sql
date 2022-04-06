CREATE DATABASE komimi_chan_t_1;

DROP TABLE comment;
DROP TABLE request;
DROP TABLE talent_base_info;
DROP TABLE talent_live_info;
DROP TABLE user_info;
DROP TABLE user_base_info;
DROP TABLE user_favorite;
DROP TABLE user_request;


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

CREATE TABLE comment(
    user_id VARCHAR(100),
    talent_id VARCHAR(100),
    comment_text VARCHAR(100)
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
);

CREATE TABLE talent_live_info(
  talent_id VARCHAR(100),
  talent_live_info01 VARCHAR(100),
  talent_live_info02 VARCHAR(100),
  talent_live_info03 VARCHAR(100),
  talent_live_info04 VARCHAR(100),
  talent_live_info05 VARCHAR(100)
);

SELECT * FROM talent_base_info;
TRUNCATE talent_base_info;