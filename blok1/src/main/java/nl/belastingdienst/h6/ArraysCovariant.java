package nl.belastingdienst.h6;

import nl.belastingdienst.h7.Author;

import java.util.Arrays;
import java.util.List;

public class ArraysCovariant {

    public void printIntValue(Number n) { // covariant
        System.out.println(n.intValue());
    }

    // Covariant:
    // Als Number <- Integer, dan is Number[] ook een <- van Integer[]

    // Contravariant:
    // Als Number <- Integer, dan is Coll<Number> een -> van Coll<Integer>

    public void addInterest(Number[] accounts) {
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = accounts[i].doubleValue() * 1.04;
        }
    }

    public void addInterest(List<Number> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            accounts.set(i, accounts.get(i).doubleValue() * 1.04);
        }
    }

    // PECS: Producer extends, Consumer super.
    public void addInterest2(List<? extends Number> accountsProducer) { // covariant
        for (int i = 0; i < accountsProducer.size(); i++) {
            double d = accountsProducer.get(i).doubleValue() * 1.04;
            // accountsProducer.add(d); // NOK
        }
    }

    public void addInterest3(List<? super Number> accountsConsumer) { // contravariant, lower bound
        for (int i = 0; i < accountsConsumer.size(); i++) {
            // Number object = accountsConsumer.get(i); // NOK
            Object object = accountsConsumer.get(i); // OK
            accountsConsumer.add(4);
        }
    }

    public static void main(String[] args) {
        ArraysCovariant a = new ArraysCovariant();

        // Voor arrays:
        Number[] accountBalance = {10000.45d, 20_000, (byte) 50, 238_746_238_746_234L};
        a.addInterest(accountBalance);

        Integer[] accountBalance2 = {1, 2, 3, 4};
        a.addInterest(accountBalance2); //

        // Voor Generic list:
        List<Number> numbers = Arrays.asList(1d, 2L, 3, 4, 5);
        a.addInterest(numbers);

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        // a.addInterest(integers); // so; List<T> is INvariant
        a.addInterest2(integers);

        List<Double> doubles = Arrays.asList(1d, 2d, 3d);
        a.addInterest2(doubles);

        List<Object> accountsConsumer = Arrays.asList("", 1, new Author(), 1.0d);
        a.addInterest3(accountsConsumer);
    }

}
