package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nМЕНЮ:");
            System.out.println("1. СОЗДАТЬ СКЛАД");
            System.out.println("2. СОЗДАТЬ ПУНКТ ПРОДАЖ");
            System.out.println("3. СОТРУДНИКИ");
            System.out.println("4. ПОКУПАТЕЛИ");
            System.out.println("0. Выход");
            System.out.println("Ваш выбор: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    Warehouse_cell warehouse = new Warehouse_cell();
                    int choice1;
                    do {
                        System.out.println("\nВЫБЕРИТЕ ОПЕРАЦИЮ СО СКЛАДОМ");
                        System.out.println("1. КУПИТЬ ТОВАРЫ НА СКЛАД");
                        System.out.println("2. ПЕРЕДАТЬ ТОВАР НА ПУНКТ ПРОДАЖ");
                        System.out.println("3. УДАЛИТЬ СКЛАД");
                        System.out.println("4. ИНФОРМАЦИЯ О СКЛАДЕ");
                        System.out.println("0. ВЕРНУТЬСЯ В МЕНЮ");
                        choice1 = scan.nextInt();
                        switch (choice1) {
                            case 1:
                                warehouse.buy();
                                break;
                            case 2:
                                warehouse.printInfo();
                                warehouse.transfer();
                                break;
                            case 3:
                                warehouse.remove();
                                break;
                            case 4:
                                warehouse.printInfo();
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Некорректный ответ.");
                        }
                    } while (choice1 != 0);
                    break;
                case 2:
                    Sales_point salespoint = new Sales_point();
                    int choice2;
                    do {
                        System.out.println("1. ПРОДАТЬ ТОВАР");
                        System.out.println("2. ПЕРЕДАТЬ ТОВАР НА СКЛАД");
                        System.out.println("3. УДАЛИТЬ ПУНКТ ПРОДАЖ.");
                        System.out.println("4. ИНФОРМАЦИЯ О ПУНКТЕ ПРОДАЖ");
                        System.out.println("0. ВЕРНУТЬСЯ В МЕНЮ");
                        System.out.println("ВЫБЕРИТЕ ОПЕРЦИЮ");
                        choice2 = scan.nextInt();
                        switch (choice2) {
                            case 1:
                                salespoint.printInfo();
                                salespoint.sell();
                                break;
                            case 2:
                                salespoint.printInfo();
                                salespoint.transfer();
                                break;
                            case 3:
                                salespoint.remove();
                                break;
                            case 4:
                                salespoint.printInfo();
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Некорректный ответ.");
                        }
                    } while (choice2 != 0);
                    break;
                case 3:
                    int choice3;
                    do {
                        Worker wor = new Worker();
                        System.out.println("ХОТИТЕ ЛИ ВЫ НАНЯТЬ ЕГО? 1 Если да, 2 - иначе");
                        choice3 = scan.nextInt();
                        switch (choice3) {
                            case 1:
                                wor.insertInfo();
                                int tempChoice;
                                do {
                                    System.out.println("1. УВОЛИТЬ СОТРУДНИКА");
                                    System.out.println("2. ИНФОРМАЦИЯ О СОТРУДНИКАХ");
                                    System.out.println("0. ВЫХОД");
                                    tempChoice = scan.nextInt();
                                    switch (tempChoice) {
                                        case 1:
                                            wor.printInfo();
                                            wor.removeWorker();
                                            break;
                                        case 2:
                                            wor.printInfo();
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.println("Некорректный ответ.");
                                    }
                                } while (tempChoice != 0);
                                break;
                            case 2:
                                break;
                            default:
                                System.out.println("Некорректный ответ.");
                        }
                    } while (choice3 != 2);
                    break;
                case 4:
                    int choice4;
                    do {
                        System.out.println("НОВЫЙ ПОКУПАТЕЛЬ: ");
                        Buyer buyer = new Buyer();
                        System.out.println("ВВЕСТИ ДАННЫЕ ПОКУПАТЕЛЯ В СИСТЕМУ? 1 Если да, 2 - иначе");
                        choice4 = scan.nextInt();
                        switch (choice4) {
                            case 1:
                                buyer.insertInfo();
                                int choicetemp10;
                                do {
                                    System.out.println("УЗНАТЬ ИНФОРМАЦИЮ О ПОКУПАТЕЛЕ? 1 Если да, 2 - иначе");
                                    choicetemp10 = scan.nextInt();
                                    switch (choicetemp10) {
                                        case 1:
                                            buyer.printInfo();
                                            break;
                                        case 2:
                                            break;
                                        default:
                                            System.out.println("Некорректный ответ.");
                                    }
                                } while (choicetemp10 != 2);
                                break;
                            case 2:
                                break;
                            default:
                                System.out.println("Некорректный ответ.");
                        }
                    } while (choice4 != 2);
                    break;
                case 0:
                    System.out.println("Программа завершилась.");
                    break;
                default:
                    System.out.println("Некорректный ответ.");
            }

        } while (choice != 0);

        scan.close();
    }
}
