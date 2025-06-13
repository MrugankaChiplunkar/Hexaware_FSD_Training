package java8;
import java.util.Arrays;

public class TrimUsers {
    public static void main(String[] args) {
        String users[] = {"asha  ", "  pooja", "kavita", " deepa "};

        // Trim each name and print it
        Arrays.stream(users)
              .map(String::trim)
              .forEach(System.out::println);
    }
}



String users[]= {"ABC ","  XYZ", "  PQR"};
Arrays.stream(users).forEach((user)->System.out.println(user.trim()));