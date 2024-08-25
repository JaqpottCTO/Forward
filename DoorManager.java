package com.evertisky.rootworkv1.core;

import java.util.ArrayList;
import java.util.List;

public class DoorManager {
    private List<Door> doors;

    public DoorManager() {
        this.doors = new ArrayList<>();
    }

    public List<Door> getDoors() {
        return doors;
    }

    public void addDoor(Door door) {
        doors.add(door);
    }
}
