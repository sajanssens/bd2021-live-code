package nl.belastingdienst.jpa.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

@Data @Builder @NoArgsConstructor @AllArgsConstructor @ToString(exclude = "worksAt") @EqualsAndHashCode(exclude = "worksAt") // lombok
@Entity // JPA annotatie, class correspondeert met een tabel
@NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
@NamedQuery(name = "Person.findByTeamName", query = "SELECT p FROM Person p WHERE p.team.name = :teamName")
@NamedQuery(name = "Person.findByTeamNamePart", query = "SELECT p FROM Person p WHERE p.team.name LIKE :teamName")
public class Person implements Identifiable<Integer> {

    // Single fields:
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // strategy: hoe wordt de id aangemaakt?
    private int id;

    private String name;
    private int age;

    @Email
    private String email;

    // Single valued relationships:
    @ManyToOne(cascade = {PERSIST, MERGE}) // UNIDI
    private Team team;

    @ManyToOne(cascade = {PERSIST, MERGE})
    // BIDI, owning side of the relationship: because 1) person fysically owns the department in the DB, AND 2) we maintain the bidi relationship here, and NOT on the other side!!
    private Department worksAt;

    public Integer getId() {
        return id;
    }

    public void setWorksAt(Department worksAt) {
        this.worksAt = worksAt;
        worksAt.addEmployee(this); // fix both sides of the bidi relationship
    }
}
