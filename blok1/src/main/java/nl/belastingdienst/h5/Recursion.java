package nl.belastingdienst.h5;

import static java.util.Arrays.stream;

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

    // 5! = 5*4*3*2*1=120
    // n! =
    //      1! = 1
    //      n*(n-1)! EN
    //      5*4!
    //      5*4*3!
    //      5*4*3*2!
    //      5*4*3*2*1!
    //      5*4*3*2*1
    public long faculty(int n) {
        long result = 1;
        for (int i = n; i >= 1; i--) {
            result = result * i;
        }
        return result;
    }

    public long facultyRec(int n) {
        if (n == 1) return 1;

        return n * facultyRec(n - 1);
    }

    public int som(int... getallen) { // HOE?
        int som = 0;
        for (int i : getallen) {
            if (i % 2 != 0) continue;

            i = i * 2;
            som += i;
        }
        return som;
    }

    public int som2(int... getallen) { // WAT?
        return stream(getallen)          // stream
                .filter(i -> i % 2 == 0) // lambda
                .map(i -> i * 2)
                .sum();
    }

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        // recursion.printTotNul(10);
        // recursion.printTotNulRecursive(10);
        System.out.println(recursion.faculty(5));
        System.out.println(recursion.facultyRec(5));

        int som = recursion.som(1, 2, 3, 4, 5);
        int som2 = recursion.som2(1, 2, 3, 4, 5);
        System.out.println(som == som2);
    }

}
