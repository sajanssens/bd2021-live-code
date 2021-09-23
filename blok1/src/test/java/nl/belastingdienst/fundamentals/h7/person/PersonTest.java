package nl.belastingdienst.fundamentals.h7.person;

import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class PersonTest {

    @Test(expected = PersonDiedException.class)
    public void whenHaveBirthdayIsCalledOnAOldPersonHeDies() throws PersonDiedException {
        // given
        Person p = new Person(130);

        // when: doe iets met de Person
        p.haveBirthday();
    }

    @Test
    public void whenHaveBirthdayIsCalledOnAOldPersonHeDiesWithAssert() throws PersonDiedException {
        // given
        Person p = new Person(130);

        // when: doe iets met de Person
        assertThrows(PersonDiedException.class, () -> p.haveBirthday());
    }
}
