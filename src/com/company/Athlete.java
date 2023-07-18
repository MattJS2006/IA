package com.company;

import java.util.ArrayList;

public class Athlete extends Level {
    private ArrayList<String> personalGoals;

    public Athlete() {
        super();
        personalGoals = new ArrayList<>();
    }

    public Athlete(String currentLevel) {
        super(currentLevel);
        personalGoals = new ArrayList<>();
    }

    public ArrayList<String> getPersonalGoals() {
        return personalGoals;
    }

    public void setPersonalGoals(ArrayList<String> personalGoals) {
        this.personalGoals = personalGoals;
    }

    public void addPersonalGoal(String goal) {
        personalGoals.add(goal);
    }

    public void removePersonalGoal(String goal) {
        personalGoals.remove(goal);
    }
}