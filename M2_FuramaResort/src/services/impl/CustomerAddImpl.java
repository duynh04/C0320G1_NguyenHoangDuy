package services.impl;


import commons.Validation;
import models.Customer;
import models.Person;
import services.IPerson;

public class CustomerAddImpl implements IPerson {
    @Override
    public Person add() {
        Customer customer = new Customer();
        customer.setCustomerName(Validation.check("Name", "Input customer's name"));
        customer.setIdCard(Validation.check("IdCard", "Input customer's ID Card"));
        customer.setBirthday(Validation.check("Birthday", "Input customer's Birthday"));
        customer.setGender(Validation.check("Gender", "Input customer's Gender"));
        customer.setPhoneNumber(Validation.check("Phone", "Input customer's Phone Number"));
        customer.setEmail(Validation.check("Email", "Input customer's Email"));
        customer.setCustomerType(Validation.check("Type", "Input customer's Type"));
        customer.setAddress(Validation.check("Address", "Input customer's Address"));
        return customer;
    }
}
