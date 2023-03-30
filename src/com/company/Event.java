package com.company;

public class Event {

    private Calendar date;
    private int month;


    public Event(){
        date = new Calendar();
    }

    public Event(int year, int month, int day, int hour, int minute){
        date = new Calendar();
        date.setDate(year, month, day, hour, minute);
        this.month = month;
    }

    public void displayEvent(){
        date.display();
    }

    public void setEvent(int year, int month, int day, int hour, int minute){
        date.setDate(year, month, day, hour, minute);
        this.month = month;
    }

    public void soon(){
        if(Calendar.thisMonth(month)){
            displayEvent();
        }
    }
}
