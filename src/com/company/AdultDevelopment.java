package com.company;

import java.util.ArrayList;

public class AdultDevelopment extends Level{

    // An ArrayList of goals for this level of Athlete
    private ArrayList<String> goals = new ArrayList<String>();

    public AdultDevelopment(){
        super("Adult Development");
    }

    // Displays the Athlete's goals
    public void displayGoals(){
        for(int i = 0; i < goals.size(); i++){
            System.out.println((i+1) + " ~ " + goals.get(i));
        }
    }

    // Sets the Athlete's goals
    public void setGoals(String goal){
        goals.add(goal);
    }

    // Removes a goal
    public void removeGoal(int pos){
        pos = pos-1;
        goals.remove(pos);
    }
}
