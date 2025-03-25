use quanlysinhvien;

# Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select SubName, Credit
FROM subject 
WHERE Credit = (SELECT MAX(Credit) FROM subject);

# Hiển thị các thông tin môn học có điểm thi lớn nhất.
select sub.SubName, max(m.Mark) as mMark 
from subject sub
inner join Mark m on sub.SubId = m.SubId
group by sub.SubName
having mMark = (select max(Mark) from mark);

# Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select s.StudentName, s.Address, s.Phone, avg(m.Mark) as Average
from student s
inner join mark m on s.StudentId = m.StudentId
group by s.StudentName, s.Address, s.Phone
order by Average desc;