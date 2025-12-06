package service;

import models.Booking;
import models.Room;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class BookingManager {

    private static volatile BookingManager instance;

    private RoomManager roomManager;

    private BookingManager() {
        roomManager = RoomManager.getInstance();
    }

    public static BookingManager getInstance() {
        if (instance == null) {
            synchronized (BookingManager.class) {
                if (instance == null) {
                    instance = new BookingManager();
                }
            }
        }
        return instance;
    }

    public boolean bookRoom(String roomName, String person, LocalTime start, LocalTime end) {
        Room room = roomManager.getRoom(roomName);

        if (!room.isAvailable(start, end)) {
            System.out.println("room not available");
            return false;
        }

        Booking booking = new Booking(start, end, person);
        room.addBooking(booking);
        return true;
    }

    public boolean cancelBooking(String roomName, LocalTime start, LocalTime end) {
        Room room = roomManager.getRoom(roomName);

        return room.cancelBooking(start, end);
    }

    public List<Booking> listBookings(String roomName) {
        Room room = roomManager.getRoom(roomName);

        return room.getSortedBookings();
    }

    public List<Room> suggestRooms(LocalTime start, LocalTime end, int minCapacity) {
        List<Room> result = new ArrayList<>();

        for (Room r : roomManager.getAllRooms()) {
            if (r.getCapacity() >= minCapacity && r.isAvailable(start, end)) {
                result.add(r);
            }
        }
        return result;
    }
}
