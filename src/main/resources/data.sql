INSERT INTO users (user_id, username, password, first_name, last_name) VALUES
  ('1', 'Asterisk', '123456', 'Nata', 'Leonova'),
  ('2', 'Sonic', 'haj55', 'Oleg', 'Sonov'),
  ('3', 'Yupie', '222555', 'Yura', 'Privezentsev');

INSERT INTO groups (name_of_group) VALUES
  ('Group One'),
  ('Group Two');

INSERT INTO groups_users (name_of_group, user_id) VALUES
	('Group One', '1'),
	('Group One', '3'),
	('Group Two', '1'),
	('Group Two', '2');