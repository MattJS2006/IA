package com.company;

import java.util.ArrayList;

public class Beginner extends Level{

    private ArrayList<String> goals = new ArrayList<String>();

    public Beginner(){
        super("Beginner");
    }

    public void displayGoals(){
        for(int i = 0; i < goals.size(); i++){
            System.out.println(i + " ~ " + goals.get(i));
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
