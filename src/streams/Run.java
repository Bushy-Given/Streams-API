package streams;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
                IntPredicate p = c2 -> c2 == c1;
                map.put((char) c1, str.chars().filter(p::test).count());
        });
        map.forEach((k,v) -> System.out.print(v + "" + k ));

        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) sb.append(c).append(",");
        Map<String, Long> mapped = Stream.of(sb.toString().split(","))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(mapped);
    }
}
