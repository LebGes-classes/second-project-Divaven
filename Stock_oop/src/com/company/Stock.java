package com.company;

import java.util.Scanner;

public abstract class Stock {
    protected Scanner in = new Scanner(System.in);
    protected int capacity;

    protected String address;

    protected String productName;

    protected String productFreshness;

    protected double price;

    protected String description;

    protected String size;

    Stock() {
        System.out.println("Вместимость помещения: ");
        capacity = in.nextInt();
        in.nextLine();
        System.out.println("Адрес помещения: ");
        address = in.nextLine();
    }

    protected abstract void transfer();
    protected abstract void remove();
    protected abstract void printInfo();

}
