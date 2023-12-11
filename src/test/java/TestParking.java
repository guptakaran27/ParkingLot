import com.karan.service.ParkingLot2;
import com.karan.VehicleType;
import com.karan.pojos.Ticket;
import com.karan.pojos.Vehicle;

public class TestParking {

    public static void main(String[] args) throws Exception {
        ParkingLot2 p1 = new ParkingLot2();
        p1.initializeParkingSlots(2,2,2);

        Vehicle v1 = new Vehicle("UP21AR0640", VehicleType.SMALL_CAR);
        Ticket t1 = p1.park(v1);
        System.out.println(t1);

        Vehicle v2 = new Vehicle("UP21CZ5696", VehicleType.SMALL_CAR);
        Ticket t2 = p1.park(v2);
        System.out.println(t2);

    }
}
