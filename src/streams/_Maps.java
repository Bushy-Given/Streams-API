package streams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Bushy-Netshidaulu
 * on 4/17/2020
 */
public class _Maps {

    final static String PAUSED = "paused";
    public static void main(String[] args) {

        Map<Long,String> map = new HashMap<>();
        map.put(1L,"ZBI_paused,naedo_");
        map.put(2L,"naedohost_paused,zrv_,zbi_,cb_");
        map.put(3L,"pacs_,zob_,zrv_,cb_");

        Map<Boolean, List<String>> isPaused =
        map.values().parallelStream()
                .flatMap(v-> {
                    Predicate<String> isEmpty = String::isEmpty;
                    return Stream.of(v.split(",")).filter(isEmpty.negate());
                })
                .collect(Collectors.partitioningBy(p->p.toLowerCase().endsWith(PAUSED)));

        List<String> paused = isPaused.get(true);
        List<String> unPaused = isPaused.get(false);

        System.out.println("paused : " + paused);
        System.out.println("unPaused : " + unPaused);

        String product;
        if (false) {
            //pausing
            product = unPaused.stream().collect(Collectors.joining(PAUSED.concat(","))).concat(PAUSED);
        }
        else {
            //unpausung
            product = paused.stream().map(p->p.replace(PAUSED,"")).collect(Collectors.joining(","));
        }
        System.out.println("product :" + product);

    }
}
