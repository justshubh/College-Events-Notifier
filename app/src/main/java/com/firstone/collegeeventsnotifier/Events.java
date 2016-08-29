package com.firstone.collegeeventsnotifier;

/**
 * Created by Shubh on 02-08-2016.
 */
public class Events {
    private int eventno;
    private String title;
    private String Description;
    private String Date;

    public Events(int eventno,String title,String Description,String Date){
        this.eventno=eventno;
        this.title=title;
        this.Description=Description;
        this.Date=Date;

    }

    public int getEventno(){ return eventno;}
    public String getTitle(){ return  title;}
    public String getDescription(){ return  Description;}
    public String getDate(){return Date;}

    @Override
    public String toString() {
        return  title;
    }
}
