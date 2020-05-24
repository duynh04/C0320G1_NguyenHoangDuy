package services;

import models.Person;

import java.util.Map;
import java.util.Set;

public interface IPerson {
    Person add();
    default Map<Integer, Person> toMap() {
        return null;
    }
}
