package models;

import java.time.LocalTime;

public class Booking {
    public LocalTime start;
    public LocalTime end;
    public String person;

    public Booking(LocalTime start, LocalTime end, String person) {
        this.start = start;
        this.end = end;
        this.person = person;
    }

    public LocalTime getStartTime(){
        return this.start;
    }

    public LocalTime getEndTime(){
        return this.end;
    }

    public String getPerson(){
        return this.person;
    }
}
