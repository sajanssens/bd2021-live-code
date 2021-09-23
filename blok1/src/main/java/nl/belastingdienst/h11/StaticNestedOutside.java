package nl.belastingdienst.h11;

public class StaticNestedOutside {

    public void accessMemberAllowed() {
        // System.out.println(member); // Cannot resolve symbol 'member'

        TopLevel topLevel  = new TopLevel();
        System.out.println(topLevel.member); // Cannot resolve symbol 'member'
    }
}
