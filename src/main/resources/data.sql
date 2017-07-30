INSERT INTO users (user_id, username, password, first_name, last_name, date_of_birth) VALUES
  ('1', 'Asterisk', '123456', 'Nata', 'Leonova', '1983-11-18'),
  ('2', 'Sonic', 'haj55', 'Oleg', 'Sonov', '2000-01-22'),
  ('3', 'Yupie', '222555', 'Yura', 'Privezentsev', '1985-03-22');

INSERT INTO groups (name_of_group) VALUES
  ('Group One'),
  ('Group Two');

INSERT INTO groups_users (name_of_group, user_id) VALUES
	('Group One', '1'),
	('Group One', '3'),
	('Group Two', '1'),
	('Group Two', '2');