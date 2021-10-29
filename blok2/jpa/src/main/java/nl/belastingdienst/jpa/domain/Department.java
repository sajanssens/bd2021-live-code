package nl.belastingdienst.jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data @Builder @NoArgsConstructor @AllArgsConstructor // lombok
@Entity // JPA annotatie, class correspondeert met een tabel
@NamedQueries({@NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d")})
public class Department implements Identifiable<Integer> {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // strategy: hoe wordt de id aangemaakt?
    private int id;

    // @Column(unique = true)
    private String name;

    // Collection valued:
    @OneToMany(mappedBy = "worksAt") // BIDI, passive side, follows the changes in person
    @Builder.Default
    private Set<Person> employees = new HashSet<>();

    /* !!NOT!! public */ void addEmployee(Person p) {
        // if (employees == null) employees = new HashSet<>();

        this.employees.add(p);
    }

    public Integer getId() {
        return id;
    }
}
