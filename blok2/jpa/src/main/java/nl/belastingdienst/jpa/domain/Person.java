package nl.belastingdienst.jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

@Data @Builder @NoArgsConstructor @AllArgsConstructor // lombok
@Entity // JPA annotatie, class correspondeert met een tabel
@NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
@NamedQuery(name = "Person.findByTeamName", query = "SELECT p FROM Person p WHERE p.team.name = :teamName")
@NamedQuery(name = "Person.findByTeamNamePart", query = "SELECT p FROM Person p WHERE p.team.name LIKE :teamName")
public class Person {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // strategy: hoe wordt de id aangemaakt?
    private int id;

    private String name;
    private int age;

    @ManyToOne(cascade = {PERSIST, MERGE})
    private Team team;

    @ManyToOne(cascade = {PERSIST, MERGE})
    private Department worksAt;
}
