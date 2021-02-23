package com.JAVA_8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileUsingFP {
    public static void main(String[] ar) throws IOException {
//        Files.lines(Paths.get("src/com/JAVA_8/textFile.txt"))
//                .forEach(System.out::println);
        //distinct words
//        Files.lines(Paths.get("src/com/JAVA_8/textFile.txt"))
//                .map(str->str.split(" "))
//                .flatMap(Arrays::stream)
//                .distinct()
//                .sorted()
//                .forEach(System.out::println);

        //file
//        Files.list(Paths.get("."))
//                .forEach(System.out::println);

        //directory
        Files.list(Paths.get("."))
                .filter(Files::isDirectory)
                .forEach(System.out::println);

    }
}
