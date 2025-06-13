package java8;

import java.util.Arrays;

public class Salary {
    public static void main(String[] args) {
        int[] salaries= {3000, 4500, 6000, 8000, 4000, 10000};
        Arrays.stream(salaries).filter(sal -> sal > 5000).forEach(sal -> System.out.println(sal));
    }
}

