INSERT INTO users (username, password, first_name, last_name) VALUES
  ('Asterisk', '123456', 'Nata', 'Leonova'),
  ('Sonic', 'haj55', 'Oleg', 'Sonov'),
  ('Yupie', '222555', 'Yura', 'Privezentsev');

INSERT INTO groups (name_of_group) VALUES
  ('Group One'),
  ('Group Two');

INSERT INTO groups_users (name_of_group, username) VALUES
	('Group One', 'Asterisk'),
	('Group One', 'Yupie'),
	('Group Two', 'Asterisk'),
	('Group Two', 'Sonic');