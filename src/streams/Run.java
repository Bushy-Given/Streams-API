package streams;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntPredicate;

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
                map.put((char) c1, str.chars().filter(p).count());
        });
        map.forEach((k,v) -> System.out.print(v + "" + k ));
    }
}
