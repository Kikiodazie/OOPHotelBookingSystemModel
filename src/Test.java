import com.hotel.Hotel;
import com.users.Guest;
import com.users.Manager;

public class Test {

    public static void main(String[] args) {
        Hotel app = new Hotel();
        app.setName("Elite Guys Hotel");
        Manager kiki = new Manager(app);


        kiki.getHotel().addAvailableRoom();
        kiki.getHotel().addAvailableRoom();

        Guest guest1 = new Guest(app);

        guest1.bookRoom();
        kiki.getHotel().roomsInThisHotel();
        guest1.reservationDetails();

    }
}
