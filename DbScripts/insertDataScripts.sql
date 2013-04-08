/* Do Not modify */

USE `AdgTest`;

/* insert data into 'Day' table */
LOCK TABLES `WeekDay` WRITE;

INSERT INTO `WeekDay` (`weekDay`) 
VALUES 
('Monday'),('Tuesday'),('Wednesday'),
('Thursday'),('Friday');

UNLOCK TABLES;


/* insert data into 'Session' table */
LOCK TABLES `Session` WRITE;

INSERT INTO `Session` (`name`)
VALUES ('Fall'),('Winter'),('Spring'),('Summer');

UNLOCK TABLES;



/* insert data into 'UserType' table */
LOCK TABLES `UserType` WRITE;

INSERT INTO `UserType` (`name`) 
VALUES 
('Student'),('Faculty'),('Admin');

UNLOCK TABLES;


/* insert data into 'GradingScheme' table */
LOCK TABLES `GradingScheme` WRITE;

INSERT INTO `GradingScheme` (`name`)
VALUES ('Percentage'),('Pass/Fail'),('GPA');

UNLOCK TABLES;



/* insert data into 'SectionType' table */
LOCK TABLES `SectionType` WRITE;

INSERT INTO `SectionType` (`name`)
VALUES ('Lecture'),('Tutorial'),('Laboratory');

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
('Main Mall', 'UBC9', 'Toronto', 'BC', 'V1210Z', 'China'),
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
('Main Mall', 'UBC9', 'Toronto', 'BC', 'V1210Z', 'China'),
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
('Main Mall', 'UBC9', 'Toronto', 'BC', 'V1210Z', 'China'),
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
('jaspreet', '502b7dfff6fb4dc619b4933e1cb122df34605430', 'Jaspreet', 'Thind', '102', '102', '34567', 'jayzthind@gmail.com', '1986-01-05'),
('harsimran', '4aaaf3c285f100eb4c3bf3318694b035bcec79c5', 'Harsimran', 'Maan', '102', '103', '45678', 'maan.harry@gmail.com',null),
('bahman', 'e99ec90aabd179a448e696de1177ce855bca0ec4', 'Bahman', 'Razmpa', '101', '104', '56789', 'razmpa@gmail.com',null),
('witty', 'e86993f920d2850ca428a1bbc4f38e1a24f23267', 'Witty', 'Chot', '100', '106', '78901', 'mimity@gmail.com',null),
('mengmeng', '4e7b08952acae50abec9e06cac9ae2c424c73473', 'Mengmeng', 'Jiang', '101', '105', '67890', 'mengmeng.mss@gmail.com',null),
('nicole', '62094dd800f813de6a47ea4f5e137aced93c354d', 'Nicole', 'Yu', '100', '107', '89012', 'nicoleyu2003@gmail.com',null);

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
(`departmentId`, `name`, `facultyId`) 
VALUES
('ARCS', 'Alternative Routes to Computing', '100'),
('ANAT', 'Anatomy', '101'),
('BIOF', 'Bioinformatics', '100'),
('BIOC', 'Biochemistry', '101'),
('CICS', 'Computing Information and Cognitive Systems', '100'),
('CELL', 'Cell and Developmental Biology', '101'),
('DMED', 'Digital Media', '100'),
('DERM', 'Clinical Dermatology', '101'),
('EECE', 'Electrical and Computer Engineering', '100'),
('EMER', 'Emergency Medicine', '101'),
('FEBC', 'Forest Engineering British Columbia', '100'),
('FMED', 'Foundations of Medicine', '101'),
('GSAT', 'Genome Science and Technology', '100'),
('HXPH', 'Herstmonceux Physics', '100'),
('HUNU', 'Human Nutrition', '101'),
('INDS', 'Interdisciplinary Studies', '100'),
('ISCI', 'Integrated Sciences', '101'),
('JAPN', 'Japanese', '100'),
('JRNL', 'Journalism', '101'),
('KORN', 'Korean', '100'),
('KNSL', 'Kinesiology', '101'),
('LLED', 'Language and Literacy Education', '100'),
('LAFS', 'Land & Food Systems', '101'),
('MATH', 'Mathematics', '100'),
('MEDG', 'Medical Genetics', '101'),
('NRSC', 'Neuroscience', '101'),
('NURS', 'Nursing', '101'),
('ONCO', 'Oncology', '100'),
('OPTH', 'Ophthalmology', '101'),
('PAED', 'Paediatrics', '101'),
('PLNT', 'Plant Science', '100'),
('RMES', 'Resource Management and Environmental Studies', '100'),
('RADI', 'Radiology', '101'),
('SATS', 'Science and Technology Studies', '100'),
('SURG', 'Surgery', '101'),
('TECS', 'Teacher Librarianship', '100'),
('TIBT', 'Tibetan Languages', '101'),
('UROL', 'Urological Surgery', '100'),
('URBN', 'Urban Studies', '101'),
('VRHS', 'Vocational Rehabilitation Counselling', '100'),
('VISA', 'Visual Arts', '101'),
('WRIT', 'University Writing Centre Courses', '100'),
('WOOD', 'Wood Products Processing', '101'),
('COGS', 'Cognitive Systems Program', '100'),
('ZOOL', 'Zoology', '101'),
('CPSC', 'Computer Science', '100');

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
(`programName`, `departmentId`, `creditsRequired`) 
VALUES 
('Bachelor of Engineering', 'ARCS', '20' ),
('Master of Medicine', 'ANAT', '23' ),
('Bachelor of Engineering', 'BIOF', '22' ),
('Bachelor of Medicine', 'BIOC', '20' ),
('Bachelor of Engineering', 'CICS', '23' ),
('Master of Software Systems', 'CICS', '20' ),
('Bachelor of Engineering', 'EECE', '22' ),
('Master of Medicine', 'CELL', '20' ),
('Bachelor of Engineering', 'DMED', '21' ),
('Bachelor of Medicine', 'DERM', '20' ),
('Bachelor of Medicine', 'EMER', '26' ),
('Bachelor of Engineering', 'FEBC', '20' ),
('Master of Medicine', 'FMED', '27' ),
('Bachelor of Engineering', 'GSAT', '23' ),
('Bachelor of Engineering', 'HXPH', '27' ),
('Bachelor of Medicine', 'HUNU', '22' ),
('Bachelor of Engineering', 'INDS', '28' ),
('Master of Medicine', 'ISCI', '23' ),
('Bachelor of Engineering', 'JAPN', '22' ),
('Bachelor of Medicine', 'JRNL', '21' ),
('Bachelor of Engineering', 'KORN', '20' ),
('Bachelor of Medicine', 'KNSL', '28' );

UNLOCK TABLES;


/* insert data into 'Student' table */
LOCK TABLES `Student` WRITE;

INSERT INTO `Student` 
(`username`, `dateOfRegistration`, `highestDegree`) 
VALUES 
('witty', '2012-02-02', 'Masters'),
('nicole', '2013-01-01', 'Masters');

UNLOCK TABLES;


/* insert data into 'Course' table */
LOCK TABLES `Course` WRITE;

INSERT INTO `Course` 
(`courseNumber`, `departmentId`, `name`, `description`, `credits`, `gradingSchemeId`, `passingRequirement`) 
VALUES 
('230', 'EECE', 'Selected Topics in Biomedical Engineering', 'Description of Selected Topics in Biomedical Engineering', '3', '101', 'Pass'),
('251', 'EECE', 'Circuit Analysis I', 'Description of Circuit Analysis I', '3', '101', 'Pass'),
('253', 'EECE', 'Circuit Analysis II', 'Description of Circuit Analysis II', '6', '101', 'Pass'),
('259', 'EECE', 'Introduction to Microcomputers', 'Description of Introduction to Microcomputers', '3', '101', 'Pass'),
('500', 'CICS', 'Software Systems Internship', 'Description of Software Systems Internship', '3', '101', 'Pass'),
('505', 'CICS', 'Introduction to Software Systems', 'Description of  Introduction to Software Systems', '6', '102', '68 percent'),
('511', 'CICS', 'Computational Structures', 'Description of  Computational Structures', '2', '102', '68 percent'),
('520', 'CICS', 'Database Systems', 'Description of Database Systems', '3', '102', '68 percent'),
('530', 'CICS', 'Advanced Software Engineering Project', 'Description of Advanced Software Engineering Project', '3', '101', 'Pass'),
('534', 'ARCS', 'ARCS Level 1', 'Description of ARCS Level 1', '3', '100', 'B Grade'),
('536', 'ARCS', 'ARCS Level 2', 'Description of ARCS Level 2', '3', '101', 'Pass'),
('538', 'ARCS', 'ARCS Level 3', 'Description of ARCS Level 3', '6', '102', 'Percent'),
('540', 'ARCS', 'ARCS Level 4', 'Description of ARCS Level 4', '3', '101', 'Pass'),
('542', 'ARCS', 'ARCS Level 5', 'Description of ARCS Level 5', '3', '101', 'Pass'),
('544', 'ARCS', 'ARCS Level 6', 'Description of ARCS Level 6', '6', '102', '68 percent'),
('546', 'ANAT', 'ANAT Level 1', 'Description of ANAT Level 1', '2', '100', 'B Grade'),
('548', 'ANAT', 'ANAT Level 2', 'Description of ANAT Level 2', '3', '102', '68 percent'),
('550', 'ANAT', 'ANAT Level 3', 'Description of ANAT Level 3', '3', '101', 'Pass'),
('552', 'ANAT', 'ANAT Level 4', 'Description of ANAT Level 4', '3', '100', 'B Grade'),
('554', 'BIOF', 'BIOF Level 1', 'Description of BIOF Level 1', '3', '101', 'Pass'),
('556', 'BIOF', 'BIOF Level 2', 'Description of BIOF Level 2', '6', '102', 'Percent'),
('558', 'BIOF', 'BIOF Level 3', 'Description of BIOF Level 3', '3', '101', 'Pass'),
('560', 'BIOF', 'BIOF Level 4', 'Description of BIOF Level 4', '3', '101', 'Pass'),
('562', 'BIOC', 'BIOC Level 1', 'Description of BIOC Level 1', '6', '102', '68 percent'),
('564', 'BIOC', 'BIOC Level 2', 'Description of BIOC Level 2', '2', '100', 'B Grade'),
('566', 'BIOC', 'BIOC Level 3', 'Description of BIOC Level 3', '3', '102', '68 percent'),
('568', 'BIOC', 'BIOC Level 4', 'Description of BIOC Level 4', '3', '101', 'Pass'),
('570', 'CELL', 'CELL Level 1', 'Description of CELL Level 1', '3', '100', 'B Grade'),
('572', 'CELL', 'CELL Level 2', 'Description of CELL Level 2', '3', '101', 'Pass'),
('574', 'CELL', 'CELL Level 3', 'Description of CELL Level 3', '6', '102', 'Percent'),
('576', 'CELL', 'CELL Level 4', 'Description of CELL Level 4', '3', '101', 'Pass'),
('578', 'DMED', 'DMED Level 1', 'Description of DMED Level 1', '3', '101', 'Pass'),
('580', 'DMED', 'DMED Level 2', 'Description of DMED Level 2', '6', '102', '68 percent'),
('582', 'DMED', 'DMED Level 3', 'Description of DMED Level 3', '2', '100', 'B Grade'),
('584', 'DMED', 'DMED Level 4', 'Description of DMED Level 4', '3', '102', '68 percent'),
('586', 'DERM', 'DERM Level 1', 'Description of DERM Level 1', '3', '101', 'Pass'),
('588', 'DERM', 'DERM Level 2', 'Description of DERM Level 2', '3', '100', 'B Grade'),
('590', 'DERM', 'DERM Level 3', 'Description of DERM Level 3', '3', '101', 'Pass'),
('592', 'DERM', 'DERM Level 4', 'Description of DERM Level 4', '6', '102', 'Percent'),
('594', 'EMER', 'Emergency Medicine Level 1', 'Description of Emergency Medicine Level 1', '3', '101', 'Pass'),
('596', 'EMER', 'Emergency Medicine Level 2', 'Description of Emergency Medicine Level 2', '3', '101', 'Pass'),
('598', 'EMER', 'Emergency Medicine Level 3', 'Description of Emergency Medicine Level 3', '6', '102', '68 percent'),
('600', 'EMER', 'Emergency Medicine Level 4', 'Description of Emergency Medicine Level 4', '2', '100', 'B Grade'),
('530', 'FEBC', 'FEBC Level 1', 'Description of FEBC Level 1', '3', '102', '68 percent'),
('532', 'FEBC', 'FEBC Level 2', 'Description of FEBC Level 2', '3', '101', 'Pass'),
('534', 'FEBC', 'FEBC Level 3', 'Description of FEBC Level 3', '3', '100', 'B Grade'),
('536', 'FEBC', 'FEBC Level 4', 'Description of FEBC Level 4', '3', '101', 'Pass'),
('538', 'FMED', 'FMED Level 1', 'Description of FMED Level 1', '6', '102', 'Percent'),
('540', 'FMED', 'FMED Level 2', 'Description of FMED Level 2', '3', '101', 'Pass'),
('542', 'FMED', 'FMED Level 3', 'Description of FMED Level 3', '3', '101', 'Pass'),
('544', 'FMED', 'FMED Level 4', 'Description of FMED Level 4', '6', '102', '68 percent'),
('546', 'GSAT', 'GSAT Level 1', 'Description of GSAT Level 1', '2', '100', 'B Grade'),
('548', 'GSAT', 'GSAT Level 2', 'Description of GSAT Level 2', '3', '102', '68 percent'),
('550', 'GSAT', 'GSAT Level 3', 'Description of GSAT Level 3', '3', '101', 'Pass'),
('552', 'GSAT', 'GSAT Level 4', 'Description of GSAT Level 4', '3', '100', 'B Grade'),
('554', 'HXPH', 'HXPH Level 1', 'Description of HXPH Level 1', '3', '101', 'Pass'),
('556', 'HXPH', 'HXPH Level 2', 'Description of HXPH Level 2', '6', '102', 'Percent'),
('558', 'HXPH', 'HXPH Level 3', 'Description of HXPH Level 3', '3', '101', 'Pass'),
('560', 'HXPH', 'HXPH Level 4', 'Description of HXPH Level 4', '3', '101', 'Pass'),
('562', 'HUNU', 'HUNU Level 1', 'Description of HUNU Level 1', '6', '102', '68 percent'),
('564', 'HUNU', 'HUNU Level 2', 'Description of HUNU Level 2', '2', '100', 'B Grade'),
('566', 'HUNU', 'HUNU Level 3', 'Description of HUNU Level 3', '3', '102', '68 percent'),
('568', 'HUNU', 'HUNU Level 4', 'Description of HUNU Level 4', '3', '101', 'Pass'),
('570', 'INDS', 'INDS Level 1', 'Description of INDS Level 1', '3', '100', 'B Grade'),
('572', 'INDS', 'INDS Level 2', 'Description of INDS Level 2', '3', '101', 'Pass'),
('574', 'INDS', 'INDS Level 3', 'Description of INDS Level 3', '6', '102', 'Percent'),
('576', 'ISCI', 'ISCI Level 1', 'Description of ISCI Level 1', '3', '101', 'Pass'),
('578', 'ISCI', 'ISCI Level 2', 'Description of ISCI Level 2', '3', '101', 'Pass'),
('580', 'ISCI', 'ISCI Level 3', 'Description of ISCI Level 3', '6', '102', '68 percent'),
('582', 'ISCI', 'ISCI Level 4', 'Description of ISCI Level 4', '2', '100', 'B Grade'),
('584', 'JAPN', 'JAPN Level 1', 'Description of JAPN Level 1', '3', '102', '68 percent'),
('586', 'JRNL', 'JRNL Level 1', 'Description of JRNL Level 1', '3', '101', 'Pass'),
('588', 'KORN', 'KORN Level 1', 'Description of KORN Level 1', '3', '100', 'B Grade'),
('590', 'KNSL', 'KNSL Level 1', 'Description of KNSL Level 1', '3', '101', 'Pass'),
('592', 'LLED', 'LLED Level 1', 'Description of LLED Level 1', '6', '102', 'Percent'),
('594', 'LAFS', 'LAFS Level 1', 'Description of LAFS Level 1', '3', '101', 'Pass'),
('596', 'MATH', 'MATH Level 1', 'Description of MATH Level 1', '3', '101', 'Pass'),
('598', 'MATH', 'MATH Level 2', 'Description of MATH Level 2', '6', '102', '68 percent'),
('600', 'MATH', 'MATH Level 3', 'Description of MATH Level 3', '2', '100', 'B Grade'),
('530', 'MATH', 'MATH Level 4', 'Description of MATH Level 4', '3', '102', '68 percent'),
('532', 'MATH', 'MATH Level 5', 'Description of MATH Level 5', '3', '101', 'Pass'),
('534', 'MATH', 'MATH Level 6', 'Description of MATH Level 6', '3', '100', 'B Grade'),
('536', 'MATH', 'MATH Level 7', 'Description of MATH Level 7', '3', '101', 'Pass'),
('538', 'MATH', 'MATH Level 8', 'Description of MATH Level 8', '6', '102', 'Percent'),
('540', 'MEDG', 'MEDG Level 1', 'Description of MEDG Level 1', '3', '101', 'Pass'),
('542', 'MEDG', 'MEDG Level 2', 'Description of MEDG Level 2', '3', '101', 'Pass'),
('544', 'MEDG', 'MEDG Level 3', 'Description of MEDG Level 3', '6', '102', '68 percent'),
('546', 'NRSC', 'NRSC Level 1', 'Description of NRSC Level 1', '2', '100', 'B Grade'),
('548', 'NRSC', 'NRSC Level 2', 'Description of NRSC Level 2', '3', '102', '68 percent'),
('550', 'NRSC', 'NRSC Level 3', 'Description of NRSC Level 3', '3', '101', 'Pass'),
('552', 'NRSC', 'NRSC Level 4', 'Description of NRSC Level 4', '6', '102', '68 percent'),
('554', 'NRSC', 'NRSC Level 5', 'Description of NRSC Level 5', '2', '100', 'B Grade'),
('556', 'NRSC', 'NRSC Level 6', 'Description of NRSC Level 6', '3', '102', '68 percent'),
('558', 'NURS', 'NURS Level 1', 'Description of NURS Level 1', '3', '101', 'Pass'),
('560', 'NURS', 'NURS Level 2', 'Description of NURS Level 2', '3', '100', 'B Grade'),
('562', 'ONCO', 'ONCO Level 1', 'Description of ONCO Level 1', '3', '101', 'Pass'),
('564', 'ONCO', 'ONCO Level 2', 'Description of ONCO Level 2', '6', '102', 'Percent'),
('566', 'ONCO', 'ONCO Level 3', 'Description of ONCO Level 3', '3', '101', 'Pass'),
('568', 'ONCO', 'ONCO Level 4', 'Description of ONCO Level 4', '3', '101', 'Pass'),
('570', 'ONCO', 'ONCO Level 5', 'Description of ONCO Level 5', '6', '102', '68 percent'),
('572', 'OPTH', 'OPTH Level 1', 'Description of OPTH Level 1', '2', '100', 'B Grade'),
('574', 'OPTH', 'OPTH Level 2', 'Description of OPTH Level 2', '3', '102', '68 percent'),
('576', 'OPTH', 'OPTH Level 3', 'Description of OPTH Level 3', '3', '101', 'Pass'),
('578', 'OPTH', 'OPTH Level 4', 'Description of OPTH Level 4', '3', '100', 'B Grade'),
('580', 'PAED', 'PAED Level 1', 'Description of PAED Level 1', '3', '101', 'Pass'),
('582', 'PAED', 'PAED Level 2', 'Description of PAED Level 2', '6', '102', 'Percent'),
('584', 'PAED', 'PAED Level 3', 'Description of PAED Level 3', '3', '101', 'Pass'),
('586', 'PAED', 'PAED Level 4', 'Description of PAED Level 4', '3', '101', 'Pass'),
('588', 'PAED', 'PAED Level 5', 'Description of PAED Level 5', '6', '102', '68 percent'),
('590', 'PLNT', 'PLNT Level 1', 'Description of PLNT Level 1', '2', '100', 'B Grade'),
('592', 'PLNT', 'PLNT Level 2', 'Description of PLNT Level 2', '3', '102', '68 percent'),
('594', 'RMES', 'RMES Level 1', 'Description of RMES Level 1', '3', '101', 'Pass'),
('596', 'RMES', 'RMES Level 2', 'Description of RMES Level 2', '6', '102', '68 percent'),
('598', 'RMES', 'RMES Level 3', 'Description of RMES Level 3', '2', '100', 'B Grade'),
('600', 'RMES', 'RMES Level 4', 'Description of RMES Level 4', '3', '102', '68 percent'),
('530', 'RADI', 'RADI Level 1', 'Description of RADI Level 1', '3', '101', 'Pass'),
('532', 'RADI', 'RADI Level 2', 'Description of RADI Level 2', '3', '100', 'B Grade'),
('534', 'RADI', 'RADI Level 3', 'Description of RADI Level 3', '3', '101', 'Pass'),
('536', 'RADI', 'RADI Level 4', 'Description of RADI Level 4', '6', '102', 'Percent'),
('538', 'SATS', 'SATS Level 1', 'Description of SATS Level 1', '3', '101', 'Pass'),
('540', 'SATS', 'SATS Level 2', 'Description of SATS Level 2', '3', '101', 'Pass'),
('542', 'SATS', 'SATS Level 3', 'Description of SATS Level 3', '6', '102', '68 percent'),
('544', 'SATS', 'SATS Level 4', 'Description of SATS Level 4', '2', '100', 'B Grade'),
('546', 'SATS', 'SATS Level 5', 'Description of SATS Level 5', '3', '102', '68 percent'),
('548', 'SATS', 'SATS Level 6', 'Description of SATS Level 6', '3', '101', 'Pass'),
('550', 'SURG', 'SURG Level 1', 'Description of SURG Level 1', '3', '100', 'B Grade'),
('552', 'SURG', 'SURG Level 2', 'Description of SURG Level 2', '3', '101', 'Pass'),
('554', 'SURG', 'SURG Level 3', 'Description of SURG Level 3', '6', '102', 'Percent'),
('556', 'SURG', 'SURG Level 4', 'Description of SURG Level 4', '3', '101', 'Pass'),
('558', 'SURG', 'SURG Level 5', 'Description of SURG Level 5', '3', '101', 'Pass'),
('560', 'SURG', 'SURG Level 6', 'Description of SURG Level 6', '6', '102', '68 percent'),
('562', 'TECS', 'TECS Level 1', 'Description of TECS Level 1', '2', '100', 'B Grade'),
('564', 'TECS', 'TECS Level 2', 'Description of TECS Level 2', '3', '102', '68 percent'),
('566', 'TIBT', 'TIBT Level 1', 'Description of TIBT Level 1', '3', '101', 'Pass'),
('568', 'UROL', 'UROL Level 1', 'Description of UROL Level 1', '6', '102', '68 percent'),
('570', 'UROL', 'UROL Level 2', 'Description of UROL Level 2', '2', '100', 'B Grade'),
('572', 'UROL', 'UROL Level 3', 'Description of UROL Level 3', '3', '102', '68 percent'),
('574', 'UROL', 'UROL Level 4', 'Description of UROL Level 4', '3', '101', 'Pass'),
('576', 'UROL', 'UROL Level 5', 'Description of UROL Level 5', '3', '100', 'B Grade'),
('578', 'UROL', 'UROL Level 6', 'Description of UROL Level 6', '3', '101', 'Pass'),
('580', 'UROL', 'UROL Level 7', 'Description of UROL Level 7', '6', '102', 'Percent'),
('582', 'URBN', 'URBN Level 1', 'Description of URBN Level 1', '3', '101', 'Pass'),
('584', 'URBN', 'URBN Level 2', 'Description of URBN Level 2', '3', '101', 'Pass'),
('586', 'URBN', 'URBN Level 3', 'Description of URBN Level 3', '6', '102', '68 percent'),
('588', 'URBN', 'URBN Level 4', 'Description of URBN Level 4', '2', '100', 'B Grade'),
('590', 'URBN', 'URBN Level 5', 'Description of URBN Level 5', '3', '102', '68 percent'),
('592', 'VRHS', 'VRHS Level 1', 'Description of VRHS Level 1', '3', '101', 'Pass'),
('594', 'VRHS', 'VRHS Level 2', 'Description of VRHS Level 2', '3', '100', 'B Grade'),
('596', 'VISA', 'VISA Level 1', 'Description of VISA Level 1', '3', '101', 'Pass'),
('598', 'VISA', 'VISA Level 2', 'Description of VISA Level 2', '6', '102', 'Percent'),
('600', 'WRIT', 'WRIT Level 1', 'Description of WRIT Level 1', '3', '101', 'Pass'),
('530', 'WRIT', 'WRIT Level 2', 'Description of WRIT Level 2', '3', '101', 'Pass'),
('532', 'WRIT', 'WRIT Level 3', 'Description of WRIT Level 3', '6', '102', '68 percent'),
('534', 'WOOD', 'WOOD Level 1', 'Description of WOOD Level 1', '2', '100', 'B Grade'),
('536', 'WOOD', 'WOOD Level 2', 'Description of WOOD Level 2', '3', '102', '68 percent'),
('538', 'WOOD', 'WOOD Level 3', 'Description of WOOD Level 3', '3', '101', 'Pass'),
('540', 'WOOD', 'WOOD Level 4', 'Description of WOOD Level 4', '6', '102', '68 percent'),
('542', 'COGS', 'COGS Level 1', 'Description of COGS Level 1', '2', '100', 'B Grade'),
('544', 'COGS', 'COGS Level 2', 'Description of COGS Level 2', '3', '102', '68 percent'),
('546', 'COGS', 'COGS Level 3', 'Description of COGS Level 3', '3', '101', 'Pass'),
('548', 'COGS', 'COGS Level 4', 'Description of COGS Level 4', '3', '100', 'B Grade'),
('550', 'COGS', 'COGS Level 5', 'Description of COGS Level 5', '3', '101', 'Pass'),
('552', 'COGS', 'COGS Level 6', 'Description of COGS Level 6', '6', '102', 'Percent'),
('554', 'COGS', 'COGS Level 7', 'Description of COGS Level 7', '3', '101', 'Pass'),
('556', 'COGS', 'COGS Level 8', 'Description of COGS Level 8', '3', '101', 'Pass'),
('558', 'ZOOL', 'ZOOL Level 1', 'Description of ZOOL Level 1', '6', '102', '68 percent'),
('560', 'ZOOL', 'ZOOL Level 2', 'Description of ZOOL Level 2', '2', '100', 'B Grade'),
('562', 'ZOOL', 'ZOOL Level 3', 'Description of ZOOL Level 3', '3', '102', '68 percent'),
('564', 'ZOOL', 'ZOOL Level 4', 'Description of ZOOL Level 4', '3', '101', 'Pass'),
('566', 'CPSC', 'CPSC Level 1', 'Description of CPSC Level 1', '3', '100', 'B Grade'),
('568', 'CPSC', 'CPSC Level 2', 'Description of CPSC Level 2', '3', '101', 'Pass'),
('570', 'CPSC', 'CPSC Level 3', 'Description of CPSC Level 3', '6', '102', 'Percent'),
('572', 'CPSC', 'CPSC Level 4', 'Description of CPSC Level 4', '3', '101', 'Pass'),
('574', 'CPSC', 'CPSC Level 5', 'Description of CPSC Level 5', '3', '101', 'Pass'),
('576', 'CPSC', 'CPSC Level 6', 'Description of CPSC Level 6', '6', '102', '68 percent'),
('578', 'CPSC', 'CPSC Level 7', 'Description of CPSC Level 7', '2', '100', 'B Grade'),
('580', 'CPSC', 'CPSC Level 8', 'Description of CPSC Level 8', '3', '102', '68 percent'),
('582', 'CPSC', 'CPSC Level 9', 'Description of CPSC Level 9', '3', '101', 'Pass');
UNLOCK TABLES;


/* insert data into 'Term' table */
LOCK TABLES `Term` WRITE;

INSERT INTO `Term` 
(`termYear`, `sessionId`) 
VALUES 
('2013', '100'),('2013', '101'),('2013', '102'),('2013', '103');

UNLOCK TABLES;

/* insert data into 'Section' table */
LOCK TABLES `Section` WRITE;

INSERT INTO `Section` 
(`sectionId`, `sectionTypeId`, `courseNumber`, `departmentId`, `termYear`, `sessionId`, `startDate`, `endDate`, `registerDeadline`, `dropDeadline`, `totalSeats`, `facultyMemberId`, `teachingAssistant`) 
VALUES 
('01', '100', '505', 'CICS', '2013', '101', '2013-01-01', '2013-04-31', '2013-01-10', '2013-01-20', '22', '100', null),
('01', '102', '505', 'CICS', '2013', '101', '2013-01-01', '2013-04-31', '2013-01-11', '2013-01-21', '20', '100', 'Iliya'),
('01', '100', '520', 'CICS', '2013', '101', '2013-01-01', '2013-04-31', '2013-01-10', '2013-01-22', '21', '101', null),
('01', '101', '520', 'CICS', '2013', '101', '2013-01-01', '2013-04-31', '2013-01-12', '2013-01-20', '20', '101', 'Hootan'),
('02', '100', '520', 'CICS', '2013', '101', '2013-01-01', '2013-04-31', '2013-01-11', '2013-01-22', '22', '100', null),
('02', '101', '520', 'CICS', '2013', '101', '2013-01-01', '2013-04-31', '2013-01-10', '2013-01-20', '21', '100', 'Hootan'),
('01', '100', '505', 'CICS', '2013', '102', '2013-05-01', '2013-08-31', '2013-05-10', '2013-05-20', '22', '100', null),
('01', '102', '505', 'CICS', '2013', '102', '2013-05-01', '2013-08-31', '2013-05-11', '2013-05-21', '20', '100', 'Iliya'),
('01', '100', '520', 'CICS', '2013', '102', '2013-05-01', '2013-08-31', '2013-05-10', '2013-05-22', '21', '101', null),
('01', '101', '520', 'CICS', '2013', '102', '2013-05-01', '2013-08-31', '2013-05-12', '2013-05-20', '20', '101', 'Hootan'),
('02', '100', '520', 'CICS', '2013', '102', '2013-05-01', '2013-08-31', '2013-05-11', '2013-05-22', '22', '100', null),
('02', '101', '520', 'CICS', '2013', '102', '2013-05-01', '2013-08-31', '2013-05-10', '2013-05-20', '21', '100', 'Hootan');

UNLOCK TABLES;


/* insert data into 'SectionTimeTable' table */
LOCK TABLES `SectionTimeTable` WRITE;

INSERT INTO `SectionTimeTable` 
(`sectionId`, `courseNumber`, `departmentId`, `termYear`, `sessionId`, `sectionTypeId`, `dayId`, `startTime`, `lengthInMinutes`) 
VALUES 
('01', '505', 'CICS', '2013', '101', '100', '102', '11:00:00', '180'),
('01', '505', 'CICS', '2013', '101', '100', '104', '14:00:00', '180'),
('01', '505', 'CICS', '2013', '101', '102', '100', '12:00:00', '120'),
('01', '505', 'CICS', '2013', '101', '102', '103', '14:30', '120'),
('01', '520', 'CICS', '2013', '101', '100', '100', '16:00', '90'),
('01', '520', 'CICS', '2013', '101', '100', '102', '16:00', '90'),
('01', '520', 'CICS', '2013', '101', '101', '104', '11:30', '120'),
('02', '520', 'CICS', '2013', '101', '100', '100', '17:30', '90'),
('02', '520', 'CICS', '2013', '101', '100', '102', '17:30', '90'),
('02', '520', 'CICS', '2013', '101', '101', '104', '17:00', '120');

UNLOCK TABLES;


/* insert data into 'Grade' table */
LOCK TABLES `Grade` WRITE;

INSERT INTO `Grade` (`name`) 
VALUES 
('A'),('B'),('C'),
('D'),('E'),('F');

UNLOCK TABLES;


/* insert data into 'Result' table */
LOCK TABLES `Result` WRITE;

INSERT INTO `Result` (`name`) 
VALUES 
('Pass'),('Fail');

UNLOCK TABLES;


/* insert data into 'Enrolment' table */
LOCK TABLES `Enrolment` WRITE;

INSERT INTO `Enrolment` 
(`studentId`, `sectionId`, `courseNumber`, `departmentId`, `termYear`, `sessionId`, `sectionTypeId`) 
VALUES 
('100', '01', '505', 'CICS', '2013', '101', '100'),
('100', '01', '505', 'CICS', '2013', '101', '102'),
('100', '01', '520', 'CICS', '2013', '101', '100'),
('100', '01', '520', 'CICS', '2013', '101', '101'),
('100', '02', '520', 'CICS', '2013', '101', '100'),
('100', '02', '520', 'CICS', '2013', '101', '101'),
('101', '01', '505', 'CICS', '2013', '101', '100'),
('101', '01', '505', 'CICS', '2013', '101', '102'),
('101', '02', '520', 'CICS', '2013', '101', '100'),
('101', '02', '520', 'CICS', '2013', '101', '101');

UNLOCK TABLES;


/* insert data into 'Glossary' table */
LOCK TABLES `Glossary` WRITE;

INSERT INTO `Glossary` 
(`term`, `definition`) 
VALUES 
('abc', 'definition of term'),
('Admin', 'Admin is the secondary target user for the system who is an administrator at the university.'),
('Course', 'The User generally views course as a literal meaning. A course in the RED system contains all the information about the course.'),
('Degree', 'Degree is the acknowledgement a student will receive after finishing each specific program.'),
('Department', 'Department is the name of the particular branch of the faculty that offers courses to students.'),
('Faculty ', 'Faculty is the third target user for the system who is a faculty member or an instructor at the university.'),
('Program', 'Program is a set of courses that a student has to take to specialize in a particular field.');

UNLOCK TABLES;

/* insert data into 'FAQ' table */
LOCK TABLES `FAQ` WRITE;

INSERT INTO `FAQ` 
(`question`, `answer`) 
VALUES 
('Where can I get information about your program?', 'The Master of Software Systems website contains all the information needed for applying to our program. '),
('What are your language requirements?', 'TOEFL (Test of English as a Foreign Language): we require a minimum score of 100 (internet-based).'),
('What is your deadline for admission?', 'Applications for January 2014 will be accepted from February 1st to June 14, 2013.');

UNLOCK TABLES;

/* insert data into 'Registration' table */ 
LOCK TABLES `Registration` WRITE;

INSERT INTO `Registration` 
(`studentId`, `programName`, `departmentId`, `startDate`, `graduationDate`) 
VALUES 
('100', 'Master of Software Systems', 'CICS', '2013-01-01', '2014-04-30'),
('101', 'Master of Software Systems', 'CICS', '2013-01-01', '2014-04-30');

UNLOCK TABLES;


/* insert data into 'MessagePriority' table */
LOCK TABLES `MessagePriority` WRITE;

INSERT INTO `MessagePriority` 
(`messagePriorityId`, `name`) 
VALUES 
('1', 'Normal'),
('2', 'Important'),
('3', 'Urgent');

UNLOCK TABLES;

/* insert data into 'MessageStatus' table */
LOCK TABLES `MessageStatus` WRITE;

INSERT INTO `MessageStatus` 
(`statusId`, `name`) 
VALUES 
('1', 'read'),
('2', 'unread'),
('3', 'deleted');

UNLOCK TABLES;


/* insert data into 'Message' table */
LOCK TABLES `Message` WRITE;

INSERT INTO `Message` 
(`subject`,`messageBody`,`priorityId`,`senderId`,`dateTime`) 
VALUES 
('Welcome to RED','Welcome to become a  member in RED. If you have any questions, please first browse  FAQ and Glossary.','1','harsimran','2013-04-02 00:00:00');

UNLOCK TABLES;


/* insert data into 'MessageReceiver' table */
LOCK TABLES `MessageReceiver` WRITE;

INSERT INTO `MessageReceiver` 
(`messageId`,`receiverId`,`statusId`,`modifiedAt`) 
VALUES 
('100','witty','2','2013-04-02 00:00:00'),
('100','nicole','1','2013-04-02 00:00:00');

UNLOCK TABLES;


/* insert data into 'CoRequisite' table */
LOCK TABLES `CoRequisite` WRITE;

INSERT INTO `CoRequisite`
(`courseNumber`,`departmentId`,`coRequisiteNumber`,`coRequisiteDeptId`,`isMust`)
VALUES
('230', 'EECE', '251', 'EECE', '0'),
('230', 'EECE', '253', 'EECE', '1'),
('251', 'EECE', '530', 'MATH', '0'),
('251', 'EECE', '534', 'MATH', '0'),
('511', 'CICS', '505', 'CICS', '1'),
('511', 'CICS', '520', 'CICS', '1'),
('520', 'CICS', '505', 'CICS', '1'),
('520', 'CICS', '511', 'CICS', '1');

UNLOCK TABLES;


/* insert data into 'Prerequisite' table */
LOCK TABLES `Prerequisite` WRITE;

INSERT INTO `Prerequisite`
(`courseNumber`,`departmentId`,`preRequisiteNumber`,`preRequisiteDeptId`,`isMust`)
VALUES
('500', 'CICS', '505', 'CICS', '1'),
('500', 'CICS', '511', 'CICS', '1'),
('500', 'CICS', '520', 'CICS', '1');

UNLOCK TABLES;


/* insert data into 'Locale' table */
LOCK TABLES `Locale` WRITE;

INSERT INTO `Locale`
(`id`,`name`)
VALUES
('5', 'chCH'),
('1', 'enUS'),
('2', 'hiIN'),
('3', 'pbIN'),
('4', 'thTH');

UNLOCK TABLES;


/* insert data into 'ResourceDictionary' table */
LOCK TABLES `ResourceDictionary` WRITE;

INSERT INTO `ResourceDictionary`
(`resourceId`,`LocaleId`,`textString`)
VALUES
('1', '1', 'Login'),
('1', '4', 'เข้าใช้งาน'),
('1', '5', '登录'),
('2', '1', 'Forgot Password'),
('2', '4', 'ลืมรหัสผ่าน'),
('2', '5', '忘记密码'),
('3', '1', 'Username'),
('3', '4', 'ชื่อผู้ใช้งาน'),
('3', '5', '用户名'),
('4', '1', 'Password'),
('4', '4', 'รหัสผ่าน'),
('4', '5', '密码'),
('5', '1', 'Invalid Username/Password'),
('5', '4', 'ชื่อผู้ใช้งาน/รหัสผ่าน ไม่ถูกต้อง'),
('5', '5', '用户名/密码错误'),
('6', '1', 'User is already logged in'),
('6', '4', 'คุณได้เข้าสู่ระบบเป็นที่เรียบร้อยแล้ว'),
('6', '5', '用户已登录'),
('7', '1', 'Browse Course'),
('7', '4', 'เลือกวิชาเรียน'),
('7', '5', '课程导航'),
('8', '1', 'Logout'),
('8', '4', 'ออกจากระบบ'),
('8', '5', '退出系统'),
('9', '1', 'Your have been successfully logged out'),
('9', '4', 'คุณได้ออกจากระบบเป็นที่เรียบร้อยแล้ว'),
('9', '5', '你已成功退出系统'),
('10', '1', 'You have been successfully enrolled to the section'),
('10', '4', 'คุณได้ทำการลงทะเบียนเป็นที่เรียบร้อยแล้ว'),
('10', '5', '你已经成功注册该课段'),
('11', '1', 'Password has been sucessfully updated'),
('11', '4', 'รหัสผ่านได้เปลี่ยนเป็นที่เรียบร้อยแล้ว'),
('11', '5', '密码已更改成功'),
('12', '1', 'New passwords dont match'),
('12', '4', 'รหัสผ่านใหม่ไม่ตรงกัน'),
('12', '5', '新密码输入错误'),
('13', '1', 'Old Password doesnt match'),
('13', '4', 'รหัสผ่านเก่าไม่ตรงกัน'),
('13', '5', '旧密码输入错误'),
('14', '1', 'Glossary'),
('14', '4', 'อภิธานศัพท์'),
('14', '5', '词汇表'),
('15', '1', 'User Profile'),
('15', '4', 'ข้อมูลส่วนตัวผู้ใช้'),
('15', '5', '用户资料'),
('16', '1', 'FAQ'),
('16', '4', 'คำถามที่พบบ่อย'),
('16', '5', 'FAQ'),
('17', '1', 'Manage Course'),
('17', '4', 'จัดการวิชาเรียน'),
('18', '1', 'View Timetable'),
('18', '4', 'ดูตารางเรียน'),
('19', '1', 'View Enrolment'),
('19', '4', 'ดูการลงทะเบียน'),
('20', '1', 'View Degree Info'),
('20', '4', 'ดูข้อมูลปริญญา'),
('21', '1', 'Personal Info'),
('21', '4', 'ข้อมูลส่วนตัวผู้ใช้'),
('22', '1', 'Messages'),
('22', '4', 'ข้อความ'),
('23', '1', 'Student'),
('23', '4', 'นักเรียน'),
('24', '1', 'Home'),
('24', '4', 'หน้าแรก'),
('25', '1', 'Search'),
('25', '4', 'ค้นหา'),
('26', '1', 'Go'),
('26', '4', 'ไปยัง'),
('27', '1', 'Exit'),
('27', '4', 'ออกจาก'),
('28', '1', 'File'),
('28', '4', 'ไฟล์'),
('29', '1', 'Help'),
('29', '4', 'ช่วยเหลือ'),
('30', '1', 'Close'),
('30', '4', 'ปิด'),
('31', '1', 'About'),
('31', '4', 'เกี่ยวกับ');

UNLOCK TABLES;

/* insert data into 'ProgramCourseList' table */
LOCK TABLES `ProgramCourseList` WRITE;

INSERT INTO `ProgramCourseList` (`programName`, `programDepartmentId`, `courseNumber`, `courseDepartmentId`) 
VALUES 
('Master of Software Systems', 'CICS', '500', 'CICS'),
('Master of Software Systems', 'CICS', '505', 'CICS'),
('Master of Software Systems', 'CICS', '511', 'CICS'),
('Master of Software Systems', 'CICS', '520', 'CICS');

UNLOCK TABLES;

/* insert data into '' table 
LOCK TABLES `` WRITE;


UNLOCK TABLES;
*/




