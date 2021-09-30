package nl.belastingdienst.fundamentals.h12;

import lombok.ToString;

@ToString
public class Person {

    @Bram(value = "Paul McCartney")
    private String name;

}
