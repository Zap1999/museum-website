package com.softserve.academy.museum.entities;

public enum Position {

    GUIDE("Guide"),
    MANAGER("Manager");

    public String title;

    Position(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static Position getPos(String pos) {
        if (pos.equalsIgnoreCase(GUIDE.toString())) {
            return GUIDE;
        } else if (pos.equalsIgnoreCase(MANAGER.toString())) {
            return MANAGER;
        } else {
            return null;
        }
    }

    public static Position getPosById(int posId){
        if (posId == GUIDE.ordinal() + 1) {
            return GUIDE;
        } else if (posId == MANAGER.ordinal() + 1) {
            return MANAGER;
        } else {
            return null;
        }
    }



    @Override
    public String toString(){
        return title;
    }

}
