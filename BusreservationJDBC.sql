CREATE DATABASE busreservation;

USE busreservation;

CREATE TABLE booking(
busno Int,
bname VARCHAR(30),
Traveldate DATE,
bookingtime VARCHAR(50),
bookingno Int,
bFrom VARCHAR(30),
bTo VARCHAR(30),
emailid VARCHAR(30) );

drop table booking;

create table bus(
busno int,
capacity int,
ac boolean);
 Insert into bus values(1,1,true),(2,48,false),(3,50,true);
select * from booking;
delete from booking;
select capacity from bus where busno=1;
select * from bus;
select count(bname) from booking ;
drop table booking;
select * from bus
where exists (select capacity from bus where busno=1);

select exists (select 2 from bus where busno=1) as mcheck; 
select capacity from bus where busno=4;

select exists(select 2920 from booking where busno=4);
select bookingno from booking where busno=24;

create table District(
sno int,
districtName varchar(20));

insert into District values(1,"Ariyalur"),(2,"Chengalpattu"),(3,"Chennai"),(4,"Coimbatore"),(5,"Cuddalore"),(6,"Dharmapuri"),
(7,"Dindigul"),(8,"Erode"),(9,"Kallakurichi"),(10,"Kancheepuram"),(11,"karur"),(12,"Krishnagiri"),(13,"Madurai"),
(14,"Mayiladuthurai"),(15,"NagaPattinam"),(16,"Kanniyakumari"),(17,"Namakkal"),(18,"Perambalur"),(19,"Pudukottai"),
(20,"Ramanathapuram"),(21,"Ranipet"),(22,"Salem"),(23,"Sivagangai"),(24,"Tenkasi"),(25,"Thanjavur"),(26,"Theni"),(27,"Thiruvallur"),
(28,"Thiruvarur"),(29,"Thoothukudi"),(30,"Trichirappali"),(31,"Thirunelveli"),(32,"Tirupathur"),(33,"Tirupur"),
(34,"Thiruvannamalai"),(35,"Nilgris"),(36,"Vellore"),(37,"Viluppuram"),(38,"Virudhunagar");

select * from District;
drop table district;
select exists (select sno from District where districtName ="chennai");
select * from booking;

select exists (select busno from booking where bookingno=768);
select busno from booking;

select * from booking;
show tables;


