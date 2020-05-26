package services.impl;

import commons.Validation;
import models.*;
import services.IService;

public class VillaServiceImpl implements IService {
    @Override
    public Service add() {
        Villa villa = new Villa();
        //villa.setId(Validation.check("Input Id Service"));
        villa.setTypeName(Validation.check(Validation.SERVICE_NAME_REGEX,"Input Service Name", "Invalid Service Name"));
        villa.setArea(Double.parseDouble(Validation.check(Validation.AREA_REGEX, "Input area usage", "Invalid Area")));
        villa.setPrice(Double.parseDouble(Validation.check(Validation.POSITIVE_NUMBER_REGEX, "Input Price Service", "Invalid Price")));
        villa.setMaxPeople(Integer.parseInt(Validation.check(Validation.MAX_PEOPLE_REGEX, "Input Max Persons", "Invalid Number")));
        villa.setRentType(Validation.check(Validation.SERVICE_NAME_REGEX,"Input Type of Rent", " Invalid, try again."));
        villa.setRoomStandard(Validation.check(Validation.SERVICE_NAME_REGEX,"Input Room Standard", " Invalid, try again."));
        villa.setFacilities(Validation.check(Validation.ATTACH_SERVICE, "Description Convenient","There is no such a service."));
        villa.setStorey(Integer.parseInt(Validation.check(Validation.POSITIVE_NUMBER_REGEX, "Input Number of Floor", "Invalid Number")));
        villa.setSwimmingPoolArea(Double.parseDouble(Validation.check(Validation.AREA_REGEX, "Input Pool's Area", "Invalid Area")));
        return villa;
    }
}
