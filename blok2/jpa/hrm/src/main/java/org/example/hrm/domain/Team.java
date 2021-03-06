package org.example.hrm.domain;

// javax: java eXtension

import lombok.*;
import org.example.Identifiable;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(name = "Team.findAll", query = "SELECT e FROM Team e"),
        @NamedQuery(name = "Team.find", query = "SELECT e FROM Team e WHERE e.id=:id")
})
public class Team implements Identifiable<Long> {

    @Id @GeneratedValue
    private Long id;
    private String yell;

    @OneToMany(mappedBy = "scrumteam", fetch = FetchType.LAZY)
    private Collection<Person> members;

    public void addMember(Person person) {
        if (members == null) {
            members = new HashSet<>();
        }

        members.add(person);
    }
}
