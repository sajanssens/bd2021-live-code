package nl.belastingdienst.fundamentals.extra.concurrency;

import lombok.Data;

@Data
public class Person {
    private int age;

    public /*synchronized*/ void haveBirthday() {
        age++;
    }
}
