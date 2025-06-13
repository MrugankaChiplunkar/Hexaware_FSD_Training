package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {
        List<User> Users = new ArrayList<>();

        Users.add(new User(1, "Amit", 50000));
        Users.add(new User(2, "Priya", 60000));
        Users.add(new User(3, "Rahul", 50000));
        Users.add(new User(4, "Sneha", 70000));
        Users.add(new User(5, "Vikram", 40000));
        Users.add(new User(6, "Pooja", 20000));
        Users.add(new User(7, "Rohit", 75000));
        Users.add(new User(8, "Neha", 58000));
        Users.add(new User(9, "Ankit", 54000));
        Users.add(new User(10, "Kiran", 67000));
    List<User> userFilter = Users.stream().filter(u -> u.getSalary() > 50000).collect(Collectors.toList());
     System.out.println(userFilter);
     
     // Filter users whose name starts with 'P' and collect names
  List<User> startP= Users.stream().filter(u -> u.getName().startsWith("P")).collect(Collectors.toList());

     System.out.println("Names starting with 'P':");
     startP.forEach(System.out::println);
     
     // Stream API: get users with salary > 60000
     List<User> highPay = Users.stream()
         .filter(u -> u.getSalary() > 60000)
         .collect(Collectors.toList());
     System.out.println("Users with salary more than 60,000:");
     highPay.forEach(System.out::println);
     
     
  // Get Names of All Users in Uppercase
     List<String> namesInUppercase = Users.stream()
         .map(u -> u.getName().toUpperCase())
         .collect(Collectors.toList());
     System.out.println("Names of all users in uppercase:");
     namesInUppercase.forEach(System.out::println);
     
     
      
     //Create a Map of user IDs and their names using Stream API.
     Map<Integer, String> userMap = Users.stream()
    		    .collect(Collectors.toMap(i -> i.getId(), i -> i.getName()));
    		System.out.println(userMap);


    		System.out.println("Map of User IDs and Names:");
    		userMap.forEach((id, name) -> System.out.println("ID: " + id + ", Name: " + name));
    		
    		//comparison and sorting on the basis of employee salary
    		Collections.sort(Users,(u1,u2)->Integer.compare(u1.getSalary(), u2.getSalary()));         
    	      Users.forEach((e)-> System.out.println(e.toString()));
     
    	      
    	      //max salary
    	      System.out.println(Users.stream().max((u1,u2)-> Double.compare(u1.getSalary(),u2.getSalary())));
    	      
    	      //min salary
    	      System.out.println(Users.stream().min((u1,u2)-> Double.compare(u1.getSalary(),u2.getSalary())));
    	      
    	      //get name of employee and display their salary
    	      Scanner sc = new Scanner(System.in);
    	      System.out.print("Enter employee name: ");
    	      String name = sc.nextLine();
    	      Users.stream()
    	          .filter(u -> u.getName().equals(name)).forEach((user)->System.out.println(user.getSalary()));
    	          
 }

    }

