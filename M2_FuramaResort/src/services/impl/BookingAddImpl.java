package services.impl;

import commons.*;
import models.*;
import services.IBooking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class BookingAddImpl implements IBooking {
    private final Scanner input = new Scanner(System.in);
    @Override
    public Booking add(Collection<IData> customerList, Collection<IData> serviceList) {
        int index = 1;
        String idCustomer = "";
        String idService;
        Service tempService = null;
        Booking booking = new Booking();
        ArrayList<IData> tempCustomerList = (ArrayList<IData>)customerList;
        ArrayList<IData> tempServiceList = (ArrayList<IData>)serviceList;
        System.out.println("Select Customer:");
        for (IData data: tempCustomerList) {
            System.out.print(index + ". ");
            data.showInfo();
            index++;
        }
        index = 1;
        int id = input.nextInt();
        if (tempCustomerList.get(0) instanceof Customer) {
            Customer tempCustomer = (Customer)tempCustomerList.get(id - 1);
            idCustomer = tempCustomer.getId();
        }
        System.out.println("Select Villa: ");
        for (IData data: tempServiceList) {
            System.out.print(index + ". ");
            data.showInfo();
            index++;
        }
        id = input.nextInt();
        if (tempServiceList.get(0) instanceof Room) {
            tempService = (Room)tempServiceList.get(id - 1);
        } else if (tempServiceList.get(0) instanceof House) {
            tempService = (House)tempServiceList.get(id - 1);
        } else if (tempServiceList.get(0) instanceof Villa) {
            tempService = (Villa)tempServiceList.get(id - 1);
        }
        idService = tempService.getId();
        booking.setCustomer(idCustomer);
        booking.setService(idService);
        return booking;
    }
}
