package streams;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bushy-Netshidaulu
 * on 3/20/2020
 */
public class Run {

    public static void main(String[] args) {

        //print the number of times each character apear on a string
        String word = "bussshyy";
        Map<Character,Long>  hashMap = new HashMap<>();
        word.chars().forEach(e -> {
            long count = word.chars().filter(c -> c == e).count();
            hashMap.put((char)e, count);
        });
        hashMap.forEach((k,v) -> System.out.print(v+""+ (char)k ));
    }
}
