package nl.belastingdienst.fundamentals.h12;

public class App {

    public static void main(String[] args) {
        Person bram = new Person();
        System.out.println(bram);
        new FlauweWoordgrappen().process(bram);
        System.out.println(bram);
    }
}
