package models;

import java.time.LocalTime;
import java.util.*;

public class Room {
    private String name;
    private int capacity;
    private List<Booking> bookings = new ArrayList<>();

    public Room(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() { return name; }
    public int getCapacity() { return capacity; }

    public boolean isAvailable(LocalTime start, LocalTime end) {
        for (Booking b : bookings) {
            if (start.isBefore(b.end) && b.start.isBefore(end)) return false;
        }
        return true;
    }

    public void addBooking(Booking b) { bookings.add(b); }

    public boolean cancelBooking(LocalTime start, LocalTime end) {
        return bookings.removeIf(b ->
                b.getStartTime().equals(start) &&
                        b.getEndTime().equals(end)
        );
    }


    public List<Booking> getSortedBookings() {
        bookings.sort((a, b) -> a.start.compareTo(b.start));
        return bookings;
    }
}
