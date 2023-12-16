package com.company;

import java.io.*;

public class Worker extends Person {

    public void insertInfo() {
        System.out.println("ВВЕДИТЕ ДОЛЖНОСТЬ СОТРУДНИКА");
        String job = in.nextLine();
        File cust = new File("workers.txt");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(cust, true));
            bw.write("[ ФИО: " + name + ", Пол: " + sex + ", лет: " + age +
                    ", Id сотрудника: " + personId + ", Должность: " + job + " ]");
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error.");
            e.printStackTrace();
        }

    }

    public void removeWorker() {
        File worker_file = new File("workers.txt");
        File new_file_work = new File("temp_file.txt");
        try {

            BufferedReader readerWORK = new BufferedReader(new FileReader(worker_file));
            BufferedWriter temporWORK = new BufferedWriter(new FileWriter(new_file_work));

            String line;
            int position = 0;
            System.out.println("Введите id сотрудника, которого вы хотите уволить");
            int workID = in.nextInt();
            while ((line = readerWORK.readLine()) != null) {
                position++;
                if (workID != position) {
                    temporWORK.write(line);
                    temporWORK.newLine();
                }
            }
            readerWORK.close();
            temporWORK.close();

            worker_file.delete();
            File worker1 = new File("workers.txt");
            new_file_work.renameTo(worker1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void printInfo() {
        try (FileReader reader = new FileReader("workers.txt")) {
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
