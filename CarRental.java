package com.gla;

class CarRental {

    String customerName;
    String carModel;
    int rentalDays;
    double costPerDay;
    double totalCost;

    CarRental() {
        customerName = "Customer";
        carModel = "Standard";
        rentalDays = 1;
        costPerDay = 1000;
        totalCost = rentalDays * costPerDay;
    }

    CarRental(String customerName, String carModel, int rentalDays, double costPerDay) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.costPerDay = costPerDay;
        this.totalCost = rentalDays * costPerDay;
    }
}

public class Main {
    public static void main(String[] args) {

        CarRental c1 = new CarRental();
        System.out.println(c1.customerName);
        System.out.println(c1.carModel);
        System.out.println(c1.rentalDays);
        System.out.println(c1.totalCost);

        CarRental c2 = new CarRental("Abhay", "SUV", 3, 2000);
        System.out.println(c2.customerName);
        System.out.println(c2.carModel);
        System.out.println(c2.rentalDays);
        System.out.println(c2.totalCost);
    }
}
