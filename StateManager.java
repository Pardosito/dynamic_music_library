package dynamicmusic;

import java.util.HashMap;
import java.util.List;

public class StateManager {
    public HashMap<String, Boolean> states;
    public List<StateChangeListener> listeners;

    public void addState(String name, Boolean value) {

    }

    public void removeState(String name) {

    }

    public void changeState(String name, Boolean value) {

    }

    public boolean hasState(String name) {
        return false;
    }

    public boolean getStateValue(String name) {
        return false;
    }
}
