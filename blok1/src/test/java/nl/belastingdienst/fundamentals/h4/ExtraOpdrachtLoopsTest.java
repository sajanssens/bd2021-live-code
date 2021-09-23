package nl.belastingdienst.fundamentals.h4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExtraOpdrachtLoopsTest {

    @Test
    public void testenMaar() {
        ExtraOpdrachtLoops e = new ExtraOpdrachtLoops();
        int som = e.rekenMaarUit();
        assertEquals(74160, som);
    }

}
