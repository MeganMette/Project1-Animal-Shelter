drop table if exists shelter_animal CASCADE;
create table shelter_animal (
animal_id BIGINT auto_increment,
additional_information varchar(255),
age integer not null,
animal_type varchar(255),
breed varchar(255),
gender varchar(255),
location varchar(255),
Name varchar(255),
size varchar(255),
primary key (animal_id));