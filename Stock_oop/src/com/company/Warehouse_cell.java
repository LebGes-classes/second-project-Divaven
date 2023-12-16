package com.company;

import java.io.*;

public class Warehouse_cell extends Stock {
    @Override
    protected void transfer() {
        File warehousefile = new File("productsWarehouse.txt");
        File new_file = new File("temp_file1.txt");
        File salespointfile = new File("productsSalesPoint.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(warehousefile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(salespointfile, true));
            BufferedWriter temp_file = new BufferedWriter(new FileWriter(new_file));

            String line;
            int position = 0;
            System.out.println("Номер продукта, которого вы хотите передать");
            int product_position = in.nextInt();
            while ((line = reader.readLine()) != null) {
                position++;
                if (product_position == position) {
                    writer.write(line);
                    writer.newLine();
                }
                if (product_position != position) {
                    temp_file.write(line);
                    temp_file.newLine();
                }
            }
            reader.close();
            writer.close();
            temp_file.close();

            warehousefile.delete();
            File WARE = new File("productsWarehouse.txt");
            new_file.renameTo(WARE);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void remove() {
        try {
            File file = new File("productsWarehouse.txt");
            FileWriter file_writer = new FileWriter(file);
            file_writer.write("");
            file_writer.close();
            System.out.println("Вы удалили продукты склада!");
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    @Override
    protected void printInfo() {
        System.out.println("Адрес:" + address + "\nРазмер: " + capacity);
        fileReader_warehouse();
    }

    public void buy() {
        try {
            FileWriter fw = new FileWriter("productsWarehouse.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите название товавра: ");
            System.out.println("(для завершения введите '-1'):");
            int i = 0;
            while (!(productName = reader.readLine()).equalsIgnoreCase("-1")) {
                i++;
                if (i <= capacity) {
                    System.out.println("Введите цену товара: ");
                    price = in.nextInt();
                    in.nextLine();
                    System.out.println("Введите свежесть товара: ");
                    productFreshness = in.nextLine();
                    System.out.println("Введите размер товара: ");
                    size = in.nextLine();
                    System.out.println("Введите описание товара: ");
                    description = in.nextLine();
                    System.out.println("Если хотите закупить еще один товар, напишите:");
                    out.println("[ " + i + ". " + productName + ", Цена: " + price + ", Свежесть: " +
                            productFreshness + ", Размер: " + size + ", Описание: " + description + " ]");
                }
            }
            out.close();
        } catch (IOException e) {
            System.out.println("Error.");
            e.printStackTrace();
        }
    }

    private void fileReader_warehouse() {
        try (FileReader reader = new FileReader("productsWarehouse.txt")) {
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
