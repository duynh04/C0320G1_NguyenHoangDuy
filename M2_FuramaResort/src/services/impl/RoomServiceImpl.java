package services.impl;

import commons.Validation;
import models.*;
import services.IService;

public class RoomServiceImpl implements IService {

    @Override
    public Service add() {
        Room room = new Room();
        //room.setId(Validation.check("Input Id Service"));
        room.setTypeName(Validation.check(Validation.SERVICE_NAME_REGEX,"Input Service Name", "Invalid Service Name"));
        room.setArea(Double.parseDouble(Validation.check(Validation.AREA_REGEX, "Input area usage", "Invalid Area")));
        room.setPrice(Double.parseDouble(Validation.check(Validation.POSITIVE_NUMBER_REGEX, "Input Price Service", "Invalid Price")));
        room.setMaxPeople(Integer.parseInt(Validation.check(Validation.MAX_PEOPLE_REGEX, "Input Max Persons", "Invalid Number")));
        room.setRentType(Validation.check(Validation.SERVICE_NAME_REGEX,"Input Type of Rent", " Invalid, try again."));
        room.setFreeService(Validation.check(Validation.SERVICE_NAME_REGEX, "Input Free Service", " Invalid, try again."));
        return room;
    }
}
