package nl.belastingdienst.h5;

public class Recursion {

    public void printTotNul(int begin) {
        // imperatieve, procedurele stijl van coderen, gebiedende wijs, HOE?
        for (int i = begin; i > 0; i--) {
            System.out.println(i);
        }
    }

    public void printTotNulRecursive(int i) {
        // functionele stijl coderen, WAT?
        if (i <= 0) return; // stopconditie!!!

        // else:
        System.out.println(i);
        printTotNulRecursive(i - 1);
    }

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        // recursion.printTotNul(10);
        recursion.printTotNulRecursive(10);
    }

}
