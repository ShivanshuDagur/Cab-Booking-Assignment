package com.example.cabbooking.Services;

import com.example.cabbooking.Model.Driver;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CabBookingServiceTest {

    private final CabBookingService service = new CabBookingService();

    @Test
    void testAddUser() {
        service.addUser("John", "M", 25);
        service.addDriver("Driver1", "M", 30, "Car", "123", 0, 0);
        List<Driver> drivers = service.findRide("John", 0, 0);
        assertFalse(drivers.isEmpty());
    }

    @Test
    void testAddDriver() {
        service.addUser("John", "M", 25);
        service.addDriver("Driver1", "M", 30, "Car", "123", 2, 2);
        List<Driver> drivers = service.findRide("John", 0, 0);
        assertFalse(drivers.isEmpty());
    }

    @Test
    void testFindRide() {
        service.addUser("John", "M", 25);
        service.addDriver("Driver1", "M", 30, "Car", "123", 0, 0);
        List<Driver> drivers = service.findRide("John", 0, 0);
        assertFalse(drivers.isEmpty());
    }

    @Test
    void testChooseRide() {
        service.addUser("John", "M", 25);
        service.addDriver("Driver1", "M", 30, "Car", "123", 0, 0);
        service.chooseRide("John", "Driver1");
        List<Driver> drivers = service.findRide("John", 0, 0);
        assertTrue(drivers.isEmpty());
    }
}
