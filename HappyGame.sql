create table Player(
ID int identity(1,1) primary key,
username nvarchar(20) unique,
password nvarchar(20),
point int,
age int
)
create table GameType(
ID int identity(1,1) primary key,
Name nvarchar(20))
create table Game(
ID int identity(1,1) primary key,
Name nvarchar(255),
TypeID int REFERENCES GameType(ID)
)
create table History(
PlayerID int REFERENCES Player(ID),
GameID int REFERENCES Game(ID),
primary key(PlayerID, GameID))
create table Admin(
ID int identity(1,1) primary key,
username nvarchar(40) unique,
password nvarchar(40))
insert into Player values
('pl1','123456',1,18),
('pl2','123456',1,19),
('pl3','123456',1,12)
insert into GameType values ('No Brain'),('strategy')
insert into Game values ('Happy Frog',1),('Puzzle game',2)
insert into History values (1,1),(2,1)
insert into Admin values ('admin','admin')
