-- ログインユーザ(パスワードはpassw0rd)
INSERT INTO login_user(user_id, user_name, password, role_id)
VALUES
 ('admin01', '管理者０１',  'admin01', 'SYSTEM'),
 ('admin02', '管理者０１',  'admin02', 'SYSTEM'),
 ('general01', '一般ユーザ０１', 'general01', 'GENERAL'),
 ('general02', '一般ユーザ０２', 'general02', 'GENERAL');

-- 納品書
INSERT INTO nouhinsho(nouhin_id, title, kaisha_name, nouhin_date, nouhin_kaisha_name)
VALUES
 ('10001', 'サンプル納品書１',  'XXX株式会社', '2022-01-01', 'YYY株式会社'),
 ('10002', 'サンプル納品書２',  'XXX株式会社', '2022-01-01', 'YYY株式会社'),
 ('10003', 'サンプル納品書３',  'XXX株式会社', '2022-01-01', 'YYY株式会社'),
 ('10004', 'サンプル納品書４',  'XXX株式会社', '2022-01-01', 'YYY株式会社');

-- 納品書明細
INSERT INTO nouhinsho_item(nouhin_id, nouhin_item_id, item_name, item_tanka, item_suryo, item_kingaku)
VALUES
 ('10001', '1', 'サンプル項目１',  1000, 4, 4000),
 ('10001', '2', 'サンプル項目２',  2000, 3, 6000), 
 ('10002', '1', 'サンプル項目１',  1000, 4, 4000),
 ('10002', '2', 'サンプル項目２',  2000, 3, 6000), 
 ('10003', '1', 'サンプル項目１',  1000, 4, 4000),
 ('10003', '2', 'サンプル項目２',  2000, 3, 6000), 
 ('10004', '1', 'サンプル項目１',  1000, 4, 4000),
 ('10004', '2', 'サンプル項目２',  2000, 3, 6000);
