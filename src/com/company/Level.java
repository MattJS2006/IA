package com.company;

import java.util.ArrayList;

public class Level {
  
  private String current;
  private ArrayList<String> levels = new ArrayList<String>();
  
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
      current = newLevel;
      System.out.println("The new level is: " + current);
    }

    public void display() {
      System.out.println("Your current level is: " + current);
    }

  public void displayLevel() {
    System.out.println("Your current level is: " + current);
  }

    public boolean correctLevel() {
      for (int i = 0; i < levels.size(); i++) {
        if (levels.get(i) == current) {
          return true;
        }
      }
      return false;
    }
  }