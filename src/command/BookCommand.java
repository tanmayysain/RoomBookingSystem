package command;

import service.BookingManager;

import java.time.LocalTime;

public class BookCommand implements command {

    private BookingManager bookingManager = BookingManager.getInstance();

    @Override
    public void execute(String[] args) {
        // BOOK <RoomName> <StartTime> <EndTime> <PersonName>

        String room = args[1];
        LocalTime start = LocalTime.parse(args[2]);
        LocalTime end = LocalTime.parse(args[3]);
        String person = args[4];

        try {
            boolean ok = bookingManager.bookRoom(room, person, start, end);
            if (ok) {
                System.out.println("Booking Created: " + room + " (" + start + " - " + end + ") for " + person);
            } else {
                System.out.println("Booking Failed: " + room + " is already booked during " + start + " - " + end);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
