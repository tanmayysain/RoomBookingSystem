package command;

import service.RoomManager;

public class AddRoomCommand implements command {

    private RoomManager roomManager = RoomManager.getInstance();

    @Override
    public void execute(String[] args) {
        // ADD_ROOM <RoomName> <Capacity>
        String roomName = args[1];
        int capacity = Integer.parseInt(args[2]);

        roomManager.addRoom(roomName, capacity);
        System.out.println("Room '" + roomName + "' added with capacity " + capacity);
    }
}
