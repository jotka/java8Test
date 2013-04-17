package pl.agilecoders.streams;

import org.testng.annotations.Test;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toStringJoiner;
import static java.util.stream.Streams.intRange;
import static java.util.stream.Streams.zip;
import static org.fest.assertions.Assertions.assertThat;

/**
 * (c) 2013 agilecoders.pl
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
    public void shoudDoSmt() {
        List<String> nameList1 = asList("Anders", "David", "James", "Jeff", "Joe", "Erik");
        nameList1.stream()
                .map(c -> "Hello! " + c)
                .forEach(System.out::println);
    }
}
