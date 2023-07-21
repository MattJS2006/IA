package com.company;

import java.util.ArrayList;

public class Athlete extends Level {
    private ArrayList<String> personalGoals;
    private int age;
    private String firstName;
    private String Surname;

    public Athlete() {
        super();
        personalGoals = new ArrayList<>();
    }

    public Athlete(String currentLevel) {
        super(currentLevel);
        personalGoals = new ArrayList<>();
    }

    public Athlete(String firstName, String Surname, int age){
        this.firstName = firstName;
        this.Surname = Surname;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }
}
