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
@NamedQueries({@NamedQuery(name = "Office.findAll", query = "SELECT d FROM Office d")})
public class Office implements Identifiable<Integer> {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // strategy: hoe wordt de id aangemaakt?
    private int id;

    @Column(unique = true)
    private String name;

    // Collection valued: is default altijd lazy!
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY) // UNIDI
    @Builder.Default // lombok keeps my initial value instead of resetting it.
    private Set<Department> departments = new HashSet<>();

    public Set<Department> getDepartments() {
        return departments;
    }

    public void addDepartment(Department d) {
        // if (departments == null) departments = new HashSet<>();

        departments.add(d);
    }

    public Integer getId() {
        return id;
    }
}
