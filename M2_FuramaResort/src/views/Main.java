package views;

import commons.CsvFile;
import models.Service;
import models.Villa;

import java.util.List;

import static controllers.MainController.displayMainMenu;

public class Main {
    public static void main(String[] args) {
        List<Villa> lst = CsvFile.read(new Villa());
//        while (true) {
//            displayMainMenu();
//            break;
//        }
    }
}
