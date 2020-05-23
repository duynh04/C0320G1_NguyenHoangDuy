package controllers;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;
import commons.CsvFile;
import models.*;
import commons.IData;
import services.IBooking;
import services.IPerson;
import services.IService;
import services.impl.*;

import java.util.*;

public class MainController {
    static Scanner input = new Scanner(System.in);
    static IService houseServiceImpl = new HouseServiceImpl();
    static IService villaServiceImpl = new VillaServiceImpl();
    static IService roomServiceImpl = new RoomServiceImpl();
    static IPerson customerAddImpl = new CustomerAddImpl();
    static IBooking bookingAddImpl = new BookingAddImpl();
    public static void displayMainMenu() {
        while(true) {
            System.out.println("------------------------------------------------------------");
            System.out.println("1. Add New Services\n" +
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
    }
    private static void showBooking() {
        while (true) {
            System.out.println("------------------------------------------------------------");
            System.out.println("1. Booking Villa\n" +
                            "2. Booking House\n" +
                            "3. Booking Room\n" +
                            "4. Back To Menu\n" +
                            "5. Exit");
            System.out.print("Select your number: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    addNewBooking(new Villa());
                    break;
                case 2:
                    addNewBooking(new House());
                    break;
                case 3:
                    addNewBooking(new Room());
                    break;
                case 4:
                    return;
                case 5:
                    System.exit(0);

            }
        }
    }
    private static void addNewBooking(IData service) {
        System.out.println("------------------------------------------------------------");
        Collection<IData> customerList = CsvFile.read(new Customer(), true);
        Collection<IData> serviceList = CsvFile.read(service, true);
        CsvFile.write(bookingAddImpl.add(customerList, serviceList));
    }

    private static void showService() {
        while (true) {
            System.out.println("------------------------------------------------------------");
            System.out.println( "1. Show all Villa\n" +
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
                    showAll(CsvFile.read(new Villa(), true));
                    break;
                case 2:
                    showAll(CsvFile.read(new House(), true));
                    break;
                case 3:
                    showAll(CsvFile.read(new Room(), true));
                    break;
                case 4:
                    showAll(CsvFile.read(new Villa(), false));
                    break;
                case 5:
                    showAll(CsvFile.read(new House(), false));
                    break;
                case 6:
                    showAll(CsvFile.read(new Room(), false));
                    break;
                case 7:
                    return;
                case 8:
                    System.exit(0);
            }
        }
    }

    public static void addNewService() {
        while (true) {
            System.out.println("------------------------------------------------------------");
            System.out.println( "1. Add New Villa\n" +
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

    private static void showAll(Collection<IData> service) {
        int index = 1;
        for (IData s: service) {
            System.out.print(index + ". ");
            s.showInfo();
            index++;
        }
    }

    private static void showInfoCustomer() {
        int index = 1;
        Collection<IData> customerList =  CsvFile.read(new Customer(), true);
        ArrayList<IData> customerListTemp = (ArrayList<IData>) customerList;
        customerListTemp.sort(new NameComparator());
        for (IData customer : customerList) {
            Customer customer1 = (Customer) customer;
            System.out.print(index + ". ");
            customer1.showInfo();
            index++;
        }
    }

    private static void addNewCustomer() {
        CsvFile.write(customerAddImpl.add());
    }


}
