package classwork2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        String inputString = "jvvskljshhhhbvlsekrjjjjjvsvnjklrsnjfjgjgffkfdkrrrrrr";
        int maxAppears = main.findMaxAppear(inputString);
        System.out.println(maxAppears);

        String symbolsForOddString = "asdfghjkllkjhgfdsa";
        int oddSymbols = main.countMaxOddSymbols(symbolsForOddString);
        System.out.println(oddSymbols);
    }

    /**
     * Gets count odd chars in given String
     * @param inputString any string input
     * @return max appearance of odd symbols
     */
    private int countMaxOddSymbols(String inputString) {
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < inputString.length(); i++) {
            if (!list.contains(inputString.charAt(i))) {
                list.add(inputString.charAt(i));
            }
        }
        return list.size();
    }

    /**
     * Find max count of appearance of chars that are equal and goes one after another
     * @param inputString any input string
     * @return max similar chars appearance in a row
     */
    private int findMaxAppear(String inputString) {
        int counter = 1;
        int tempMax = 0;
        for (int i = 1; i < inputString.length(); i++) {
            if (inputString.codePointAt(i - 1) == inputString.codePointAt(i)) {
                counter++;
                if (i == inputString.length() - 1) {
                    tempMax = counter > tempMax ? counter : tempMax;
                }
            } else {
                tempMax = counter > tempMax ? counter : tempMax;
                counter = 1;
            }
        }
        return tempMax;
    }
}