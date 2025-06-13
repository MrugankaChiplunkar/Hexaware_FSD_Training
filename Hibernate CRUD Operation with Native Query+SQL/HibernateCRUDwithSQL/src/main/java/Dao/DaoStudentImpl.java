package Dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import Connection.StudentConn;
import Model.Student;

public class DaoStudentImpl implements DaoStudent {

    @Override
    public void addStudent(Student s) {
        Session session = StudentConn.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(s);
            tx.commit();
            System.out.println("Student added successfully.");
        } catch (Exception e) {
            tx.rollback();
            System.out.println("Error while adding student: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    @Override
    public void updateStudent(Student s) {
        Session session = StudentConn.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(s);
            tx.commit();
            System.out.println("Student updated successfully.");
        } catch (Exception e) {
            tx.rollback();
            System.out.println("Error while updating student: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteStudent(int id) {
        Session session = StudentConn.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Student s = session.get(Student.class, id);
            if (s != null) {
                session.delete(s);
                tx.commit();
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student not found with ID: " + id);
                tx.rollback();
            }
        } catch (Exception e) {
            tx.rollback();
            System.out.println("Error while deleting student: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    @Override
    public Student getStudent(int id) {
        Session session = StudentConn.getSessionFactory().openSession();
        Student s = null;
        try {
            s = session.get(Student.class, id);
        } catch (Exception e) {
            System.out.println("Error while fetching student: " + e.getMessage());
        } finally {
            session.close();
        }
        return s;
    }

    @Override
    public List<Student> getAllStudents() {
        Session session = StudentConn.getSessionFactory().openSession();
        List<Student> students = null;
        try {
            Query<Student> query = session.createQuery("from Student", Student.class);
            students = query.getResultList();
        } catch (Exception e) {
            System.out.println("Error while fetching all students: " + e.getMessage());
        } finally {
            session.close();
        }
        return students;
    }

    @Override
    public Student getStudentByName(String sname) {
        Session session = StudentConn.getSessionFactory().openSession();
        Student s = null;
        try {
            Query<Student> query = session.createQuery("from Student where sname = :name", Student.class);
            query.setParameter("name", sname);
            s = query.uniqueResult();
        } catch (Exception e) {
            System.out.println("Error while searching student by name: " + e.getMessage());
        } finally {
            session.close();
        }
        return s;
    }

    @Override
    public void searchByMarks(double marks) {
        Session session = StudentConn.getSessionFactory().openSession();
        try {
            Query<Student> q = session.createQuery("from Student s where s.marks > :marks", Student.class);
            q.setParameter("marks", marks);
            List<Student> qlist = q.list();

            qlist.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error in searchByMarks: " + e.getMessage());
        } finally {
            session.close();
        }
    }
    
    public void removeByRollNo(double roll)
	{
		Session session=StudentConn.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		 try {
		        Query<?> q = session.createQuery("delete from Student where sid = :sid");
		        q.setParameter("sid", roll);
		        int result = q.executeUpdate();
		        tx.commit();

		        if (result > 0) {
		            System.out.println("Student deleted successfully.");
		        } else {
		            System.out.println("No student found with sid: " + roll);
		        }
		    } catch (Exception e) {
		        tx.rollback();
		        System.out.println("Error while deleting: " + e.getMessage());
		    } finally {
		        session.close();
		    }
 
		
		
	}
    
    @Override
    public void updateNameById(int id, String name) {
        Session session = StudentConn.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery("update Student set sname = :name where sid = :id");
            query.setParameter("name", name);
            query.setParameter("id", id);
            int result = query.executeUpdate();
            tx.commit();

            if (result > 0) {
                System.out.println("Student name updated successfully.");
            } else {
                System.out.println("No student found with ID: " + id);
            }
        } catch (Exception e) {
            tx.rollback();
            System.out.println("Error while updating: " + e.getMessage());
        } finally {
            session.close();
        }
    }
    
    @Override
    public List<Student> getPaginatedStudents(int pageNumber, int pageSize) {
        Session session = StudentConn.getSessionFactory().openSession();
        List<Student> students = null;
        try {
            Query<Student> query = session.createQuery("from Student", Student.class);
            int start = (pageNumber - 1) * pageSize;
            query.setFirstResult(start);      // Offset
            query.setMaxResults(pageSize);    // Limit

            students = query.list();

            for (Student s : students) {
                System.out.println(s);
            }

        } catch (Exception e) {
            System.out.println("Pagination error: " + e.getMessage());
        } finally {
            session.close();
        }
        return students;
    }
    
}
