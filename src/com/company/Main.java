package com.company;

public class Main {

    public static void main(String[] args) {
        // Database logins = new Database("src/com/company/Logins.txt",80,20);
        Quotes quote = new Quotes();
        quote.getQuote();
        System.out.println(quote);
    }
}
