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
        DailyRunner newQuote = new DailyRunner(cal, Quotes.displayQuote(), "newQuote");
    }
}
