INSERT INTO users (user_id, username, password, first_name, last_name, date_of_birth) VALUES
  ('1', 'Asterisk', '123456', 'Nata', 'Leonova', '1983-11-18'),
  ('2', 'Sonic', 'haj55', 'Oleg', 'Sonov', '2000-01-22'),
  ('3', 'Yupie', '222555', 'Yura', 'Privezentsev', '1985-03-22');

INSERT INTO groups (group_id, name_of_group) VALUES
  ('1', 'Group One'),
  ('2', 'Group Two');

INSERT INTO groups_users (group_id, user_id) VALUES
	('1', '1'),
	('1', '3'),
	('2', '1'),
	('2', '2');