package nl.belastingdienst.tdd;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringAdderTest {

    @Test
    public void whenAdderGetsNullItReturnsZero() {
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

    @Test(expected = IllegalArgumentException.class)
    public void whenAdderGetsNoNumberItThrowsException() {
        StringAdder adder = new StringAdder();
        int wtf = adder.add("a");
    }

    @Test
    public void whenAdderGetsNoNumberItThrowsExceptionWhichContainsCorrectMessage() {
        StringAdder adder = new StringAdder();
        IllegalArgumentException a = assertThrows(IllegalArgumentException.class, () -> adder.add("a"));
        assertTrue(a.getMessage().contains("Dit is geen nummer! a"));
    }
}
