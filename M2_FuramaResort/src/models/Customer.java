package models;

import exceptions.BirthdayException;
import services.IPerson;

public class Customer extends Person{
    private String id;
    private String customerName;
    private String idCard;
    private String birthday;
    private String gender;
    private String phoneNumber;
    private String email;
    private String customerType;
    private String address;
    private Service service;

    public Customer() {
    }

    public Customer(String id, String customerName, String idCard, String birthday, String gender, String phoneNumber, String email, String customerType, String address, Service service) {
        this.id = id;
        this.customerName = customerName;
        this.idCard = idCard;
        this.birthday = birthday;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.customerType = customerType;
        this.address = address;
        this.service = service;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String[] gatherInfo() {
        int NUM_OF_FIELD = 9;
        String[] data = new String[NUM_OF_FIELD];
        data[0] = id;
        data[1] = customerName;
        data[2] = idCard;
        data[3] = birthday;
        data[4] = gender;
        data[5] = phoneNumber;
        data[6] = email;
        data[7] = customerType;
        data[8] = address;
        return data;
    }

    public Customer splitInfo(String[] data) {
        Customer customer = new Customer();
        customer.setId(data[0]);
        customer.setCustomerName(data[1]);
        customer.setIdCard(data[2]);
        customer.setBirthday(data[3]);
        customer.setGender(data[4]);
        customer.setPhoneNumber(data[5]);
        customer.setEmail(data[6]);
        customer.setCustomerType(data[7]);
        customer.setAddress(data[8]);
        return customer;
    }

    @Override
    public void showInfo() {
        System.out.printf("Name: %s, ID: %s, Birthday: %s, Gender; %s, Phone: %s, Email: %s, Type: %s, Address: %s\n",
                customerName,
                idCard,
                birthday,
                gender,
                phoneNumber,
                email,
                customerType,
                address);
    }
}
