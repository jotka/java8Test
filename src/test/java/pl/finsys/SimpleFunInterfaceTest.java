package pl.finsys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * (c) 2013 finsys.pl
 * User: jarek
 * Date: 30.03.13
 * Time: 20:05
 */
public class SimpleFunInterfaceTest {
    private Logger logger = LoggerFactory.getLogger(SimpleFunInterfaceTest.class);

    public void carryOutWork(SimpleFunctionalInterface sfi) {
        sfi.doWork();
    }

    @Test
    public void usingFunctionalInterface() {

        carryOutWork(new SimpleFunctionalInterface() {
            @Override
            public void doWork() {
                logger.info("Do work in SimpleFun impl...");
            }
        });
    }

    @Test
    public void usingLambda() {
        carryOutWork(() -> logger.info("Do work in lambda exp impl..."));
    }


}
