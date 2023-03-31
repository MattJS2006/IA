package com.company;

import java.util.ArrayList;

public class Development extends Level{

    // An ArrayList of goals for this level of Athlete
    private ArrayList<String> goals = new ArrayList<String>();

    public Development(){
        super("Development");
    }

    // Displays the goals of the Athlete
    public void displayGoals(){
        for(int i = 0; i < goals.size(); i++){
            System.out.println((i+1) + " ~ " + goals.get(i));
        }
    }

    // Sets a goal for the Athlete
    public void setGoals(String goal){
        goals.add(goal);
    }

    // Removes a specified goal
    public void removeGoal(int pos){
        pos = pos-1;
        goals.remove(pos);
    }
}
