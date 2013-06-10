package pl.finsys.domain;

/**
 * (c) 2013 finsys.pl
 * User: jarek
 * Date: 17.04.13
 * Time: 19:36
 */
public class Fruit {
    private final String name;

    public Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
