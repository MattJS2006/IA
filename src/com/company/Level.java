package com.company;

import java.util.ArrayList;

public class Level {
  
  private String current;
  private ArrayList<String> levels = new ArrayList<String>();
  // An ArrayList of goals for this Athlete
  private ArrayList<String> goals = new ArrayList<String>();
  
  public Level(){
    current = null;
    setLevels();
  }
  
  public Level(String current){
    this.current = current;
    setLevels();
  }
  
  public void setLevels() {
    levels.add("Beginner");
    levels.add("Development");
    levels.add("Seasoned Athlete");
    levels.add("Adult Development");
    levels.add("Young Elite");
    levels.add("Adult Elite");
  }

    public String getLevel(){
      return current;
    }

    public void setLevel(String newLevel){
      if(correctLevel(newLevel)) {
        current = newLevel;
        System.out.println("The new level is: " + current);
      } else {
        System.out.println("This level is invalid");
      }
    }

    public void display() {
      displayLevel();
      System.out.println("Goals :");
      for(int i = 0; i < goals.size(); i++){
        System.out.println("    " + (i+1) + " ~ " + goals.get(i));
      }
    }

  public void displayLevel() {
    System.out.println("Your current level is: " + current);
  }

    public boolean correctLevel(String level) {
      for (int i = 0; i < levels.size(); i++) {
        if (levels.get(i) == level) {
          return true;
        }
      }
      return false;
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