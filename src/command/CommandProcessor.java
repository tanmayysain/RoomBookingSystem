package command;

public class CommandProcessor {

    private CommandRegistry registry;

    public CommandProcessor(CommandRegistry registry) {
        this.registry = registry;
    }

    public void process(String input) {
        String[] tokens = input.split(" ");

        String commandName = tokens[0];

        command cmd = registry.get(commandName);

        if (cmd == null) {
            System.out.println("Invalid command: " + commandName);
            return;
        }

        try {
            cmd.execute(tokens);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
