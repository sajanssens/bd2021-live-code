package nl.belastingdienst.h5;

public class Overloading {

    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) { // ander aantal params
        return a + b + c;
    }

    public int add(String a, int b) {
        return Integer.parseInt(a) + b;
    }

    public static void main(String[] args) {
        Overloading overloading = new Overloading();
        int result = overloading.add(1, 2);
    }

    // NOT ALLOWED!

    // public void add(int a, int b) { // different return type
    //     System.out.println(a);
    //     System.out.println(b);
    // }

    // public int add(int a2, int b2) { // different param name(s)
    //     return a2 + b2;
    // }

}
