package pl.agilecoders;

/**
 * (c) 2013 agilecoders.pl
 * User: jarek
 * Date: 30.03.13
 * Time: 20:07
 */

@FunctionalInterface
public interface ComplexFunctionalInterface extends SimpleFunctionalInterface {
    default public void doSomeWork() {
        System.out.println("Doing some work in interface impl...");
    }

    default public void doSomeOtherWork() {
        System.out.println("Doing some other work in interface impl...");
    }
}
