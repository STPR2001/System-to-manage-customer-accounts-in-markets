create table users (
  id integer AUTO_INCREMENT primary key,
  name varchar(30) not null,
  address varchar(100) not null,
  email varchar(30) not null,
  verified boolean default false,
  created_at timestamp default CURRENT_TIMESTAMP,
  updated_at timestamp default CURRENT_TIMESTAMP
);

create table organizations (
  id integer AUTO_INCREMENT primary key,
  owner_id integer not null,
  name varchar(30) not null,
  description varchar(50),
  public boolean not null,
  created_at timestamp default CURRENT_TIMESTAMP,
  updated_at timestamp default CURRENT_TIMESTAMP
);

create table accounts (
  id integer AUTO_INCREMENT primary key,
  total float not null,
  limit_amount float not null,
  user_id integer not null,
  organization_id integer not null,
  # w for weekly, m for monthly, t for 3-m
  payment_interval varchar(20) default "m",
  created_at timestamp default CURRENT_TIMESTAMP,
  updated_at timestamp default CURRENT_TIMESTAMP,
  foreign key(user_id) references users(id),
  foreign key(organization_id) references organizations(id)
);

create table payment_transactions (
  id integer AUTO_INCREMENT primary key,
  created_at timestamp default CURRENT_TIMESTAMP,
  updated_at timestamp default CURRENT_TIMESTAMP,
  status varchar(30) not null default "pending",
  account_id integer not null,
  amount float not null,
  user_id integer not null,
  foreign key(user_id) references users(id),
  foreign key(account_id) references accounts(id)
);

create table debt_transactions (
  id integer AUTO_INCREMENT primary key,
  created_at timestamp default CURRENT_TIMESTAMP,
  updated_at timestamp default CURRENT_TIMESTAMP,
  total_amount float not null,
  initial_price float not null default 0,
  account_id integer not null,
  detail varchar(500),
  foreign key(account_id) references accounts(id)
);

create table organization_passwords (
  id integer AUTO_INCREMENT primary key,
  created_at timestamp default CURRENT_TIMESTAMP,
  updated_at timestamp default CURRENT_TIMESTAMP,
  password varchar(30) not null
);

create table account_passwords (
  id integer AUTO_INCREMENT primary key,
  created_at timestamp default CURRENT_TIMESTAMP,
  updated_at timestamp default CURRENT_TIMESTAMP,
  password varchar(30) not null
);

create table linked_emails (
  id integer AUTO_INCREMENT primary key,
  created_at timestamp default CURRENT_TIMESTAMP,
  updated_at timestamp default CURRENT_TIMESTAMP,
  account_id integer not null,
  email varchar (50) not null,
  foreign key (account_id) references accounts(id)
);
