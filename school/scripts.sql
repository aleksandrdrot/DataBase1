select * from student where age between 10 and 20;
select name from student;
SELECT * FROM Student where name like '%н%';
select * from student order by age;
select * from student,faculty where student.faculty_id = faculty.id and faculty.color = name('Зеленый');
select student.name, student.age, faculty.name from student,faculty where student.faculty_id = faculty.id and faculty.color = name('Зеленый');
select * from student,faculty where student.faculty_id = faculty.id and student.name = name('Маша');
select student.name, faculty.name, faculty.color from student,faculty where student.faculty_id = faculty.id and student.name = name('Маша');
