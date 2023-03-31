package com.company;

public class Event {

    private Calendar date;
    private int month;
    private String name;

    public Event(){
        date = new Calendar();
    }

    public Event(int year, int month, int day, int hour, int minute, String name){
        date = new Calendar();
        date.setDate(year, month, day, hour, minute);
        this.month = month;
        this.name = name;
    }

    // Displays the date of the event
    public void displayEvent(){
        date.display();
    }

    // Sets the date of an event
    public void setEvent(int year, int month, int day, int hour, int minute, String name){
        date.setDate(year, month, day, hour, minute);
        this.month = month;
        this.name = name;
    }

    // Checks if the event is this month
    public void soon(){
        if(Calendar.thisMonth(month)){
            displayEvent();
        }
    }
}
