package controllers;

import commons.CsvFile;
import services.impl.*;

import java.util.Scanner;

public class MainController {
    static Scanner input = new Scanner(System.in);
    static HouseServiceImpl houseServiceImpl = new HouseServiceImpl();
    static VillaServiceImpl villaServiceImpl = new VillaServiceImpl();
    static RoomServiceImpl roomServiceImpl = new RoomServiceImpl();
    public static void displayMainMenu() {
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
            case 4:
            case 5:
            case 6:
            case 7:
                System.exit(0);
        }
    }

    private static void showService() {
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
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return;
            case 8:
                System.exit(0);

        }
    }
    public static void addNewService() {
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
                break;
            case 2:
                CsvFile.write(houseServiceImpl.add());
                break;
            case 3:
                CsvFile.write(roomServiceImpl.add());
                break;
            case 4:
                return;
            case 5:
                System.exit(0);
        }
    }
}
