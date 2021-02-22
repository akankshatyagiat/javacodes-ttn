package com.JAVA_8;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class MoreAboutFunctional {
    public static void main(String[] args){
        List<Integer> listNumber= Arrays.asList(2,45,71,63,
                4,0,441,11);
        System.out.println(listNumber);
        Predicate <Integer> testEven=x->x%2==0;  //test an input and returns boolean
        // behavioral parameterization
        //List<Integer> doubleNumber=mapAndCreate(listNumber,x->x*2); // 2nd = func interface
        //System.out.println(doubleNumber);

        //bi interfaces   biPredicateImplement(listNumber);
        // biFunctionImplement();
        BiConsumer<String,String> biConsumer=(x,y)-> {  //biConsumer
            System.out.println("BiConsumer example:: "+x+y);
        };
        biConsumer.accept("Akanksha","Tyagi");

    }
    public static void biPredicateImplement(List<Integer> list) {
        BiPredicate<Integer,String> biPredicate=(number,str)->{
            return number<20 && str.length()>5;
        };
        System.out.println(biPredicate.test(15,"akanksha"));
    }

    public static void biFunctionImplement() {  //takes 2 inputs and result 1
        BiFunction<Integer,Integer,String> biFunction=(number1,number2)->{
            return  "Adding two numbers, result::  "+(number1+number2);
        };
        System.out.println(biFunction.apply(15,25));
    }
    public static List<Integer> mapAndCreate(List<Integer> numbers,Function<Integer,Integer> mapperFunc) {
        return numbers.stream()
                .map(mapperFunc)
                .collect(Collectors.toList());
    }
}
