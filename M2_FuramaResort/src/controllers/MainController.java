package controllers;

import commons.CsvFile;
import models.*;
import commons.IData;
import services.IPerson;
import services.IService;
import services.impl.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class MainController {
    static Scanner input = new Scanner(System.in);
    static IService houseServiceImpl = new HouseServiceImpl();
    static IService villaServiceImpl = new VillaServiceImpl();
    static IService roomServiceImpl = new RoomServiceImpl();
    static IPerson customerAddImpl = new CustomerAddImpl();
    public static void displayMainMenu() {
        System.out.println("------------------------------------------------------------");
        System.out.println(
                "1. Add New Services\n" +
                "2. Show Services\n" +
                "3. Add New Customer\n" +
                "4. Show Information of Customer\n" +
                "5. Add New Booking\n" +
                "6. Show Information of Employee\n" +
                "7. Exit");
        System.out.print("Select your number: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                addNewService();
                break;
            case 2:
                showService();
                break;
            case 3:
                addNewCustomer();
                break;
            case 4:
                System.out.println("doooo");
                showInfoCustomer();
                break;
            case 5:
                showBooking();
                break;
            case 6:
            case 7:
                System.exit(0);
        }
    }

    private static void showInfoCustomer() {
        List<IData> customerList =  CsvFile.read(new Customer());
        customerList.sort(new NameComparator());
        for (IData customer : customerList) {
            Customer customer1 = (Customer) customer;
            customer1.showInfo();
        }
    }

    private static void addNewCustomer() {
        CsvFile.write(customerAddImpl.add());
    }

    private static void showBooking() {
        System.out.println("------------------------------------------------------------");
        System.out.println(
                "1. Booking Villa\n" +
                "2. Booking House\n" +
                "3. Booking Room\n" +
                "4. Back To Menu\n" +
                "5. Exit");
        System.out.print("Select your number: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
            case 2:
            case 3:
            case 4:
                return;
            case 5:
                System.exit(0);

        }

    }

    private static void showService() {
        System.out.println("------------------------------------------------------------");
        System.out.println(
                "1. Show all Villa\n" +
                "2. Show all House\n" +
                "3. Show all Room\n" +
                "4. Show All Name Villa Not Duplicate\n" +
                "5. Show All Name House Not Duplicate\n" +
                "6. Show All Name Room Not Duplicate\n" +
                "7. Back To Menu\n" +
                "8. Exit");
        System.out.print("Select your number: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                showAll(CsvFile.read(new Villa()));
                return;
            case 2:
                showAll(CsvFile.read(new House()));
                return;
            case 3:
                showAll(CsvFile.read(new Room()));
                return;
            case 4:
            case 5:
            case 6:
            case 7:
                return;
            case 8:
                System.exit(0);

        }
    }

    private static void showAll(List<IData> service) {
        for (IData s: service) {
            s.showInfo();
        }
    }

    public static void addNewService() {
        System.out.println("------------------------------------------------------------");
        System.out.println(
                "1. Add New Villa\n" +
                "2. Add New House\n" +
                "3. Add New Room\n" +
                "4. Back to Menu\n" +
                "5. Exit");
        System.out.print("Select your number: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                CsvFile.write(villaServiceImpl.add());
                return;
            case 2:
                CsvFile.write(houseServiceImpl.add());
                return;
            case 3:
                CsvFile.write(roomServiceImpl.add());
                return;
            case 4:
                return;
            case 5:
                System.exit(0);
        }
    }
}
