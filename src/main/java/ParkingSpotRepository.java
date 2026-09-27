import java.util.List;
import java.util.ArrayList;

public interface ParkingSpotRepository{

    // DB에 저장된 ParkingSpot 모조리 갖고오기
    // occupied판단은 ParkingSpot클래스가 하도록 하겠다.
    List<ParkingSpot> getParkingSpots();

    public void updateParkingSpot(ParkingSpot parkingSpot);
    
    public void registerParkingSpot(ParkingSpot parkingSpot);

}