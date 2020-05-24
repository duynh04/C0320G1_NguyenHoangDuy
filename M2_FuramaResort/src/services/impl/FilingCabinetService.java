package services.impl;

import commons.CsvFile;
import models.Employee;
import services.IFilingCabinet;

import java.util.Collection;
import java.util.EmptyStackException;
import java.util.Stack;

public class FilingCabinetService implements IFilingCabinet {
    private static final Stack<Employee> employees;
    static {
        employees = new Stack<>();
        Collection<Employee> employeeList = CsvFile.read(new Employee(), true);
        for (Employee employee: employeeList) {
            employees.push(employee);
        }
    }
    @Override
    public Employee findEmployee(String id) {
        String idCode = "EM" + id;
        Employee data;
        //Stack<Employee> tempStack = employees;
        while (true) {
            try {
                data = employees.pop();
                if (data.getEmployeeId().equals(idCode)) {
                    return data;
                }
            } catch (EmptyStackException e) {
                return null;
            }
        }
    }
}
