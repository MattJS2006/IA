package com.company;

import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        // Database logins = new Database("src/com/company/Logins.txt",80,20);
        Quotes quote = new Quotes();
        quote.displayQuote();
        CalendarTime cal = new CalendarTime();
        System.out.println(cal.returnTime());
    }
}
