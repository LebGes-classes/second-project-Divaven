package com.company;

import java.util.Scanner;

public abstract class Person {
    protected Scanner in = new Scanner(System.in);

    protected String name;

    protected int age;

    protected String sex;

    protected String personId;

    Person() {
        System.out.println("Введите ФИО: ");
        name = in.nextLine();
        System.out.println("Укажите пол: ");
        sex = in.nextLine();
        System.out.println("Сколько вам лет?: ");
        age = in.nextInt();
        System.out.println("Введите ID: ");
        personId = in.nextLine();
    }

    protected abstract void printInfo();
}
