package nl.belastingdienst.tdd;

public class StringAdder {

    public int add(String numbers) {
        if (isInvalid(numbers)) {
            return 0;
        }

        return processValidNumber(numbers);
    }

    private boolean isInvalid(String numbers) {
        return numbers == null || numbers.isBlank();
    }

    private int processValidNumber(String numbers) {
        try {
            return Integer.parseInt(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Dit is geen nummer! " + numbers);
        }
    }

}
