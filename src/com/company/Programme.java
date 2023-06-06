package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Programme {
    private String Training;
    private Calendar today;
    private String filename = "src/com/company/training_programme.txt";

    public Programme(){
        LocalDate startDate = LocalDate.now(); // Set the start date as today
        String line;
        int day = 1;
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");

        while (day-1 < 7) {
            LocalDate currentDate = startDate.plusDays(day - 1); // Calculate the current date

            System.out.println(currentDate + ":");
            line = FileHandler.readFromFile(filename,day-1);
            String[] parts = line.split(": ");
            String date = dateFormat.format(currentDate);
            if(parts[0] == date){
                System.out.println("Rest day / Personal Training");
            } else {
                System.out.println(line);
            }
            System.out.println();
            day++;
        }
    }
}