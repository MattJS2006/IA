package com.company;

import java.util.Random;
import java.util.ArrayList;

public class Quotes {

    private int currentPos;
    private ArrayList<String> quotes;

    public void setQuotes(){

    }

    public String getQuote(){
        Random rand = new Random();
        boolean found = false;
        while(!found) {
            int n = rand.nextInt(quotes.Length());
            if (n != currentPos){
                found = true;
            }
        }
        return quotes(n);
    }
}
