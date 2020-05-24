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
        String idCustomer = "";
        String idService;
        Service tempService = null;
        Booking booking = new Booking();
        ArrayList<Customer> customerList = ((ArrayList<Customer>) (CsvFile.read(new Customer(), true)));
        ArrayList<IData> serviceList = (ArrayList<IData>) CsvFile.read(service, true);
        System.out.println("Select Customer:");
        for (Customer data: customerList) {
            System.out.print(index + ". ");
            data.showInfo();
            index++;
        }
        index = 1;
        int id = input.nextInt();
//        Customer tempCustomer = tempCustomerList.get(id - 1);
        idCustomer = customerList.get(id - 1).getId();
        System.out.println("Select Service: ");
        for (IData data: serviceList) {
            System.out.print(index + ". ");
            data.showInfo();
            index++;
        }
        id = input.nextInt();
        if (serviceList.get(0) instanceof Room) {
            tempService = (Room)serviceList.get(id - 1);
        } else if (serviceList.get(0) instanceof House) {
            tempService = (House)serviceList.get(id - 1);
        } else if (serviceList.get(0) instanceof Villa) {
            tempService = (Villa)serviceList.get(id - 1);
        }
        idService = tempService.getId();
        booking.setCustomer(idCustomer);
        booking.setService(idService);
        return booking;
    }
}
