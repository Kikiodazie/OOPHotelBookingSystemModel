package com.users;

import com.hotel.Hotel;
import com.hotel.Room;
import com.payment.BookingStatus;
import com.payment.PaymentDetails;
import com.payment.PaymentMode;
import com.payment.PaymentStatus;

import java.util.Date;
import java.util.Scanner;

public class Guest extends Account {
    private Hotel hotel;
    private BookingStatus bookingStatus;
    private Room bookedRoom;
    private Date date;
    private PaymentDetails paymentDetails;

    public Guest(String name, int accountId, String emailId){
        super(name, accountId, emailId);
        this.paymentDetails = new PaymentDetails();
    }

    /*
    *This method when called books a room
    *
     */

    public void bookRoom(){
        System.out.println("Here are the available rooms in " + hotel.getName());
        System.out.println();
        hotel.roomsInThisHotel();
        System.out.print("What room number do you want: ");
        Scanner scanner = new Scanner(System.in);
        int roomNumber = scanner.nextInt();

        //May want to use the date class Here
        //To store the particular room booked for the payNow method
        for (Room room: hotel.getRooms()) {
            if(roomNumber == room.getRoomNumber()){
                payForRoom(room);
                if (getPaymentDetails().getPaymentStatus() == PaymentStatus.PAID){
                    this.setBookedRoom(room);
                    hotel.getRooms().remove(room);
                    this.setBookingStatus(BookingStatus.RESERVED);
                    System.out.println(this.getBookingStatus());
                    reservationDetails();
                    break;
                }else {
                    System.out.println("Invalid Payment");
                }

            }else {
                System.out.println("Wrong room number");
            }

        }
    }

    /*
    * Allows user pay for room
     */
    public void payForRoom(Room room){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Your Card number: ");
        String  cardNumber = scanner.nextLine();
        getPaymentDetails().setCardNumber(cardNumber);
        System.out.println("Select card type '1 for Mastercard', '2 for Verve' & 3 for Visa");
        System.out.print("Card type: ");
        Scanner scanner2 = new Scanner(System.in);

        int cardType = scanner2.nextInt();
        if (cardType == 1) getPaymentDetails().setPaymentMode(PaymentMode.MASTERCARD);

        if (cardType == 2) getPaymentDetails().setPaymentMode(PaymentMode.VERVE);
        if (cardType == 3) getPaymentDetails().setPaymentMode(PaymentMode.VISA);
        int cost = scanner2.nextInt();
        getPaymentDetails().setAmount(cost);

        if (getPaymentDetails().getAmount() != room.getCost()){
            getPaymentDetails().setPaymentStatus(PaymentStatus.UNPAID);
        }
        if (getPaymentDetails().getAmount() == room.getCost()){
            getPaymentDetails().setPaymentStatus(PaymentStatus.PAID);
        }
    }


    /*
    * This method cancels reservation
     */

    public void cancelReservation(){
        System.out.println("Do you want to cancel your reservation? (yes/no): ");
        Scanner scanner = new Scanner(System.in);
        String decision = scanner.next();

        if (decision.equals("yes")){
            this.setBookedRoom(null);
            System.out.println("Your Reservation has been canceled");
            this.setBookingStatus(BookingStatus.CANCELED);
            System.out.println("Reservation status: " + this.getBookingStatus());
            reservationDetails();
        }

        if (decision.equals("no")){
            System.out.println("Great, you still have your reservation");
            reservationDetails();
        }

    }

    public void reservationDetails(){
        if(this.getBookedRoom() != null) {
            System.out.println("Good day Guest you Reservation details are as follows");
            System.out.println("Reservation status: " + getBookingStatus());
            System.out.println("Room type: " + getBookedRoom().getRoomType());
            System.out.println();
            System.out.println("Room number: " + getBookedRoom().getRoomNumber());
            System.out.println();
            System.out.printf("Room Cost: %d%n", getBookedRoom().getCost());
        }

    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Room getBookedRoom() {
        return bookedRoom;
    }

    public void setBookedRoom(Room bookedRoom) {
        this.bookedRoom = bookedRoom;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
