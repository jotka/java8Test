package pl.agilecoders;

import org.testng.annotations.Test;
import pl.agilecoders.domain.Fruit;

import java.util.Comparators;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.Fail.fail;

/**
 * (c) 2013 agilecoders.pl
 * User: jarek
 * Date: 17.04.13
 * Time: 20:05
 */
public class OptionalsAndStreams {

    public static final String GRAPE = "grape";
    public static final String APPLE = "apple";

    /*@Test
    public void shouldGiveLast() {
        Stream<Fruit> fruits = asList(new Fruit(APPLE), new Fruit(GRAPE)).stream();

        Optional<Fruit> max = fruits.max(Comparators.comparing(Fruit::getName));
        if(max.isPresent()) {
            Fruit fruit = max.get();
            assertThat(fruit.getName()).isEqualTo(GRAPE);
        }

        else fail("should've find grape.");
    }*/

    @Test
    public void shouldFindFirst() {
        Stream<Fruit> fruits = asList(new Fruit(APPLE), new Fruit(GRAPE)).stream();
        Optional<Fruit> first = fruits.findFirst();
        if(first.isPresent()) {
            Fruit firstFruit = first.get();
            assertThat(firstFruit.getName()).isEqualTo(APPLE);
        }
        else fail("should've find apple.");
    }
}
