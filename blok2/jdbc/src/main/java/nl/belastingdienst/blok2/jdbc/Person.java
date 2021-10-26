package nl.belastingdienst.blok2.jdbc;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class Person {
    private final int id;
    private final String name;
    private final int age;
}
