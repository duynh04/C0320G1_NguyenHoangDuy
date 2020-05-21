package services.impl;

import commons.Validation;
import models.*;
import services.IService;

public class RoomServiceImpl implements IService {

    @Override
    public Service add() {
        Room room = new Room();
        room.setId(Validation.check("Input Id Service"));
        room.setTypeName(Validation.check(Validation.SERVICE_NAME_REGEX,"Input Service Name", "Invalid Service Name"));
        room.setArea(Double.parseDouble(Validation.check(Validation.AREA_REGEX, "Input area usage", "Invalid Area")));
        room.setPrice(Double.parseDouble(Validation.check(Validation.POSITIVE_NUMBER_REGEX, "Input Price Service", "Invalid Price")));
        room.setMaxPeople(Integer.parseInt(Validation.check(Validation.POSITIVE_NUMBER_REGEX, "Input Max Persons", "Invalid Number")));
        room.setRentType(Validation.check("Input Type of Rent"));
        room.setFreeService(Validation.check("Input Free Service"));
        return room;
    }
}
