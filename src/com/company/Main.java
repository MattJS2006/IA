package com.company;

public class Main {

    public static void main(String[] args) {
        // Database logins = new Database("src/com/company/Logins.txt",80,20);
        // Creates a new quote from the list of quotes and displays it
        Quotes quote = new Quotes();
        quote.displayQuote();
        // Creates a calendar and displays the current time
        Calendar cal = new Calendar();
        System.out.println(cal.returnTime());
        // Creates a system that changes the quote everyday if program remains on
        Calendar nextQuote = new Calendar();
        nextQuote.setCal(0,0,0);
        nextQuote.Daily();
        // Creates a new Beginner Athlete and displays there level
        Beginner Dave = new Beginner();
        Dave.setGoals("Run 100m in 20s by May");
        Dave.display();
        Dave.removeGoal(1);
        Dave.display();
        Programme myProgramme = new Programme();
        myProgramme.clear();
    }
}