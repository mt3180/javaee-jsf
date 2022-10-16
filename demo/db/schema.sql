-- ログインユーザ
CREATE TABLE login_user (
 user_id VARCHAR(20) NOT NULL PRIMARY KEY,
 user_name VARCHAR(40) NOT NULL,
 password VARCHAR(128) NOT NULL,
 role_id VARCHAR(20) NOT NULL
);

-- 納品書
CREATE TABLE nouhinsho (
 nouhin_id VARCHAR(20) NOT NULL PRIMARY KEY,
 title VARCHAR(100) NOT NULL,
 kaisha_name VARCHAR(100) NOT NULL,
 nouhin_date DATE NOT NULL,
 nouhin_kaisha_name VARCHAR(100) NOT NULL
);

-- 納品書明細
CREATE TABLE nouhinsho_item (
 nouhin_id VARCHAR(20) NOT NULL,
 nouhin_item_id VARCHAR(20) NOT NULL,
 item_name VARCHAR(100) NOT NULL,
 item_tanka INTEGER NOT NULL,
 item_suryo INTEGER NOT NULL,
 item_kingaku INTEGER NOT NULL,
 PRIMARY KEY(nouhin_id, nouhin_item_id),
 foreign key (nouhin_id) references nouhinsho(nouhin_id)
);
