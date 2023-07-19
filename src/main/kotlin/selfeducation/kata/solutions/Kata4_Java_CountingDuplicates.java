package selfeducation.kata.solutions;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Kata4_Java_CountingDuplicates {

    public static void main(String[] args) {
        System.out.println(duplicateCount("qwwqwe"));
    }


    public static int duplicateCount(String text) {
        return (int) Arrays.stream(text.toLowerCase().split("")).collect(Collectors.groupingBy(el -> el)).values().stream().filter(x -> x.size() > 1).count();
    }
}
