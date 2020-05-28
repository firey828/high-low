public class GameMethods {
    // ======== INSTANCE VARIABLES ========
    private int turns = 0;
    private int wins = 0;
    private int losses = 0;
    private boolean gameIsOver = false;

    // ======== GETTERS ========
    public boolean isGameOver() {
        return gameIsOver;
    }

    /*
     * Displays the String message as a pop-up.
     */
    public void msg(String message) {
        String trueMessage = "== W: " + wins + " == L: " + losses + " == \n" + message;
        JOptionPane.showMessageDialog((Component) null, trueMessage);
    }

    /*
     * Returns the numerical value of the card represented by String card.
     */
    public int numberValue(String card) {
        if (card.substring(0, 3).equalsIgnoreCase("ACE")) {
            return 1;
        } else if (card.substring(0, 3).equalsIgnoreCase("TWO")) {
            return 2;
        } else if (card.substring(0, 5).equalsIgnoreCase("THREE")) {
            return 3;
        } else if (card.substring(0, 4).equalsIgnoreCase("FOUR")) {
            return 4;
        } else if (card.substring(0, 4).equalsIgnoreCase("FIVE")) {
            return 5;
        } else if (card.substring(0, 3).equalsIgnoreCase("SIX")) {
            return 6;
        } else if (card.substring(0, 5).equalsIgnoreCase("SEVEN")) {
            return 7;
        } else if (card.substring(0, 5).equalsIgnoreCase("EIGHT")) {
            return 8;
        } else if (card.substring(0, 4).equalsIgnoreCase("NINE")) {
            return 9;
        } else if (card.substring(0, 3).equalsIgnoreCase("TEN")) {
            return 10;
        } else if (card.substring(0, 4).equalsIgnoreCase("JACK")) {
            return 11;
        } else if (card.substring(0, 5).equalsIgnoreCase("QUEEN")) {
            return 12;
        } else if (card.substring(0, 4).equalsIgnoreCase("KING")) {
            return 13;
        } else {
            System.out.println("this should literally never happen. each and every card\nin this deck was written, one at a time, by me. if any card in\nthe deck does not follow these naming conventions, that\'s not\non me.\n\nthat\'s on you.");
            System.exit(-1);
            return -1;
        }
    }

    /*
     * Returns true if the player's guess is correct, false otherwise
     */
    public boolean guessIsCorrect(String guess, String currentCard, String otherCard) {
        turns++;
        if (numberValue(currentCard) == numberValue(otherCard)) {
            return true;
        } else if (guess.equalsIgnoreCase("LOWER") && numberValue(currentCard) < numberValue(otherCard)) {
            wins++;
            return true;
        } else if (guess.equalsIgnoreCase("HIGHER") && numberValue(currentCard) > numberValue(otherCard)) {
            wins++;
            return true;
        } else {
            losses++;
            if (losses == 3) {
                double chance = calculateChancesOfGettingThisFar();
                String chanceResult = "....oh dear. Well, the point is, it\'s a hard game!";
                if (Double.isFinite(chance) && !Double.isNaN(chance)) {
                    chanceResult = " " + chance + "%!";
                }

                msg("You guessed wrong three times, so you lost! You aren\'t alone, though.");
                msg("The chances of actually winning this game are 0.0000000847343%, and ");
                msg("the chances of getting as far as you did are" + chanceResult);
                gameIsOver = true;
            }

            return false;
        }
    }

    /*
     * Calculates and returns the chances of the player having gotten as far in the game as they did.
     */
    public double calculateChancesOfGettingThisFar() {
        double chance = 0.0;
        double n = (double) turns;
        double k = (double) wins;
        double chanceOfSuccess = 0.55882352941;
        double chanceOfFailure = 1.0 - chanceOfSuccess;
        chance = n / k;
        chance *= Math.pow(chanceOfSuccess, k);
        chance *= Math.pow(chanceOfFailure, n - k);
        chance *= 100.0;
        return chance;
    }
}