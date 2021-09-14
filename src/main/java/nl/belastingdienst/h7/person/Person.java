package nl.belastingdienst.h7.person;

public class Person {

    public static final String UNIVERSAL_RIGHTS = "...equal.";
    private int age;

    public Person(int age) throws PersonDiedException {
        setAge(age);
    }

    public void haveBirthday() throws PersonDiedException {
        setAge(age + 1);
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) throws PersonDiedException {
        if (age < 130) {
            this.age += age;
        } else {
            throw new PersonDiedException("Persoon is overleden.");
        }
    }

}
