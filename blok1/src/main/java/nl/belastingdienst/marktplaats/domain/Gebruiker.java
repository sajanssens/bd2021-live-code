package nl.belastingdienst.marktplaats.domain;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class Gebruiker {
    private String emailadres;
    private String wachtwoord;
    private String adres;
    private boolean isAkkoordMetVoorwaarden;
    private Bezorgwijze bezorgwijze;
}
