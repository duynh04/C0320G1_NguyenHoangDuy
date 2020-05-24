package services.impl;

import commons.CsvFile;
import commons.IData;
import commons.Validation;
import models.Employee;
import models.Person;
import services.IPerson;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EmployeeAddImpl implements IPerson {
    @Override
    public Person add() {
        Employee employee = new Employee();
        employee.setEmployeeName(Validation.check("Name", "Input employee's name"));
        employee.setAddress(Validation.check("Address", "Input employee's Address"));
        employee.setAge(Integer.parseInt(Validation.check(Validation.POSITIVE_NUMBER_REGEX, "Input employee's Age")));
        return employee;
    }

    @Override
    public Map<Integer, Person> toMap() {
        Collection<IData> employees = CsvFile.read(new Employee(), true);
        Map<Integer, Person> employeeMap = new HashMap<>();
        int key = 100;
        for (IData employee:employees ) {
            employeeMap.put(key, (Person)employee);
            key++;
        }
        return employeeMap;
    }
}
