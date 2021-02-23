package com.JAVA_8;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;
import java.util.stream.Stream.*;

class Course
{
    private String name;
    private String category;
    private int reviewScore, noOfStudents;

    public Course(String n, String category, int review, int number) {
        this.name = n;
        this.category = category;
        this.reviewScore = review;
        this.noOfStudents = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        return name+
                ":"+ reviewScore +
                ":"+ noOfStudents+"\n";
    }
}
public class CustomFunctional {
    public static void main(String[] args) {
        List<Course> listCourse=Arrays.asList(
                new Course("Java","language",98,1050),
                new Course("AWS","Cloud",95,8500),
                new Course("Spring","Framework",93,2000),
                new Course("Full Stack","FullStack",100,2000),
                new Course("Azure","Cloud",98,5000),
                new Course("API","Framework",93,1800),
                new Course("Docker","Cloud",91,6000)
        );
        //all match noneMatch  anyMatch
        Predicate<Course> getCoursePredicateGreaterThan95=
                course -> course.getReviewScore() > 95;
        Predicate<Course> getCoursePredicateLessThan95=
                course -> course.getReviewScore() < 95;
        Predicate<Course> getCoursePredicateAnyLessThan92=
                course -> course.getReviewScore() < 92;
        /*
        System.out.println("all match(greater than 95): "+listCourse.stream()
                .allMatch(getCoursePredicateGreaterThan95));
        //if no element matches the condition, return true else false
        System.out.println("none match(less than 95): "+listCourse.stream()
                .noneMatch(getCoursePredicateLessThan95));
        System.out.println("any match(less than 92): "+listCourse.stream()
                .anyMatch(getCoursePredicateAnyLessThan92));

         */

        //sorting
        Comparator<Course> comparingIncreasingStudents=Comparator
                .comparing(Course::getName);
        //System.out.println("Natural Order:\n"+listCourse.stream()
                //.sorted(comparingIncreasingStudents).collect(Collectors.toList()));

        Comparator<Course> comparingDecreasingStudents=Comparator
                .comparing(Course::getNoOfStudents).reversed();
        //System.out.println("Reversed Order:\n"+listCourse.stream()
          //     .sorted(comparingDecreasingStudents).collect(Collectors.toList()));

        //custom comparator
        Comparator<Course> comparingCustomStudents=Comparator
                .comparing(Course::getNoOfStudents)
                .thenComparing(Course::getReviewScore).reversed();
        //System.out.println("Custom:\n"+listCourse.stream()
               // .sorted(comparingCustomStudents).collect(Collectors.toList()));


        //skip, topfive
        /*System.out.println("Skip 3:\n"+listCourse.stream()
                .skip(3)
                .collect(Collectors.toList()));
        System.out.println("Limit 5:\n"+listCourse.stream()
                .limit(5)
                .collect(Collectors.toList()));



        System.out.println("Max: \n"+listCourse.stream()
                .max(comparingDecreasingStudents));
        System.out.println("Min: \n"+listCourse.stream()
                .min(comparingDecreasingStudents));


        // avg, sum and count
        System.out.println("Sum:: "+
                listCourse.stream()
                .filter(getCoursePredicateGreaterThan95)
                .mapToInt(Course::getNoOfStudents)
                .sum()  //8050
        );

        System.out.println("Average:: "+
                listCourse.stream()
                        .filter(getCoursePredicateGreaterThan95)
                        .mapToInt(Course::getNoOfStudents)
                        .average() //OptionalDouble[2683.3333333333335]
        );

        System.out.println("count:: "+
                listCourse.stream()
                        .filter(getCoursePredicateGreaterThan95)
                        .mapToInt(Course::getNoOfStudents)
                        .count()  //3
        );

        System.out.println("max: "+
                listCourse.stream()
                        .filter(getCoursePredicateGreaterThan95)
                        .mapToInt(Course::getNoOfStudents)
                        .max() //OptionalInt[5000]
        );

         */

        //grouping on some criteria
        System.out.println("Grouping: "+listCourse.stream()
                .collect(Collectors.groupingBy(Course::getCategory)));
        //Grouping: {Cloud=[AWS:95:8500
        //, Azure:98:5000
        //, Docker:91:6000
        //], language=[Java:98:1050
        //], FullStack=[Full Stack:100:2000
        //], Framework=[Spring:93:2000
        //, API:93:1800
        //]}

        System.out.println("Grouping: "+listCourse.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.counting())));
        //Grouping: {Cloud=3, language=1, FullStack=1, Framework=2}

        System.out.println("group by category, maxBy: reviewScore\n"+
                listCourse.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.maxBy(Comparator.comparing(
                                        Course::getReviewScore))))
        );

        System.out.println("group by category, map as list by name\n"+
                listCourse.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.mapping(Course::getName,
                                        Collectors.toList())))
        );
    }
}
