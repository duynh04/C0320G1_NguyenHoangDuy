package services.impl;

import models.*;
import services.IService;

import java.util.Scanner;

public class HouseServiceImpl implements IService {
    @Override
    public Service add() {
        Scanner input = new Scanner(System.in);
        House house = new House();
        //
        return house;
    }
}
