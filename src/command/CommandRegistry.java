package command;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {

    private Map<String, command> registry = new HashMap<>();

    public void register(String key, command command) {
        registry.put(key, command);
    }

    public command get(String key) {
        return registry.get(key);
    }
}
