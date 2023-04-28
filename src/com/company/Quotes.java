package com.company;

import java.util.Random;
import java.util.ArrayList;

public class Quotes {

    private static int currentPos;
    private static ArrayList<String> quotes = new ArrayList<String>();
    private String filename = "src/com/company/Quotes.txt";
    private static String currentQuote;

    public Quotes() {
        currentPos = 0;
        setQuotes();
        getQuote();
    }

    public void setQuotes() {
        int count = FileHandler.countLines(filename);
        for (int i = 0; i < count; i++) {
            quotes.add(FileHandler.readFromFile(filename, i));
        }
    }

    public static String getQuote() {
        Random rand = new Random();
        boolean found = false;
        int n = 0;
        while (!found) {
            n = rand.nextInt(quotes.size());
            if (n == currentPos) {
                found = false;
            } else {
                found = true;
            }
        }
        currentPos = n;
        String quote = quotes.get(n);
        currentQuote = quote;
        return quote;
    }

    public static void displayQuote() {
        System.out.println("\n" + currentQuote);
    }
}