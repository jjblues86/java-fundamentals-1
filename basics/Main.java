/*
 * jen shin
 * This is lab 1 for 401
 * that contains three methods.
 * 28 May 2019
 * Main.java
 */

import java.util.Random;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        int dogCount = 1;
        System.out.println("I own " + dogCount + " " + pluralize("dog", dogCount) + ".");

        int catCount = 2;
        System.out.println("I own " + catCount + " " + pluralize("cat", catCount) + ".");

        int turtleCount = 0;
        System.out.println("I own " + turtleCount + " " + pluralize("turtle", turtleCount) + ".");

        flipNHeads(1);
        flipNHeads(3);

        clock();
    }

    /**
     * Accepts a word and a number and returns a string
     * with the word pluralized with an “s” if the number is zero,
     * or greater than one.
     * @param word String
     * @param number int
     * @return word String
     */
    private static String pluralize(String word, int number) {
        if(number == 0) {
            return word;
        } else {
            return word + 's';
        }

    }

    /**
     * Accepts an integer n and flips coins until n heads are flipped in a row.
     * @param number
     */
    private static void flipNHeads(int number) {
        int headTracker = 0;
        int total = 0;
        while (headTracker != number) {
            total++;
            //1 == heads
            int randomNum = randomNumber();
            if (randomNum == 0) {
                System.out.println("tails");
                headTracker = 0;
            } else {
                System.out.println("heads");
                headTracker++;
            }
        }
        String head = "head";
        if(number > 1) {
            head = "heads";
        }
        System.out.println("It it took " + total + " flips to flip " + number + " " + head + " in row.");

    }

    //helper function to generate number between 0 and 1

    private static int randomNumber() {
        return new Random().nextInt(2);
    }


    /**
     * Uses Java’s built-in LocalDateTime object
     * to constantly print out the current time to the console,
     * second by second. The program should run until
     * someone manually kills it with CTRL-C
     * or presses the “stop” button in their IDE.
     * Each time should only be printed once.
     * The program detects when the seconds increase
     * and only print something out when the timestamp changes.
     */
    private static void clock() {
        LocalDateTime now = LocalDateTime.now();

        while(true) {
            LocalDateTime current = LocalDateTime.now();
            if(now.getSecond() != current.getSecond()) {
                now = current;
                String statement = current.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                System.out.println(statement);
            }
        }
    }

}