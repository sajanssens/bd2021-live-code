package nl.belastingdienst.marktplaats.dao;

import nl.belastingdienst.marktplaats.domain.Bezorgwijze;

import java.util.Arrays;
import java.util.List;

public class BezorgwijzeDao {

    public List<Bezorgwijze> getAll() {
        return Arrays.asList(Bezorgwijze.values());
    }


}
