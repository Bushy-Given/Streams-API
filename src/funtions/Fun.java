package funtions;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Bushy-Netshidaulu
 * on 9/19/2020
 */
public class Fun <T>{
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1,2,3,4,5,6);

        int total  = 0;
        for (int e : values){
            total +=  e * 2;
        }
        System.out.println(total);

        int totals = IntStream
                .rangeClosed(1, 6)
                .map(e -> e * 2)
                .sum();

        final Integer integer = Stream
                .iterate(1, e -> e + 1)
                .map(e1 -> e1 * 2)
                .limit(6)
                .reduce(0, Integer::sum);

        System.out.println(totals);
        System.out.println(integer);
    }

}
