package nl.belastingdienst.h8;

import nl.belastingdienst.h7.Author;

import java.lang.reflect.Method;

public class Reflection {

    public static void main(String[] args) {
        Class<Author> authorClass = Author.class;
        Method[] methods = authorClass.getMethods();
        for (Method method : methods) {
            String name = method.getName();
            System.out.println(name);
        }
    }

}
