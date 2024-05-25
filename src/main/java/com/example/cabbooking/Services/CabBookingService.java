package com.example.cabbooking.Services;

import com.example.cabbooking.Model.User;
import com.example.cabbooking.Model.Driver;
import com.example.cabbooking.Model.Location;
import com.example.cabbooking.Model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CabBookingService {
    private final List<User> users = new ArrayList<>();
    private final List<Driver> drivers = new ArrayList<>();

    public void addUser(String name, String gender, int age) {
        users.add(new User(name, gender, age, null));
    }

    public void addDriver(String name, String gender, int age, String vehicleName, String vehicleNumber, int x, int y) {
        drivers.add(new Driver(name, gender, age, new Vehicle(vehicleName, vehicleNumber), new Location(x, y), true));
    }

    public List<Driver> findRide(String userName, int x, int y) {
        Optional<User> userOpt = users.stream().filter(u -> u.name().equals(userName)).findFirst();
        if (userOpt.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }
        User user = userOpt.get();
        user = new User(user.name(), user.gender(), user.age(), new Location(x, y));
        users.set(users.indexOf(userOpt.get()), user);
        User finalUser = user;
        return drivers.stream()
                .filter(driver -> driver.isAvailable() && calculateDistance(finalUser.location(), driver.currentLocation()) <= 5)
                .collect(Collectors.toList());
    }

    public void chooseRide(String userName, String driverName) {
        User user = users.stream().filter(u -> u.name().equals(userName)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Driver driver = drivers.stream().filter(d -> d.name().equals(driverName)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Driver not found"));
        Driver updatedDriver = new Driver(driver.name(), driver.gender(), driver.age(), driver.vehicle(), driver.currentLocation(), false);
        drivers.set(drivers.indexOf(driver), updatedDriver);
    }

    private double calculateDistance(Location loc1, Location loc2) {
        return Math.sqrt(Math.pow(loc2.x() - loc1.x(), 2) + Math.pow(loc2.y() - loc1.y(), 2));
    }
}
