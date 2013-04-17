package pl.agilecoders.streams;

import org.testng.annotations.Test;

import java.util.List;
import java.util.StringJoiner;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toStringJoiner;
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
}
