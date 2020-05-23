package services.impl;

import commons.IData;
import models.Customer;

import java.util.Comparator;

public class NameComparator implements Comparator<IData> {
    @Override
    public int compare(IData o1, IData o2) {
        if(o1 instanceof Customer && o2 instanceof Customer) {
            Customer o11 = (Customer)o1;
            Customer o22 = (Customer)o2;
            int diff = o11.getCustomerName().compareTo(o22.getCustomerName());
            if(diff == 0 ) {
                BirthdayComparator birth = new BirthdayComparator();
                return birth.compare(o1, o2);
            } else {
                return diff;
            }
        }
        return 0;
    }
}
