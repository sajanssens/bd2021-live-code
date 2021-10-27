package nl.belastingdienst.jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data @Builder @NoArgsConstructor @AllArgsConstructor // lombok
@Entity // JPA annotatie, class correspondeert met een tabel
public class Person {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // strategy: hoe wordt de id aangemaakt?
    private int id;

    private String name;
    private int age;
}
