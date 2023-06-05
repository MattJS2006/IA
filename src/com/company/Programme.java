package com.company;

import java.time.LocalDate;

public class Programme {
    private String Training;
    private Calendar today;
    private String filename = "src/com/company/training_programme.txt";

    public Programme(){
        LocalDate startDate = LocalDate.now(); // Set the start date as today
        String line;
        int day = 1;

        while ((FileHandler.readWholeLineAt(filename,day-1)) != null) {
            LocalDate currentDate = startDate.plusDays(day - 1); // Calculate the current date

            System.out.println("Day " + day + ": " + currentDate);
            System.out.println(FileHandler.readWholeLineAt(filename,day-1));
            System.out.println();
            day++;
        }
    }
}