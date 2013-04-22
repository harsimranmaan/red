Use AdgTest;

ALTER TABLE User
ADD UNIQUE INDEX UserINDusernamePasswordIsActive (username,password,isActive) USING BTREE;

ALTER TABLE User
ADD INDEX UserINfirstNamelastName (firstName, lastName) USING BTREE;

ALTER TABLE Message
ADD INDEX MessageINDdateTime (dateTime) USING BTREE;

ALTER TABLE MessageStatus
ADD UNIQUE INDEX MessageStatusINDname (name) USING BTREE;

ALTER TABLE Enrolment
ADD INDEX EnrolmentINDstudentIdSectionTypeIdIsActive (studentId, isActive, sectionTypeId) USING BTREE;

ALTER TABLE Enrolment
ADD INDEX EnrolmentINDstuidResidSectypidIsact (studentId, isActive, resultId, sectionTypeId) USING BTREE;

ALTER TABLE SectionTimeTable
ADD INDEX SectionTimeTableINDdayIdStartTime (dayId, startTime) USING BTREE;

ALTER TABLE Registration
ADD INDEX RegistrationINDstudentIdIsActive (studentId, isActive) USING BTREE;

ALTER TABLE ProgramCourseList
ADD INDEX ProgramCourseListINDprogramNameProgramDeptId (programName, programDepartmentId) USING BTREE;





