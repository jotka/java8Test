package pl.finsys.streams;

import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.Comparators.comparing;
import static java.util.stream.Collectors.*;
import static java.util.stream.Streams.intRange;
import static org.fest.assertions.Assertions.assertThat;

/**
 * (c) 2013 finsys.pl
 * User: jarek
 * Date: 17.04.13
 * Time: 20:25
 */
public class StreamsTest {
    @Test
    public void shouldFilter() {
        //given
        String[] names = {"Sam", "Pamela", "Dave", "Pascal", "Erik"};

        //when
        List<String> filteredNames = stream(names)
                .filter(c -> c.contains("am"))
                .collect(toList());

        //then
        assertThat(filteredNames).isNotEmpty();

        assertThat(filteredNames.size()).isEqualTo(2);

        assertThat(filteredNames).contains("Sam");

        assertThat(filteredNames).contains("Pamela");

    }


    @Test
    public void shoudlJoin() {
        List<String> names = asList("Sam", "Pamela", "Dave", "Pascal", "Erik");

        StringJoiner brands = names.stream().collect(toStringJoiner(","));

        assertThat(brands).isEqualTo("Sam,Pamela,Dave,Pascal,Erik");
    }


    /*@Test
    public void shouldDoSmthing() {
        String[] names = {"Sam","Pamela", "Dave", "Pascal", "Erik"};

        List<String> nameList;
        Stream<Integer> indices = intRange(1, names.length).boxed();
        nameList = zip(indices, stream(names), AbstractMap.SimpleEntry::new)
                .filter(e -> e.getValue().length() <= e.getKey())
                .map(Map.Entry::getValue)
                .collect(toList());
    }*/

    @Test
    public void shoudlMapAndPrint() {
        List<String> nameList1 = asList("Anders", "David", "James", "Jeff", "Joe", "Erik");
        nameList1.stream()
                .map(c -> "Hello! " + c)
                .forEach(System.out::println);
    }

    @Test
    public void shoudBox() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        List<Integer> firstFour;
        firstFour = stream(numbers).limit(4)
                .boxed()
                .collect(toList());


    }


    @Test
    public void shouldRange() {
        IntStream multiplesOfEleven = intRange(1, 100).filter(n -> n % 11 == 0);

    }


    @Test
    public void shouldTestByPredicate() {
        String[] names  = { "Sam","Samuel","Dave","Pascal","Erik","Sid" };

        List<String> found = (List<String>) stream(names).collect(partitioningBy( c -> c.startsWith("S"))).get(true);
    }

    @Test
    public void shoudDistinct() {
        String[] songIds = {"Song#1", "Song#2", "Song#2", "Song#2", "Song#3", "Song#1"};
        stream(songIds).distinct();
    }

    @Test
    public void shouldGroupByCriterium() {
        String[] names = {"Sam", "Samuel", "Samu", "Ravi", "Ratna", "Barsha"};

        Map<Integer, List<String>> groups;
        groups = stream(names).collect(groupingBy(String::length));
    }

    @Test
    public void shoudSortByCriterium() {
        String[] friends = { "Sam", "Pamela", "Dave", "Anders", "Erik" };
        friends = stream(friends)
                .sorted( (s1,s2) -> Integer.compare(s1.length(), s2.length()))
                .toArray(String[]::new);
    }


    @Test
    public void shouldSortByMultipleCriteria() {
        String[] fruits = {"grape", "passionfruit", "banana", "apple",
                "orange", "raspberry", "mango", "blueberry"};

        Comparator<String> comparator;
        comparator = comparing((Function<String, Integer>) String::length, Integer::compare)
                .thenComparing((Comparator<String>) String::compareTo);

        fruits = stream(fruits).sorted(comparator)
                .toArray(String[]::new);
    }
}
