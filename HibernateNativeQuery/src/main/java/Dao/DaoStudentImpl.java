package Dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
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
    
	@Override
	public void removeByRollNo(double rno) {
		
Session session=StudentConn.getSessionFactory().openSession();
		
		Transaction txt=session.beginTransaction();
		
		
		NativeQuery<Student> q=session.createNativeQuery("delete from student where sid=:rollno", Student.class);
		q.setParameter("rollno", rno);
		
		
		int r=q.executeUpdate();
		if(r>0)
		{
			System.out.println("Removed");
		
			}
		else
		{
			
			System.out.println("Not Found");
		}	
		txt.commit();
	}
	
	@Override
    public Student getStudentByName(String sname) {
        Session session = StudentConn.getSessionFactory().openSession();
        Student s = null;
        NativeQuery<Student> q=session.createNativeQuery("select from student where sname=:sname", Student.class);
		q.setParameter("sname", sname);
		
		
		int r=q.executeUpdate();
		if(r>0)
		{
			System.out.println("found");
		
			}
		else
		{
			
			System.out.println("Not Found");
		}
        return s;
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
    
    public void updateName(int rollno,String name)
	{
		Session session=StudentConn.getSessionFactory().openSession();
		Transaction txTransaction=session.beginTransaction();
 
		NativeQuery<Student> query=session.createNativeQuery("update Student set name=:name where rollno=:rollno", Student.class);
		query.setParameter("rollno", rollno);
		query.setParameter("name", name);
		int r=query.executeUpdate();
		if(r>0)
		{
			System.out.println("updated");
		}
		else
			{
				System.out.println("not found");
			}
		txTransaction.commit();
	
	   }
    
    @Override
    public List<Student> findAll() {
        Session session = StudentConn.getSessionFactory().openSession();
        List<Student> students = null;
        try {
        	Query<Student> query=session.createNamedQuery("Student.findAll", Student.class);
            students = query.getResultList();
        } catch (Exception e) {
            System.out.println("Error while fetching all students: " + e.getMessage());
        } finally {
            session.close();
        }
        return students;
    }
    
    @Override
	public void removeByRoll(double roll) {
		
Session session=StudentConn.getSessionFactory().openSession();
		
		Transaction txt=session.beginTransaction();
		Query <Student>Q=session.createNamedQuery("Student.removeByRoll");
		Q.setParameter("sid", roll);
		
		
		int r=Q.executeUpdate();
		if(r>0)
		{
			System.out.println("Removed");
		
			}
		else
		{
			
			System.out.println("Not Found");
		}	
		txt.commit();
	}
    
    @Override
    public Student findByName(String sname) {
        Session session = StudentConn.getSessionFactory().openSession();
        Student s = null;
        Query<Student> q=session.createNamedQuery("Student.findByName", Student.class);
		q.setParameter("sname", sname);
		
		
		int r=q.executeUpdate();
		if(r>0)
		{
			System.out.println("found");
		
			}
		else
		{
			
			System.out.println("Not Found");
		}
        return s;
    }
		
}