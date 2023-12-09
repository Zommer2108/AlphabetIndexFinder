package program;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    /**
     * Method prints index of the corresponding letter that is being
     * searched for.
     *
     * @param alphabet     array of the given alphabet
     * @param searchLetter letter used to find the corresponding index
     */
    private static void returnIndexFromLetter(String[] alphabet, String searchLetter) {
        for (int i = 0; i < alphabet.length; i++) {

            /*searchLetter.toUppercase() is being used for to also
                find letters that are in lower case
             */
            if (alphabet[i].equals(String.valueOf(searchLetter.toUpperCase()))) {
                System.out.println(
                    "Der Buchstabe " + searchLetter.toUpperCase() + " ist an der Stelle " + (i + 1) + " im Alphabet.");
            }
        }
    }

    /**
     * Method prints the letter of the corresponding index that is being
     * searched for.
     *
     * @param alphabet array of the given alphabet
     * @param index    index used to find the corresponding letter
     */
    private static void returnLetterFromIndex(String[] alphabet, int index) {
        System.out.println(
            //index - 1 because of ArrayOutOfBoundsException
            "Der Index " + index + " steht für den Buchstabe " + (alphabet[index - 1]) + " im Alphabet.");
    }

    public static void main(String[] args) {
        final int MAX_ALPHABET_SIZE = 26;                                           //AlphabetSizeConstant
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Scanner userInput = new Scanner(System.in);
        String programmContinue = "y";

        while (programmContinue.equals("y")) {
            System.out.print(
                "Wählen Sie den Programmmodus.\n (1) für Suche nach dem Buchstaben, (2) für Suche nach dem Index:");
            int programmMode = userInput.nextInt();

            switch (programmMode) {
                case 1:
                    System.out.print("Gib den Buchstaben ein, den du suchst:");
                    String inputStr = userInput.next();
                    if (inputStr.length() > 1) {
                        System.out.println("Bitte nur einen Buchstaben eingeben!");
                        continue;
                    }
                    returnIndexFromLetter(alphabet, inputStr);
                    break;

                case 2:
                    System.out.print("Gib den Index ein, den du suchst:");
                    int inputInt = userInput.nextInt();
                    if ((inputInt > MAX_ALPHABET_SIZE || inputInt < 1)) {
                        System.out.println("Bitte nur Zahlen einschließlich und zwischen 1 bis 26 eingeben!");
                        continue;
                    }
                    returnLetterFromIndex(alphabet, inputInt);
                    break;

                default:
                    System.out.println("Bitte entweder 1 oder 2 eingeben!");
                    break;
            }
            System.out.print("Willst du nochmal ein Wort suchen? (y/n):");
            programmContinue = userInput.next();
        }
        System.out.println("Programm wird beendet...");
    }
}
