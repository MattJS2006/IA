package com.company;

import java.util.Date;

public class Calendar {

    private java.util.Calendar cal;
    private java.util.Calendar now;

    public Calendar(){
        cal = java.util.Calendar.getInstance();
        now = java.util.Calendar.getInstance();
    }

    // Checks if the month on the calendar is equal to this month
    public static boolean thisMonth(int month) {
        if (month == java.util.Calendar.MONTH){
            return true;
        } else {
            return false;
        }
    }

    // Returns the current time
    public Date returnTime(){
        return cal.getTime();
    }

    // Sets the time of the calendar
    public void setCal(int hour, int minute, int second){
        cal.set(java.util.Calendar.HOUR_OF_DAY, hour);
        cal.set(java.util.Calendar.MINUTE, minute);
        cal.set(java.util.Calendar.SECOND, second);
    }

    // Sets the data and time of the calendar
    public void setDate(int year,int month, int day, int hour, int minute){
        cal.set(year, month, day, hour, minute);
    }

    // Creates a Runnable to run everyday
    public void Daily(){
        Thread t1 = new Thread(new Calendar.RunnableImpl());
        DailyRunner newQuote = new DailyRunner(cal, t1, "newQuote");
        newQuote.start();
    }

    // Displays the time
    public void display() {
        System.out.println(cal.getTime());
    }

    // A private class with a Runnable that runs everyday
    private class RunnableImpl implements Runnable {
        public void run() {
            // Checks if it works
            System.out.println(Thread.currentThread().getName() + ", executing run() method!");
            // Gets and displays a new quote
            Quotes.getQuote();
            Quotes.displayQuote();
        }
    }
}
