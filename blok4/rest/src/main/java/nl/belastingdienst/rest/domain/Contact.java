package nl.belastingdienst.rest.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@XmlRootElement
public class Contact {

    private Long id;
    private String firstName;
    private String surname;
    private String email;

}
