use QuanLySinhVien;

# Hiển thị danh sách tất cả các học viên
select * from student;

# Hiển thị danh sách các học viên đang theo học.
select * from student where status = true;

# Hiển thị danh sách các môn học có thời gian học nhỏ hơn 10 giờ.
select * from subject where credit < 10;

# Hiển thị danh sách học viên lớp A1
select s.StudentId, s.StudentName, c.ClassName
from student s join class c on s.ClassId = c.ClassID
where c.ClassName = 'A1';

# Hiển thị điểm môn CF của các học viên.
select s.StudentName, sub.SubName, m.Mark
from student s join mark m on s.StudentId = m.StudentId
join subject sub on sub.SubId = m.SubId where sub.SubName = 'CF';

