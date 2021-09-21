package nl.belastingdienst.h6;

import nl.belastingdienst.h7.Author;

import java.util.Arrays;
import java.util.List;

public class ArraysCovariant {

    public void printIntValue(Number n) { // you can pass any number, e.g. number, integer, double, ...
        System.out.println(n.intValue());
    }

    public void addInterest(Number[] numbers) { // compile
        for (int i = 0; i < numbers.length; i++) {
            double result = numbers[i].doubleValue() * 1.04;
            numbers[i] = result;
        }
    }

    public void addInterestInvariant(List<Number> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            accounts.set(i, accounts.get(i).doubleValue() * 1.04);
        }
    }

    // PECS: Producer extends, Consumer super.

    // Covariant:
    // Als Number <- Integer, dan is Number[] ook een <- van Integer[]
    // Contravariant:
    // Als Number <- Integer, dan is Coll<Number> een -> van Coll<Integer>

    public void addInterestCovariant(List<? extends Number> accountsProducer) { // covariant
        for (int i = 0; i < accountsProducer.size(); i++) {
            double d = accountsProducer.get(i).doubleValue() * 1.04;
            // accountsProducer.add(d); // NOK
        }
    }

    public void addInterestContravariant(List<? super Number> accountsConsumer) { // contravariant, lower bound
        for (int i = 0; i < accountsConsumer.size(); i++) {
            // Number object = accountsConsumer.get(i); // NOK
            Object object = accountsConsumer.get(i); // OK
            if (object instanceof Number) { // needed
                accountsConsumer.add(((Number) object).doubleValue() * 1.04);
            }
        }
    }

    public static void main(String[] args) {
        ArraysCovariant a = new ArraysCovariant();

        // Voor arrays:
        Number[] numbers = {10000.45d, 20_000, (byte) 50, 238_746_238_746_234L};
        a.addInterest(numbers);

        Integer[] integers = {1, 2, 3, 4};
        a.addInterest(integers); // runtime type is Integer[]; Arrays are covariant, but this is dangerous!!!

        // Voor List:
        List<Object> objectList = Arrays.asList("", 1, new Author(), 1.0d);
        List<Number> numberList = Arrays.asList(1d, 2L, 3, 4, 5);
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubleList = Arrays.asList(1d, 2d, 3d);

        a.addInterestInvariant(numberList);
        // a.addInterestInvariant(doubleList); // so; List<T> is INvariant
        // a.addInterestInvariant(integerList); // so; List<T> is INvariant

        // a.addInterestCovariant(objectList); // NOK
        a.addInterestCovariant(numberList);
        a.addInterestCovariant(doubleList);
        a.addInterestCovariant(integerList);

        a.addInterestContravariant(objectList);
        a.addInterestContravariant(numberList);
    }

}
