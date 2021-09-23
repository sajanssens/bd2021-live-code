package nl.belastingdienst.h11;

public class TopLevel {

    // static members -------------------------------------------------
    public static final int GETAL = 42;

    public static class StaticNested {
        public void isAccessToToplevelMemberAllowed() {
            // NO!
            // System.out.println(member); // Non-static field 'member' cannot be referenced from a static context
        }
        // ....
    }

    public static int doeWat() {
        // System.out.println(member); // Non-static field 'member' cannot be referenced from a static context
        return 42;
    }

    // non-static members -------------------------------------------------

    public String member = "Hallo";

    public class Inner {
        public Inner() {
        }

        public void isAccessToplevelMemberAllowed() {
            // YES!
            System.out.println(member);
        }
        // ....
    }
}
