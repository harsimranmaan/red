INSERT INTO `UserType` VALUES (1,'Faculty'),(2,'Admin'),(3,'Student');
INSERT INTO `GradingScheme` VALUES (1,'Percentage'),(2,'Pass/Fail');
INSERT INTO `SectionType` VALUES (1,'Lecture'),(2,'Tutorial'),(3,'Lab');

INSERT INTO `AdgTest`.`Faculty` (`facultyId`, `name`, `phone`, `website`) VALUES ('1', 'Engineering', '123456789', 'www.someFac.com');
INSERT INTO `AdgTest`.`Department` (`departmentId`, `name`, `facultyId`, `phone`, `email`, `website`, `isActive`) VALUES ('1', 'CICS', '1', '12345', 'dp@dp.com', 'asd.com', 1);
