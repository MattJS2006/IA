package com.company;

import java.util.ArrayList;

public class AthleteHandler {
    private ArrayList<Athlete> AllAthletes = new ArrayList<Athlete>();


    public void addAthlete(String FirstName,String Surname, int age){
        Athlete person = new Athlete(FirstName,Surname,age);
        AllAthletes.add(person);
    }

    public void removeAthlete(String FirstName, String Surname){

    }
}