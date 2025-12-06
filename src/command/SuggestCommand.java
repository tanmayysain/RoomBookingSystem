package command;

import models.Room;
import service.BookingManager;

import java.time.LocalTime;
import java.util.List;

public class SuggestCommand implements command {

    private BookingManager bookingManager = BookingManager.getInstance();

    @Override
    public void execute(String[] args) {
        // SUGGEST <StartTime> <EndTime> <MinCapacity>

        LocalTime start = LocalTime.parse(args[1]);
        LocalTime end = LocalTime.parse(args[2]);
        int minCapacity = Integer.parseInt(args[3]);

        try {
            List<Room> rooms = bookingManager.suggestRooms(start, end, minCapacity);
            System.out.println("Suggestions for " + start + " - " + end + " (Min Capacity: " + minCapacity + "):");
            if (rooms.isEmpty()) {
                System.out.println("(No rooms available)");
            } else {
                rooms.forEach(r ->
                        System.out.println("- " + r.getName() + " (Capacity: " + r.getCapacity() + ")")
                );
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
