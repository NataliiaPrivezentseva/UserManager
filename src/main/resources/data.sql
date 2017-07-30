INSERT INTO users (user_id, username, password, first_name, last_name, date_of_birth) VALUES
  ('1', 'Sociopath', 'desire', 'Cersei', 'Lannister', '1000-10-10'),
  ('2', 'The Kingslayer', 'one-handed', 'Jaime', 'Lannister', '1000-10-10'),
  ('3', 'MotherOfDragon', 'justice', 'Daenerys', 'Targaryen', '1010-03-31');

INSERT INTO groups (group_id, name_of_group) VALUES
  ('1', 'Queen'),
  ('2', 'Blood mixers');

INSERT INTO groups_users (group_id, user_id) VALUES
	('1', '1'),
	('1', '3'),
	('2', '1'),
	('2', '2');