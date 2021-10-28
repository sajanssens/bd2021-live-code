package nl.belastingdienst.jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Data @Builder @NoArgsConstructor @AllArgsConstructor // lombok
@Entity // JPA annotatie, class correspondeert met een tabel
@NamedQueries({@NamedQuery(name = "Department.findAll", query = "SELECT t FROM Department t")})
public class Department {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // strategy: hoe wordt de id aangemaakt?
    private int id;

    private String name;

    @OneToMany(mappedBy = "worksAt")
    private Collection<Person> employees = new ArrayList<>();
}
