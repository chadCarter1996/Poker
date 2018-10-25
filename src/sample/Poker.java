package sample;

/**
 * Created by Chad Carter on 10/19/2018.
 */

import java.util.Arrays;
import java.util.Random;
import java.util.*;


public class Poker {

    public static String[] createDeck(int numSuits, int numCardValues) {
        String[] cardValues = {"A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
        String[] suits = {"hearts", "diamonds", "spades", "clubs"};
        String[] finalDeck = new String[numSuits*numCardValues];
        int numCards = 0;

        for (int i=0; i < numCardValues; i++) {
            for (int j = 0; j < numSuits; j++) {
                finalDeck[numCards] = "" + cardValues[i] + "-" + suits[j] + "";
                numCards++;
            }
        }
        return finalDeck;
    }

    public static void showDeck(String[] deck) {
        int deckSize = deck.length;
        for (int i = 0; i < deckSize; i++) {
            System.out.println(deck[i]);
        }
    }

    public static String[] shuffleDeck(String[] deck) {

        int numCards = deck.length;
        String[] shuffledDeck = new String[numCards];
        LinkedList<Integer> orderOfCards = new LinkedList<>();
        Random r = new Random();
        int num;
        while (orderOfCards.size() < numCards) {
            num = r.nextInt(numCards);
            if (!orderOfCards.contains(num)) {
                orderOfCards.add(num);
            }
        }

        for (int i = 0; i < numCards; i++) {
            shuffledDeck[i] = deck[orderOfCards.get(i)];
        }

        return shuffledDeck;
    }

    public static String[] proveNoRepeats(String[] shuffledDeck) {

        int length = shuffledDeck.length;
        String[] provenDeck = new String[length];
        Arrays.sort(shuffledDeck);
        for (int i=0; i<length; i++) {
            provenDeck[i] = shuffledDeck[i];
        }
        return provenDeck;
    }

    public static String[][] preFlop(String[] shuffledDeck, int numPlayers) {
        int dealtCards = 0;
        String[][] playersHands = new String[numPlayers][2];
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < numPlayers; i++) {
                playersHands[i][j] = shuffledDeck[dealtCards];
                dealtCards++;
            }
        }
        return playersHands;
    }

    public static String[] flop(String[] shuffledDeck) {
        String[] flop = new String[3];
        for (int i=0; i<flop.length; i++) {
            flop[i] = shuffledDeck[11 + i];
        }
        return flop;
    }

    public static String[] turn(String[] shuffledDeck) {
        String[] turn = new String[4];
        for (int i=0; i<turn.length - 1; i++) { //The flop cards...
            turn[i] = shuffledDeck[11 + i];
        }
        turn[3] = shuffledDeck[15]; //The turn card
        return turn;
    }

    public static String[] river(String[] shuffledDeck) {
        String[] river = new String[5];
        for (int i=0; i<river.length - 2; i++) { //The flop cards...
            river[i] = shuffledDeck[11 + i];
        }
        river[3] = shuffledDeck[15]; //The turn card
        river[4] = shuffledDeck[17];
        return river;
    }


    public static void main(String[] args) {
        String[] firstDeck = createDeck(4,13);
        //showDeck(firstDeck);
        System.out.println("Welcome to Texas Hold'Em :) Here are your cards.");
        System.out.println();
        String[] shuffledDeck = shuffleDeck(firstDeck);
        System.out.println(Arrays.toString(shuffledDeck));
        System.out.println(Arrays.deepToString(preFlop(shuffledDeck, 5)));
        System.out.println("Here's the flop...");
        System.out.println(Arrays.toString(flop(shuffledDeck)));
        System.out.println("Here's the turn...");
        System.out.println(Arrays.toString(turn(shuffledDeck)));
        System.out.println("Here's the river...");
        System.out.println(Arrays.toString(river(shuffledDeck)));

        //showDeck(firstDeck);
    }

}
