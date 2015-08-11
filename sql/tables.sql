CREATE TABLE Posts (
	id int(11) auto_increment not null,
	title varchar(40) not null,
	preview varchar(4000) not null,
	date datetime not null,
	primary key(id)
) ENGINE=InnoDB;

CREATE TABLE Post_details (
	id int(11) auto_increment not null,
	post_details text not null,
	primary key(id),
	constraint post foreign key (id) references Posts(id)
) ENGINE=InnoDB;

CREATE TABLE Comments (
	id int(11) auto_increment not null,
	comment varchar(4000) not null,
	date datetime,
	user_id int(11),
	post_id int(11),
	primary key(id),
	constraint user_id_fk foreign key(user_id) references Users(id),
	constraint post_id_fk foreign key(post_id) references Posts(id)
) ENGINE=InnoDB;

CREATE TABLE Users (
	id int(11) auto_increment not null,
	fist_name varchar(40) not null,
	last_name varchar(40) not null,
	email varchar(320) not null,
	enabled tinyint(1) not null,
	registration_date datetime not null,
	primary key(id)
) ENGINE=InnoDB;

CREATE TABLE Roles (
	id int(11) auto_increment not null,
	role varchar(30),
	primary key(id)
) ENGINE=InnoDB;

CREATE TABLE Users_Roles (
	user_id int(11),
	role_id int(11),
	primary key(user_id, role_id),
	constraint user_fk foreign key(user_id) references Users(id),
	constraint role_fk foreign key(role_id) references Roles(id)
) ENGINE=InnoDB;