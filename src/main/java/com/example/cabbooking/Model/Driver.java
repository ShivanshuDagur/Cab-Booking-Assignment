package com.example.cabbooking.Model;

public record Driver(String name, String gender, int age, Vehicle vehicle, Location currentLocation, boolean isAvailable) {
}
