package mastermind;

import code.*;
import utils.*;

public class Mastermind {
    private final Code secretCode;
    private final Code playerCode;
    private int attempts;
    private boolean isFind;

    public Mastermind() {
        this.secretCode = new Code();
        this.playerCode = new Code();
        this.attempts = 0;
        this.isFind = false;
    }

    public void play() {
        System.out.println("<--------------------[ MASTERMIND ]-------------------->");
        System.out.println("Welcome to Mastermind game! In this version, you will compete\n" +
                           "against the CPU. The CPU will generate a code composed by "
                           + GameConstants.MAX_CODE_LENGTH + " numbers.\n" +
                           "Allowed values: 0, 1, 2, 3, 4, 5. Same values are allowed.\n" +
                           "You have " + GameConstants.ATTEMPTS + " " +
                           "attempts. After each try a feedback will tell you what's correct:\n" +
                           "X correct position, Y correct number but wrong position.\n");
        System.out.print("CPU is creating the code... ");
        generateCode();
        System.out.println("code generated!" + this.secretCode);

        System.out.println("Now you have to find the code. Good luck!\n");
        findSecretCode();

        if (this.isFind)
            System.out.println("Congratulation, you win! Thanks for playing.");
        else
            System.out.println("Nice try, but you did not find the code.\n" +
                               "Secret code: " + this.secretCode.toString());
    }

    private void generateCode() {
        ReadRandom readRandom = new ReadRandom();

        while (this.secretCode.size() != GameConstants.MAX_CODE_LENGTH)
            secretCode.add(new Digit(readRandom.readInt(6)));
    }

    private void findSecretCode() {
        Read input = new Read();
        while (this.attempts < GameConstants.ATTEMPTS && !this.isFind) {
            System.out.println("<----------[ ATTEMPT " + (this.attempts + 1) + "]---------->");
            readCode(input);
            checkPlayerCode();
        }
    }

    private void checkPlayerCode() {
        if (playerCode.equals(secretCode))
            this.isFind = true;
        else {
            this.playerCode.checkOccurrences(this.secretCode);
            System.out.println("Feedback: " + this.playerCode.getFeedback());

            this.playerCode.clear();
            this.attempts++;
        }
    }

    private void readCode(Read input) {
        boolean isValid = true;
        do {
            System.out.print("Insert your code: ");
            String code = input.readString();

            char[] charArray = code.toCharArray();
            for (char c : charArray) {
                int singleDigit = Integer.parseInt(String.valueOf(c));

                if (singleDigit < 0 || singleDigit > 5)
                    isValid = false;
                else
                    playerCode.add(new Digit(singleDigit));
            }
        } while (!isValid);
    }

}
