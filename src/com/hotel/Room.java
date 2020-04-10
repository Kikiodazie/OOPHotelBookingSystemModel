package com.hotel;

public class Room {
    private String roomType;
    private int roomNumber;
    private int cost;

    public Room(){
        this.setCost(cost);
        this.setRoomType(roomType);
        this.setRoomNumber(roomNumber);
    }


    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
