package demoMaven.mavenSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Student s1 = (Student) context.getBean("s1");
        System.out.println("Injected Student bean:");
        System.out.println(s1);
    }
}
