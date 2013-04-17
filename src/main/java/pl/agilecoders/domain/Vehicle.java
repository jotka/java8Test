package pl.agilecoders.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * (c) 2013 agilecoders.pl
 * User: jarek
 * Date: 02.04.13
 * Time: 13:01
 */
public class Vehicle {
    protected Logger logger = LoggerFactory.getLogger(Vehicle.class);

    public void drive() {
        logger.info("Driving vehicle ...");
    }
}
