package command;

import models.Booking;
import service.BookingManager;

import java.util.List;

public class ListBookingsCommand implements command {

    private BookingManager bookingManager = BookingManager.getInstance();

    @Override
    public void execute(String[] args) {
        // LIST_BOOKINGS <RoomName>

        String room = args[1];

        try {
            List<Booking> bookings = bookingManager.listBookings(room);
            System.out.println("Bookings for " + room + ":");
            if (bookings.isEmpty()) {
                System.out.println("(No bookings found)");
            } else {
                bookings.forEach(b ->
                        System.out.println("- " + b.getStartTime() + " to " + b.getEndTime() +
                                " (Person: " + b.getPerson() + ")")
                );
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
