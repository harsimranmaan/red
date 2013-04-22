/* Do Not modify */

CREATE DATABASE  IF NOT EXISTS `AdgTest` ;
USE `AdgTest`;

DROP TABLE IF EXISTS `UserType`;
CREATE TABLE `UserType` (
  `userTypeId` INT NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  PRIMARY KEY (`userTypeId`),
  UNIQUE KEY `UserTypeUNIQname` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE UserType AUTO_INCREMENT = 100;

DROP TABLE IF EXISTS `Address`;
CREATE TABLE `Address` (
  `addressId` INT NOT NULL AUTO_INCREMENT,	/* Auto Increment */
  `addressLineFirst` varchar(45) NOT NULL,
  `addressLineSecond` varchar(45) ,
  city varchar(15)  NOT NULL,
  province varchar(16),
  `postalCode` varchar(6) NOT NULL,
  country varchar(25) NOT NULL,	/* added */
  PRIMARY KEY (`addressId`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
  
  ALTER TABLE Address AUTO_INCREMENT = 100; /* AI from 100*/
  
  
DROP TABLE IF EXISTS `Faculty`;
CREATE TABLE `Faculty` (
  `facultyId` INT NOT NULL AUTO_INCREMENT,	/* Auto Increment */
  name VARCHAR(50) NOT NULL,
/* removed addressId and Head */
  `phone` varchar(15) DEFAULT NULL,
  `website` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`facultyId`),
/*  CONSTRAINT `FacultyFKaddressId` FOREIGN KEY (`addressId`) REFERENCES `Address` (`addressId`) ON UPDATE CASCADE ON DELETE RESTRICT,*/
  UNIQUE KEY `FacultyUNIQname` (name),
  CONSTRAINT FacultyCHKfacultyId CHECK (facultyId > 0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE Faculty AUTO_INCREMENT = 100;


DROP TABLE IF EXISTS `Department`;
CREATE TABLE `Department` (
  `departmentId` varchar(4) NOT NULL,
  `name` varchar(100) NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  facultyId INT NOT NULL,
  PRIMARY KEY (`departmentId`),
  CONSTRAINT `DepartmentFKfacultyId` FOREIGN KEY (`facultyId`) REFERENCES `Faculty` (`facultyId`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `username` varchar(15) NOT NULL,
  `password` varchar(40) NOT NULL,
  `firstName` varchar(15) NOT NULL,
  `lastName` varchar(15) NOT NULL,
  `isOnline` bit(1) NOT NULL DEFAULT b'0',
  `userTypeId` INT NOT NULL,
   addressId INT,
  `phoneNumber` varchar(15) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `dateOfBirth` date DEFAULT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`username`),
  CONSTRAINT `UserFKuserTypeId` FOREIGN KEY (`userTypeId`) REFERENCES `UserType` (`userTypeId`) ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT `UserFKaddressId` FOREIGN KEY (`addressId`) REFERENCES `Address` (`addressId`) ON UPDATE CASCADE ON DELETE RESTRICT,
  UNIQUE KEY `UserUNIQemail`  (`email`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `EmailCode`;
CREATE TABLE `EmailCode` (
  `username` varchar(15) NOT NULL,
  `code` VARCHAR(6) NOT NULL ,
   PRIMARY KEY (`username`),
   CONSTRAINT `EmailCodeFKusername` FOREIGN KEY (`username`) REFERENCES `User` (`username`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `Program`;
CREATE  TABLE `Program` (
  `programName` VARCHAR(30) NOT NULL ,
  `departmentId` VARCHAR(4) NOT NULL , 
  `isActive` BIT NOT NULL DEFAULT 1 ,
  `creditsRequired` INT NOT NULL , 
  PRIMARY KEY (`programName`, `departmentId`) ,
  CONSTRAINT `ProgramFKdepartmentId`
    FOREIGN KEY (`departmentId` )
    REFERENCES `Department` (`departmentId` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `Student`;
CREATE TABLE `Student` (
  `studentId` INT NOT NULL AUTO_INCREMENT,	/* Auto Increment */
  `username` varchar(10) NOT NULL,
  `dateOfRegistration` date DEFAULT NULL,
  `highestDegree` varchar(20) DEFAULT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`studentId`),
  UNIQUE KEY `StudentUNIQusername` (`username`),
  CONSTRAINT `StudentFKusername` FOREIGN KEY (`username`) REFERENCES `User` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE Student AUTO_INCREMENT = 100;


DROP TABLE IF EXISTS `Administrator`;
CREATE TABLE `Administrator` (
  `adminId` INT NOT NULL AUTO_INCREMENT,	/* Auto Increment */
  `username` varchar(10) NOT NULL,
  `dateOfJoining` date NOT NULL,
  /**-- `access` varchar(20) NOT NULL,**/
  `hiringFacultyId` INT NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`adminId`),
  UNIQUE KEY `AdministratorUNIQusername` (`username`),
  CONSTRAINT `AdministratorFKusername` FOREIGN KEY (`username`) REFERENCES `User` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `AdministratorFKhiringFacultyId` FOREIGN KEY (`hiringFacultyId`) REFERENCES `Faculty` (`facultyId`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE Administrator AUTO_INCREMENT = 100;


DROP TABLE IF EXISTS `FacultyMember`;
CREATE TABLE `FacultyMember` (
  `facultyMemberId` INT NOT NULL AUTO_INCREMENT,	/* Auto Increment */
  `username` varchar(10) NOT NULL,
  `departmentId` varchar(4) NOT NULL,
  `title` varchar(20) NOT NULL,
  `dateOfJoining` date NOT NULL,
  `highestDegree` varchar(25) DEFAULT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`facultyMemberId`),
  UNIQUE KEY `FacultyMemberUNIQusername` (`username`),
  CONSTRAINT `FacultyMemberFKdepartmentId` FOREIGN KEY (`departmentId`) REFERENCES `Department` (`departmentId`) ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT `FacultyMemberFKusername` FOREIGN KEY (`username`) REFERENCES `User` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE FacultyMember AUTO_INCREMENT = 100;

/*
ALTER TABLE `Faculty`
ADD CONSTRAINT `FacultyFKheadId` 
FOREIGN KEY (`facultyId`) 
REFERENCES `FacultyMember` (`facultyMemberId`) 
ON UPDATE CASCADE ON DELETE RESTRICT;
*/

DROP TABLE IF EXISTS `GradingScheme`;
CREATE TABLE `GradingScheme` (
gradingSchemeId INT NOT NULL AUTO_INCREMENT,
name  varchar(25) NOT NULL,
  PRIMARY KEY (`gradingSchemeId`),
  UNIQUE KEY `GradingSchemeUNIQname` (`name`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE GradingScheme AUTO_INCREMENT = 100;


DROP TABLE IF EXISTS `Course`;
CREATE TABLE `Course` (
  `courseNumber` INT NOT NULL,
  `departmentId` varchar(4) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `credits` INT NOT NULL,
  `gradingSchemeId`INT NOT NULL,
  `passingRequirement` varchar(45) NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`courseNumber`,`departmentId`),
  CONSTRAINT `CourseFKdepartmentId` FOREIGN KEY (`departmentId`) REFERENCES `Department` (`departmentId`) ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT `CourseFKgradingSchemeId` FOREIGN KEY (`gradingSchemeId`) REFERENCES `GradingScheme` (`gradingSchemeId`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `ProgramCourseList`;
CREATE TABLE `ProgramCourseList` (
  `programName` VARCHAR(30) NOT NULL ,
  `programDepartmentId` VARCHAR(4) NOT NULL ,
  `courseNumber` INT NOT NULL,
  `courseDepartmentId` varchar(4) NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
   PRIMARY KEY (`programName`,`programDepartmentId`,`courseNumber`,`courseDepartmentId`),
   CONSTRAINT `ProgramCourseListFKprogramTable` FOREIGN KEY (`programName`,`programDepartmentId`) REFERENCES `Program` (`programName`,`departmentId`) ON UPDATE CASCADE ON DELETE RESTRICT,
   CONSTRAINT `ProgramCourseListFKcourseTable` FOREIGN KEY (`courseNumber`,`courseDepartmentId`) REFERENCES `Course` (`courseNumber`,`departmentId`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `CoRequisite`;
CREATE TABLE `CoRequisite` (
  `courseNumber` int NOT NULL,
  `departmentId` varchar(4) NOT NULL,
  `coRequisiteNumber` int NOT NULL,
  `coRequisiteDeptId` varchar(4) NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  isMust bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`courseNumber`,`departmentId`,`coRequisiteNumber`,`coRequisiteDeptId`),
/* changed table name to Course from Department and merged foreign keys */
  CONSTRAINT `CoRequisiteFKcourseNumberdepartmentId` FOREIGN KEY (`courseNumber`,`departmentId`) REFERENCES `Course` (`courseNumber`,`departmentId`) ON DELETE RESTRICT ON UPDATE CASCADE,
/* changed table name to Course from Department and merged foreign keys*/
  CONSTRAINT `CoRequisiteFKcoRequisiteDeptIdcoRequisiteDeptId` FOREIGN KEY (`coRequisiteNumber`,`coRequisiteDeptId`) REFERENCES `Course` (`courseNumber`,`departmentId`) ON DELETE RESTRICT ON UPDATE CASCADE
/*  CONSTRAINT `CoRequisiteFKcoRequisiteNumber` FOREIGN KEY (`coRequisiteNumber`) REFERENCES `Course` (`courseNumber`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `CoRequisiteFKcourseNumber` FOREIGN KEY () REFERENCES `Course` (`courseNumber`) ON DELETE RESTRICT ON UPDATE CASCADE */
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

  
DROP TABLE IF EXISTS `Prerequisite`;
CREATE TABLE `Prerequisite` (
  `courseNumber` int NOT NULL,
  `departmentId` varchar(4) NOT NULL,
  `preRequisiteNumber` int NOT NULL,
  `preRequisiteDeptId` varchar(4) NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  isMust bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`courseNumber`,`departmentId`,`preRequisiteNumber`,`preRequisiteDeptId`),
/* changed table name to Course from Department  and merged foreign keys*/
  CONSTRAINT `PrerequisiteFKcourseNumberdepartmentId` FOREIGN KEY (`courseNumber`,`departmentId`) REFERENCES `Course` (`courseNumber`,`departmentId`) ON DELETE RESTRICT ON UPDATE CASCADE,
/* changed table name to Course from Department  and merged foreign keys*/
  CONSTRAINT `PrerequisiteFKpreRequisiteNumberpreRequisiteDeptId` FOREIGN KEY (`preRequisiteNumber`,`preRequisiteDeptId`) REFERENCES `Course` (`courseNumber`,`departmentId`) ON DELETE RESTRICT ON UPDATE CASCADE
 /* CONSTRAINT `PrerequisiteFKpreRequisiteNumber` FOREIGN KEY (`preRequisiteNumber`) REFERENCES `Course` (`courseNumber`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `PrerequisiteFKcourseNumber` FOREIGN KEY (`courseNumber`) REFERENCES `Course` (`courseNumber`) ON DELETE RESTRICT ON UPDATE CASCADE	*/
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `SectionType`;
CREATE TABLE `SectionType` (
  `sectionTypeId` INT NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  PRIMARY KEY (`sectionTypeId`),
  UNIQUE KEY `SectionTypeUNIQname` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE SectionType AUTO_INCREMENT = 100;


DROP TABLE IF EXISTS `Session`;
CREATE TABLE `Session` (
  `sessionId` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`sessionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE `Session` AUTO_INCREMENT = 100;


DROP TABLE IF EXISTS `Term`;
CREATE TABLE `Term` (
  `termYear` SMALLINT NOT NULL,
  `sessionId` INT NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`termYear`,`sessionId`),
  CONSTRAINT TermCHKtermYear CHECK (termYear > 2000 AND termYear < 2999),
  CONSTRAINT `TermFKsessionId` FOREIGN KEY (`sessionId`) REFERENCES `Session` (`sessionId`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `Section`;
CREATE TABLE `Section` (
  `sectionId` INT NOT NULL,
  `sectionTypeId` INT NOT NULL,
  `courseNumber` INT NOT NULL,
  `departmentId` varchar(4) NOT NULL,
  `termYear` SMALLINT NOT NULL,
  `sessionId` INT NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `registerDeadline` date NOT NULL,
  `dropDeadline` date NOT NULL,
  `totalSeats` INT NOT NULL,
   /* created term table */
  `facultyMemberId` INT NOT NULL,
  `teachingAssistant` varchar(20) DEFAULT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`sectionId`,`courseNumber`,`departmentId`,`termYear`,`sessionId`,`sectionTypeId`),
/* changed table name to Course from Department and merged foreign keys*/
  CONSTRAINT `SectionFKcourseNumberdepartmentId` FOREIGN KEY (`courseNumber`,`departmentId`) REFERENCES `Course` (`courseNumber`,`departmentId`) ON DELETE RESTRICT ON UPDATE CASCADE,
/*   CONSTRAINT `SectionFKdepartmentId` FOREIGN KEY (`departmentId`) REFERENCES `Course` (`departmentId`) ON DELETE RESTRICT ON UPDATE CASCADE, */
  CONSTRAINT `SectionFKtermYearsessionId` FOREIGN KEY (`termYear`,`sessionId`) REFERENCES `Term` (`termYear`,`sessionId`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `SectionFKfacultyMemberId` FOREIGN KEY (`facultyMemberId`) REFERENCES `FacultyMember` (`facultyMemberId`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `SectionFKsectionTypeId` FOREIGN KEY (`sectionTypeId`) REFERENCES `SectionType` (`sectionTypeId`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `Registration`;
CREATE  TABLE `Registration` (
  `studentId` INT NOT NULL ,
  `programName` VARCHAR(30) NOT NULL ,
  `departmentId` VARCHAR(4) NOT NULL ,
  `startDate` DATE NOT NULL ,
  `graduationDate` DATE NOT NULL ,
  `isActive` BIT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (`studentId`, `programName`, `departmentId`) ,
  CONSTRAINT `RegistrationFKstudentId`
    FOREIGN KEY (`studentId` )
    REFERENCES `Student` (`studentId` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
/* changed table name to Program from Department  and merged foreign keys*/
  CONSTRAINT `RegistrationFKprogramNamedepartmentId`
    FOREIGN KEY (`programName`,`departmentId` )
    REFERENCES `Program` (`programName`,`departmentId` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE
/*  CONSTRAINT `RegistrationFKdepartmentId` FOREIGN KEY (`departmentId` ) REFERENCES `Program` (`departmentId` ) ON DELETE RESTRICT ON UPDATE CASCADE */
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*
DROP TABLE IF EXISTS `MessagePriority`;
CREATE  TABLE `MessagePriority` (
  `messagePriorityId` INT NOT NULL ,
  `name` VARCHAR(10) NOT NULL ,
  PRIMARY KEY (`messagePriorityId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/

DROP TABLE IF EXISTS `Message`;
CREATE  TABLE `Message` (
  `messageId` INT NOT NULL AUTO_INCREMENT,	/* Auto Increment */
  `subject` VARCHAR(250) NULL ,
  `messageBody` VARCHAR(5000) NULL ,
/*  `priorityId` INT NOT NULL , */
  `senderId` VARCHAR(15) NOT NULL ,
  `dateTime` DATETIME NOT NULL ,
  PRIMARY KEY (`messageId`) ,
/*  CONSTRAINT `MessageFKpriorityId`
    FOREIGN KEY (`priorityId` )
    REFERENCES `MessagePriority` (`message	` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE,*/
  CONSTRAINT `MessageFKsenderId`
    FOREIGN KEY (`senderId` )
    REFERENCES `User` (`username` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE Message AUTO_INCREMENT = 100;


DROP TABLE IF EXISTS `MessageStatus`;
CREATE  TABLE `MessageStatus` (
  `statusId` INT NOT NULL ,
  `name` VARCHAR(15) NOT NULL ,
  PRIMARY KEY (`statusId`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `MessageReceiver`;
CREATE  TABLE `MessageReceiver` (
  `messageId` INT NOT NULL ,
  `receiverId` VARCHAR(15) NOT NULL ,
  `statusId` INT NOT NULL DEFAULT 0 ,
  `modifiedAt` DATETIME NOT NULL ,
  PRIMARY KEY (`messageId`, `receiverId`) ,
  CONSTRAINT `MessageReceiverFKmessageId`
    FOREIGN KEY (`messageId` )
    REFERENCES `Message` (`messageId` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `MessageReceiverFKreceiverId`
    FOREIGN KEY (`receiverId` )
    REFERENCES `User` (`username` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `MessageReceiverFKstatusId`
    FOREIGN KEY (`statusId` )
    REFERENCES `MessageStatus` (`statusId` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `Glossary`;
CREATE  TABLE `Glossary` (
  `term` VARCHAR(100) NOT NULL ,
  `definition` VARCHAR(1000) NOT NULL ,
  PRIMARY KEY (`term`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `FAQ`;
CREATE  TABLE `FAQ` (
  `question` VARCHAR(250) NOT NULL ,
  `answer` VARCHAR(5000) NOT NULL ,
  PRIMARY KEY (`question`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `WeekDay`;
CREATE  TABLE `WeekDay` (
  `dayId` INT NOT NULL AUTO_INCREMENT,
  `weekDay` VARCHAR(10) NOT NULL ,
  PRIMARY KEY (`dayId`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE WeekDay AUTO_INCREMENT = 100;


DROP TABLE IF EXISTS `SectionTimeTable`;
CREATE  TABLE `SectionTimeTable` (
  `sectionId` INT NOT NULL ,
  `courseNumber` INT NOT NULL ,
  `departmentId` VARCHAR(4) NOT NULL ,
  `termYear` SMALLINT NOT NULL,
  `sessionId` INT NOT NULL,
  `sectionTypeId` INT NOT NULL,
  `dayId` INT NOT NULL ,
  `startTime` TIME NOT NULL ,
  `lengthInMinutes` INT NOT NULL ,
  PRIMARY KEY (`sectionId`,`sectionTypeId`, `courseNumber`, `departmentId`,`termYear`,`sessionId`, `dayId`, `startTime`),
   CONSTRAINT SectionTimeTableCHKlengthInMinutes CHECK (lengthInMinutes > 59),
/* changed table name to Section from Course and merged foreign keys*/
/* changed table name to Section from Department and merged foreign keys*/
  CONSTRAINT `SectionTimeTableFKSectionTable`
    FOREIGN KEY (`sectionId`,`courseNumber`,`departmentId`,`termYear`,`sessionId`,`sectionTypeId`)
    REFERENCES `Section` (`sectionId`,`courseNumber`,`departmentId`,`termYear`,`sessionId`,`sectionTypeId` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
   CONSTRAINT `SectionTimeTableFKdayId`
    FOREIGN KEY (`dayId` )
    REFERENCES `WeekDay` (`dayId` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `Grade`;
CREATE TABLE `Grade` (
  `gradeId` INT NOT NULL AUTO_INCREMENT,
  `name` varchar(1) NOT NULL,
   PRIMARY KEY (`gradeId`),
   UNIQUE KEY `GradeUNIQname` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE `Grade` AUTO_INCREMENT = 100;


DROP TABLE IF EXISTS `Result`;
CREATE TABLE `Result` (
  `resultId` INT NOT NULL AUTO_INCREMENT,
  `name` varchar(4) NOT NULL,
   PRIMARY KEY (`resultId`),
   UNIQUE KEY `ResultUNIQname` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE `Result` AUTO_INCREMENT = 100;


DROP TABLE IF EXISTS `Enrolment`;
CREATE  TABLE `Enrolment` (
  `studentId` INT NOT NULL ,
  `sectionId` INT NOT NULL ,
  `courseNumber` INT NOT NULL ,
  `departmentId` VARCHAR(4) NOT NULL ,
  `termYear` SMALLINT NOT NULL,
  `sessionId` INT NOT NULL,
  `sectionTypeId` INT NOT NULL,
  `score` INT DEFAULT NULL,
  `gradeId` INT DEFAULT NULL,
  `resultId` INT DEFAULT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`studentId`, `sectionId`,`sectionTypeId`, `courseNumber`, `departmentId`,  `termYear`,`sessionId`) ,
  CONSTRAINT `EnrolmentFKstudentId`
    FOREIGN KEY (`studentId` )
    REFERENCES `Student` (`studentId` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
/* changed table name to Section from Course  and merged foreign keys */
/* changed table name to Section from Department and merged foreign keys */
/* CONSTRAINT EnrolmentCHKscore CHECK (`score` > -1 AND `score` < 101),*/
	CONSTRAINT `EnrolmentFKsectionIdcourseNumberdepartmentId`
    FOREIGN KEY (`sectionId`,`courseNumber`,`departmentId`,`termYear`,`sessionId`,`sectionTypeId` )
    REFERENCES `Section` (`sectionId`,`courseNumber`,`departmentId`,`termYear`,`sessionId`,`sectionTypeId`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
	CONSTRAINT `EnrolmentFKgradeId`
    FOREIGN KEY (`gradeId`) REFERENCES `Grade` (`gradeId`) ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT `EnrolmentFKresultId`
    FOREIGN KEY (`resultId`) REFERENCES `Result` (`resultId`) ON DELETE RESTRICT ON UPDATE CASCADE
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `Locale`;
CREATE TABLE `Locale` (
  `id` INT NOT NULL,
  `name` varchar(4) NOT NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY `LocaleUNIQname` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS ResourceDictionary;
CREATE TABLE ResourceDictionary (
  resourceId INT NOT NULL,
  localeId INT NOT NULL,
  textString varchar(1000) NOT NULL,
  PRIMARY KEY (resourceId ,localeId),
  CONSTRAINT LocaleFKid FOREIGN KEY (localeId) REFERENCES Locale (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
