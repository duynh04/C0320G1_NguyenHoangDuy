package services;

import models.Customer;

import java.util.Queue;

public interface IBookingCinema {
    void bookingNewTicket(Customer customer);
    Queue<Customer> getAllBookingCinema();
}
