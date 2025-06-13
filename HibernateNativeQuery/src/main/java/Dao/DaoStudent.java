package Dao;

import java.util.List;
import Model.Student;

public interface DaoStudent {
    void addStudent(Student s);
    void updateStudent(Student s);
    void deleteStudent(int id);
    Student getStudent(int id);
    List<Student> getAllStudents();
    Student getStudentByName(String snm);
    public void searchByMarks(double marks);
    public void removeByRollNo(double rno);
    void updateNameById(int id, String name);
    List<Student> getPaginatedStudents(int pageNumber, int pageSize);
	List<Student> findAll();
	void removeByRoll(double roll);
	Student findByName(String sname);
    }
