package com.company;

import java.util.Random;
import java.util.ArrayList;

public class Quotes {

    private int currentPos;
    private ArrayList<String> quotes = new ArrayList<String>();
    private String filename = "src/com/company/Quotes.txt";

    public Quotes(){
        currentPos = 0;
        setQuotes();
    }

    public void setQuotes(){
        int count = FileHandler.countLines(filename);
        for(int i = 0; i < count; i++){
            quotes.add(FileHandler.readFromFile(filename,i));
        }
        System.out.println(quotes);
    }

    public String getQuote(){
        Random rand = new Random();
        boolean found = false;
        int n = 0;
        while(!found) {
            n = rand.nextInt(quotes.size());
            if (n == currentPos){
                found = false;
            } else {
                found = true;
            }
        }
        currentPos = n;
        String quote = quotes.get(n);
        return quote;
    }

    public void displayQuote(){
        System.out.println("\n" + getQuote());

    }
}
