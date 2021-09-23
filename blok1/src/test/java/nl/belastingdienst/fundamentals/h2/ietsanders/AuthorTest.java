package nl.belastingdienst.fundamentals.h2.ietsanders;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthorTest {

    @Test
    public void whenDoeIetsThen42() {
        // given: aanmaken van testdata
        int i = 0;
        nl.belastingdienst.fundamentals.h2.ietsanders.Author tolkien = new nl.belastingdienst.fundamentals.h2.ietsanders.Author(); // Author is de class
        nl.belastingdienst.fundamentals.h2.ietsanders.Author reve = new nl.belastingdienst.fundamentals.h2.ietsanders.Author();    // tolkien en reve zijn objecten = instanties van die class

        // when: roep subject under test aan, hier iets van Author
        int resultaatTolkien = tolkien.doeIets("tolkien");
        int resultaatReve = reve.doeIets("reve");

        // then: wat verwacht ik?
        assertEquals(42, resultaatTolkien);
        assertEquals(42, resultaatReve);
    }

}
