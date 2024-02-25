
Use ex2_student

CREATE TABLE Department
(
	DepID int primary key,
	[Name] nvarchar(50),
	Phone nvarchar(50)
)

CREATE TABLE Student 
(
	StudentID int primary key,
	FirstName nvarchar(20),
	LastName nvarchar(20),
	Dob datetime,
	GPA float(2),
	Street nvarchar(50),
	City nvarchar(50),
	DepID int foreign key references Department(DepID)
)

CREATE TABLE [Student Email]
(
	StudentID int Foreign key references Student(StudentID),
	Mail nvarchar(50),
	[type] nvarchar(50),
	Constraint PK_Mail primary key(StudentID, Mail)
)
 

CREATE TABLE [Student Phone]
(
	StudentID int foreign key references Student(StudentID),
	Phone nvarchar(50),
	[type] nvarchar(50),
	Constraint PK_Phone primary key(StudentID, Phone)
)

CREATE TABLE [Subject] 
(
	Code nvarchar(5) primary key,
	SubjectName nvarchar(50),
	NumberCredit int,
	DepartmentID int Foreign key references Department(DepID)
)

CREATE TABLE Course
(
	CourseID int primary key,
	CourseName nvarchar(50),
	numberOfStudent int,
	SubjectCode nvarchar(5) foreign key References [Subject](Code)
)



CREATE TABLE Requirement
(
	SubjectCode nvarchar(5) foreign Key References [Subject](Code),
	PresubjectCode nvarchar(5) foreign Key References [Subject](Code)
)

CREATE TABLE Enrollment
(
	StudentID int Foreign key references Student(StudentID),
	CourseID int Foreign Key References Course(CourseID),
	Grade float,
	[Status] bit
	Constraint PK_Enrollment Primary key(StudentID, CourseID)
)

