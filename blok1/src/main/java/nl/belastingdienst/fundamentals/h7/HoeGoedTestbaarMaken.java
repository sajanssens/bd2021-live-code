package nl.belastingdienst.fundamentals.h7;

public class HoeGoedTestbaarMaken {

    public static void main(String[] args) {
        HoeGoedTestbaarMaken productionTarget = new HoeGoedTestbaarMaken();

        // System.out.println("Hello World!");
        // System.out.println("Hello World!");

        // DRY!

        System.out.println(productionTarget.createMessage());
        System.out.println(productionTarget.createMessage());
    }

    String createMessage() {
        return "Hello World!";
    }

}
