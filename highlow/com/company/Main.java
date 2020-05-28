package com.company;

import com.company.GameMethods;
import java.awt.Component;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {

   public static void main(String[] args) {
      String[] cards = new String[52];
      new Scanner(System.in);
      cards[0] = "Ace of Spades";
      cards[1] = "Ace of Clubs";
      cards[2] = "Ace of Diamonds";
      cards[3] = "Ace of Hearts";
      cards[4] = "Two of Spades";
      cards[5] = "Two of Clubs";
      cards[6] = "Two of Diamonds";
      cards[7] = "Two of Hearts";
      cards[8] = "Three of Spades";
      cards[9] = "Three of Clubs";
      cards[10] = "Three of Diamonds";
      cards[11] = "Three of Hearts";
      cards[12] = "Four of Spades";
      cards[13] = "Four of Clubs";
      cards[14] = "Four of Diamonds";
      cards[15] = "Four of Hearts";
      cards[16] = "Five of Spades";
      cards[17] = "Five of Clubs";
      cards[18] = "Five of Diamonds";
      cards[19] = "Five of Hearts";
      cards[20] = "Six of Spades";
      cards[21] = "Six of Clubs";
      cards[22] = "Six of Diamonds";
      cards[23] = "Six of Hearts";
      cards[24] = "Seven of Spades";
      cards[25] = "Seven of Clubs";
      cards[26] = "Seven of Diamonds";
      cards[27] = "Seven of Hearts";
      cards[28] = "Eight of Spades";
      cards[29] = "Eight of Clubs";
      cards[30] = "Eight of Diamonds";
      cards[31] = "Eight of Hearts";
      cards[32] = "Nine of Spades";
      cards[33] = "Nine of Clubs";
      cards[34] = "Nine of Diamonds";
      cards[35] = "Nine of Hearts";
      cards[36] = "Ten of Spades";
      cards[37] = "Ten of Clubs";
      cards[38] = "Ten of Diamonds";
      cards[39] = "Ten of Hearts";
      cards[40] = "Jack of Spades";
      cards[41] = "Jack of Clubs";
      cards[42] = "Jack of Diamonds";
      cards[43] = "Jack of Hearts";
      cards[44] = "Queen of Spades";
      cards[45] = "Queen of Clubs";
      cards[46] = "Queen of Diamonds";
      cards[47] = "Queen of Hearts";
      cards[48] = "King of Spades";
      cards[49] = "King of Clubs";
      cards[50] = "King of Diamonds";
      cards[51] = "King of Hearts";

      for(String choice = "PLAY AGAIN"; choice.equalsIgnoreCase("PLAY AGAIN"); choice = JOptionPane.showInputDialog((Component)null, "Would you like to play again? If so, say \"PLAY AGAIN\". Otherwise, say \"EXIT\".")) {
         GameMethods _gm = new GameMethods();
         String currentCard = "PLACEHOLDER";

         for(int realCounter = 0; realCounter < 52 && !_gm.isGameOver(); ++realCounter) {
            _gm.msg("==== TURN " + (realCounter + 1) + " ====");
            int i = (int)(Math.random() * 51.0D);
            if(realCounter == 0) {
               currentCard = cards[38];
            } else {
               _gm.msg("I give you my " + currentCard + ". ");
            }

            _gm.msg("You have this card: " + currentCard + "\nI am about to draw a card. Will your card have a \"HIGHER\" or \"LOWER\" value than mine?");

            String higherOrLower;
            for(higherOrLower = "PLACEHOLDER"; !higherOrLower.equalsIgnoreCase("HIGHER") && !higherOrLower.equalsIgnoreCase("LOWER"); higherOrLower = JOptionPane.showInputDialog((Component)null, "Please respond with the word \"HIGHER\" or the word \"LOWER\".")) {
               if(higherOrLower.equalsIgnoreCase("EXIT")) {
                  _gm.msg("Goodbye.");
                  System.exit(0);
               }
            }

            _gm.msg("Time for the big reveal! My card was....");

            try {
               Thread.sleep(500L);
               _gm.msg("....");
               Thread.sleep(500L);
            } catch (InterruptedException var10) {
               _gm.msg("Drumroll, please....");
            }

            _gm.msg("....the " + cards[i] + "! ");
            boolean isCorrect = _gm.guessIsCorrect(higherOrLower, currentCard, cards[i]);
            if(isCorrect) {
               _gm.msg("Congratulations! Your guess was correct!");
            } else if(!_gm.isGameOver()) {
               _gm.msg("Oh no! Your guess was incorrect!");
            } else {
               _gm.msg("Better luck next time!");
            }

            currentCard = cards[i];
         }
      }

   }
}