package views;

import commons.CsvFile;
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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static controllers.MainController.displayMainMenu;
import static java.lang.System.*;

public class Main {
    public static void main(String[] args) throws ParseException {
//        List<Service> lst = CsvFile.read(new Room());
        while (true) {
            displayMainMenu();
//            break;
        }
//        Scanner in = new Scanner(System.in);
//        String u = "";
//        while (true) {
//            String x = in.nextLine();
//            try {
//                x = BirthdayException.check(x);
//                x = BirthdayException.check(x);
//                System.out.println("fomat: " + x);
//            } catch (UserException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//        SimpleDateFormat f1 = new SimpleDateFormat("dd/MM/yyyy");
//        Date birthday = f1.parse("23/05/2002");
//        Date now = new Date();
//        Calendar c  = Calendar.getInstance();
//        Calendar c1  = Calendar.getInstance();
//        c.set(2020, 05, 29, 0, 0, 0);
//        c1.set(2002, 05, 22, 0, 0, 0);
//        long year1 = c.getTimeInMillis() - c1.getTimeInMillis();
//        double year2 = (double)year1 / 1000 / 60 / 60 / 24 / 365;
//        out.println(year2);
//        long timeDistance = now.getTime() - birthday.getTime();
//        out.println(timeDistance);
//        double year = (double)timeDistance / 1000 / 60 / 60 / 24 / 365;
//        out.println(year);
//        //------------------------------
//        LocalDate l = LocalDate.of(2002, 05, 23); //specify year, month, date directly
//        LocalDate now1 = LocalDate.now(); //gets localDate
//        Period diff = Period.between(l, now1); //difference between the dates is calculated
//        out.println("----------------------------------------");
//        System.out.println(diff.getYears() + "years" + diff.getMonths() + "months" + diff.getDays() + "days");
    }
}
