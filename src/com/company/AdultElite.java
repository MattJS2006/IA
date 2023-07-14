package com.company;

import java.util.ArrayList;

public class AdultElite extends Athlete {

    // An ArrayList of goals for this level of Athlete
    private ArrayList<String> goals = new ArrayList<String>();

    public AdultElite(){
        super("Adult Elite");
    }

    // Displays the goals of the Athlete
    public void display(){
        displayLevel();
        System.out.println("Goals :");
        for(int i = 0; i < goals.size(); i++){
            System.out.println("    " + (i+1) + " ~ " + goals.get(i));
        }
    }

    // Sets the Athlete's goals
    public void setGoals(String goal){
        goals.add(goal);
    }

    // Removes a specified goal
    public void removeGoal(int pos){
        pos = pos-1;
        goals.remove(pos);
    }
}
