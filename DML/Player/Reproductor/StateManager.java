package DML.Player.Reproductor;

import java.util.Map;
import java.util.TreeMap;

/**
 * This class stores, creates, delete, and updates every state created in the library.
 */
public class StateManager {
    /**
     * Map which will store the entirety of the program's actions and states.
     */
    private static Map<String, Boolean> states;

    /**
     * Constructor
     */
    public StateManager() {
        states = new TreeMap<>();
    }

    /**
     * Adds a new state to the map.
     */
    public static void addState(String name, Boolean value) {
        if (states.containsKey(name)) System.out.println("State already in Map");
        states.put(name, value);
        System.out.println("New state added correctly");
    }

    /**
     * Removes a state from the map.
     */
    public static void removeState(String name) {
        if (!states.containsKey(name)) System.out.println("State does not exist in Map");
        else {
            states.remove(name);
            System.out.println("State removed correctly");
        }
    }

    /**
     * Changes the value of a given key from States map.
     */
    public static void changeState(String name, Boolean value) {
        if (states.containsKey(name)) {
            states.replace(name, value);
            System.out.println("State value changed correctly");
        } else {
            System.out.println("State does not exist in Map");
        }
    }

    /**
     * Returns if a state exists in the map.
     */
    public static boolean hasState(String name) {
        return states.containsKey(name);
    }

    /**
     * Returns the current value of a given state.
     */
    public static boolean getStateValue(String name) {
        return states.getOrDefault(name, false);
    }

    /**
     * Prints all states stored in the map.
     */
    public static void printStates() {
        for (Map.Entry<String, Boolean> entry : states.entrySet()) {
            String key = entry.getKey();
            String value = String.valueOf(entry.getValue());
            System.out.println("<State: " + key + "> <Value: " + value + ">");
        }
    }

}
