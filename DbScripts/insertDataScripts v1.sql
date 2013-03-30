USE `AdgTest`;

/* insert data into 'Day' table */
LOCK TABLES `Day` WRITE;

INSERT INTO `Day` (`dayId`, `day`) 
VALUES 
('1', 'Monday'),('2', 'Tuesday'),('3', 'Wednesday'),
('4', 'Thursday'),('5', 'Friday'),('6', 'Saturday'),
('7', 'Sunday');

UNLOCK TABLES;


/* insert data into 'UserType' table */
LOCK TABLES `UserType` WRITE;

INSERT INTO `UserType` (`userTypeId`, `name`) 
VALUES 
('2', 'Admin'),('1', 'Faculty'),('0', 'Student');

UNLOCK TABLES;


/* insert data into 'GradingScheme' table */
LOCK TABLES `GradingScheme` WRITE;

INSERT INTO `GradingScheme` 
VALUES (1,'Percentage'),(2,'Pass/Fail'),(3,'GPA');

UNLOCK TABLES;



/* insert data into 'SectionType' table */
LOCK TABLES `SectionType` WRITE;

INSERT INTO `SectionType` 
VALUES (1,'Lecture'),(2,'Tutorial'),(3,'Laboratory');

UNLOCK TABLES;


/* insert data into 'Address' table */
LOCK TABLES `Address` WRITE;

INSERT INTO `Address` 
(`addressLineFirst`, `addressLineSecond`, `city`, `province`, `postalCode`, `country`) 
VALUES 
('Main Mall', 'UBC1', 'Vancouver', 'BC', 'V1201Z', 'Canada'),
('East Mall', 'UBC2', 'Toronto', 'BC', 'V1202Z', 'India'),
('West Mall', 'West Coast3', 'Vancouver', 'BC', 'V1203Z','Canada'),
('Main Mall', 'West Coast4', 'Toronto', 'BC', 'V1204Z', 'India'),
('East Mall', 'UBC5', 'Vancouver', 'BC', 'V1205Z', 'Canada'),
('West Mall', 'East Coast6', 'Toronto', 'BC', 'V1206Z', 'India'),
('Main Mall', 'UBC7', 'Vancouver', 'BC', 'V1207Z', 'Canada'),
('East Mall', 'UBC8', 'Toronto', 'BC', 'V1208Z', 'India'),
('West Mall', 'West Coast9', 'Vancouver', 'BC', 'V1209Z', 'Canada'),
('Main Mall', 'UBC1', 'Vancouver', 'BC', 'V1201Z', 'Canada'),
('East Mall', 'UBC2', 'Toronto', 'BC', 'V1202Z', 'India'),
('West Mall', 'West Coast3', 'Vancouver', 'BC', 'V1203Z','Canada'),
('Main Mall', 'West Coast4', 'Toronto', 'BC', 'V1204Z', 'India'),
('East Mall', 'UBC5', 'Vancouver', 'BC', 'V1205Z', 'Canada'),
('West Mall', 'East Coast6', 'Toronto', 'BC', 'V1206Z', 'India'),
('Main Mall', 'UBC7', 'Vancouver', 'BC', 'V1207Z', 'Canada'),
('East Mall', 'UBC8', 'Toronto', 'BC', 'V1208Z', 'India'),
('West Mall', 'West Coast9', 'Vancouver', 'BC', 'V1209Z', 'Canada'),
('Main Mall', 'UBC9', 'Toronto', 'BC', 'V1210Z', 'China');

UNLOCK TABLES;


/* insert data into 'User' table */
LOCK TABLES `User` WRITE;

INSERT INTO `User` 
(`username`, `password`, `firstName`, `lastName`, `userTypeId`, `addressId`, `phoneNumber`, `email`, `dateOfBirth`) 
VALUES 
('jaspreet', 'singh', 'Jaspreet', 'Thind', '2', '102', '34567', 'jayzthind@gmail.com', '1986-01-05'),
('harsimran', 'singh', 'Harsimran', 'Maan', '2', '103', '45678', 'maan.harry@gmail.com',null),
('bahman', 'razmpa', 'Bahman', 'Razmpa', '1', '104', '56789', 'razmpa@gmail.com',null),
('witty', 'chot', 'Witty', 'Chot', '0', '106', '78901', 'mimity@gmail.com',null),
('mengmeng', 'jiang', 'Mengmeng', 'Jiang', '1', '105', '67890', 'mengmeng.mss@gmail.com',null),
('nicole', 'yu', 'Nicole', 'Yu', '0', '107', '89012', 'nicoleyu2003@gmail.com',null);

UNLOCK TABLES;


/* insert data into 'Faculty' table */
SET foreign_key_checks = 0;
LOCK TABLES `Faculty` WRITE;

INSERT INTO `Faculty` (`name`, `addressId`, `headOfFacultyId`, `phone`, `website`) 
VALUES 
('Faculty of Engineering', '100', null, '12345', 'www.foengg.com'),
('Faculty of Medical Sciences', '101', null, '23456', 'www.foms.com');

UNLOCK TABLES;
SET foreign_key_checks = 1;


/* insert data into 'Department' table */
LOCK TABLES `Department` WRITE;

INSERT INTO `Department` 
(`departmentId`, `name`, `addressId`, `facultyId`, `phone`, `email`, `website`) 
VALUES 
('CICS', 'Computing, Information and Cognitive Systems', '108', '100', '98373', 'gradsec@mss.icics.ubc.ca', 'www.icics.ubc.ca'),
('EECE', 'Electrical and Computer Engineering', '109', '100', '78234', 'esec@ece.ubc.ca', 'www.ece.ubc.ca'),
('EMER', 'Emergency Medicine', '110', '101', '43287', 'emer@ubc.ca', 'www.emer.ubc.ca');

UNLOCK TABLES;


/* insert data into 'FacultyMember' table */
LOCK TABLES `FacultyMember` WRITE;

INSERT INTO `FacultyMember` 
(`username`, `departmentId`, `title`, `dateOfJoining`, `highestDegree`) 
VALUES 
('bahman', 'CICS', 'Prof', '2012-01-01', 'BE'),
('mengmeng', 'EMER', 'Prof', '2012-06-01', 'ME');

UNLOCK TABLES;

/*  update headOfFacultyId of Faculty table */
UPDATE Faculty
SET headOfFacultyId = '100'
where facultyId = '100';

UPDATE Faculty
SET headOfFacultyId = '101'
where facultyId = '101';


/*  update directorId of Department table */


/* insert data into 'Administrator' table */
LOCK TABLES `Administrator` WRITE;

INSERT INTO `Administrator` 
(`username`, `dateOfJoining`, `hiringFacultyId`) 
VALUES 
('jaspreet', '2012-01-01', '100'),
('harsimran', '2012-06-01', '101');

UNLOCK TABLES;


/* insert data into 'Program' table */
LOCK TABLES `Program` WRITE;

INSERT INTO `Program` 
(`programName`, `departmentId`, `addressId`, `email`, `phone`) 
VALUES 
('Master of Software Systems', 'CICS', '111', 'mss@ubc.ca', '43243'),
('Bachelor of Engineering', 'CICS', '112', 'becics@ubc.ca', '32487'),
('Bachelor of Engineering', 'EECE', '113', 'beece@ubc.ca', '43728');

UNLOCK TABLES;


/* insert data into 'Student' table */
LOCK TABLES `Student` WRITE;

INSERT INTO `Student` 
(`username`, `programName`, `departmentId`, `dateOfRegistration`, `highestDegree`) 
VALUES 
('witty', 'Bachelor of Engineering', 'CICS', '2012-02-02', 'Masters'),
('nicole', 'Master of Software Systems', 'CICS', '2013-01-01', 'Masters');

UNLOCK TABLES;


/*insert data into '' table
LOCK TABLES `` WRITE;



UNLOCK TABLES;
*/




