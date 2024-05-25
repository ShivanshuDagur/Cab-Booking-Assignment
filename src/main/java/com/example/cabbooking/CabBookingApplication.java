package com.example.cabbooking;

import com.example.cabbooking.Services.CabBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CabBookingApplication implements CommandLineRunner {
        @Autowired
        private CabBookingService cabBookingService;

        public static void main(String[] args) {
            SpringApplication.run(CabBookingApplication.class, args);
        }

        @Override
        public void run(String... args) {
            // Onboard Users
            cabBookingService.addUser("Abhishek", "M", 23);
            cabBookingService.addUser("Rahul", "M", 29);
            cabBookingService.addUser("Nandini", "F", 22);

            // Onboard Drivers
            cabBookingService.addDriver("Driver1", "M", 22, "Swift", "KA-01-12345", 101, 101);
            cabBookingService.addDriver("Driver2", "M", 29, "Swift", "KA-01-12345", 110, 110);
            cabBookingService.addDriver("Driver3", "M", 24, "Swift", "KA-01-12345", 53, 53);

            // Find Rides
            System.out.println(cabBookingService.findRide("Abhishek", 0, 0)); // No ride found
            System.out.println(cabBookingService.findRide("Rahul", 100, 100)); // Driver1 found
            System.out.println(cabBookingService.findRide("Nandini", 150, 150)); // No ride found

            // Choose Ride
            cabBookingService.chooseRide("Rahul", "Driver1");

            // Verify Driver1 is no longer available
            System.out.println(cabBookingService.findRide("Nandini", 100, 100)); // No ride found
        }


}
