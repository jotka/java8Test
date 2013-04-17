package pl.agilecoders;

import org.testng.annotations.Test;
import pl.agilecoders.domain.Car;
import pl.agilecoders.domain.Vehicle;

import java.util.function.Supplier;

/**
 * (c) 2013 agilecoders.pl
 * User: jarek
 * Date: 02.04.13
 * Time: 13:04
 */
public class SupplierTest {
    private void driveVehicle(Supplier<? extends Vehicle> supplier) {
        Vehicle vehicle = supplier.get();
        vehicle.drive();
    }

    @Test
    public void usingLambda() {
        //Using Lambda expression
        driveVehicle(() -> new Vehicle());
        driveVehicle(() -> new Car());
    }

    @Test
    public void usingMethodExpression() {
        driveVehicle(Vehicle::new);
        driveVehicle(Car::new);
    }
}
