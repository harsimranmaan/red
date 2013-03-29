CREATE DATABASE  IF NOT EXISTS `AdgTest` ;
USE `AdgTest`;

DROP TABLE IF EXISTS `UserType`;
CREATE TABLE `UserType` (
  `userTypeId` INT NOT NULL,
  `name` varchar(25) NOT NULL,
  PRIMARY KEY (`userTypeId`),
  UNIQUE KEY `UserTypeUNIQname` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `Address`;
CREATE TABLE `Address` (
  `addressId` INT NOT NULL,
  `addressLineFirst` varchar(45) NOT NULL,
  `addressLineSecond` varchar(45) ,
  city varchar(15)  NOT NULL,
  province varchar(16),
  `postalCode` varchar(6) NOT NULL,
  PRIMARY KEY (`addressId`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
  
DROP TABLE IF EXISTS `Faculty`;
CREATE TABLE `Faculty` (
  `facultyId` INT NOT NULL,
  name VARCHAR(50) NOT NULL,
  addressId INT,
  `headOfFacultyId` INT DEFAULT NULL,/**FK**/
  `phone` varchar(15) DEFAULT NULL,
  `website` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`facultyId`),
  CONSTRAINT `FacultyFKaddressId` FOREIGN KEY (`addressId`) REFERENCES `Address` (`addressId`) ON UPDATE CASCADE ON DELETE RESTRICT,
  UNIQUE KEY `FacultyUNIQname` (name),
  CONSTRAINT FacultyCHKfacultyId CHECK facultyId > 0
  /**CONSTRAINT `FacultyFKheadId` FOREIGN KEY (`facultyId`) REFERENCES `Address` (`addressId`) ON UPDATE CASCADE ON DELETE RESTRICT**/
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `Department`;
CREATE TABLE `Department` (
  `departmentId` varchar(4) NOT NULL,
  `name` varchar(30) NOT NULL,
   addressId INT,
  `directorId` INT DEFAULT NULL,/**FK**/
   facultyId INT NOT NULL,
  `phone` varchar(15) NOT NULL,
  `email` varchar(45) NOT NULL,
  `website` varchar(50) NOT NULL,
  `createdBy` varchar(15) NOT NULL,
  `createdAt` datetime NOT NULL,
  `modifiedBy` varchar(15) NOT NULL,
  `modifiedAt` datetime NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`departmentId`),
  CONSTRAINT `DepartmentFKaddressId` FOREIGN KEY (`addressId`) REFERENCES `Address` (`addressId`) ON UPDATE CASCADE ON DELETE RESTRICT,
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
  `createdBy` varchar(15),
  `createdAt` datetime NOT NULL,
  `modifiedBy` varchar(15),
  `modifiedAt` datetime NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`username`),
  CONSTRAINT `UserFKuserTypeId` FOREIGN KEY (`userTypeId`) REFERENCES `UserType` (`userTypeId`) ON UPDATE CASCADE ON DELETE RESTRICT,
  /**CONSTRAINT `UserFKcreatedBy` FOREIGN KEY (`createdBy`) REFERENCES`User` (`username`) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT `UserFKmodifiedBy` FOREIGN KEY (`modifiedBy`) REFERENCES `User` (`username`) ON UPDATE CASCADE ON DELETE CASCADE,
  **/CONSTRAINT `UserFKaddressId` FOREIGN KEY (`addressId`) REFERENCES `Address` (`addressId`) ON UPDATE CASCADE ON DELETE RESTRICT,
  UNIQUE KEY `UserUNIQemail`  (`email`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `Program`;
CREATE  TABLE `Program` (
  `programName` VARCHAR(30) NOT NULL ,
  `departmentId` VARCHAR(4) NOT NULL ,
  `addressId` INT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  `phone` VARCHAR(15) NOT NULL ,
  `createdBy` VARCHAR(15) NOT NULL ,
  `createdAt` DATETIME NOT NULL ,
  `modifiedBy` VARCHAR(15) NOT NULL ,
  `modifiedAt` DATETIME NOT NULL ,
  `isActive` BIT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (`programName`, `departmentId`) ,
  CONSTRAINT `ProgramFKdepartmentId`
    FOREIGN KEY (`departmentId` )
    REFERENCES `Department` (`departmentId` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `ProgramFKaddressId`
    FOREIGN KEY (`addressId` )
    REFERENCES `Address` (`addressId` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `Student`;
CREATE TABLE `Student` (
  `studentId` INT NOT NULL,
  `username` varchar(10) NOT NULL,
  `programName` VARCHAR(30) NOT NULL ,
  `dateOfRegistration` date DEFAULT NULL,
  `highestDegree` varchar(20) DEFAULT NULL,
  `createdBy` varchar(15) NOT NULL,
  `createdAt` datetime NOT NULL,
  `modifiedBy` varchar(15) NOT NULL,
  `modifiedAt` datetime NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`studentId`),
  UNIQUE KEY `StudentUNIQusername` (`username`),
  CONSTRAINT `StudentFKusername` FOREIGN KEY (`username`) REFERENCES `User` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `StudentFKcreatedBy` FOREIGN KEY (`createdBy`) REFERENCES `User` (`username`) ON UPDATE CASCADE ON DELETE SET NULL,
  CONSTRAINT `StudentFKmodifiedBy` FOREIGN KEY (`modifiedBy`) REFERENCES `User` (`username`) ON UPDATE CASCADE ON DELETE SET NULL,
  CONSTRAINT `StudentFKprogramName` FOREIGN KEY (`programName`) REFERENCES `Program` (`programName`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `Administrator`;
CREATE TABLE `Administrator` (
  `adminId` INT NOT NULL,
  `username` varchar(10) NOT NULL,
  `dateOfJoining` date NOT NULL,
  /**--`title` varchar(20) DEFAULT NULL,
 -- `access` varchar(20) NOT NULL,**/
  `hiringFacultyId` INT NOT NULL,
  `createdBy` varchar(15) NOT NULL,
  `createdAt` datetime NOT NULL,
  `modifiedBy` varchar(15) NOT NULL,
  `modifiedAt` datetime NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`adminId`),
  KEY `username_idx` (`username`),
  CONSTRAINT `AdministratorFKusername` FOREIGN KEY (`username`) REFERENCES `User` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT `AdministratorFKfacultyId` FOREIGN KEY (`hiringFacultyId`) REFERENCES `Faculty` (`facultyId`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `FacultyMember`;
CREATE TABLE `FacultyMember` (
  `facultyMemberId` varchar(10) NOT NULL,
  `username` varchar(10) NOT NULL,
  `departmentId` varchar(4) NOT NULL,
  `title` varchar(20) NOT NULL,
  -- `type` varchar(20) NOT NULL,
  `dateOfJoining` date NOT NULL,
  `highestDegree` varchar(25) DEFAULT NULL,
  `createdBy` varchar(15) NOT NULL,
  `createdAt` datetime NOT NULL,
  `modifiedBy` varchar(15) NOT NULL,
  `modifiedAt` datetime NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`facultyMemberId`),
  CONSTRAINT `FacultyMemberFKdepartmentId` FOREIGN KEY (`departmentId`) REFERENCES `Department` (`departmentId`) ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT `FacultyMemberFKusername` FOREIGN KEY (`username`) REFERENCES `User` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `GradingScheme`;
CREATE TABLE `GradingScheme` (
gradingSchemeId INT NOT NULL,
name  varchar(25) NOT NULL,
  PRIMARY KEY (`gradingSchemeId`),
  UNIQUE KEY `GradingSchemeUNIQname` (`name`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `Course`;
CREATE TABLE `Course` (
  `courseNumber` INT NOT NULL,
  `departmentId` varchar(4) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `credits` INT NOT NULL,
  `gradingSchemeId`INT NOT NULL,
  `passingRequirement` varchar(45) NOT NULL,
 `createdBy` varchar(15) NOT NULL,
  `createdAt` datetime NOT NULL,
  `modifiedBy` varchar(15) NOT NULL,
  `modifiedAt` datetime NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`courseNumber`),
  CONSTRAINT `departmentId` FOREIGN KEY (`departmentId`) REFERENCES `Department` (`departmentId`) ON UPDATE CASCADE,
  CONSTRAINT `CourseFKgradingSchemeId` FOREIGN KEY (`gradingSchemeId`) REFERENCES `GradingScheme` (`gradingSchemeId`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `CoRequisite`;
CREATE TABLE `CoRequisite` (
  `courseNumber` int NOT NULL,
  `departmentId` varchar(4) NOT NULL,
  `coRequisiteNumber` int NOT NULL,
  `coRequisiteDeptId` varchar(4) NOT NULL,
  `createdBy` varchar(15) NOT NULL,
  `createdAt` datetime NOT NULL,
  `modifiedBy` varchar(15) NOT NULL,
  `modifiedAt` datetime NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  isMust bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`courseNumber`,`departmentId`,`coRequisiteNumber`,`coRequisiteDeptId`),
  CONSTRAINT `CoRequisiteFKdepartmentId` FOREIGN KEY (`departmentId`) REFERENCES `Department` (`departmentId`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `CoRequisiteFKcoRequisiteDeptId` FOREIGN KEY (`coRequisiteDeptId`) REFERENCES `Department` (`departmentId`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `CoRequisiteFKcoRequisiteNumber` FOREIGN KEY (`coRequisiteNumber`) REFERENCES `Course` (`courseNumber`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `CoRequisiteFKcourseNumber` FOREIGN KEY (`courseNumber`) REFERENCES `Course` (`courseNumber`) ON DELETE RESTRICT ON UPDATE CASCADE
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

  
  DROP TABLE IF EXISTS `Prerequisite`;
CREATE TABLE `Prerequisite` (
  `courseNumber` int NOT NULL,
  `departmentId` varchar(4) NOT NULL,
  `preRequisiteNumber` int NOT NULL,
  `preRequisiteDeptId` varchar(4) NOT NULL,
  `createdBy` varchar(15) NOT NULL,
  `createdAt` datetime NOT NULL,
  `modifiedBy` varchar(15) NOT NULL,
  `modifiedAt` datetime NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  isMust bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`courseNumber`,`departmentId`,`preRequisiteNumber`,`preRequisiteDeptId`),
  CONSTRAINT `PrerequisiteFKdepartmentId` FOREIGN KEY (`departmentId`) REFERENCES `Department` (`departmentId`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `PrerequisiteFKpreRequisiteDeptId` FOREIGN KEY (`preRequisiteDeptId`) REFERENCES `Department` (`departmentId`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `PrerequisiteFKpreRequisiteNumber` FOREIGN KEY (`preRequisiteNumber`) REFERENCES `Course` (`courseNumber`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `PrerequisiteFKcourseNumber` FOREIGN KEY (`courseNumber`) REFERENCES `Course` (`courseNumber`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `SectionType`;
CREATE TABLE `SectionType` (
  `sectionTypeId` INT NOT NULL,
  `name` varchar(25) NOT NULL,
  PRIMARY KEY (`sectionTypeId`),
  UNIQUE KEY `SectionTypeUNIQname` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `Section`;
CREATE TABLE `Section` (
  `sectionId` INT NOT NULL,
  `courseNumber` INT NOT NULL,
  `departmentId` varchar(4) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `term` varchar(20) NOT NULL, /* create term table */
  `facultyMemberId` varchar(20) NOT NULL,
  `sectionTypeId` varchar(3) NOT NULL,
  `teachingAssistant` varchar(20) DEFAULT NULL,
  `createdBy` varchar(15) NOT NULL,
  `createdAt` datetime NOT NULL,
  `modifiedBy` varchar(15) NOT NULL,
  `modifiedAt` datetime NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (sectionId,`courseNumber`,`departmentId`),
  CONSTRAINT `SectionFKcourseNumber` FOREIGN KEY (`courseNumber`) REFERENCES `Course` (`courseNumber`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `SectionFKdepartmentId` FOREIGN KEY (`departmentId`) REFERENCES `Department` (`departmentId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `Registration`;
CREATE  TABLE `Registration` (
  `studentId` INT(11) NOT NULL ,
  `programName` VARCHAR(30) NOT NULL ,
  `departmentId` VARCHAR(4) NOT NULL ,
  `startDate` DATE NOT NULL ,
  `graduationDate` DATE NOT NULL ,
  `createdBy` VARCHAR(15) NOT NULL ,
  `createdAt` DATETIME NOT NULL ,
  `modifiedBy` VARCHAR(15) NOT NULL ,
  `modifiedAt` DATETIME NOT NULL ,
  `isActive` BIT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (`studentId`, `programName`, `departmentId`) ,
  CONSTRAINT `EnrolmentFKstudentId`
    FOREIGN KEY (`studentId` )
    REFERENCES `adgtest`.`student` (`studentId` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `EnrolmentFKprogramName`
    FOREIGN KEY (`programName` )
    REFERENCES `adgtest`.`program` (`programName` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `EnrolmentFKdepartmentId`
    FOREIGN KEY (`departmentId` )
    REFERENCES `adgtest`.`department` (`departmentId` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




DROP TABLE IF EXISTS `MessagePriority`;
CREATE  TABLE `MessagePriority` (
  `messagePriorityId` INT NOT NULL ,
  `name` VARCHAR(10) NOT NULL ,
  PRIMARY KEY (`messagePriorityId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `Message`;
CREATE  TABLE `Message` (
  `messageId` INT NOT NULL ,
  `subject` VARCHAR(45) NULL ,
  `messageBody` VARCHAR(300) NULL ,
  `priorityId` INT NOT NULL ,
  `senderId` VARCHAR(15) NOT NULL ,
  `timeStamp` DATETIME NOT NULL ,
  PRIMARY KEY (`messageId`) ,
  CONSTRAINT `MessageFKpriorityId`
    FOREIGN KEY (`priorityId` )
    REFERENCES `adgtest`.`messagepriority` (`messagePriorityId` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `MessageFKsenderId`
    FOREIGN KEY (`senderId` )
    REFERENCES `adgtest`.`user` (`username` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


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
  CONSTRAINT `MessageFKmessageId`
    FOREIGN KEY (`messageId` )
    REFERENCES `adgtest`.`message` (`messageId` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `MessageFKreceiverId`
    FOREIGN KEY (`receiverId` )
    REFERENCES `adgtest`.`user` (`username` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `MessageFKstatusId`
    FOREIGN KEY (`statusId` )
    REFERENCES `adgtest`.`messagestatus` (`statusId` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `Glossary`;
CREATE  TABLE `Glossary` (
  `pageId` INT NOT NULL ,
  `term` VARCHAR(45) NOT NULL ,
  `definition` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`pageId`, `term`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `FAQ`;
CREATE  TABLE `FAQ` (
  `question` VARCHAR(100) NOT NULL ,
  `answer` VARCHAR(300) NOT NULL ,
  PRIMARY KEY (`question`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `Day`;
CREATE  TABLE `Day` (
  `dayId` INT NOT NULL ,
  `day` VARCHAR(10) NOT NULL ,
  PRIMARY KEY (`dayId`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `SectionTimeTable`;
CREATE  TABLE `SectionTimeTable` (
  `sectionId` INT NOT NULL ,
  `courseNumber` INT NOT NULL ,
  `departmentId` VARCHAR(4) NOT NULL ,
  `dayId` INT NOT NULL ,
  `startTime` TIME NOT NULL ,
  `lengthInMinutes` INT NOT NULL , /* check constraint min 60 */
  `createdBy` VARCHAR(15) NOT NULL ,
  `createdAt` DATETIME NOT NULL ,
  `modifiedBy` VARCHAR(15) NOT NULL ,
  `modifiedAt` DATETIME NOT NULL ,
  PRIMARY KEY (`sectionId`, `courseNumber`, `departmentId`, `dayId`, `startTime`) ,
  CONSTRAINT `SectionTimeTableFKsectionId`
    FOREIGN KEY (`sectionId` )
    REFERENCES `adgtest`.`section` (`sectionId` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `SectionTimeTableFKcourseNumber`
    FOREIGN KEY (`courseNumber` )
    REFERENCES `adgtest`.`course` (`courseNumber` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `SectionTimeTableFKdepartmentId`
    FOREIGN KEY (`departmentId` )
    REFERENCES `adgtest`.`department` (`departmentId` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `SectionTimeTableFKdayId`
    FOREIGN KEY (`dayId` )
    REFERENCES `adgtest`.`day` (`dayId` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* enrolment */