package models;

import commons.IData;

public class Employee extends Person {
    private String employeeId;
    private String employeeName;
    private int age;
    private String address;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String[] gatherInfo() {
        int NUM_OF_FIELD = 4;
        String[] data = new String[NUM_OF_FIELD];
        data[1] = employeeName;
        data[2] = Integer.toString(age);
        data[3] = address;
        return data;
    }

    @Override
    public Employee splitInfo(String[] data) {
        Employee employee = new Employee();
        employee.setEmployeeId(data[0]);
        employee.setEmployeeName(data[1]);
        employee.setAge(Integer.parseInt(data[2]));
        employee.setAddress(data[3]);
        return employee;
    }

    @Override
    public String toString() {
        return "Employee Name: " + employeeName + ", Age: " + age + ", Address:" + address;
    }
}
