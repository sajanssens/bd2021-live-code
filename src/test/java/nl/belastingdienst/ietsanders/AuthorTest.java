package nl.belastingdienst.ietsanders;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthorTest {

    @Test
    public void whenDoeIetsThen42() {
        // given: aanmaken van testdata
        int i = 0;
        Author tolkien = new Author(); // Author is de class
        Author reve = new Author();    // tolkien en reve zijn objecten = instanties van die class

        // when: roep subject under test aan, hier iets van Author
        int resultaatTolkien = tolkien.doeIets("tolkien");
        int resultaatReve = reve.doeIets("reve");

        // then: wat verwacht ik?
        assertEquals(42, resultaatTolkien);
        assertEquals(42, resultaatReve);
    }

}
