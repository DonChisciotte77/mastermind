package code;

// Digit is a single component of the code. It has been used to simply the checkOccurrences method
public class Digit {
    private final int value;

    public Digit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean equals(Digit digit) {
        return this.value == digit.getValue();
    }
}
