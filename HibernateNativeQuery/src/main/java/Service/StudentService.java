package Service;

import java.util.List;
import java.util.Scanner;
import Dao.DaoStudentImpl;
import Model.Student;

public class StudentService {
    Scanner sc = new Scanner(System.in);
    DaoStudentImpl dao = new DaoStudentImpl();

    public void searchByMarksService() {
        System.out.print("Enter minimum marks to search: ");
        double marks = sc.nextDouble();
        dao.searchByMarks(marks);
    }

    public void findByName() {
        System.out.print("Enter student name: ");
        String sname = sc.next();
        Student s = dao.findByName(sname);
        if (s != null) {
            System.out.println("Student Found: " + s);
        } else {
            System.out.println("No student found with name: " +sname);
        }
    }

    public void addStudentService() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        System.out.print("Enter name: ");
        String name = sc.next();
        System.out.print("Enter marks: ");
        int marks = sc.nextInt();

        Student s = new Student();
        s.setSid(id);
        s.setSname(name);
        s.setMarks(marks);

        dao.addStudent(s);
    }
    
    public void removeByRollNo() {
    	System.out.print("Enter roll no to delete");
        double roll = sc.nextDouble();
        dao.removeByRollNo(roll);
    }
    
    public void updateStudentName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Roll No (sid) to update: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter new name: ");
        String name = sc.nextLine();
        dao.updateNameById(id, name);
        sc.close();
    }
    
    public void showPaginatedStudents() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter page number: ");
        int page = sc.nextInt();

        System.out.print("Enter page size: ");
        int size = sc.nextInt();

        List<Student> students = dao.getPaginatedStudents(page, size);
        if (students.isEmpty()) {
            System.out.println("No records found.");
        }

        sc.close();
    }
    
    public void findAll(){
    	dao.findAll();
    }
    public void removeByRoll(){
    	System.out.print("Enter roll no to remove: ");
        double roll = sc.nextDouble();
        dao.removeByRoll(roll);
    }
}
