use quanlysinhvien;

# Hiển thị số lượng sinh viên ở từng nơi
select Address, count(Address) as Count 
from student
group by Address;

# Tính điểm trung bình các môn học của mỗi học viên
select s.StudentName, avg(m.Mark) as Average 
from student s
inner join mark m on s.StudentId = m.StudentId
group by s.StudentName;

# Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 8
select s.StudentName, avg(m.Mark) as Average 
from student s
inner join mark m on s.StudentId = m.StudentId
group by s.StudentName
having Average > 8;

# Hiển thị thông tin các học viên có điểm trung bình lớn nhất.
SELECT s.StudentName, AVG(m.Mark) AS Average 
FROM student s
INNER JOIN mark m ON s.StudentId = m.StudentId
GROUP BY s.StudentName
HAVING Average = (
    SELECT MAX(Average)
    FROM (
        SELECT AVG(m.Mark) AS Average
        FROM student s
        INNER JOIN mark m ON s.StudentId = m.StudentId
        GROUP BY s.StudentName
    ) AS subquery
);