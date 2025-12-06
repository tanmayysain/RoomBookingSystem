package command;

import service.BookingManager;

import java.time.LocalTime;

public class CancelCommand implements command {

    private BookingManager bookingManager = BookingManager.getInstance();

    @Override
    public void execute(String[] args) {
        // CANCEL <RoomName> <StartTime> <EndTime> <Person>

        String room = args[1];
        LocalTime start = LocalTime.parse(args[2]);
        LocalTime end = LocalTime.parse(args[3]);
        try {
            boolean ok = bookingManager.cancelBooking(room, start, end);
            if (ok) {
                System.out.println("Booking Cancelled: " + room + " (" + start + " - " + end + ")");
            } else {
                System.out.println("No matching booking found.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
