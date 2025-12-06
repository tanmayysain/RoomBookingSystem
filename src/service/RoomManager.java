package service;

import models.Room;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RoomManager {

    private static volatile RoomManager instance;
    private Map<String, Room> rooms;

    private RoomManager() {
        rooms = new ConcurrentHashMap<>();
    }

    public static RoomManager getInstance() {
        if (instance == null) {
            synchronized (RoomManager.class) {
                if (instance == null) {
                    instance = new RoomManager();
                }
            }
        }
        return instance;
    }

    public Room addRoom(String roomName, int capacity) {
        if (rooms.containsKey(roomName)) {
            throw new IllegalArgumentException("Room already exists");
        }
        Room r = new Room(roomName, capacity);
        rooms.put(roomName, r);
        return r;
    }

    public Room getRoom(String roomName) {
        Room room = rooms.get(roomName);
        if (room == null) {
            throw new IllegalArgumentException("Room does not exist: " + roomName);
        }
        return room;
    }

    public Collection<Room> getAllRooms() {
        return rooms.values();
    }

    public boolean roomExists(String roomName) {
        return rooms.containsKey(roomName);
    }
}
