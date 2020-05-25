package services.impl;

import commons.*;
import models.*;
import services.IBooking;

import java.util.ArrayList;
import java.util.Scanner;

public class BookingAddImpl implements IBooking {
    private final Scanner input = new Scanner(System.in);

    @Override
    public Booking add(IData service) {
        int index = 1;
        int id;
        Customer customer;
        Service tempService = null;
        Booking booking = new Booking();
        // get customer and service list
        ArrayList<Customer> customerList = ((ArrayList<Customer>) (CsvFile.read(new Customer(), true)));
        ArrayList<IData> serviceList = (ArrayList<IData>) CsvFile.read(service, true);

        // select a customer
        for (Customer data: customerList) {
            System.out.print(index + ". ");
            data.showInfo();
            index++;
        }
        while (true) {
            try {
                System.out.println("Select Customer:");
                id = input.nextInt();
                customer = customerList.get(id - 1);
                break;
            } catch (Exception e) {
                System.out.println("Customer is not in range. Try again.");
                input.nextLine();
            }
        }

        //select a service
        index = 1;
        for (IData data: serviceList) {
            System.out.print(index + ". ");
            data.showInfo();
            index++;
        }
        while (true) {
            try {
                System.out.println("Select Service: ");
                id = input.nextInt();
                customer = customerList.get(id - 1);
                break;
            } catch (Exception e) {
                System.out.println("Service is not in range. Try again.");
                input.nextLine();
            }
        }
        if (serviceList.get(0) instanceof Room) {
            tempService = (Room)serviceList.get(id - 1);
        } else if (serviceList.get(0) instanceof House) {
            tempService = (House)serviceList.get(id - 1);
        } else if (serviceList.get(0) instanceof Villa) {
            tempService = (Villa)serviceList.get(id - 1);
        }

        // save to booking.
        customer.setService(tempService);
        booking.setCustomer(customer);
        return booking;
    }
}
