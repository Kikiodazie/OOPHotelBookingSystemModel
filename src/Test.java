import com.hotel.Hotel;
import com.users.Guest;
import com.users.Manager;

public class Test {

    public static void main(String[] args) {

        Manager kiki = new Manager("Chiza",234, "ciza@gmail.com");

        kiki.getHotel().addAvailableRoom();
        kiki.getHotel().addAvailableRoom();

        Guest guest1 = new Guest("Stanley",222, "stanley@gmail.com");

        guest1.bookRoom();
        kiki.getHotel().roomsInThisHotel();
        guest1.reservationDetails();

    }
}
