package views;

import commons.CsvFile;
import commons.IData;
import exceptions.BirthdayException;
import exceptions.GenderException;
import exceptions.NameException;
import exceptions.UserException;
import models.Room;
import models.Service;
import models.Villa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

import static controllers.MainController.displayMainMenu;
import static java.lang.System.*;
public class Main {
    public static void main(String[] args) {
        displayMainMenu();
//         Collection<IData> lst = CsvFile.read(new Villa(), true);
//         TreeSet<IData> tree = new TreeSet<>(lst);
//        for (IData service: tree) {
//            service.showInfo();
//        }
//        // init map
//        Map<Integer, String[]> map = new HashMap<Integer, String[]>();
//        map.put(100, new String[]{"A", "j"});
//        map.put(101, new String[]{"g", "B"});
//        map.put(102, new String[]{"A", "j"});
//        map.put(103, new String[]{"g", "B"});
//        // show map
//        Set<Integer> set = map.keySet();
//        for (Integer key : set) {
//            System.out.println(key + " " + map.get(key));
//        }
//        while (true) {
//            displayMainMenu();
////            break;
//        }
    }
}
//        Scanner in = new Scanner(System.in);
//        String u = "";
//        while (true) {
//            String x = in.nextLine();
//            try {
//                x = BirthdayException.check(x);
//                x = BirthdayException.check(x);
//                System.out.println("format: " + x);
//            } catch (UserException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    }
//    }
//}
