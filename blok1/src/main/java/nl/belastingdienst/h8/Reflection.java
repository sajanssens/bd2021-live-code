package nl.belastingdienst.h8;

import nl.belastingdienst.h7.Author;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection {

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException {
        // Class<Author> authorClass = Author.class;
        Class<?> codeVanAuthor = Class.forName("nl.belastingdienst.h7.Author");

        Method[] methods = codeVanAuthor.getMethods();
        for (Method method : methods) {
            String name = method.getName();
            System.out.println(name);
        }

        Author bram = new Author();
        System.out.println(bram);

        for (Field field : codeVanAuthor.getFields()) {
            if (field.getName().equals("age")) {
                field.setAccessible(true);
                field.set(bram, 42); // bram.age = 42
            }
        }
        System.out.println(bram);
        // comment
    }

}
