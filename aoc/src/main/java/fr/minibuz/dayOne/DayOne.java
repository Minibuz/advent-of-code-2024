package fr.minibuz.dayOne;

import fr.minibuz.utils.FileReader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class DayOne {

    public static void main(String[] args) {
        List<String> fileInput = FileReader.readFile(DayOne.class.getSimpleName());

        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();

        fileInput.forEach(line -> {
            String[] elements = line.split(" {3}");
            firstList.add(Integer.parseInt(elements[0]));
            secondList.add(Integer.parseInt(elements[1]));
        });

        firstList.sort(Integer::compareTo);
        secondList.sort(Integer::compareTo);

        long resultPartOne = LongStream.range(0, firstList.size())
                .map(i -> {
                    var e1 = firstList.get((int) i);
                    var e2 = secondList.get((int)i);
                    return Math.abs(e1 - e2);
                })
                .sum();

        System.out.println("Part one : " + resultPartOne);

        long resultPartTwo = LongStream.range(0, firstList.size())
                .map(i -> {
                    var e1 = firstList.get((int) i);
                    var appearance = secondList.stream().filter(e -> e.equals(e1))
                            .count();
                    return e1 * appearance;
                }).sum();

        System.out.println("Part two : " + resultPartTwo);
    }
}
