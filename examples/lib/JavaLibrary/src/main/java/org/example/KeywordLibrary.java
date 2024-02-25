package org.example;


import io.github.robson.robotframework.Doc;
import io.github.robson.robotframework.Keyword;
import io.github.robson.robotframework.RobotLibrary;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Doc(doc="Some Java Library")
public class KeywordLibrary extends RobotLibrary {

    @Keyword(name="Sum list")
    @Doc(doc="Sum the integer numbers in a list")
    public int sumList(List<Integer> nums) {
        return nums.stream().mapToInt(Integer::intValue).sum();
    }

    @Keyword(name="Double list")
    @Doc(doc="Double each integer number in a list")
    public List<Integer> doubleList(int[] nums) {
        return Arrays.stream(nums)
                .map(i -> 2*i)
                .boxed().collect(Collectors.toList());
    }

    @Keyword(name="Add histograms")
    @Doc(doc="Add two histograms")
    public Map<String, Integer> addHistograms(Map<String, Integer> hist1, Map<String, Integer> hist2) {
        return Stream.of(hist1, hist2).flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum));
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
}
