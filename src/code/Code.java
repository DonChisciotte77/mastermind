package code;

import mastermind.GameConstants;

import java.util.ArrayList;

// Code class, in practice an array of Digit
public class Code {
    private final ArrayList<Digit> code;    // Dynamic array which represents the code. Used because of the already existing methods
    private String feedback;    // Contains X or Y

    public Code() {
        this.code = new ArrayList<>(GameConstants.MAX_CODE_LENGTH); // Default capacity should (must) be 4
        this.feedback = "";
    }

    public void add(Digit digit) {
        this.code.add(digit);
    }   // Pushing a digit to the array

    public Digit get(int i) {
        return this.code.get(i);
    }   // Getting the digit (used for getting the value of the digit)

    public int size() {
        return this.code.size();
    }   // Array length

    // Check if a code is the same of another. This is made by checking every single digit value
    public boolean equals(Code code) {
        for (int i = 0; i < GameConstants.MAX_CODE_LENGTH; i++) {
            if (!this.code.get(i).equals(code.get(i)))  // If there's at least 1 wrong number, the research is done
                return false;
        }

        return true;
    }

    public void checkOccurrences(Code code) {
        StringBuilder tempCode = new StringBuilder(code.toString());    // Copy of the secret code
        StringBuilder sb = new StringBuilder(); // StringBuilder are more efficient if concatenation happens inside loop

        // Checking if there are correct numbers in correct position
        for (int i = 0; i < GameConstants.MAX_CODE_LENGTH; i++) {
            if (this.code.get(i).equals(code.get(i))) {
                tempCode.replace(i, i + 1, "9");    // If a value is find, it is replaced by a 9, a value that
                sb.append("X");                             // won't appear (because of controls in Mastermind class)
            }
        }

        // Checking if there are correct numbers in wrong position
        for (int i = 0; i < GameConstants.MAX_CODE_LENGTH; i++) {
            for (int j = 0; j < tempCode.length(); j++) {
                if (Integer.parseInt(String.valueOf(tempCode.charAt(j))) == this.code.get(i).getValue())
                    sb.append("Y");
            }
        }

        this.feedback = sb.toString();  // Copying value to feedback field
    }

    public String getFeedback() {
        return feedback;
    }

    public void clear() {
        this.code.clear();
    }

    // Custom toString that return the code only
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Digit digit : code)
            sb.append(digit.getValue());

        return sb.toString();
    }
}
