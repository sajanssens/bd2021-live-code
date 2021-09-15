package nl.belastingdienst.h7;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HoeGoedTestbaarMakenTest {

    private HoeGoedTestbaarMaken target;

    @Before // wordt opnieuw uitgevoerd vóór iedere test
    public void setUp() throws Exception {
        target = new HoeGoedTestbaarMaken();
    }

    @Test
    public void printenMaarTesten() {
        String message = target.createMessage();
        Assert.assertEquals("Hello World!", message);
    }

}
