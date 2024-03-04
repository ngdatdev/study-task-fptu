-- Tao 1 thu tuc hien thi danh sach sinh vien
if OBJECT_ID ('usp_student_getAll', 'P') is not null 
	DROP PROCEDURE usp_student_getAll;
go
Create proc usp_student_getAll
@deptID int
As
	select * from student
	where departmentID = @deptID
-- chay store procedure
exec usp_student_getAll @deptID = 1

--2. Tao 1 thu tuc hien thi danh sach sinh vien theo khoa
go
Create proc usp_student_getByDeptID
@deptID int
As
	select * from student
	where departmentID = @deptID
-- chay store procedure
exec usp_student_getAll @deptID = 1
go

--3 Tao 1 thu tuc hien thi danh sasch sinh vien thuoc khoa 1 hoac ho le
create proc usp_student_getbyDeptFirstname
@deptID int, @fisrtname nvarchar(30)
as 
	select * from student
	where DepartmentID = @deptID or FirstName like @fisrtname + '%'
	
exec usp_student_getbyDeptFirstname @deptID = 1, @fisrtname = N'Nguyễn'

-- sửa lại store proc trên với hiển thị tên chữa chữ Th

go
alter proc usp_student_getbyDeptFirstname
@deptID int, @fisrtname nvarchar(30)
as 
	select * from student
	where DepartmentID = @deptID or FirstName like '%' + @fisrtname + '%'
	
exec usp_student_getbyDeptFirstname @deptID = 1, @fisrtname = N'Th'

-- 4. Tao 1 sp cho phép chèn dữ liệu vào bảng subject, nếu số lượng number of credit bé hơn 0 thì không nhận
go
create proc usp_subject_insertvalue
@subId varchar(6), @name nvarchar(30), @numbercredits int, @deptId int
as
		Begin
			insert into subject
			values(@subId, @name, @numbercredits, @deptId)
		end

select * from Subject
exec usp_subject_insertvalue @subID = 'CSD201', @name = N'Cấu trúc dữ liệu và giải thuật', @numbercredits = 2, @deptId = 1

select * from subject
go
alter proc usp_subject_insertvalue
@subId varchar(6), @name nvarchar(30), @numbercredits int, @deptId int
as
Begin
BEGIN TRANSACTION
		Begin
			insert into subject
			values(@subId, @name, @numbercredits, @deptId)
			print 'Insert successfully'
		end
	if(@numbercredits < 0) 
		begin 
			declare @ErrorMessage nvarchar(255) = 'Number of credits must be greater than 0.';
			print @ErrorMessage
			rollback transaction
		end
commit transaction
end

exec usp_subject_insertvalue @subID = 'CSD201', @name = N'Cấu trúc dữ liệu và giải thuật', @numbercredits = -2, @deptId = 1

--5 Viết thủ tục Liệt kê ra những sinh viên có tên chứa chữ Th, chỉ lấy First Name, LastName và Gender
go 
create proc usp_student_getInfo
as
	begin 
		select FirstName, LastName, Gender
		from student
		where FirstName like '%Th%' or LastName like '%Th%';
	end

exec usp_student_getInfo

--6. Viết thủ tục hiển thị số lượng môn học mà khoa nào đó đang quản lý.
select * from subject

go
create proc usp_department_getNumersOfSubject1
@DepartmentName nvarchar(50)
as 
	begin 
		select Department.Name, count(Subject.DepartmentID) as [Number of Subject]
		from Department
		left join Subject on Subject.DepartmentID = Department.DepartmentID
		where Department.Name = @DepartmentName
		group by Department.Name
	end;
go 

exec usp_department_getNumersOfSubject1 @DepartmentName = N'Công nghệ thông tin'

go

create proc usp_department_getNumersOfSubject
as 
	begin 
		select Department.Name, count(Subject.DepartmentID) as [Number of Subject]
		from Department
		left join Subject on Subject.DepartmentID = Department.DepartmentID
		group by Department.Name
	end;


--7. Viết thủ tục hiển thị số lượng tín chỉ mà sinh viên nào đó đã đăng ký được

---------- 
select * from student
select * from Enrollment
select * from Subject
select * from course

select student.studentID, isnull(sum(NumberOfCredits), 0) as [Total credits] from student
left join enrollment on student.StudentID = Enrollment.StudentID
left join course on Course.CourseID = Enrollment.CourseID
left join subject on subject.SubjectID = course.SubjectID
group by student.StudentID

go
create proc usp_student_getTotalCredits
@studentID int
as 
	begin
		select student.studentID, isnull(sum(NumberOfCredits), 0) as [Total credits] from student
		left join enrollment on student.StudentID = Enrollment.StudentID
		left join course on Course.CourseID = Enrollment.CourseID
		left join subject on subject.SubjectID = course.SubjectID
		where student.StudentID = @studentID
		group by student.StudentID
	end

exec usp_student_getTotalCredits @studentID = 1001

--8. Viết thủ tục lấy điểm của sinh viên nào đó theo một khóa học
select * from student
select * from course
select * from Enrollment

select student.StudentID, Concat(firstname, ' ', LastName) as [Full name], isnull(cast(grade as nvarchar(10)), N'Chưa có'), Course.Name as Grade from student
left join Enrollment on student.StudentID = Enrollment.StudentID
left join course on Course.CourseID = Enrollment.CourseID
where Concat(firstname, ' ', LastName) = N'Trần Danh'
and Course.Name = 'DBI202_1'

go 

create proc usp_student_getGradeByName
@studentName nvarchar(30),
@courseName nvarchar(30)
as
	begin 
		select student.StudentID, Concat(firstname, ' ', LastName) as [Full name], isnull(cast(grade as nvarchar(10)), N'Chưa có') as Grade, Course.Name from student
		left join Enrollment on student.StudentID = Enrollment.StudentID
		left join course on Course.CourseID = Enrollment.CourseID
		where Concat(firstname, ' ', LastName) = @studentName 
		and Course.Name = @courseName
	end

exec usp_student_getGradeByName @studentName = N'Trần Gia Huy', @courseName = 'DBI202_1'

--9. Viết thủ tục thêm 1 môn học vào bảng Subject
select * from subject
go
create proc usp_subject_addsubject
	@subjectID nvarchar(30),
	@name nvarchar(50),
	@credits int,
	@departmentId int
as 
	begin 
		insert into subject
		values(@subjectID, @name, @credits, @departmentId)
	end

exec usp_subject_addsubject @SubjectId = 'MAD201', @Name = N'Toán rời rạc',@credits = 3, @DepartmentID = 1;

--10. Viết thủ tục update điểm của 1 khóa học của 1 sinh viên nào đó  
select * from Enrollment
select * from student

go
create proc usp_enrollment_updateGrade
	@grade float,
	@studentName nvarchar(50),
	@courseId int
as
	begin 
		update Enrollment
		set grade = @grade
		where studentId = (select studentID from student where (student.FirstName + ' ' + student.LastName) = @studentName)
		and CourseID = @courseId
	end

exec usp_enrollment_updateGrade @grade = 10, @studentName = N'Trần Gia Huy', @courseId = 1

--11. Viết thủ tục in ra thông tin của sinh viên gồm ID, Full Name, Tên khoa và điểm của từng khóa học của sinh viên đó
select student.StudentID, (student.FirstName + student.LastName) as [Full Name], Department.Name, Course.Name, Isnull(Cast(grade as nvarchar(10)), N'Chưa có') as Grade from student
inner join Department on student.DepartmentID = Department.DepartmentID
left join Enrollment on student.StudentID = Enrollment.StudentID
left join Course on course.CourseID = Enrollment.CourseID

drop proc usp_student_getInfoById

go
create proc usp_student_getInfoById
@studentId int
as 
	begin
		select student.StudentID, (student.FirstName + ' ' + student.LastName) as [Full Name], Department.Name, Course.name, Isnull(Cast(grade as nvarchar(10)), N'Chưa có') as Grade from student
		left join Department on student.DepartmentID = Department.DepartmentID
		left join Enrollment on student.StudentID = Enrollment.StudentID
		left join Course on course.CourseID = Enrollment.CourseID
		where student.StudentID = @studentId
	end

exec usp_student_getInfoById @studentId = 1001

--13. Viết thủ tục lấy số lượng sinh viên của 1 khoa.
select Department.Name, count(student.DepartmentID) as [Number of student] from Department
left join student on Department.DepartmentID = student.DepartmentID
group by Department.Name
go
create proc usp_department_numberOfStudents
@departmentId int
as
	begin 
		select Department.Name, count(student.DepartmentID) as [Number of student] from Department
		left join student on Department.DepartmentID = student.DepartmentID
		where Department.DepartmentID = @departmentId
		group by Department.Name
	end

exec usp_department_numberOfStudents @departmentId = 1


--14. Viết thủ tục hiển thị tên các môn học và tiên quyết của môn học đó, kèm số tín chỉ của chúng.
select * from subject
select * from PreSubject

select Subject.Name, subject.NumberOfCredits, isnull(ss.Name, N'Không có') 
as [PreSubject Name], isnull(Cast(ss.NumberOfCredits as nvarchar(20)), N'Không có') as [Number of PreSubject'Credits]  from subject
left join PreSubject on Subject.SubjectID = PreSubject.SubjectID
left join subject as ss on ss.SubjectID = PreSubject.PreSubjectID

go
create proc usp_subject_getPresubject
as 
	begin		
		select Subject.Name, subject.NumberOfCredits, isnull(ss.Name, N'Không có') 
		as [PreSubject Name], isnull(Cast(ss.NumberOfCredits as nvarchar(20)), N'Không có') as [Number of PreSubject'Credits]  from subject
		left join PreSubject on Subject.SubjectID = PreSubject.SubjectID
		left join subject as ss on ss.SubjectID = PreSubject.PreSubjectID
	end;

exec usp_subject_getPresubject