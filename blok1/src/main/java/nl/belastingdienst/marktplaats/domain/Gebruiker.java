package nl.belastingdienst.marktplaats.domain;

import lombok.Data;

@Data
public class Gebruiker {
    private String emailadres;
    private String wachtwoord;
    private String adres;
    private boolean isAkkoordMetVoorwaarden;
}
