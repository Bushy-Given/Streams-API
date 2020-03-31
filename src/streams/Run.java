package streams;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;

/**
 * Created by Bushy-Netshidaulu
 * on 3/20/2020
 */
public class Run {

    public static void main(String[] args) {

        //print the number of times each character apear on a string
        String str = "bussshyy";
        Map<Character,Long>  map = new HashMap<>();
        str.chars().forEach(c1 -> {
             map.put((char) c1, str.chars().filter(c2 -> c2 == c1).count());
        });
        map.forEach((k,v) -> System.out.print(" "+ k + " = " + v));

        System.out.println( System.lineSeparator() + "---------------better way---------");

        str.chars().mapToObj(Character::toString)
                .collect(Collectors.groupingBy(identity(), counting()))
                .forEach((k,v) -> System.out.print(" "+ k + " = " + v));
    }
}
