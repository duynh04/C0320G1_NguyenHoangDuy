package services.impl;

import commons.Validation;
import models.*;
import services.IService;

import java.util.Scanner;

public class HouseServiceImpl implements IService {
    @Override
    public Service add() {
        House house = new House();
        house.setId(Validation.check("Input Id Service"));
        house.setTypeName(Validation.check(Validation.SERVICE_NAME_REGEX,"Input Service Name", "Invalid Service Name"));
        house.setArea(Double.parseDouble(Validation.check(Validation.AREA_REGEX, "Input area usage", "Invalid Area")));
        house.setPrice(Double.parseDouble(Validation.check(Validation.POSITIVE_NUMBER_REGEX, "Input Price Service", "Invalid Price")));
        house.setMaxPeople(Integer.parseInt(Validation.check(Validation.MAX_PEOPLE_REGEX, "Input Max Persons", "Invalid Number")));
        house.setRentType(Validation.check("Input Type of Rent"));
        house.setRoomStandard(Validation.check("Input Room Standard"));
        house.setFacilities(Validation.check("Description Convenient"));
        house.setStorey(Integer.parseInt(Validation.check(Validation.POSITIVE_NUMBER_REGEX, "Input Number of Floor", "Invalid Number")));
        return house;
    }
}
