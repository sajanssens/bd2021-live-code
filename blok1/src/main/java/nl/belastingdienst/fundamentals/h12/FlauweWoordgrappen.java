package nl.belastingdienst.fundamentals.h12;

import java.lang.reflect.Field;

public class FlauweWoordgrappen {

    public void process(Class<Person> c, Person p) {
        for (Field field : c.getDeclaredFields()) {
            if (field.isAnnotationPresent(Bram.class)) {
                try {
                    Bram annotation = field.getAnnotation(Bram.class);
                    field.setAccessible(true);
                    field.set(p, "Waarom konden de Beatles niet klaverjassen? " + annotation.value() + " :-)!");
                } catch (IllegalAccessException e) {
                    System.err.println("Jammer joh!");
                }
            }
        }
    }

}
