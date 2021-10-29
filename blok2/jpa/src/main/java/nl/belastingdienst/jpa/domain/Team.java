package nl.belastingdienst.jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @Builder @NoArgsConstructor @AllArgsConstructor // lombok
@Entity // JPA annotatie, class correspondeert met een tabel
@NamedQueries({@NamedQuery(name = "Team.findAll", query = "SELECT t FROM Team t")})
public class Team implements Identifiable<Integer> {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // strategy: hoe wordt de id aangemaakt?
    private int id;

    @Column(unique = true)
    private String name;

    public Integer getId() {
        return id;
    }
}
