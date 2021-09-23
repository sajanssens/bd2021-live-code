package nl.belastingdienst.fundamentals.h4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ElevenProofTest {

    private ElevenProof target;
    private final ScannerTussenpersoon mockScannerTussenpersoon = mock(ScannerTussenpersoon.class);

    @Before
    public void setUp() {
        this.target = new ElevenProof();
        this.target.setScannerTussenpersoon(mockScannerTussenpersoon);

        when(mockScannerTussenpersoon.nextLine()).thenReturn("123456789");
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
        when(mockScannerTussenpersoon.nextLine()).thenReturn("123456789");
        String rekeningnummer = target.getRekeningnummer(); // won't work, user input required...
        assertEquals("123456789", rekeningnummer);
    }
}
