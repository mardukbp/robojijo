package org.example;


import rf.robson.robotframework.Doc;
import rf.robson.robotframework.Keyword;
import rf.robson.robotframework.RobotLibrary;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Doc(doc="""
Some Java Library
""")
public class JavaLibrary extends RobotLibrary {
    @Keyword(name="Sum list")
    @Doc(doc="Sum the integer numbers in a list")
    public int sumList(int[] nums) {
        return Arrays.stream(nums)
                .sum();
    }

    @Keyword(name="Sum matrix")
    @Doc(doc="Sum the integer numbers in a matrix")
    public int sumMatrix(int[][] nums) {
        return Arrays.stream(nums)
                .map(this::sumList)
                .mapToInt(Integer::intValue)
                .sum();
    }

    @Keyword(name="Double list")
    @Doc(doc="Double each integer number in a list")
    public int[] doubleList(int[] nums) {
        return Arrays.stream(nums)
                        .map(i -> 2*i)
                        .toArray();
    }

    @Keyword(name="Add histograms")
    @Doc(doc="Add two histograms")
    public Map<String, Integer> addHistograms(Map<String, Integer> hist1, Map<String, Integer> hist2) {
         return Stream.of(hist1, hist2)
                 .flatMap(m -> m.entrySet().stream())
                 .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum));
    }

    @Keyword(name="Set Env Vars")
    @Doc(doc="Set the given env vars")
    public void setEnvVars(Map<String, String> envVars) {
        envVars.forEach((name, value) ->
                System.out.printf("%s: %s\n", name, value));
    }

    @Keyword(name="Sum ints")
    @Doc(doc="Sum two integer numbers")
    public int sumInts(int a, int b) {
        return a + b;
    }

    @Keyword(name="Concat strings")
    @Doc(doc="Concatenate two strings")
    public String concat(String a, String b) {
        return a + b;
    }

    @Keyword(name="Concat list")
    @Doc(doc="Concatenate a list of strings using the given delimiter")
    public String concatList(String delimiter, String[] strings) {
        return String.join(delimiter, strings);
    }

    @Keyword(name="Build sentence")
    @Doc(doc="Build a sentence out of a matrix of characters")
    public String buildSentence(String delimiter, String[][] letters) {
        return Arrays.stream(letters)
                .map(letterArr -> String.join("", letterArr))
                .collect(Collectors.joining(delimiter));
    }
}
