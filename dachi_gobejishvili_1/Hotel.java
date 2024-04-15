package quizes.q3.dachi_gobejishvili_1;

import java.util.Scanner;

public class Hotel {
    private Room[] rooms;
    public Hotel(String hotelName, Room[] rooms){
        this.rooms = rooms;
    }
    public void displayAvailableRooms(){
        System.out.println("Available Rooms");
        for (Room room : rooms){
            if (!room.isOccupied()){
                System.out.println(room);
            }
        }
    }
    public void checkIn(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter room number: ");
        int roomNumber = scanner.nextInt();
        Room room = findRoom(roomNumber);
        if (room !=null){
            if (room.isOccupied()){
                System.out.println("Room " + roomNumber + "is already occupied.");
            } else {
                System.out.println("Enter guest name: ");
                String guestName = scanner.next();
                room.setGuestName(guestName);
                room.setOccupied(true);
                System.out.println("Guest" + guestName + "checked into room " + roomNumber + ".");
            }
        }else {
            System.out.println("Room " + roomNumber + "does not exist.");
        }
    }
    public  void  checkOut(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter room number: ");
        int roomNumber = scanner.nextInt();
        Room room = findRoom(roomNumber);
        if (room.isOccupied()){
            String guestname = room.getGuestName();
            room.setGuestName("");
            room.setOccupied(false);
            System.out.println("Guest " + guestname + "checked out of room " + roomNumber + ".");
        }else {
            System.out.println("Room " + roomNumber + "is not occupied");
        }
    }
    private Room findRoom(int roomNumber){
        for (Room room : rooms){
            if (room.getRoomNumber() == roomNumber){
                return room;
            }
        }
        return null;
    }
}
