package nl.belastingdienst.fundamentals.h5;

public class VarArg {

    public double average(int... values) {
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return sum / values.length;
    }

    public double average2(int[] values) {
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return sum / values.length;
    }

    public static void main(String[] args) {
        double average = new VarArg().average(10, 11, 12, 13);
        double average2 = new VarArg().average2(new int[]{10, 11, 12, 13});
    }

}
