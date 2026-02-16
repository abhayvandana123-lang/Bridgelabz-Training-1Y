package com.gla;

class Book {

    String title;
    String author;
    double price;

    Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
}

public class Main {
    public static void main(String[] args) {

        Book b1 = new Book();
        System.out.println(b1.title);
        System.out.println(b1.author);
        System.out.println(b1.price);

        Book b2 = new Book("Java Programming", "James Gosling", 499.99);
        System.out.println(b2.title);
        System.out.println(b2.author);
        System.out.println(b2.price);
    }
}
