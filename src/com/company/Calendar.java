package com.company;

import java.util.Date;

public class Calendar {

    private java.util.Calendar cal;

    public Calendar(){
        cal = java.util.Calendar.getInstance();
    }

    public Date returnTime(){
        return cal.getTime();
    }

    public void setCal(int hour, int minute, int second){
        cal.set(java.util.Calendar.HOUR_OF_DAY, hour);
        cal.set(java.util.Calendar.MINUTE, minute);
        cal.set(java.util.Calendar.SECOND, second);
    }

    public void Daily(){
        Thread t1 = new Thread(new Calendar.RunnableImpl());
        DailyRunner newQuote = new DailyRunner(cal, t1, "newQuote");
    }

    private class RunnableImpl implements Runnable {
        public void run() {
            System.out.println(Thread.currentThread().getName() + ", executing run() method!");
            Quotes.getQuote();
            Quotes.displayQuote();
        }
    }
}
