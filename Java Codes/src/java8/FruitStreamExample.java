//usage of Stream API in array list
package java8;
import java.util.Arrays;
public class FruitStreamExample {
    public static void main(String[] args) {
        String[] fruits = {"Apple", "Banana","Mango"};

        Arrays.stream(fruits).forEach(fruit -> System.out.println(fruit));
    }
}

