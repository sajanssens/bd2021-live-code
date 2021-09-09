package nl.belastingdienst.h2.ietsanders;

public class Author {

    public String name;
    public String genre;
    public int age;

    // Ctrl Shift T -> open test, of create test

    public int doeIets(String name) {
        if (name.equals("tolkien")) {
            return 42;
        } else {
            return 42;
        }
    }

    public void doeIetsAnders() {
        //...
        //...
        //...
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", age=" + age +
                '}';
    }
}
