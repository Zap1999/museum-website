package com.softserve.academy.museum.entities;

public enum Position {

    GUIDE, MANAGER;

    public static Position getPos(String pos) {
        if (pos.equalsIgnoreCase(GUIDE.toString())) {
            return GUIDE;
        } else if (pos.equalsIgnoreCase(MANAGER.toString())) {
            return MANAGER;
        } else {
            return null;
        }
    }

}
