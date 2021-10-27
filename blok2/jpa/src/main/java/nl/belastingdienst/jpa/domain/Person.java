package nl.belastingdienst.jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;

@Data @Builder @NoArgsConstructor @AllArgsConstructor // lombok
@Entity // JPA annotatie, class correspondeert met een tabel
@Table(name = "Persoontje")
public class Person {

    @Id @GeneratedValue
    private int id;

    @Column(name = "voornaam")
    private String name;
    private int age;

}
