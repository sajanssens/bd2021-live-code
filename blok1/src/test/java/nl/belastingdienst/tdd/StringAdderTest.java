package nl.belastingdienst.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringAdderTest {

    @DisplayName("Display name .....")
    @Test
    void whenAdderGetsNullItReturnsZero() {
        StringAdder adder = new StringAdder();
        int zero = adder.add(null);
        assertEquals(0, zero);
    }

    @Test
    public void whenAdderGetsNothingItReturnsZero() {
        StringAdder adder = new StringAdder();
        int zero = adder.add("");
        assertEquals(0, zero);
    }

    @Test
    public void whenAdderGetsOneNumberItReturnsTheNumber() {
        StringAdder adder = new StringAdder();
        int one = adder.add("1");
        assertEquals(1, one);

        int largeNumber = adder.add("4628468");
        assertEquals(4628468, largeNumber);
    }

    @Test
    public void whenAdderGetsNoNumberItThrowsException() {
        StringAdder adder = new StringAdder();
        assertThrows(IllegalArgumentException.class, () -> adder.add("a"));
    }

    @Test
    public void whenAdderGetsNoNumberItThrowsExceptionWhichContainsCorrectMessage() {
        StringAdder adder = new StringAdder();
        IllegalArgumentException a = assertThrows(IllegalArgumentException.class, () -> adder.add("a"));
        assertTrue(a.getMessage().contains("Dit is geen nummer! a"));
    }
}
