package nl.belastingdienst.h4;

import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ElevenProofTest {

    private ElevenProof target;
    private final Scanner mockScanner = mock(Scanner.class);

    @Before
    public void setUp() {
        this.target = new ElevenProof();
        this.target.setScanner(mockScanner);

        when(mockScanner.nextLine()).thenReturn("123456789");
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
        assertEquals("123456789", rekeningnummer);
    }
}
