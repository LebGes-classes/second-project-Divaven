package com.company;

import java.io.*;

public class Buyer extends Person {

    public void insertInfo() {
        File cust = new File("buyer.txt");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(cust, true));
            bw.write("{ ФИО: " + name + ", Пол: " + sex + ", лет: " + age +
                    ", Id сотрудника: " + personId + " }");
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error.");
            e.printStackTrace();
        }
    }

    @Override
    protected void printInfo() {
        try (FileReader reader = new FileReader("buyer.txt")) {
            int x;
            while ((x = reader.read()) != -1) {
                System.out.print((char) x);
            }
            System.out.println();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
