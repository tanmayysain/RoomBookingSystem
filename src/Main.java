package app;

import command.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 1️⃣ Initialize command registry and register all commands
        CommandRegistry registry = new CommandRegistry();
        registry.register("ADD_ROOM", new AddRoomCommand());
        registry.register("BOOK", new BookCommand());
        registry.register("CANCEL", new CancelCommand());
        registry.register("LIST_BOOKINGS", new ListBookingsCommand());
        registry.register("SUGGEST", new SuggestCommand());

        CommandProcessor processor = new CommandProcessor(registry);

        // 2️⃣ CLI loop
        Scanner scanner = new Scanner(System.in);
        System.out.println("Meeting Room Booking System CLI. Enter commands:");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();

            if (input == null || input.trim().isEmpty()) {
                continue;
            }

            input = input.trim();

            if (input.equalsIgnoreCase("EXIT") || input.equalsIgnoreCase("QUIT")) {
                System.out.println("Exiting...");
                break;
            }

            // Process command
            processor.process(input);
        }

        scanner.close();
    }
}
