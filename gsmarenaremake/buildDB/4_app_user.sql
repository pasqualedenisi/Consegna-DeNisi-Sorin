create table app_user (
	_id serial primary key,
	_name varchar(50),
	_surname varchar(50),
	_email varchar(100),
	_type int,
	foreign key (_type) references user_type(_id)
)