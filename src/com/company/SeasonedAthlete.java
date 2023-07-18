package com.company;

import java.util.ArrayList;

public class SeasonedAthlete extends Athlete {

    private ArrayList<String> goals = new ArrayList<String>();

    public SeasonedAthlete(){
        super("Seasoned Athlete");
    }

    public void display(){
        displayLevel();
        System.out.println("Goals :");
        for(int i = 0; i < goals.size(); i++){
            System.out.println("    " + (i+1) + " ~ " + goals.get(i));
        }
    }

    public void setGoals(String goal){
        goals.add(goal);
    }

    public void removeGoal(int pos){
        pos = pos-1;
        goals.remove(pos);
    }
}
