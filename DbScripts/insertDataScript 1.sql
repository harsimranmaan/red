/* Do Not modify */

USE `Adg`;

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
VALUES ('Fall'),('Winter'),('Summer');

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
('Main Mall', 'UBC1', 'Vancouver', 'BC', 'V1201Z', 'Canada');

UNLOCK TABLES;


/* insert data into 'User' table */
LOCK TABLES `User` WRITE;

INSERT INTO `User` 
(`username`, `password`, `firstName`, `lastName`, `userTypeId`, `addressId`, `phoneNumber`, `email`, `dateOfBirth`) 
VALUES 
('admin', '4aaaf3c285f100eb4c3bf3318694b035bcec79c5', 'Harsimran', 'Maan', '102', '100', '45678', 'adgredinfo@gmail.com',null);

UNLOCK TABLES;


/* insert data into 'Faculty' table */
LOCK TABLES `Faculty` WRITE;

INSERT INTO `Faculty` (`name`, `phone`, `website`) 
VALUES 
('Faculty of Engineering', '12345', 'www.foengg.com'),
('Faculty of Medical Sciences', '23456', 'www.foms.com');

UNLOCK TABLES;


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


/* insert data into 'Administrator' table */
LOCK TABLES `Administrator` WRITE;

INSERT INTO `Administrator` 
(`username`, `dateOfJoining`, `hiringFacultyId`) 
VALUES 
('admin', '2012-01-01', '100');
UNLOCK TABLES;


/* insert data into 'Program' table */
LOCK TABLES `Program` WRITE;

INSERT INTO `Program` 
(`programName`, `departmentId`, `creditsRequired`) 
VALUES 
('Master of Software Systems', 'CICS', '24' ),
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

/* Now Upload courses.csv via mysql workbench */