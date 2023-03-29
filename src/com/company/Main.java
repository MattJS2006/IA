package com.company;

public class Main {

    public static void main(String[] args) {
        // Database logins = new Database("src/com/company/Logins.txt",80,20);
        Quotes quote = new Quotes();
        quote.displayQuote();
        Calendar cal = new Calendar();
        System.out.println(cal.returnTime());
        Calendar nextQuote = new Calendar();
        nextQuote.setCal(0,0,0);
        nextQuote.Daily();
    }
}