package dynamicmusic;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StateManager {
    private static Map<String, Boolean> states;
    public List<StateChangeListener> listeners;

    public StateManager() {
        states = new TreeMap<String, Boolean>();
    }

    public void addState(String name, Boolean value) {
        if (states.containsKey(name)) System.out.println("State already in Map");
        states.put(name, value);
        System.out.println("New state added correctly");
    }

    public void removeState(String name) {
        if (!states.containsKey(name)) System.out.println("State does not exist in Map");
        else {
            states.remove(name);
            System.out.println("State removed correctly");
        }
    }

    public void changeState(String name, Boolean value) {
        if (states.containsKey(name)) {
            states.replace(name, value);
            System.out.println("State value changed correctly");
        }
        else {
            System.out.println("State does not exist in Map");
        }
    }

    public boolean hasState(String name) {
        return states.containsKey(name);
    }

    public boolean getStateValue(String name) {
        return states.getOrDefault(name, false);
    }

    public void printStates() {
        for(Map.Entry<String, Boolean> entry : states.entrySet()) {
            String key = entry.getKey();
            String value = String.valueOf(entry.getValue());
            System.out.println("<State: "+ key + "> <Value: " + value + ">");
        }
    }

}
