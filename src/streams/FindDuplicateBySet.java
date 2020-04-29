package streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Bushy-Netshidaulu
 * on 4/29/2020
 */
public class FindDuplicateBySet {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);

        System.out.println(findDuplicateBySetAdd(list));
        System.out.println(findDuplicateByFrequency(list));
        System.out.println(findDuplicateByGrouping(list));

    }
    public static <T>Set<T> findDuplicateBySetAdd(List<T> list){

        Set<T> items = new HashSet<>();
        return list.stream()
                .filter(n->!items.add(n)) //Set.add() returns false if the element was already in the set.
                .collect(Collectors.toSet());
    }

    public static <T> Set<T> findDuplicateByFrequency(List<T> list) {

        return list.stream()
                .filter(i -> Collections.frequency(list, i) > 1)
                .collect(Collectors.toSet());

    }

    public static <T> Set<T> findDuplicateByGrouping(List<T> list) {

        return list.stream()
                .collect(Collectors.groupingBy(Function.identity()
                        , Collectors.counting()))    // create a map {1=1, 2=1, 3=2, 4=2, 5=1, 7=1, 9=2}
                .entrySet().stream()                 // Map -> Stream
                .filter(m -> m.getValue() > 1)       // if map value > 1, duplicate element
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

    }

}
