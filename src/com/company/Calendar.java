package com.company;

import java.util.Date;

public class Calendar {

    private java.util.Calendar cal;
    private java.util.Calendar now;

    public Calendar(){
        cal = java.util.Calendar.getInstance();
        now = java.util.Calendar.getInstance();
    }

    public static boolean thisMonth(int month) {
        if (month == java.util.Calendar.MONTH){
            return true;
        } else {
            return false;
        }
    }

    public Date returnTime(){
        return cal.getTime();
    }

    public void setCal(int hour, int minute, int second){
        cal.set(java.util.Calendar.HOUR_OF_DAY, hour);
        cal.set(java.util.Calendar.MINUTE, minute);
        cal.set(java.util.Calendar.SECOND, second);
    }

    public void setDate(int year,int month, int day, int hour, int minute){
        cal.set(year, month, day, hour, minute);
    }

    public void Daily(){
        Thread t1 = new Thread(new Calendar.RunnableImpl());
        DailyRunner newQuote = new DailyRunner(cal, t1, "newQuote");
    }

    public void display() {
        System.out.println(cal.getTime());
    }

    private class RunnableImpl implements Runnable {
        public void run() {
            System.out.println(Thread.currentThread().getName() + ", executing run() method!");
            Quotes.getQuote();
            Quotes.displayQuote();
        }
    }
}
