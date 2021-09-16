package nl.belastingdienst.h4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElevenProofTest {

    private ElevenProof target;

    @Before
    public void setUp() {
        this.target = new ElevenProof();
    }

    @Test
    public void bepaalSomHappyFlow() {
        // given
        String rekeningnummer = "123456789";
        // when
        int som = target.bepaalSom(rekeningnummer);
        // then
        assertEquals(165, som);
    }

    @Test
    public void bepaalSomHappyFlow2() {
        // given when then
        assertEquals(176, target.bepaalSom("736160221"));
    }

    @Test
    public void elevenProofHappyFlow() {
        assertTrue(target.isElevenProof(165));
        assertFalse(target.isElevenProof(166));
    }

    @Test
    public void getRekeningnummer() {
        String rekeningnummer = target.getRekeningnummer(); // won't work, user input required...
    }
}
