package pl.agilecoders.domain;

/**
 * (c) 2013 agilecoders.pl
 * User: jarek
 * Date: 02.04.13
 * Time: 13:02
 */
public class Car extends Vehicle {
    @Override
    public void drive() {
        logger.info("Driving car...");
    }
}
