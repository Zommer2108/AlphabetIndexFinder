import java.util.Scanner;

public class Main {
    private static void findIndexFromLetter(String[] alphabet, String searchWord) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i].equals(String.valueOf(searchWord.toUpperCase()))) {
                System.out.println("Der Buchstabe " + searchWord.toUpperCase() + " ist an der Stelle " + (i + 1) + " im Alphabet.");
            }
        }
    }

    private static void findLetterFromIndex(String[] alphabet, int index) {
        System.out.println(
            "Der Index " + index + " steht für den Buchstabe " + (alphabet[index - 1]) + " im Alphabet.");
    }

    private static boolean checkAmountDigits(int input) {
        final int AMOUNT_DIGITS = 2;
        String checkResult = String.valueOf(input);
        return checkResult.length() > AMOUNT_DIGITS;
    }

    private static boolean checkLength(int input) {
        final int MAX_ALPHABET_SIZE = 26;
        return input > MAX_ALPHABET_SIZE;
    }

    public static void main(String[] args) {
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Scanner userInput = new Scanner(System.in);
        String programmEnd = "y";

        while (programmEnd.equals("y")) {
            System.out.print("Welcher Programmmodus? (1) Indexsuche oder (2) Buchstabensuche: ");
            int programmMode = userInput.nextInt();
            switch (programmMode) {
                case 1:
                    System.out.print("Gib den Buchstaben ein, den du suchst: ");
                    String inputStr = userInput.next();
                    if (inputStr.length() > 1) {
                        System.out.println("Bitte nur einen Buchstaben eingeben.");
                        continue;
                    }
                    findIndexFromLetter(alphabet, inputStr);
                    break;

                case 2:
                    System.out.print("Gib die Zahl ein, die du suchst: ");
                    int inputInt = Integer.parseInt(userInput.next());
                    if (checkLength(inputInt)) {
                        System.out.println("Bitte nur Zahlen zwischen 1 und 23 eingeben");
                        continue;
                    } else if (checkAmountDigits(inputInt)) {
                        System.out.println("Bitte nur eine zweistellige Zahl eingeben");
                        continue;
                    }
                    findLetterFromIndex(alphabet, inputInt);

                    break;

            }
            System.out.print("Willst du nochmal ein Wort suchen? (y/n): ");
            programmEnd = userInput.next();
        }
        System.out.println("Programm wird beendet");
    }
}
