package com.JAVA_8;

import java.util.*;

public class MethodReferences {
    public static void main(String[] args)
    {
        List<String> listCourses= Arrays.asList("Spring","SpringBoot",
                "API", "java","c#","Javascript","Azure");
        listCourses.stream()
                //method reference
                .map(str->str.toUpperCase())
                //method reference to string class method
                //.map(String::toUpperCase)
                //.reduce(0,MethodReferences::aRandomMethod)
                .forEach(System.out::println);
    }

    private static String aRandomMethod(String s, String s1) {
    return s+s1;
    }
}
