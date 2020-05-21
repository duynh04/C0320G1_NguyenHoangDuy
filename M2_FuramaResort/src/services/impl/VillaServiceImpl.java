package services.impl;

import commons.Validation;
import models.*;
import services.IService;

public class VillaServiceImpl implements IService {
    @Override
    public Service add() {
        Villa villa = new Villa();
        villa.setId(Validation.check("Input Id Service"));
        villa.setTypeName(Validation.check(Validation.SERVICE_NAME_REGEX,"Input Service Name", "Invalid Service Name"));
        villa.setArea(Double.parseDouble(Validation.check(Validation.AREA_REGEX, "Input area usage", "Invalid Area")));
        villa.setPrice(Double.parseDouble(Validation.check(Validation.POSITIVE_NUMBER_REGEX, "Input Price Service", "Invalid Price")));
        villa.setMaxPeople(Integer.parseInt(Validation.check(Validation.POSITIVE_NUMBER_REGEX, "Input Max Persons", "Invalid Number")));
        villa.setRentType(Validation.check("Input Type of Rent"));
        villa.setRoomStandard(Validation.check("Input Room Standard"));
        villa.setFacilities(Validation.check("Description Convenient"));
        villa.setStorey(Integer.parseInt(Validation.check(Validation.POSITIVE_NUMBER_REGEX, "Input Number of Floor", "Invalid Number")));
        villa.setSwimmingPoolArea(Double.parseDouble(Validation.check(Validation.AREA_REGEX, "Input Pool's Area", "Invalid Area")));
        return villa;
    }
}
