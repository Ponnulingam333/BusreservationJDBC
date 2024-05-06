CREATE DATABASE busreservation;
-- create database busreservation 

USE busreservation;

-- create table for storing passanger booking details
CREATE TABLE booking(
busno Int,
bname VARCHAR(30),
Traveldate DATE,
bookingtime VARCHAR(50),
bookingno Int,
bFrom VARCHAR(30),
bTo VARCHAR(30),
emailid VARCHAR(30) );

-- create table bus for storing bus details
CREATE TABLE bus(
busno INT,
capacity INT,
ac BOOLEAN);

-- insert the bus details in bus table
INSERT INTO bus VALUES(1,1,true),(2,48,false),(3,50,true);

-- create table for storing district details
CREATE TABLE District(
sno INT,
districtName VARCHAR(20));

-- insert the district details in District table
INSERT INTO District VALUES(1,"Ariyalur"),(2,"Chengalpattu"),(3,"Chennai"),(4,"Coimbatore"),(5,"Cuddalore"),(6,"Dharmapuri"),
(7,"Dindigul"),(8,"Erode"),(9,"Kallakurichi"),(10,"Kancheepuram"),(11,"karur"),(12,"Krishnagiri"),(13,"Madurai"),
(14,"Mayiladuthurai"),(15,"NagaPattinam"),(16,"Kanniyakumari"),(17,"Namakkal"),(18,"Perambalur"),(19,"Pudukottai"),
(20,"Ramanathapuram"),(21,"Ranipet"),(22,"Salem"),(23,"Sivagangai"),(24,"Tenkasi"),(25,"Thanjavur"),(26,"Theni"),(27,"Thiruvallur"),
(28,"Thiruvarur"),(29,"Thoothukudi"),(30,"Trichirappali"),(31,"Thirunelveli"),(32,"Tirupathur"),(33,"Tirupur"),
(34,"Thiruvannamalai"),(35,"Nilgris"),(36,"Vellore"),(37,"Viluppuram"),(38,"Virudhunagar");



