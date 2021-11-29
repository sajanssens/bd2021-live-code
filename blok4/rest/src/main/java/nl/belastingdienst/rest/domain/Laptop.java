package nl.belastingdienst.rest.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@XmlRootElement
@Entity
@NamedQueries({
        @NamedQuery(name = "Laptop.findAll", query = "SELECT c FROM Laptop c"),
        @NamedQuery(name = "Laptop.find", query = "SELECT c FROM Laptop c WHERE c.id=:id")
})
public class Laptop {

    @Id @GeneratedValue
    private long id;

    private String brand;
}
