DROP TABLE users;

CREATE TABLE `test`.`users`( 
                 			`id` INT AUTO_INCREMENT,
                              `username`  VARCHAR(45) NOT NULL UNIQUE, 
                              `password`  VARCHAR(45) NOT NULL, 
                              `firstname` VARCHAR(45) NOT NULL, 
                              `lastname`  VARCHAR(45) NULL, 
                              `email`     VARCHAR(45) NULL, 
                              `address`   VARCHAR(45) NULL, 
                              `phone`     BIGINT NULL, 
                              `enabled` INT NOT NULL DEFAULT 1 ,
                              PRIMARY KEY (`id`) 
                 );
                 
  DROP TABLE test.user_roles;
  
  CREATE TABLE test.user_roles (
  								user_role_id int(11) NOT NULL AUTO_INCREMENT,
  								username varchar(45) NOT NULL,
  								role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));
              
 INSERT INTO test.user_roles (username, role) VALUES ('mukul', 'ROLE_USER');
              
                 
DROP TABLE HotelList;

CREATE TABLE `test`.`HotelList`( 
                 			  `hotelID` INT AUTO_INCREMENT,
                              `hotelName`  VARCHAR(45) NOT NULL UNIQUE,
                              `place`  VARCHAR(45) NOT NULL, 
                              `hotelPrice`  VARCHAR(45) NOT NULL, 
                              `hotelRating` VARCHAR(45) NOT NULL, 
                              `hotelOffer`  VARCHAR(45) NULL,
                              `date`		DATE, 
                               PRIMARY KEY (`hotelID`) 
                 );
                 
insert into HotelList(hotelID,hotelName,place,hotelPrice,hotelRating,hotelOffer,date) values(1,'Sea Side','goa','5000','3*','20%','2017-12-30'); 
insert into HotelList(hotelID,hotelName,place,hotelPrice,hotelRating,hotelOffer,date) values(2,'Goa In','goa','4000','3*','25%','2017-12-31'); 
insert into HotelList(hotelID,hotelName,place,hotelPrice,hotelRating,hotelOffer,date) values(3,'Delhi In','delhi','10000','4*','10%','2017-11-30'); 
insert into HotelList(hotelID,hotelName,place,hotelPrice,hotelRating,hotelOffer,date) values(4,'India Gate Hotel','delhi','2000','2*','5%','2017-10-31');
insert into HotelList(hotelID,hotelName,place,hotelPrice,hotelRating,hotelOffer,date) values(5,'Bangalore Resort','bangalore','5000','4*','15%','2017-10-22');     
insert into HotelList(hotelID,hotelName,place,hotelPrice,hotelRating,hotelOffer,date) values(6,'Ashoka','bangalore','5000','3*','20%','2017-12-30'); 
insert into HotelList(hotelID,hotelName,place,hotelPrice,hotelRating,hotelOffer,date) values(7,'Grand Lalith','bangalore','4000','3*','25%','2017-12-31'); 
insert into HotelList(hotelID,hotelName,place,hotelPrice,hotelRating,hotelOffer,date) values(8,'The Leela Palace','delhi','10000','4*','10%','2017-11-30'); 
insert into HotelList(hotelID,hotelName,place,hotelPrice,hotelRating,hotelOffer,date) values(9,'Hotel Maurya','patna','2000','2*','5%','2017-10-31');
insert into HotelList(hotelID,hotelName,place,hotelPrice,hotelRating,hotelOffer,date) values(10,'Bangalore Resort','bangalore','5000','4*','15%','2017-10-22');     
insert into HotelList(hotelID,hotelName,place,hotelPrice,hotelRating,hotelOffer,date) values(11,'The Taj Mahal Palace','mumbai','5000','3*','20%','2017-12-30'); 
insert into HotelList(hotelID,hotelName,place,hotelPrice,hotelRating,hotelOffer,date) values(12,'Taj Falaknuma Palace','hydrabad','4000','3*','25%','2017-12-31'); 
insert into HotelList(hotelID,hotelName,place,hotelPrice,hotelRating,hotelOffer,date) values(13,'Vivanta by Taj','bangalore','10000','4*','10%','2017-11-30'); 
insert into HotelList(hotelID,hotelName,place,hotelPrice,hotelRating,hotelOffer,date) values(14,'The Oberoi Cecil','shimla','2000','2*','5%','2017-10-31');
insert into HotelList(hotelID,hotelName,place,hotelPrice,hotelRating,hotelOffer,date) values(15,'Moevenpick Hotel','bangalore','5000','4*','15%','2017-10-22');     
    DROP TABLE BookingDetails;

CREATE TABLE `test`.`BookingDetails`( 
                 			  `bookingid` INT AUTO_INCREMENT,
                 			   `username`  VARCHAR(45) NOT NULL,
                              `hotelareaname`  VARCHAR(45) NOT NULL,
                              `roomcount`  int, 
                              `guestcount` int, 
                              `fromdate` VARCHAR(45) NOT NULL, 
                              `todate`  VARCHAR(45) NOT NULL, 
                              `selectedhotelname` VARCHAR(45) NOT NULL, 
                               PRIMARY KEY (`bookingid`) 
                 );

