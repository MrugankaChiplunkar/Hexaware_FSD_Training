package java8;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        int[] a = {4, 6, 7, 3, 4, 5, 6, 7};

        List<Integer> seen = new ArrayList<>();
        List<Integer> duplicates = new ArrayList<>();

        for (int num : a) {
            if (seen.contains(num)) {
                if (!duplicates.contains(num)) {
                    duplicates.add(num);
                }
            } else {
                seen.add(num);
            }
        }

        System.out.println(duplicates);
    }
}

