package java8;

import java.util.ArrayList;
import java.util.List;

public class Slary1{
    public static void main(String[] args) {
        List<Integer> sal = new ArrayList<>();
        sal.add(40000);
        sal.add(50000);
        sal.add(60000);
        sal.add(30000);
        sal.add(70000);
        sal.stream().map(salary -> salary + (salary * 0.05)).forEach(updated -> System.out.println(updated));
    }
}

