package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

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
            Date latestDate = localDateToDate(currentDate);
            long days = numDays(currentDate);

            System.out.println(currentDate + ":");
            line = FileHandler.readFromFile(filename, (int) days);

            String date = dateToString(latestDate);
            if(line != null){
                System.out.println(line);
            }else {
                System.out.println("Rest day / Personal Development");
            }
            System.out.println();
            day++;
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
        FileHandler.clearFile(filename);
    }

    public long numDays(LocalDate current){
        LocalDate start = LocalDate.parse("2023-01-01");
        LocalDate end = current;

        long difInDays = start.until(end, ChronoUnit.DAYS);

        return difInDays;
    }

    public void outDays(){
        LocalDate date = LocalDate.now();
        System.out.println(numDays(date) + 1);
    }
}