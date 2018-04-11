package lesson11;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<Integer>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
        );

//        Collections.sort(integers, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return -Integer.compare(o1, o2);
//            }
//        });
        Collections.sort(integers, (o1, o2) -> {
            return -Integer.compare(o1, o2);
        });

        integers.forEach(integer -> {
            System.out.println(integer);
        });

        List<Integer> list = new ArrayList<>();
        for (Integer i : integers) {
            if (i > 5) {
                list.add(i);
            }
        }

        List<Integer> list1 = integers.stream()
                .filter(i -> i > 5)
                .collect(Collectors.toList());

        System.out.println(integers.toString());
    }
}
