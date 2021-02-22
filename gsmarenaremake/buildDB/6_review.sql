create table review (
	_id serial primary key,
	_author int,
	_device int,
	_title varchar(200),
	_text text,
	foreign key (_author) references app_user(_id),
	foreign key (_device) references device(_id)
)