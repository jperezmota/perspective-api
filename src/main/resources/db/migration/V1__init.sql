create table users(
	username varchar(50) not null,
	password varchar(200) not null,
	token varchar(200) not null,
	enabled boolean not null,
	primary key(username)
);

create table authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);

create table authors(
	id bigint(20) not null auto_increment,
	name varchar(200) not null,
	created_by varchar(50) not null,
	created_date date not null,
	last_modified_by varchar(50),
	last_modified_date date,
	deleted boolean default false,
	deleted_by varchar(50),
	deleted_date date,
	primary key(id)
);

create table categories(
	id bigint(20) not null auto_increment,
	name varchar(200) not null,
	created_by varchar(50) not null,
	created_date date not null,
	last_modified_by varchar(50),
	last_modified_date date,
	deleted boolean default false,
	deleted_by varchar(50),
	deleted_date date,
	primary key(id)
);

create table perspectives(
	id bigint(20) not null auto_increment,
	perspective varchar(1000) not null,
	author_id bigint(20),
	category_id bigint(20),
	thoughts varchar(1000),
	created_by varchar(50) not null,
	created_date date not null,
	last_modified_by varchar(50),
	last_modified_date date,
	deleted boolean default false,
	deleted_by varchar(50),
	deleted_date date,
	primary key(id),
	foreign key (author_id) references authors(id),
	foreign key (category_id) references categories(id)
);