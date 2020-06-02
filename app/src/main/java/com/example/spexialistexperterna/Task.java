package com.example.spexialistexperterna;

import java.util.Date;

public class Task {

    private String title;
    private String startTime;
    private String endTime;
    private String position;
    private String message;

    private Profile taskOwner;
    private Profile assignee;
    private boolean completed;


    //Date creationDate;  TODO: kolla upp hur datetime hämtas i Java
    //Date endDate;






    public Task(String title, String startTime, String endTime, String position, String message) {

        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.position = position;
        this.message = message;

    }


    public String getTitle() {
        return title;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return  endTime;
    }

    public String getBigMessageTime() {
        return endTime + " Den " + startTime;
    }

    public String getPosition() {
        return position;
    }

    public String getMessage() {
        return message;
    }

    public Profile getTaskOwner() {
        return taskOwner;
    }

    public Profile getAssignee() {
        return assignee;
    }

    public boolean isCompleted() {
        return completed;
    }
}
