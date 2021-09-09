package nl.belastingdienst.h2;

import nl.belastingdienst.h2.Hello;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloTest {

    // alt insert

    // TDD: eerst test schrijven, dan pas code, dan evt. code verbeteren

    @Test
    public void whenVerdubbelThenResultIsTheDouble() {
        int verdubbel = Hello.verdubbel(10); // c a v = toekennen aan een var.

        assertEquals(20, verdubbel);
    }
}
