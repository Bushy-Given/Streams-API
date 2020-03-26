package funtions;

import java.util.function.*;

/**
 * Created by Bushy-Netshidaulu
 * on 3/26/2020
 */
public class _Funtions {
    public static void main(String[] args) {
       //get length of a string
        Integer l = length.apply("bushy");
        System.out.println("length : " + l);
        //print a string
        print.accept("bushy");
        divide.apply(5);
        String bushy = uOut.apply("bushy");
        System.out.println(bushy);
        biOut.apply("bushy","netshidaulu");
        biFunction.apply("Yes",5L);
    }
    //a funtion accept one argument and have a return typ
    //<input , output>
    public static Function<String,Integer> length = str -> str.length();

    //consumer->consumes/or take one input and return a void /not return anything
    public static Consumer<String> print = str->{
        str.concat("printing....");
        System.out.println(str);
    };

    // IntFunction accept in as inout and specify return typ
    public static IntFunction<Double> divide = i -> i/2.0;

    //unaryoperator takes a single input and produce the output of the same type
    public static UnaryOperator<String> uOut = i->i.toUpperCase();

    //Binaryoperator takes a 2 input args and produce the output of the same type
    public static BinaryOperator<String> biOut = (a, b)-> a.concat(b);

    //biFunction takes 2input args and produces an output of specified return type
    public static BiFunction<String,Long,String> biFunction  = (str, n)-> str + n;

}
