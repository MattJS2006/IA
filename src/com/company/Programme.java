package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Programme {
    private String Training;
    private Calendar today;
    private String filename = "src/com/company/training_programme.txt";

    public Programme(){
        clear();
        LocalDate startDate = LocalDate.now(); // Set the start date as today
        String line;
        int day = 1;
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");

        while (day-1 < 7) {
            LocalDate currentDate = startDate.plusDays(day - 1); // Calculate the current date
            Date latestDate = localDateToDate(currentDate);
            String parts[] = null;

            System.out.println(currentDate + ":");
            line = FileHandler.readFromFile(filename, day - 1);
            if (line != null) {
                parts = line.split(": ");
            }
            String date = dateToString(latestDate);
            if(parts == null){
                System.out.println("Rest day / Personal Development");
            }else if(parts[0] == date){
                System.out.println(parts[1]);
            } else {
                System.out.println("Rest day / Personal Development");
            }
            System.out.println();
            day++;
            System.out.println(currentDate);
        }
    }

    public String dateToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    public Date localDateToDate(LocalDate localDate) {
        ZoneId zoneId = ZoneId.systemDefault();
        return Date.from(localDate.atStartOfDay(zoneId).toInstant());
    }

    public void clear(){

    }
}