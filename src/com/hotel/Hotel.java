package com.hotel;

import com.users.Guest;
import com.users.Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hotel {
    private String name;
    List<Room> rooms; //Rooms are not ordered: A BETTER DATA STRUCTURE WOULD BE TreeMap using http://www.sergiy.ca/guide-to-selecting-appropriate-map-collection-in-java/ GUIDE
    List<Guest> guests;

    public Hotel() {
        rooms = new ArrayList<>();
        guests = new ArrayList<>();
    }


    public void addAvailableRoom(){
        System.out.println("Add Room");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Room type:");
        String roomType = scanner.nextLine();
        Scanner scannerInt = new Scanner(System.in);
        System.out.print("Room number: ");
        int roomNumber = scannerInt.nextInt();
        System.out.print("Room cost: ");
        int roomCost = scannerInt.nextInt();

        Room room = new Room(roomCost, roomType, roomNumber);
        rooms.add(room);
    }

    public void  removeRoom(){
        // Using that enum check if room has been booked

    }


    public void roomsInThisHotel(){
        System.out.println("Room Number" + " | "+ "Room Type" + " | "+ "Room Cost (N)" );
        for (Room room: rooms) {
            System.out.println( "    " + room.getRoomNumber() + "          "   + room.getRoomType() + "         " + room.getCost());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }
}
