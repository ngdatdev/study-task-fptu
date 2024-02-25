Use DB_Student_Final

--Nguyen Van Dat De180922

--1. Cập nhật địa chỉ của sinh viên có tên Bảo Thi, quê Quảng Ngãi
select * from student

Update student
Set [Address] = N'Quảng Ngãi'
Where LastName = N'Bảo Thi'

--2. Liệt kê ra những sinh viên quê ở Quảng Nam, Đà Nẵng

Select * From Student
Where [Address] in (N'Quảng Nam', N'Đà Nẵng')

--3. Liệt kê ra những sinh viên họ Nguyễn

Select * From Student
Where FirstName Like N'Nguyễn%'

--4. Liệt kê ra những sinh viên ở khoa Công nghệ thông tin, lấy FirstName, Last Name và Tuổi
--Sắp xếp giảm dần theo Tuổi.

Select FirstName, LastName, (Year(GETDATE()) - Year(DOB)) as Age 
From Student 
Where DepartmentID = (Select DepartmentID From Department Where [Name] = N'Công nghệ thông tin')
Order By Age Desc

Select * from Department	

--5. Liệt kê ra những sinh viên có tên chứa chữ Th, chỉ lấy First Name, LastName và Gender
Select FirstName, LastName, Gender From Student
Where  FirstName LIKE '%Th%' OR LastName LIKE '%Th%'

--6. Xóa khoa Giáo dục thể chất
DELETE FROM Department 
WHERE Name = N'Giáo dục thể chất';

--7. Lấy ra thông tin sv thuộc khoa có mã 1, hoặc 2 sắp xếp tăng dần theo FirstName, giảm dần theo LastName
Select * from Student 
Where DepartmentID in (1, 2)
Order By FirstName, LastName Desc

--8. Liệt kê thông tin những khoa nào chưa có sinh viên
Select * from Department
Where DepartmentID Not IN (
Select distinct DepartmentID from student)

Select * from Department
Where not exists (
Select DepartmentID from student where student.DepartmentID = Department.DepartmentID)

--9. Đếm có bao nhiêu sinh viên thuộc khoa có mã là 1

Select DepartmentID ,count(*) as [Number of student]
From student
Where DepartmentID = 1
group by DepartmentID

--10. Liệt kê thông tin gồm Mã khoa, số lượng sinh viên
SELECT Department.DepartmentID, COUNT(studentId) AS StudentCount 
from Department
left join student on student.DepartmentID = Department.DepartmentID
Group by Department.DepartmentID

--11. Liệt kê thông tin gồm: StudentID, Full name, Tuổi, Address
Select StudentId, (FirstName + ' ' + LastName) as FullName, Year(GETDATE()) - Year(DOB) as Age, Address 
from student
order by FullName Desc

--12. Liệt kê thông tin gồm StudentID, Full name, Department Name
Select StudentId, (FirstName + ' ' + LastName) as FullName, Department.Name from student
inner join Department on Department.DepartmentID = Student.DepartmentID

--13. Liệt kê thông tin sinh viên gồm studentID, Full Name, Số điện thoại của SV (nếu có) -------------
select * from student
where gpa is not null

--14. Liệt kê thông tin sinh viên gồm studentID, Full Name, Số điện thoại của SV, Email (nếu có)

--15. Liệt kê ra những khóa học của môn học có mã DBI202
Select * from course
where subjectID = (Select SubjectID from Subject where SubjectID = 'DBI202')

--16. Liệt kê theo mã môn học, số lượng khóa học của môn học đó.
select Subject.SubjectID, count(*) as [Number of courses] from Subject
left join course on Course.SubjectID = Subject.SubjectID
group by Subject.subjectID

--17. Liệt kê theo mã môn học, số lượng khóa học của môn học đó, chỉ hiển thị số lượng khóa học >=2
select Subject.SubjectID, count(*) as [Number of courses] from Subject
left join course on Course.SubjectID = Subject.SubjectID
group by Subject.subjectID
having count(*) >= 2

--18. Liệt kê xem có sinh viên nào không đăng ký học khóa học nào cả.
select * from student
where not exists
(
	select * from Enrollment where student.StudentID = Enrollment.StudentID
)

--19. Liệt kê các tên môn học và tên các môn học tiên quyết của nó


--20. Liệt kê theo ID sinh viên, số lượng khóa học đã đăng ký.


Select student.StudentID, count(*) from student
left join Enrollment on Enrollment.StudentID = student.StudentID
group by student.StudentID

