package com.gla;

class HotelBooking {

    String guestName;
    String roomType;
    int nights;

    HotelBooking() {
        guestName = "Guest";
        roomType = "Standard";
        nights = 1;
    }

    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    HotelBooking(HotelBooking h) {
        this.guestName = h.guestName;
        this.roomType = h.roomType;
        this.nights = h.nights;
    }
}

public class Main {
    public static void main(String[] args) {

        HotelBooking h1 = new HotelBooking();
        System.out.println(h1.guestName);
        System.out.println(h1.roomType);
        System.out.println(h1.nights);

        HotelBooking h2 = new HotelBooking("Abhay", "Deluxe", 3);
        System.out.println(h2.guestName);
        System.out.println(h2.roomType);
        System.out.println(h2.nights);

        HotelBooking h3 = new HotelBooking(h2);
        System.out.println(h3.guestName);
        System.out.println(h3.roomType);
        System.out.println(h3.nights);
    }
}
