package controllers;

import commons.CsvFile;
import models.*;
import commons.IData;
import services.*;
import services.impl.*;

import java.util.*;

public class MainController {
    static Scanner input = new Scanner(System.in);
    static IService houseServiceImpl = new HouseServiceImpl();
    static IService villaServiceImpl = new VillaServiceImpl();
    static IService roomServiceImpl = new RoomServiceImpl();
    static IPerson customerAddImpl = new CustomerAddImpl();
    static IPerson employeeAddImpl = new EmployeeAddImpl();
    static IBooking bookingAddImpl = new BookingAddImpl();
    static IBookingCinema bookingCinemaImpl = new BookingCinemaImpl();
    static IFilingCabinet filingCabinetImpl = new FilingCabinetService();
    public static void displayMainMenu() {
        while(true) {
            System.out.println("------------------------------------------------------------");
            System.out.println("1. Add New Services\n" +
                    "2. Show Services\n" +
                    "3. Add New Customer\n" +
                    "4. Show Information of Customer\n" +
                    "5. Add New Booking\n" +
                    "6. Show Information of Employee\n" +
                    "7. Add booking cinema 4D\n" +
                    "8. Show booking cinema 4D\n" +
                    "9. Search Filing Cabinets of Employee\n" +
                    "10. Exit");
            int choice = selectOption();
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
                    showEmployee();
                    break;
                case 7:
                    addBookingCinema();
                    break;
                case 8:
                    showBookingCinema();
                    break;
                case 9:
                    findEmployee();
                    break;
                case 10:
                    System.exit(0);
                default:
            }
        }
    }

    private static void findEmployee() {
        System.out.println("------------------------------------------------------------");
        int choice;
        while (true) {
            try {
                System.out.print("Input the employee's ID: ");
                choice = input.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Wrong selection, try again.");
                input.nextLine();
            }
        }
        Employee employee = filingCabinetImpl.findEmployee(String.valueOf(choice));
        if (employee != null)
            System.out.println(employee);
        else
            System.out.println("Employee is not found!!");
    }

    private static void showBookingCinema() {
        Queue<Customer> queue = bookingCinemaImpl.getAllBookingCinema();
        Customer customer;
        while((customer = queue.poll()) != null) {
            customer.showInfo();
        }
    }

    private static void addBookingCinema() {
        int index = 0;
        Collection<Customer> customerList = CsvFile.read(new Customer(), true);
        System.out.println("Select Customer to booking ticket:");
        for (Customer customer: customerList) {
            index++;
            System.out.print(index + ". ");
            customer.showInfo();
        }
        int id = input.nextInt();
        bookingCinemaImpl.bookingNewTicket((Customer)customerList.toArray()[id - 1]);
    }

    private static void showEmployee() {
        Map<Integer, Person> employeeMap = employeeAddImpl.toMap();
        Set<Integer> employeeSet = employeeMap.keySet();
        for (Integer k: employeeSet) {
            System.out.println(k + ". " + employeeMap.get(k));
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
            int choice = selectOption();
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
                default:
            }
        }
    }
    private static void addNewBooking(IData service) {
        System.out.println("------------------------------------------------------------");
        CsvFile.write(bookingAddImpl.add(service));
        System.out.print("Press Enter to continue...");
        input.nextLine();
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
            int choice = selectOption();
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
                default:
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
            int choice = selectOption();
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
                default:
            }
            System.out.print("Press Enter to continue...");
            input.nextLine();
        }
    }

    private static void showAll(Collection<IData> service) {
        int index = 1;
        for (IData s: service) {
            System.out.print(index + ". ");
            s.showInfo();
            index++;
        }
        System.out.print("Press Enter to continue...");
        input.nextLine();
    }

    private static void showInfoCustomer() {
        int index = 1;
        Collection<Customer> customerList =  CsvFile.read(new Customer(), true);
        ArrayList<Customer> customerListTemp = (ArrayList<Customer>) customerList;
        customerListTemp.sort(new NameComparator());
        for (Customer customer : customerList) {
            System.out.print(index + ". ");
            customer.showInfo();
            index++;
        }
    }

    private static void addNewCustomer() {
        CsvFile.write(customerAddImpl.add());
    }

    private static int selectOption() {
        int choice;
        while (true) {
            try {
                System.out.print("Select your number: ");
                choice = Integer.parseInt(input.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Wrong selection, try again.");
                input.nextLine();
            }
        }
        return choice;
    }

}
