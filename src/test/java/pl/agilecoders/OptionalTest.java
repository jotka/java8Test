package pl.agilecoders;

import org.testng.annotations.Test;
import pl.agilecoders.domain.Fruit;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;

/**
 * (c) 2013 agilecoders.pl
 * User: jarek
 * Date: 17.04.13
 * Time: 19:35
 */
public class OptionalTest {

    private List<Fruit> fruits = asList(new Fruit("apple"), new Fruit("grape"), new Fruit("orange"));

    public static Optional<Fruit> find(String name, List<Fruit> fruits) {
        for (Fruit fruit : fruits) {
            if (fruit.getName().equals(name)) {
                return Optional.of(fruit);
            }
        }
        return Optional.empty();
    }


    @Test
    public void shouldTestIsPresent() {
        //when
        Optional<Fruit> found = find("lemon", fruits);

        //then
        assertThat(found.isPresent()).isFalse();
    }

    @Test
    public void shouldFindFruit() {
        //when
        Optional<Fruit> foundApple = find("apple", fruits);

        //then
        assertThat(foundApple.isPresent()).isTrue();

        assertThat(foundApple.get()).isInstanceOf(Fruit.class);
    }

    @Test
    public void shouldNotFindAndReturnKiwi() {
        Fruit kiwi = find("coconut", fruits).orElse(new Fruit("Kiwi"));

        assertThat(kiwi).isInstanceOf(Fruit.class);

        assertThat(kiwi.getName()).isEqualTo("Kiwi");
    }

    @Test
    public void shouldProvideSupplier() {
        Optional<Fruit> found = find("aaaaa", fruits);
        Fruit fruit = found.orElseGet(() -> new Fruit("Lemon"));

        assertThat(fruit.getName()).isEqualTo("Lemon");
    }
}
