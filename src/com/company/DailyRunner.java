package com.company;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class DailyRunner {
    private final Runnable dailyTask;
    private final int hour;
    private final int minute;
    private final int second;
    private final String runThreadName;

    public DailyRunner(Calendar timeOfDay, Runnable dailyTask, String runThreadName) {
        this.dailyTask = dailyTask;
        this.hour = timeOfDay.get(Calendar.HOUR_OF_DAY);
        this.minute = timeOfDay.get(Calendar.MINUTE);
        this.second = timeOfDay.get(Calendar.SECOND);
        this.runThreadName = runThreadName;
    }

    // Starts the timed execution of a task
    public void start()
    {
        startTimer();
    }

    // Runs the task at a specified time everyday
    private void startTimer(){
        new Timer(runThreadName, true).schedule(new TimerTask() {
            @Override
            public void run() {
                dailyTask.run();
                startTimer();
            }
        }, getNextRunTime());
    }

    // Gets the next date for the run
    private Date getNextRunTime() {
        Calendar startTime = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, hour);
        startTime.set(Calendar.MINUTE, minute);
        startTime.set(Calendar.SECOND, second);
        startTime.set(Calendar.MILLISECOND, 0);

        if(startTime.before(now) || startTime.equals(now)) {
            startTime.add(Calendar.DATE, 1);
        }

        return startTime.getTime();
    }
}