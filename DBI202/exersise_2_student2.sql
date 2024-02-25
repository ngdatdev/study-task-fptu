--DE180922 Nguyen Van Dat--

--B1

USE db_student

--B2
CREATE TABLE Department 
(
	ID int IDENTITY(1, 1),
	[Name] NVARCHAR(40) NOT NULL,
	Phone NVARCHAR(11) NOT NULL,
	CONSTRAINT PK_DEPARTMENT PRIMARY KEY(ID)
)

CREATE TABLE [Subject]
(
	ID VARCHAR(30),
	[Name] NVARCHAR(40) NOT NULL,
	[Number Of Credit] TINYINT,
	DepartmentID INT,
	CONSTRAINT PK_SUBJECT PRIMARY KEY (ID),
	CONSTRAINT FK_SUBJECT_DEPARTMENT FOREIGN KEY (DepartmentID) REFERENCES Department(ID)
)

--B3 Xem bang OK
--B4

INSERT INTO Department 
VALUES('Information Technology', '1234567890')

INSERT INTO Department 
VALUES('Digital Marketing', '0987654321')

INSERT INTO Department 
VALUES('Human Resource', '0948379253')

--------------------------------------

INSERT INTO [Subject] 
VALUES('PRF192', 'Programming Fundamental', 3, 1)

INSERT INTO [Subject] 
VALUES('PRO192', 'Programming Oriented', 3, 1)

INSERT INTO [Subject] 
VALUES('OSG192', 'Oprerate System', 3, 1)

INSERT INTO [Subject]
VALUES('SSG102', 'Working Skills', 3, 2)

--B5

ALTER TABLE Department 
ADD [Status] varchar(10) 

--B6

CREATE TABLE Student 
(
	ID INT IDENTITY(1, 1),
	[First Name] NVARCHAR(30),
	[Last Name] NVARCHAR(30),
	DOB DATE,	
	Grade INT,
	[Address] NVARCHAR(100) DEFAULT N'Đà Nẵng',
	DepartmentID INT
	CONSTRAINT PK_STUDENT PRIMARY KEY (ID)
	CONSTRAINT PK_STUDENT_DEPARTMENT FOREIGN KEY (ID) REFERENCES Department(ID)
)


ALTER TABLE STUDENT 
ADD Gender NVARCHAR(30)

ALTER TABLE STUDENT
ADD CONSTRAINT CK_GENDER CHECK(GENDER IN(N'Nam', N'Nữ'))

SELECT * FROM Student

INSERT INTO Student
VALUES(N'Nguyễn', N'Đạt', '2004-02-29', 10, N'Quảng Bình', 1, N'Nam'),
(N'Huy', N'Trần', '2004-09-22', 10, N'Đà Nẵng', 1, N'Nam')

INSERT INTO Student ([First Name], [Last Name], DOB, DepartmentID, Gender)
VALUES(N'Trần', 'Thùy', '2004-1-1', 2, N'Nữ')

--B7

ALTER TABLE Department
ADD CONSTRAINT UQ_Department Unique(Name)

ALTER TABLE [Subject]
ADD CONSTRAINT CK_Subject CHECK(ID LIKE('[A-Z][A-Z][A-Z][0-9][0-9][0-9]'))

--B8

CREATE TABLE Course
(
	ID INT IDENTITY(1, 1),
	[Course Name] NVARCHAR(30),
	[Course Semester] NVARCHAR(30),
	[Number Of Student] INT,
	SubjectID VARCHAR(30),
	CONSTRAINT PK_COURSE PRIMARY KEY (ID),
	CONSTRAINT FK_COURSE FOREIGN KEY (SubjectID) REFERENCES [Subject](ID)
)

--B9

CREATE TABLE Enrollment
(
	StudentID INT,
	CourseID INT, 
	Grade FLOAT,
	[Status] NVARCHAR(30),
	CONSTRAINT PK_ENROLLMENT PRIMARY KEY (StudentID, CourseID),
	CONSTRAINT FK_ENROLLMENT_STUDENT FOREIGN KEY (StudentID) REFERENCES Student(ID),
	CONSTRAINT FK_ENROLLMENT_COURSE FOREIGN KEY (CourseID) REFERENCES Course(ID)
)

--B10

INSERT INTO Course
VALUES
('PRF191', 'Summer 2023', 500, 'PRF192'),
('PRF192', 'Fall 2023', 600, 'PRF192'),
('PRF193', 'Summer 2023', 500, 'PRF192'),
('PRF194', 'Spring 2023', 1000, 'PRF192'),
('OSG202', 'Summer 2024', 500, 'OSG192')
 

 INSERT INTO ENROLLMENT
 VALUES
 (1, 7, 9, 'Good'),
 (1, 8, 9, 'Good'),
 (1, 9, 6, 'Bad'),
 (2, 10, 9, 'Good'),
 (3, 11, 5, 'Bad')