package services.impl;

import models.Customer;
import services.IBookingCinema;

import java.util.LinkedList;
import java.util.Queue;

public class BookingCinemaImpl implements IBookingCinema {
    private static final Queue<Customer> customers = new LinkedList<>();

    @Override
    public void bookingNewTicket(Customer customer) {
        customers.add(customer);
    }

    @Override
    public Queue<Customer> getAllBookingCinema() {
        return customers;
    }
}
