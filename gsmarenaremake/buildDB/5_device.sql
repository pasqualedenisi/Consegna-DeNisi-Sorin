create table device (
	_id serial primary key,
	_name varchar(50),
	_serial_number varchar(50),
	_brand int,
	_type int,
	foreign key (_brand) references brand(_id),
	foreign key (_type) references device_type(_id)
)