package services.impl;

import commons.IData;
import models.Customer;
import sun.util.resources.cldr.chr.CalendarData_chr_US;

import java.util.Comparator;

public class BirthdayComparator implements Comparator<IData> {

    @Override
    public int compare(IData o1, IData o2) {
        System.out.println(" start compare");
        if(o1 instanceof Customer && o2 instanceof Customer) {
            Customer o11 = (Customer)o1;
            Customer o22 = (Customer)o2;
            String[] o1Date = o11.getBirthday().split("/");
            String[] o2Date = o22.getBirthday().split("/");
            return Integer.parseInt(o1Date[2]) - Integer.parseInt(o2Date[2]);
        }
        return 0;
    }
}
