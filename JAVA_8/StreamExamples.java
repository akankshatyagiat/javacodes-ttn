package com.JAVA_8;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.*;

public class StreamExamples {
    public static void main(String[] args){
        //Stream.of(12,9,13,4,6,2,4,12,15); // wrapper class
        //count
        //System.out.println("count:: "+Stream.of(12,9,13,4,6,2,4,12,15).count());
        //sum
        //System.out.println("Sum:: "+Stream.of(12,9,13,4,6,2,4,12,15).reduce(
                //0,Integer::sum ));

        //primitive types stream
//        System.out.println("Primitive types:: ");
//        int[] numArr={12,9,13,4,6,2,4,12,15};
//        System.out.println("Stream:: "+Arrays.stream(numArr));
//        System.out.println("Count:: "+Arrays.stream(numArr).count());
//        System.out.println("Sum:: "+Arrays.stream(numArr).sum());
//        System.out.println("average:: "+Arrays.stream(numArr).average());
//        System.out.println("min:: "+Arrays.stream(numArr).min());
//        System.out.println("max:: "+Arrays.stream(numArr).max());
        //intStreamFunction();
        mapToBigInteger();
    }
    static void mapToBigInteger() {
        //very long value
        System.out.println("factorial upto 50: " +
                LongStream.rangeClosed(1, 50)
                        .reduce(1, (x, y) -> x * y));
        //-3258495067890909184

        System.out.println("mapping to object:"+
                "factorial upto 50:\n" +
                LongStream.rangeClosed(1, 50)
                        .mapToObj(BigInteger::valueOf)
                        .reduce(BigInteger.ONE,
                                BigInteger::multiply));
        //30414093201713378043612608166064768844377641568960512000000000000
    }
    public  static void intStreamFunction() {
        //IntStream.range(1,10)
          //      .forEach(System.out::println);
        System.out.println("sum: "+IntStream.rangeClosed(1,10).sum());
//        System.out.println("sum: "+IntStream.iterate(2,e->e+2)
//                .limit(10)
//                .peek(System.out::println)
//                .sum());
//        System.out.println("power of 2:: "+IntStream.iterate(2,e->e*2)
//                .limit(10)
//                .peek(System.out::println)
//                .sum());

        //boxing and then storing in the list
        System.out.println("storing in the list:: "+
                IntStream.iterate(2,e->e*2)
                .limit(10)
                .boxed()
                .collect(Collectors.toList())
        );

    }
}
