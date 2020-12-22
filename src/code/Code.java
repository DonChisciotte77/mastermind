package code;

import mastermind.GameConstants;

import java.util.ArrayList;

public class Code {
    private final ArrayList<Digit> code;
    private String feedback;

    public Code() {
        this.code = new ArrayList<>();
        this.feedback = "";
    }

    public void add(Digit digit) {
        this.code.add(digit);
    }

    public Digit get(int i) {
        return this.code.get(i);
    }

    public int size() {
        return this.code.size();
    }

    public boolean equals(Code code) {
        for (int i = 0; i < GameConstants.MAX_CODE_LENGTH; i++) {
            if (!this.code.get(i).equals(code.get(i)))
                return false;
        }

        return true;
    }

    public void checkOccurrences(Code code) {
        StringBuilder tempCode = new StringBuilder(code.toString());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < GameConstants.MAX_CODE_LENGTH; i++) {
            if (this.code.get(i).equals(code.get(i))) {
                tempCode.replace(i, i + 1, "9");
                sb.append("X");
            }
        }

        for (int i = 0; i < GameConstants.MAX_CODE_LENGTH; i++) {
            int x = Integer.parseInt(String.valueOf(tempCode.charAt(i)));
            int y = this.code.get(i).getValue();

            for (int j = 0; j < tempCode.length(); j++) {
                if (Integer.parseInt(String.valueOf(tempCode.charAt(j))) == this.code.get(i).getValue())
                    sb.append("Y");
            }
        }

        this.feedback = sb.toString();
    }

    public String getFeedback() {
        return feedback;
    }

    public void clear() {
        this.code.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Digit digit : code)
            sb.append(digit.getValue());

        return sb.toString();
    }
}
