# Cab Booking Application

## Description

This is a simple cab booking application built with Java 17 and Spring Boot. The application allows users to book rides on a specified route. It includes functionalities for user and driver onboarding, finding available rides, and selecting rides based on proximity.

## Features

- **User Registration**: Users can register themselves.
- **Driver Onboarding**: Drivers can onboard the system with their vehicle details and current location.
- **Find Rides**: Users can search and select rides based on the nearest available drivers to their location.

## Requirements

- **Java 17**
- **Maven**
- **Spring Boot**

## Setup

1. **Clone the repository**:
   ```bash
   git clone https://github.com/ShivanshuDagur/Cab-Booking-Assignment.git
   cd cabbooking
   ```

2. **Build the project**:
   ```bash
   mvn clean install
   ```

3. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

## Usage

### Adding Users

To add a user, use the following endpoint:

```http
POST /users
{
    "name": "John",
    "gender": "M",
    "age": 25
}
```

### Adding Drivers

To add a driver, use the following endpoint:

```http
POST /drivers
{
    "name": "Driver1",
    "gender": "M",
    "age": 30,
    "vehicleName": "Car",
    "vehicleNumber": "123",
    "x": 10,
    "y": 10
}
```

### Finding Rides

To find available rides for a user:

```http
GET /rides?userName=John&x=0&y=0
```

### Choosing a Ride

To choose a ride from the available options:

```http
POST /chooseRide
{
    "userName": "John",
    "driverName": "Driver1"
}
```

## Project Structure

- **src/main/java**: Contains the application code.
  - **model**: Contains the data models (`User`, `Driver`, `Location`, `Vehicle`).
  - **service**: Contains the service classes (`CabBookingService`).
  - **CabBookingApplication**: The main application class.

- **src/test/java**: Contains the test code.
  - **service**: Contains the test classes for services (`CabBookingServiceTest`).

## Running Tests

To run the tests, use the following command:

```bash
mvn test
```
