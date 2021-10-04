package nl.belastingdienst.fundamentals.h12;

import java.lang.reflect.Field;

public class FlauweWoordgrappen {

    // member dependent of T
    public <T> void process(Class<T> c, T anObjectOfTypeT) {
        for (Field field : c.getDeclaredFields()) {
            if (field.isAnnotationPresent(Bram.class)) {
                try {
                    Bram annotation = field.getAnnotation(Bram.class);
                    field.setAccessible(true);
                    field.set(anObjectOfTypeT, "Waarom konden de Beatles niet klaverjassen? " + annotation.value() + getTrailingString(annotation.level()));
                } catch (IllegalAccessException e) {
                    System.err.println("Jammer joh!");
                }
            }
        }
    }

    // members not dependent of T
    // ...
    private String getTrailingString(int level) {
        String exclamation = "!".repeat(level);
        return " :-)" + exclamation;
    }
    // ...

}
