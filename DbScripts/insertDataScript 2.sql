
/* insert data into 'Term' table */
LOCK TABLES `Term` WRITE;

INSERT INTO `Term` 
(`termYear`, `sessionId`) 
VALUES 
('2013', '100'),('2013', '101'),('2013', '102');

UNLOCK TABLES;


/* insert data into 'Section' table */
LOCK TABLES `Section` WRITE;

INSERT INTO `Section` 
(`sectionId`, `sectionTypeId`, `courseNumber`, `departmentId`, `termYear`, `sessionId`, `startDate`, `endDate`, `registerDeadline`, `dropDeadline`, `totalSeats`, `facultyMemberId`, `teachingAssistant`) 
VALUES 
('01', '100', '505', 'CICS', '2013', '101', '2013-01-01', '2013-04-30', '2013-01-10', '2013-01-20', '20', '101', 'Iliya'),
('01', '102', '505', 'CICS', '2013', '101', '2013-01-01', '2013-04-30', '2013-01-10', '2013-01-20', '20', '101', 'Iliya'),
('01', '100', '520', 'CICS', '2013', '101', '2013-01-01', '2013-04-30', '2013-01-10', '2013-01-20', '20', '100', 'Hootan'),
('01', '100', '511', 'CICS', '2013', '101', '2013-01-01', '2013-02-28', '2013-01-10', '2013-01-20', '20', '102', 'Bader'),

('01', '100', '514', 'CICS', '2013', '102', '2013-05-01', '2013-08-31', '2013-05-10', '2013-05-20', '20', '103', 'Iliya'),
('01', '100', '516', 'CICS', '2013', '102', '2013-05-01', '2013-08-31', '2013-05-10', '2013-05-20', '20', '104', 'Hootan'),
('01', '100', '518', 'CICS', '2013', '102', '2013-05-01', '2013-08-31', '2013-05-10', '2013-05-20', '20', '105', 'Iliya'),
('01', '100', '525', 'CICS', '2013', '102', '2013-05-01', '2013-08-31', '2013-05-10', '2013-05-20', '20', '106', 'Hootan'),

('02', '100', '514', 'CICS', '2013', '102', '2013-05-01', '2013-08-31', '2013-05-10', '2013-05-20', '20', '107', 'Iliya'),
('02', '100', '516', 'CICS', '2013', '102', '2013-05-01', '2013-08-31', '2013-05-10', '2013-05-20', '20', '106', 'Hootan'),
('02', '100', '518', 'CICS', '2013', '102', '2013-05-01', '2013-08-31', '2013-05-10', '2013-05-20', '20', '108', 'Iliya'),
('02', '100', '525', 'CICS', '2013', '102', '2013-05-01', '2013-08-31', '2013-05-10', '2013-05-20', '20', '109', 'Hootan');

UNLOCK TABLES;


/* insert data into 'SectionTimeTable' table */
LOCK TABLES `SectionTimeTable` WRITE;

INSERT INTO `SectionTimeTable` 
(`sectionId`, `courseNumber`, `departmentId`, `termYear`, `sessionId`, `sectionTypeId`, `dayId`, `startTime`, `lengthInMinutes`) 
VALUES 
('01', '505', 'CICS', '2013', '101', '100', '100', '10:00', '120'),
('01', '505', 'CICS', '2013', '101', '100', '104', '14:00', '120'),
('01', '505', 'CICS', '2013', '101', '102', '101', '14:00', '90'),
('01', '505', 'CICS', '2013', '101', '102', '103', '14:00', '90'),
('01', '520', 'CICS', '2013', '101', '100', '101', '10:00', '90'),
('01', '520', 'CICS', '2013', '101', '100', '103', '10:00', '90'),
('01', '511', 'CICS', '2013', '101', '100', '100', '16:00', '90'),
('01', '511', 'CICS', '2013', '101', '100', '103', '16:00', '90'),

('01', '514', 'CICS', '2013', '102', '100', '100', '12:00', '120'),
('01', '514', 'CICS', '2013', '102', '100', '102', '14:00', '120'),
('01', '516', 'CICS', '2013', '102', '100', '101', '16:00', '120'),
('01', '516', 'CICS', '2013', '102', '100', '103', '16:00', '120'),
('01', '518', 'CICS', '2013', '102', '100', '104', '10:00', '120'),
('01', '518', 'CICS', '2013', '102', '100', '102', '12:00', '120'),
('01', '525', 'CICS', '2013', '102', '100', '100', '16:00', '120'),
('01', '525', 'CICS', '2013', '102', '100', '102', '16:00', '120'),

('02', '514', 'CICS', '2013', '102', '100', '104', '10:00', '120'),
('02', '514', 'CICS', '2013', '102', '100', '103', '13:00', '120'),
('02', '516', 'CICS', '2013', '102', '100', '104', '14:00', '120'),
('02', '516', 'CICS', '2013', '102', '100', '102', '15:00', '120'),
('02', '518', 'CICS', '2013', '102', '100', '104', '12:00', '120'),
('02', '518', 'CICS', '2013', '102', '100', '100', '14:00', '120'),
('02', '525', 'CICS', '2013', '102', '100', '101', '10:00', '120'),
('02', '525', 'CICS', '2013', '102', '100', '103', '10:00', '120');

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
('100', '01', '511', 'CICS', '2013', '101', '100'),

('101', '01', '505', 'CICS', '2013', '101', '100'),
('101', '01', '505', 'CICS', '2013', '101', '102'),
('101', '01', '520', 'CICS', '2013', '101', '100'),
('101', '01', '511', 'CICS', '2013', '101', '100'),

('102', '01', '505', 'CICS', '2013', '101', '100'),
('102', '01', '505', 'CICS', '2013', '101', '102'),
('102', '01', '520', 'CICS', '2013', '101', '100'),
('102', '01', '511', 'CICS', '2013', '101', '100'),

('103', '01', '505', 'CICS', '2013', '101', '100'),
('103', '01', '505', 'CICS', '2013', '101', '102'),
('103', '01', '520', 'CICS', '2013', '101', '100'),
('103', '01', '511', 'CICS', '2013', '101', '100'),

('104', '01', '505', 'CICS', '2013', '101', '100'),
('104', '01', '505', 'CICS', '2013', '101', '102'),
('104', '01', '520', 'CICS', '2013', '101', '100'),
('104', '01', '511', 'CICS', '2013', '101', '100'),

('105', '01', '505', 'CICS', '2013', '101', '100'),
('105', '01', '505', 'CICS', '2013', '101', '102'),
('105', '01', '520', 'CICS', '2013', '101', '100'),
('105', '01', '511', 'CICS', '2013', '101', '100'),

('106', '01', '505', 'CICS', '2013', '101', '100'),
('106', '01', '505', 'CICS', '2013', '101', '102'),
('106', '01', '520', 'CICS', '2013', '101', '100'),
('106', '01', '511', 'CICS', '2013', '101', '100'),

('107', '01', '505', 'CICS', '2013', '101', '100'),
('107', '01', '505', 'CICS', '2013', '101', '102'),
('107', '01', '520', 'CICS', '2013', '101', '100'),
('107', '01', '511', 'CICS', '2013', '101', '100'),

('108', '01', '505', 'CICS', '2013', '101', '100'),
('108', '01', '505', 'CICS', '2013', '101', '102'),
('108', '01', '520', 'CICS', '2013', '101', '100'),
('108', '01', '511', 'CICS', '2013', '101', '100');

UNLOCK TABLES;


/* insert data into 'Registration' table */ 
LOCK TABLES `Registration` WRITE;

INSERT INTO `Registration` 
(`studentId`, `programName`, `departmentId`, `startDate`, `graduationDate`) 
VALUES 
('100', 'Master of Software Systems', 'CICS', '2013-01-01', '2014-04-30'),
('101', 'Master of Software Systems', 'CICS', '2013-01-01', '2014-04-30'),
('102', 'Master of Software Systems', 'CICS', '2013-01-01', '2014-04-30'),
('103', 'Master of Software Systems', 'CICS', '2013-01-01', '2014-04-30'),
('104', 'Master of Software Systems', 'CICS', '2013-01-01', '2014-04-30'),
('105', 'Master of Software Systems', 'CICS', '2013-01-01', '2014-04-30'),
('106', 'Master of Software Systems', 'CICS', '2013-01-01', '2014-04-30'),
('107', 'Master of Software Systems', 'CICS', '2013-01-01', '2014-04-30'),
('108', 'Master of Software Systems', 'CICS', '2013-01-01', '2014-04-30');

UNLOCK TABLES;


/* insert data into 'MessageStatus' table */
LOCK TABLES `MessageStatus` WRITE;

INSERT INTO `MessageStatus` 
(`statusId`, `name`) 
VALUES 
('1', 'Read'),
('2', 'Unread'),
('3', 'Delete');

UNLOCK TABLES;


/* insert data into 'Message' table */
LOCK TABLES `Message` WRITE;

INSERT INTO `Message` 
(`subject`,`messageBody`,`senderId`,`dateTime`) 
VALUES 
('Welcome to RED','Welcome to become a  member in RED. If you have any questions, please first browse  FAQ and Glossary.','admin','2013-04-02 00:00:00');

UNLOCK TABLES;


/* insert data into 'MessageReceiver' table */
LOCK TABLES `MessageReceiver` WRITE;

INSERT INTO `MessageReceiver` 
(`messageId`,`receiverId`,`statusId`,`modifiedAt`) 
VALUES 
('100','admin','2','2013-04-20 00:00:00'),
('100','bahman','2','2013-04-20 00:00:00'),
('100','harsimran','2','2013-04-20 00:00:00'),
('100','jaspreet','2','2013-04-20 00:00:00'),
('100','nicole','2','2013-04-20 00:00:00'),
('100','mengmeng','2','2013-04-20 00:00:00'),
('100','witty','2','2013-04-20 00:00:00'),
('100','jeffrey','2','2013-04-20 00:00:00'),
('100','nathan','2','2013-04-20 00:00:00'),
('100','bob','2','2013-04-20 00:00:00'),
('100','george','2','2013-04-20 00:00:00'),
('100','ardeshir','2','2013-04-20 00:00:00');

UNLOCK TABLES;


/* insert data into 'CoRequisite' table */
LOCK TABLES `CoRequisite` WRITE;

INSERT INTO `CoRequisite`
(`courseNumber`,`departmentId`,`coRequisiteNumber`,`coRequisiteDeptId`,`isMust`)
VALUES
('505', 'CICS', '511', 'CICS', '1'),
('505', 'CICS', '520', 'CICS', '1'),
('511', 'CICS', '520', 'CICS', '1'),
('511', 'CICS', '505', 'CICS', '1'),
('520', 'CICS', '505', 'CICS', '1'),
('520', 'CICS', '511', 'CICS', '1'),
('514', 'CICS', '516', 'CICS', '1'),
('514', 'CICS', '518', 'CICS', '1'),
('514', 'CICS', '525', 'CICS', '1'),
('516', 'CICS', '514', 'CICS', '1'),
('516', 'CICS', '518', 'CICS', '1'),
('516', 'CICS', '525', 'CICS', '1'),
('518', 'CICS', '514', 'CICS', '1'),
('518', 'CICS', '516', 'CICS', '1'),
('518', 'CICS', '525', 'CICS', '1'),
('525', 'CICS', '514', 'CICS', '1'),
('525', 'CICS', '516', 'CICS', '1'),
('525', 'CICS', '518', 'CICS', '1');

UNLOCK TABLES;


/* insert data into 'Prerequisite' table */
LOCK TABLES `Prerequisite` WRITE;

INSERT INTO `Prerequisite`
(`courseNumber`,`departmentId`,`preRequisiteNumber`,`preRequisiteDeptId`,`isMust`)
VALUES
('514', 'CICS', '505', 'CICS', '1'),
('514', 'CICS', '511', 'CICS', '1'),
('514', 'CICS', '520', 'CICS', '1'),
('516', 'CICS', '505', 'CICS', '1'),
('516', 'CICS', '511', 'CICS', '1'),
('516', 'CICS', '520', 'CICS', '1'),
('518', 'CICS', '505', 'CICS', '1'),
('518', 'CICS', '511', 'CICS', '1'),
('518', 'CICS', '520', 'CICS', '1'),
('525', 'CICS', '505', 'CICS', '1'),
('525', 'CICS', '511', 'CICS', '1'),
('525', 'CICS', '520', 'CICS', '1'),
('500', 'CICS', '514', 'CICS', '1'),
('500', 'CICS', '516', 'CICS', '1'),
('500', 'CICS', '518', 'CICS', '1'),
('500', 'CICS', '525', 'CICS', '1'),
('530', 'CICS', '500', 'CICS', '1');

UNLOCK TABLES;


/* insert data into 'ProgramCourseList' table */
LOCK TABLES `ProgramCourseList` WRITE;

INSERT INTO `ProgramCourseList` (`programName`, `programDepartmentId`, `courseNumber`, `courseDepartmentId`) 
VALUES 
('Master of Software Systems', 'CICS', '505', 'CICS'),
('Master of Software Systems', 'CICS', '511', 'CICS'),
('Master of Software Systems', 'CICS', '520', 'CICS'),
('Master of Software Systems', 'CICS', '514', 'CICS'),
('Master of Software Systems', 'CICS', '516', 'CICS'),
('Master of Software Systems', 'CICS', '518', 'CICS'),
('Master of Software Systems', 'CICS', '525', 'CICS'),
('Master of Software Systems', 'CICS', '500', 'CICS'),
('Master of Software Systems', 'CICS', '530', 'CICS');

UNLOCK TABLES;



/* Separate script for glossary*/
/* Separate script for FAQ*/
