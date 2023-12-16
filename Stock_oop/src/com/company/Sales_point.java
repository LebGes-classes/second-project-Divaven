package com.company;

import java.io.*;

    public class Sales_point extends Stock {
    public void sell() {
        String temp = "temp.txt";
        File old_file = new File("productsSalesPoint.txt");
        File new_file = new File(temp);

        int pos = 0;
        String this_line;
        System.out.println("Какой номер позиции у продукта который вы хотели продать");
        int delete_pos = in.nextInt();
        try {
            FileWriter fw = new FileWriter(temp, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader("productsSalesPoint.txt");
            BufferedReader br = new BufferedReader(fr);

            while ((this_line = br.readLine()) != null) {
                pos++;
                if (delete_pos != pos) {
                    pw.println(this_line);
                }
            }

            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();

            old_file.delete();
            File dump = new File("productsSalesPoint.txt");
            new_file.renameTo(dump);
            System.out.println("Вы успешно продали продукт на " + delete_pos + " позиции");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    @Override
    protected void transfer() {
        File salespointfile = new File("productsSalesPoint.txt");
        File newfileSALES = new File("temp_file3.txt");

        File warehousefile = new File("productsWarehouse.txt");
        try {

            BufferedReader r_sales = new BufferedReader(new FileReader(salespointfile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(warehousefile, true));
            BufferedWriter temp_sales = new BufferedWriter(new FileWriter(newfileSALES));

            String line;
            int position = 0;
            System.out.println("Введите номер продукта, которого вы хотите передать");
            int productPos = in.nextInt();
            while ((line = r_sales.readLine()) != null) {
                position++;
                if (productPos == position) {
                    writer.write(line);
                    writer.newLine();
                }
                if (productPos != position) {
                    temp_sales.write(line);
                    temp_sales.newLine();
                }
            }
            // Закрываем потоки
            r_sales.close();
            writer.close();
            temp_sales.close();

            salespointfile.delete();
            File SALES = new File("productsSalesPoint.txt");
            newfileSALES.renameTo(SALES);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void remove() {
        try {
            File file = new File("productsSalesPoint.txt");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("");
            fileWriter.close();
            System.out.println("Вы удалили пункт продаж!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    protected void printInfo() {
        System.out.println("Адрес:" + address + "\nВместимость: " + capacity);
        fileReader_salespoint();
    }

    public void fileReader_salespoint() {
        try (FileReader reader = new FileReader("productsSalesPoint.txt")) {
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
