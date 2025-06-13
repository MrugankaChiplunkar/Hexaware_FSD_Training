package com.Maven.Hibernate.HibernateMVC1;

import Service.StudentService;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        Scanner sc = new Scanner(System.in);
//
//        // Search student by name
//        System.out.print("Enter name to search: ");
//        String name = sc.nextLine();
//        service.searchByNameService(name);
//
//        // Search student by name and marks
//        System.out.print("\nEnter name to search with marks: ");
//        String nm = sc.nextLine();
//        System.out.print("Enter marks: ");
//        double mk = sc.nextDouble();
//   
        
        //remove roll no
//       /service.removeByRollNo();
//        service.updateStudentName(); 
        service.showPaginatedStudents();
        

        sc.close();
    }
}
