/* Do Not modify */

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
('102', 'Admin'),('101', 'Faculty'),('100', 'Student');

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
/*
INSERT INTO `Department` 
(`departmentId`, `name`, `addressId`, `facultyId`, `phone`, `email`, `website`) 
VALUES 
('CICS', 'Computing, Information and Cognitive Systems', '108', '100', '98373', 'gradsec@mss.icics.ubc.ca', 'www.icics.ubc.ca'),
('EECE', 'Electrical and Computer Engineering', '109', '100', '78234', 'esec@ece.ubc.ca', 'www.ece.ubc.ca'),
('EMER', 'Emergency Medicine', '110', '101', '43287', 'emer@ubc.ca', 'www.emer.ubc.ca');
*/
INSERT INTO `Department` 
(`departmentId`, `name`, `addressId`, `facultyId`, `phone`, `email`, `website`) 
VALUES
('ARCS', 'Alternative Routes to Computing', '108', '100', '98308', 'arcs@ubc.ca', 'www.arcs.ubc.ca'),
('ANAT', 'Anatomy', '109', '101', '98309', 'anat@ubc.ca', 'www.anat.ubc.ca'),
('BIOF', 'Bioinformatics', '110', '100', '98310', 'biof@ubc.ca', 'www.biof.ubc.ca'),
('BIOC', 'Biochemistry', '111', '101', '98311', 'bioc@ubc.ca', 'www.bioc.ubc.ca'),
('CICS', 'Computing Information and Cognitive Systems', '112', '100', '98312', 'gradsec@mss.icics.ubc.ca', 'www.icics.ubc.ca'),
('CELL', 'Cell and Developmental Biology', '113', '101', '98313', 'cell@ubc.ca', 'www.cell.ubc.ca'),
('DMED', 'Digital Media', '114', '100', '98314', 'dmed@ubc.ca', 'www.dmed.ubc.ca'),
('DERM', 'Clinical Dermatology', '115', '101', '98315', 'derm@ubc.ca', 'www.derm.ubc.ca'),
('EECE', 'Electrical and Computer Engineering', '116', '100', '78216', 'esec@ece.ubc.ca', 'www.ece.ubc.ca'),
('EMER', 'Emergency Medicine', '117', '101', '43217', 'emer@ubc.ca', 'www.emer.ubc.ca'),
('FEBC', 'Forest Engineering British Columbia', '118', '100', '98318', 'febc@ubc.ca', 'www.febc.ubc.ca'),
('FMED', 'Foundations of Medicine', '119', '101', '98319', 'fmed@ubc.ca', 'www.fmed.ubc.ca'),
('GSAT', 'Genome Science and Technology', '120', '100', '98320', 'gsat@ubc.ca', 'www.gsat.ubc.ca'),
('HXPH', 'Herstmonceux Physics', '121', '100', '98321', 'hxph@ubc.ca', 'www.hxph.ubc.ca'),
('HUNU', 'Human Nutrition', '122', '101', '98322', 'hunu@ubc.ca', 'www.hunu.ubc.ca'),
('INDS', 'Interdisciplinary Studies', '123', '100', '98323', 'inds@ubc.ca', 'www.inds.ubc.ca'),
('ISCI', 'Integrated Sciences', '124', '101', '98324', 'isci@ubc.ca', 'www.isci.ubc.ca'),
('JAPN', 'Japanese', '125', '100', '98325', 'japn@ubc.ca', 'www.japn.ubc.ca'),
('JRNL', 'Journalism', '126', '101', '98326', 'jrnl@ubc.ca', 'www.jrnl.ubc.ca'),
('KORN', 'Korean', '127', '100', '98327', 'korn@ubc.ca', 'www.korn.ubc.ca'),
('KNSL', 'Kinesiology', '128', '101', '98328', 'knsl@ubc.ca', 'www.knsl.ubc.ca'),
('LLED', 'Language and Literacy Education', '129', '100', '98329', 'lled@ubc.ca', 'www.lled.ubc.ca'),
('LAFS', 'Land & Food Systems', '130', '101', '98330', 'lafs@ubc.ca', 'www.lafs.ubc.ca'),
('MATH', 'Mathematics', '131', '100', '98331', 'math@ubc.ca', 'www.math.ubc.ca'),
('MEDG', 'Medical Genetics', '132', '101', '98332', 'medg@ubc.ca', 'www.medg.ubc.ca'),
('NRSC', 'Neuroscience', '133', '101', '98333', 'nrsc@ubc.ca', 'www.nrsc.ubc.ca'),
('NURS', 'Nursing', '134', '101', '98334', 'nurs@ubc.ca', 'www.nurs.ubc.ca'),
('ONCO', 'Oncology', '135', '100', '98335', 'onco@ubc.ca', 'www.onco.ubc.ca'),
('OPTH', 'Ophthalmology', '136', '101', '98336', 'opth@ubc.ca', 'www.opth.ubc.ca'),
('PAED', 'Paediatrics', '137', '101', '98337', 'paed@ubc.ca', 'www.paed.ubc.ca'),
('PLNT', 'Plant Science', '138', '100', '98338', 'plnt@ubc.ca', 'www.plnt.ubc.ca'),
('RMES', 'Resource Management and Environmental Studies', '139', '100', '98339', 'rmes@ubc.ca', 'www.rmes.ubc.ca'),
('RADI', 'Radiology', '140', '101', '98340', 'radi@ubc.ca', 'www.radi.ubc.ca'),
('SATS', 'Science and Technology Studies', '141', '100', '98341', 'sats@ubc.ca', 'www.sats.ubc.ca'),
('SURG', 'Surgery', '142', '101', '98342', 'surg@ubc.ca', 'www.surg.ubc.ca'),
('TECS', 'Teacher Librarianship', '143', '100', '98343', 'tecs@ubc.ca', 'www.tecs.ubc.ca'),
('TIBT', 'Tibetan Languages', '144', '101', '98344', 'tibt@ubc.ca', 'www.tibt.ubc.ca'),
('UROL', 'Urological Surgery', '145', '100', '98345', 'urol@ubc.ca', 'www.urol.ubc.ca'),
('URBN', 'Urban Studies', '146', '101', '98346', 'urbn@ubc.ca', 'www.urbn.ubc.ca'),
('VRHS', 'Vocational Rehabilitation Counselling', '147', '100', '98347', 'vrhs@ubc.ca', 'www.vrhs.ubc.ca'),
('VISA', 'Visual Arts', '148', '101', '98348', 'visa@ubc.ca', 'www.visa.ubc.ca'),
('WRIT', 'University Writing Centre Courses', '149', '100', '98349', 'writ@ubc.ca', 'www.writ.ubc.ca'),
('WOOD', 'Wood Products Processing', '150', '101', '98350', 'wood@ubc.ca', 'www.wood.ubc.ca'),
('COGS', 'Cognitive Systems Program', '151', '100', '98351', 'cogs@ubc.ca', 'www.cogs.ubc.ca'),
('ZOOL', 'Zoology', '152', '101', '98352', 'zool@ubc.ca', 'www.zool.ubc.ca'),
('CPSC', 'Computer Science', '153', '100', '98353', '@ubc.ca', 'www.cpsc.ubc.ca');

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
('Bachelor of Engineering', 'ARCS', '154', 'bearcs@ubc.ca', '98354'),
('Master of Medicine', 'ANAT', '155', 'mmanat@ubc.ca', '98355'),
('Bachelor of Engineering', 'BIOF', '156', 'bebiof@ubc.ca', '98356'),
('Bachelor of Medicine', 'BIOC', '157', 'bmbioc@ubc.ca', '98357'),
('Bachelor of Engineering', 'CICS', '158', 'becics@ubc.ca', '98358'),
('Master of Software Systems', 'CICS', '159', 'msscics@ubc.ca', '98359'),
('Bachelor of Engineering', 'EECE', '163', 'beeece@ubc.ca', '98363'),
('Master of Medicine', 'CELL', '160', 'mmcell@ubc.ca', '98360'),
('Bachelor of Engineering', 'DMED', '161', 'bedmed@ubc.ca', '98361'),
('Bachelor of Medicine', 'DERM', '162', 'bmderm@ubc.ca', '98362'),
('Bachelor of Medicine', 'EMER', '164', 'bmemer@ubc.ca', '98364'),
('Bachelor of Engineering', 'FEBC', '165', 'befebc@ubc.ca', '98365'),
('Master of Medicine', 'FMED', '166', 'bmfmed@ubc.ca', '98366'),
('Bachelor of Engineering', 'GSAT', '167', 'begsat@ubc.ca', '98367'),
('Bachelor of Engineering', 'HXPH', '168', 'behxph@ubc.ca', '98368'),
('Bachelor of Medicine', 'HUNU', '169', 'bmhunu@ubc.ca', '98369'),
('Bachelor of Engineering', 'INDS', '170', 'beinds@ubc.ca', '98370'),
('Master of Medicine', 'ISCI', '171', 'bmisci@ubc.ca', '98371'),
('Bachelor of Engineering', 'JAPN', '172', 'bejapn@ubc.ca', '98372'),
('Bachelor of Medicine', 'JRNL', '173', 'bmjrnl@ubc.ca', '98373'),
('Bachelor of Engineering', 'KORN', '174', 'bekorn@ubc.ca', '98374'),
('Bachelor of Medicine', 'KNSL', '175', 'bmknsl@ubc.ca', '98375');

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
('230', 'EECE', 'Selected Topics in Biomedical Engineering', 'Description of Selected Topics in Biomedical Engineering', '3', '2', 'Pass'),
('251', 'EECE', 'Circuit Analysis I', 'Description of Circuit Analysis I', '3', '2', 'Pass'),
('253', 'EECE', 'Circuit Analysis II', 'Description of Circuit Analysis II', '6', '2', 'Pass'),
('259', 'EECE', 'Introduction to Microcomputers', 'Description of Introduction to Microcomputers', '3', '2', 'Pass'),
('500', 'CICS', 'Software Systems Internship', 'Description of Software Systems Internship', '3', '2', 'Pass'),
('505', 'CICS', 'Introduction to Software Systems', 'Description of  Introduction to Software Systems', '6', '3', '68 percent'),
('511', 'CICS', 'Computational Structures', 'Description of  Computational Structures', '2', '3', '68 percent'),
('520', 'CICS', 'Database Systems', 'Description of Database Systems', '3', '3', '68 percent'),
('530', 'CICS', 'Advanced Software Engineering Project', 'Description of Advanced Software Engineering Project', '3', '2', 'Pass'),
('534', 'ARCS', 'ARCS Level 1', 'Description of ARCS Level 1', '3', '1', 'B Grade'),
('536', 'ARCS', 'ARCS Level 2', 'Description of ARCS Level 2', '3', '2', 'Pass'),
('538', 'ARCS', 'ARCS Level 3', 'Description of ARCS Level 3', '6', '3', 'Percent'),
('540', 'ARCS', 'ARCS Level 4', 'Description of ARCS Level 4', '3', '2', 'Pass'),
('542', 'ARCS', 'ARCS Level 5', 'Description of ARCS Level 5', '3', '2', 'Pass'),
('544', 'ARCS', 'ARCS Level 6', 'Description of ARCS Level 6', '6', '3', '68 percent'),
('546', 'ANAT', 'ANAT Level 1', 'Description of ANAT Level 1', '2', '1', 'B Grade'),
('548', 'ANAT', 'ANAT Level 2', 'Description of ANAT Level 2', '3', '3', '68 percent'),
('550', 'ANAT', 'ANAT Level 3', 'Description of ANAT Level 3', '3', '2', 'Pass'),
('552', 'ANAT', 'ANAT Level 4', 'Description of ANAT Level 4', '3', '1', 'B Grade'),
('554', 'BIOF', 'BIOF Level 1', 'Description of BIOF Level 1', '3', '2', 'Pass'),
('556', 'BIOF', 'BIOF Level 2', 'Description of BIOF Level 2', '6', '3', 'Percent'),
('558', 'BIOF', 'BIOF Level 3', 'Description of BIOF Level 3', '3', '2', 'Pass'),
('560', 'BIOF', 'BIOF Level 4', 'Description of BIOF Level 4', '3', '2', 'Pass'),
('562', 'BIOC', 'BIOC Level 1', 'Description of BIOC Level 1', '6', '3', '68 percent'),
('564', 'BIOC', 'BIOC Level 2', 'Description of BIOC Level 2', '2', '1', 'B Grade'),
('566', 'BIOC', 'BIOC Level 3', 'Description of BIOC Level 3', '3', '3', '68 percent'),
('568', 'BIOC', 'BIOC Level 4', 'Description of BIOC Level 4', '3', '2', 'Pass'),
('570', 'CELL', 'CELL Level 1', 'Description of CELL Level 1', '3', '1', 'B Grade'),
('572', 'CELL', 'CELL Level 2', 'Description of CELL Level 2', '3', '2', 'Pass'),
('574', 'CELL', 'CELL Level 3', 'Description of CELL Level 3', '6', '3', 'Percent'),
('576', 'CELL', 'CELL Level 4', 'Description of CELL Level 4', '3', '2', 'Pass'),
('578', 'DMED', 'DMED Level 1', 'Description of DMED Level 1', '3', '2', 'Pass'),
('580', 'DMED', 'DMED Level 2', 'Description of DMED Level 2', '6', '3', '68 percent'),
('582', 'DMED', 'DMED Level 3', 'Description of DMED Level 3', '2', '1', 'B Grade'),
('584', 'DMED', 'DMED Level 4', 'Description of DMED Level 4', '3', '3', '68 percent'),
('586', 'DERM', 'DERM Level 1', 'Description of DERM Level 1', '3', '2', 'Pass'),
('588', 'DERM', 'DERM Level 2', 'Description of DERM Level 2', '3', '1', 'B Grade'),
('590', 'DERM', 'DERM Level 3', 'Description of DERM Level 3', '3', '2', 'Pass'),
('592', 'DERM', 'DERM Level 4', 'Description of DERM Level 4', '6', '3', 'Percent'),
('594', 'EMER', 'Emergency Medicine Level 1', 'Description of Emergency Medicine Level 1', '3', '2', 'Pass'),
('596', 'EMER', 'Emergency Medicine Level 2', 'Description of Emergency Medicine Level 2', '3', '2', 'Pass'),
('598', 'EMER', 'Emergency Medicine Level 3', 'Description of Emergency Medicine Level 3', '6', '3', '68 percent'),
('600', 'EMER', 'Emergency Medicine Level 4', 'Description of Emergency Medicine Level 4', '2', '1', 'B Grade'),
('530', 'FEBC', 'FEBC Level 1', 'Description of FEBC Level 1', '3', '3', '68 percent'),
('532', 'FEBC', 'FEBC Level 2', 'Description of FEBC Level 2', '3', '2', 'Pass'),
('534', 'FEBC', 'FEBC Level 3', 'Description of FEBC Level 3', '3', '1', 'B Grade'),
('536', 'FEBC', 'FEBC Level 4', 'Description of FEBC Level 4', '3', '2', 'Pass'),
('538', 'FMED', 'FMED Level 1', 'Description of FMED Level 1', '6', '3', 'Percent'),
('540', 'FMED', 'FMED Level 2', 'Description of FMED Level 2', '3', '2', 'Pass'),
('542', 'FMED', 'FMED Level 3', 'Description of FMED Level 3', '3', '2', 'Pass'),
('544', 'FMED', 'FMED Level 4', 'Description of FMED Level 4', '6', '3', '68 percent'),
('546', 'GSAT', 'GSAT Level 1', 'Description of GSAT Level 1', '2', '1', 'B Grade'),
('548', 'GSAT', 'GSAT Level 2', 'Description of GSAT Level 2', '3', '3', '68 percent'),
('550', 'GSAT', 'GSAT Level 3', 'Description of GSAT Level 3', '3', '2', 'Pass'),
('552', 'GSAT', 'GSAT Level 4', 'Description of GSAT Level 4', '3', '1', 'B Grade'),
('554', 'HXPH', 'HXPH Level 1', 'Description of HXPH Level 1', '3', '2', 'Pass'),
('556', 'HXPH', 'HXPH Level 2', 'Description of HXPH Level 2', '6', '3', 'Percent'),
('558', 'HXPH', 'HXPH Level 3', 'Description of HXPH Level 3', '3', '2', 'Pass'),
('560', 'HXPH', 'HXPH Level 4', 'Description of HXPH Level 4', '3', '2', 'Pass'),
('562', 'HUNU', 'HUNU Level 1', 'Description of HUNU Level 1', '6', '3', '68 percent'),
('564', 'HUNU', 'HUNU Level 2', 'Description of HUNU Level 2', '2', '1', 'B Grade'),
('566', 'HUNU', 'HUNU Level 3', 'Description of HUNU Level 3', '3', '3', '68 percent'),
('568', 'HUNU', 'HUNU Level 4', 'Description of HUNU Level 4', '3', '2', 'Pass'),
('570', 'INDS', 'INDS Level 1', 'Description of INDS Level 1', '3', '1', 'B Grade'),
('572', 'INDS', 'INDS Level 2', 'Description of INDS Level 2', '3', '2', 'Pass'),
('574', 'INDS', 'INDS Level 3', 'Description of INDS Level 3', '6', '3', 'Percent'),
('576', 'ISCI', 'ISCI Level 1', 'Description of ISCI Level 1', '3', '2', 'Pass'),
('578', 'ISCI', 'ISCI Level 2', 'Description of ISCI Level 2', '3', '2', 'Pass'),
('580', 'ISCI', 'ISCI Level 3', 'Description of ISCI Level 3', '6', '3', '68 percent'),
('582', 'ISCI', 'ISCI Level 4', 'Description of ISCI Level 4', '2', '1', 'B Grade'),
('584', 'JAPN', 'JAPN Level 1', 'Description of JAPN Level 1', '3', '3', '68 percent'),
('586', 'JRNL', 'JRNL Level 1', 'Description of JRNL Level 1', '3', '2', 'Pass'),
('588', 'KORN', 'KORN Level 1', 'Description of KORN Level 1', '3', '1', 'B Grade'),
('590', 'KNSL', 'KNSL Level 1', 'Description of KNSL Level 1', '3', '2', 'Pass'),
('592', 'LLED', 'LLED Level 1', 'Description of LLED Level 1', '6', '3', 'Percent'),
('594', 'LAFS', 'LAFS Level 1', 'Description of LAFS Level 1', '3', '2', 'Pass'),
('596', 'MATH', 'MATH Level 1', 'Description of MATH Level 1', '3', '2', 'Pass'),
('598', 'MATH', 'MATH Level 2', 'Description of MATH Level 2', '6', '3', '68 percent'),
('600', 'MATH', 'MATH Level 3', 'Description of MATH Level 3', '2', '1', 'B Grade'),
('530', 'MATH', 'MATH Level 4', 'Description of MATH Level 4', '3', '3', '68 percent'),
('532', 'MATH', 'MATH Level 5', 'Description of MATH Level 5', '3', '2', 'Pass'),
('534', 'MATH', 'MATH Level 6', 'Description of MATH Level 6', '3', '1', 'B Grade'),
('536', 'MATH', 'MATH Level 7', 'Description of MATH Level 7', '3', '2', 'Pass'),
('538', 'MATH', 'MATH Level 8', 'Description of MATH Level 8', '6', '3', 'Percent'),
('540', 'MEDG', 'MEDG Level 1', 'Description of MEDG Level 1', '3', '2', 'Pass'),
('542', 'MEDG', 'MEDG Level 2', 'Description of MEDG Level 2', '3', '2', 'Pass'),
('544', 'MEDG', 'MEDG Level 3', 'Description of MEDG Level 3', '6', '3', '68 percent'),
('546', 'NRSC', 'NRSC Level 1', 'Description of NRSC Level 1', '2', '1', 'B Grade'),
('548', 'NRSC', 'NRSC Level 2', 'Description of NRSC Level 2', '3', '3', '68 percent'),
('550', 'NRSC', 'NRSC Level 3', 'Description of NRSC Level 3', '3', '2', 'Pass'),
('552', 'NRSC', 'NRSC Level 4', 'Description of NRSC Level 4', '6', '3', '68 percent'),
('554', 'NRSC', 'NRSC Level 5', 'Description of NRSC Level 5', '2', '1', 'B Grade'),
('556', 'NRSC', 'NRSC Level 6', 'Description of NRSC Level 6', '3', '3', '68 percent'),
('558', 'NURS', 'NURS Level 1', 'Description of NURS Level 1', '3', '2', 'Pass'),
('560', 'NURS', 'NURS Level 2', 'Description of NURS Level 2', '3', '1', 'B Grade'),
('562', 'ONCO', 'ONCO Level 1', 'Description of ONCO Level 1', '3', '2', 'Pass'),
('564', 'ONCO', 'ONCO Level 2', 'Description of ONCO Level 2', '6', '3', 'Percent'),
('566', 'ONCO', 'ONCO Level 3', 'Description of ONCO Level 3', '3', '2', 'Pass'),
('568', 'ONCO', 'ONCO Level 4', 'Description of ONCO Level 4', '3', '2', 'Pass'),
('570', 'ONCO', 'ONCO Level 5', 'Description of ONCO Level 5', '6', '3', '68 percent'),
('572', 'OPTH', 'OPTH Level 1', 'Description of OPTH Level 1', '2', '1', 'B Grade'),
('574', 'OPTH', 'OPTH Level 2', 'Description of OPTH Level 2', '3', '3', '68 percent'),
('576', 'OPTH', 'OPTH Level 3', 'Description of OPTH Level 3', '3', '2', 'Pass'),
('578', 'OPTH', 'OPTH Level 4', 'Description of OPTH Level 4', '3', '1', 'B Grade'),
('580', 'PAED', 'PAED Level 1', 'Description of PAED Level 1', '3', '2', 'Pass'),
('582', 'PAED', 'PAED Level 2', 'Description of PAED Level 2', '6', '3', 'Percent'),
('584', 'PAED', 'PAED Level 3', 'Description of PAED Level 3', '3', '2', 'Pass'),
('586', 'PAED', 'PAED Level 4', 'Description of PAED Level 4', '3', '2', 'Pass'),
('588', 'PAED', 'PAED Level 5', 'Description of PAED Level 5', '6', '3', '68 percent'),
('590', 'PLNT', 'PLNT Level 1', 'Description of PLNT Level 1', '2', '1', 'B Grade'),
('592', 'PLNT', 'PLNT Level 2', 'Description of PLNT Level 2', '3', '3', '68 percent'),
('594', 'RMES', 'RMES Level 1', 'Description of RMES Level 1', '3', '2', 'Pass'),
('596', 'RMES', 'RMES Level 2', 'Description of RMES Level 2', '6', '3', '68 percent'),
('598', 'RMES', 'RMES Level 3', 'Description of RMES Level 3', '2', '1', 'B Grade'),
('600', 'RMES', 'RMES Level 4', 'Description of RMES Level 4', '3', '3', '68 percent'),
('530', 'RADI', 'RADI Level 1', 'Description of RADI Level 1', '3', '2', 'Pass'),
('532', 'RADI', 'RADI Level 2', 'Description of RADI Level 2', '3', '1', 'B Grade'),
('534', 'RADI', 'RADI Level 3', 'Description of RADI Level 3', '3', '2', 'Pass'),
('536', 'RADI', 'RADI Level 4', 'Description of RADI Level 4', '6', '3', 'Percent'),
('538', 'SATS', 'SATS Level 1', 'Description of SATS Level 1', '3', '2', 'Pass'),
('540', 'SATS', 'SATS Level 2', 'Description of SATS Level 2', '3', '2', 'Pass'),
('542', 'SATS', 'SATS Level 3', 'Description of SATS Level 3', '6', '3', '68 percent'),
('544', 'SATS', 'SATS Level 4', 'Description of SATS Level 4', '2', '1', 'B Grade'),
('546', 'SATS', 'SATS Level 5', 'Description of SATS Level 5', '3', '3', '68 percent'),
('548', 'SATS', 'SATS Level 6', 'Description of SATS Level 6', '3', '2', 'Pass'),
('550', 'SURG', 'SURG Level 1', 'Description of SURG Level 1', '3', '1', 'B Grade'),
('552', 'SURG', 'SURG Level 2', 'Description of SURG Level 2', '3', '2', 'Pass'),
('554', 'SURG', 'SURG Level 3', 'Description of SURG Level 3', '6', '3', 'Percent'),
('556', 'SURG', 'SURG Level 4', 'Description of SURG Level 4', '3', '2', 'Pass'),
('558', 'SURG', 'SURG Level 5', 'Description of SURG Level 5', '3', '2', 'Pass'),
('560', 'SURG', 'SURG Level 6', 'Description of SURG Level 6', '6', '3', '68 percent'),
('562', 'TECS', 'TECS Level 1', 'Description of TECS Level 1', '2', '1', 'B Grade'),
('564', 'TECS', 'TECS Level 2', 'Description of TECS Level 2', '3', '3', '68 percent'),
('566', 'TIBT', 'TIBT Level 1', 'Description of TIBT Level 1', '3', '2', 'Pass'),
('568', 'UROL', 'UROL Level 1', 'Description of UROL Level 1', '6', '3', '68 percent'),
('570', 'UROL', 'UROL Level 2', 'Description of UROL Level 2', '2', '1', 'B Grade'),
('572', 'UROL', 'UROL Level 3', 'Description of UROL Level 3', '3', '3', '68 percent'),
('574', 'UROL', 'UROL Level 4', 'Description of UROL Level 4', '3', '2', 'Pass'),
('576', 'UROL', 'UROL Level 5', 'Description of UROL Level 5', '3', '1', 'B Grade'),
('578', 'UROL', 'UROL Level 6', 'Description of UROL Level 6', '3', '2', 'Pass'),
('580', 'UROL', 'UROL Level 7', 'Description of UROL Level 7', '6', '3', 'Percent'),
('582', 'URBN', 'URBN Level 1', 'Description of URBN Level 1', '3', '2', 'Pass'),
('584', 'URBN', 'URBN Level 2', 'Description of URBN Level 2', '3', '2', 'Pass'),
('586', 'URBN', 'URBN Level 3', 'Description of URBN Level 3', '6', '3', '68 percent'),
('588', 'URBN', 'URBN Level 4', 'Description of URBN Level 4', '2', '1', 'B Grade'),
('590', 'URBN', 'URBN Level 5', 'Description of URBN Level 5', '3', '3', '68 percent'),
('592', 'VRHS', 'VRHS Level 1', 'Description of VRHS Level 1', '3', '2', 'Pass'),
('594', 'VRHS', 'VRHS Level 2', 'Description of VRHS Level 2', '3', '1', 'B Grade'),
('596', 'VISA', 'VISA Level 1', 'Description of VISA Level 1', '3', '2', 'Pass'),
('598', 'VISA', 'VISA Level 2', 'Description of VISA Level 2', '6', '3', 'Percent'),
('600', 'WRIT', 'WRIT Level 1', 'Description of WRIT Level 1', '3', '2', 'Pass'),
('530', 'WRIT', 'WRIT Level 2', 'Description of WRIT Level 2', '3', '2', 'Pass'),
('532', 'WRIT', 'WRIT Level 3', 'Description of WRIT Level 3', '6', '3', '68 percent'),
('534', 'WOOD', 'WOOD Level 1', 'Description of WOOD Level 1', '2', '1', 'B Grade'),
('536', 'WOOD', 'WOOD Level 2', 'Description of WOOD Level 2', '3', '3', '68 percent'),
('538', 'WOOD', 'WOOD Level 3', 'Description of WOOD Level 3', '3', '2', 'Pass'),
('540', 'WOOD', 'WOOD Level 4', 'Description of WOOD Level 4', '6', '3', '68 percent'),
('542', 'COGS', 'COGS Level 1', 'Description of COGS Level 1', '2', '1', 'B Grade'),
('544', 'COGS', 'COGS Level 2', 'Description of COGS Level 2', '3', '3', '68 percent'),
('546', 'COGS', 'COGS Level 3', 'Description of COGS Level 3', '3', '2', 'Pass'),
('548', 'COGS', 'COGS Level 4', 'Description of COGS Level 4', '3', '1', 'B Grade'),
('550', 'COGS', 'COGS Level 5', 'Description of COGS Level 5', '3', '2', 'Pass'),
('552', 'COGS', 'COGS Level 6', 'Description of COGS Level 6', '6', '3', 'Percent'),
('554', 'COGS', 'COGS Level 7', 'Description of COGS Level 7', '3', '2', 'Pass'),
('556', 'COGS', 'COGS Level 8', 'Description of COGS Level 8', '3', '2', 'Pass'),
('558', 'ZOOL', 'ZOOL Level 1', 'Description of ZOOL Level 1', '6', '3', '68 percent'),
('560', 'ZOOL', 'ZOOL Level 2', 'Description of ZOOL Level 2', '2', '1', 'B Grade'),
('562', 'ZOOL', 'ZOOL Level 3', 'Description of ZOOL Level 3', '3', '3', '68 percent'),
('564', 'ZOOL', 'ZOOL Level 4', 'Description of ZOOL Level 4', '3', '2', 'Pass'),
('566', 'CPSC', 'CPSC Level 1', 'Description of CPSC Level 1', '3', '1', 'B Grade'),
('568', 'CPSC', 'CPSC Level 2', 'Description of CPSC Level 2', '3', '2', 'Pass'),
('570', 'CPSC', 'CPSC Level 3', 'Description of CPSC Level 3', '6', '3', 'Percent'),
('572', 'CPSC', 'CPSC Level 4', 'Description of CPSC Level 4', '3', '2', 'Pass'),
('574', 'CPSC', 'CPSC Level 5', 'Description of CPSC Level 5', '3', '2', 'Pass'),
('576', 'CPSC', 'CPSC Level 6', 'Description of CPSC Level 6', '6', '3', '68 percent'),
('578', 'CPSC', 'CPSC Level 7', 'Description of CPSC Level 7', '2', '1', 'B Grade'),
('580', 'CPSC', 'CPSC Level 8', 'Description of CPSC Level 8', '3', '3', '68 percent'),
('582', 'CPSC', 'CPSC Level 9', 'Description of CPSC Level 9', '3', '2', 'Pass');
UNLOCK TABLES;


/* insert data into '' table
LOCK TABLES `` WRITE;


UNLOCK TABLES;
*/




