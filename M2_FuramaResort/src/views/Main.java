package views;


import commons.IData;
import models.Room;
import models.Service;

import static controllers.MainController.displayMainMenu;

public class Main {
    public static void main(String[] args) {
//        displayMainMenu();
        Room r1 = new Room();
        Room r2 = new Room();
        System.out.println(r1 == r2);
    }

}
