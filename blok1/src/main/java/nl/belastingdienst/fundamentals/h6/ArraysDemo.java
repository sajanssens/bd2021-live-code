package nl.belastingdienst.fundamentals.h6;

import static java.util.Arrays.stream;

public class ArraysDemo {

    public double average(int[] numbers) {
        return stream(numbers).average().orElse(0);
    }

    public static void main(String[] args) {
        ArraysDemo arraysDemo = new ArraysDemo();

        // arraysDemo.average({1, 2, 3, 4, 5}); // NOK
        arraysDemo.average(new int[]{1, 2, 3, 4, 5}); // OK

        int[] ints = {1, 2, 3, 4, 5};
        arraysDemo.average(ints); // OK

    }

}
