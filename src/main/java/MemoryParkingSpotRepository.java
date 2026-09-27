import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class MemoryParkingSpotRepository
    implements ParkingSpotRepository{

        // Map이기에 순서성이 보장되지않는다.
        // 조건을 만족하는 랜덤한 ParkingSpot에 주차가 될것이다.
        Map<String, ParkingSpot> memoryParkingSpotRepository =
            new HashMap<>();
        
        @Override
        public List<ParkingSpot> getParkingSpots(){

            List<ParkingSpot> parkingSpots =
                new ArrayList<>();

            for(ParkingSpot parkingSpot : memoryParkingSpotRepository.values()){

                parkingSpots.add(parkingSpot);
            }

            return parkingSpots;
        }

        @Override
        public void registerParkingSpot(ParkingSpot parkingSpot){
            memoryParkingSpotRepository.put(parkingSpot.getParkingSpotId(), parkingSpot);
        }

        @Override
        public void updateParkingSpot(ParkingSpot parkingSpot){
            memoryParkingSpotRepository.put(parkingSpot.getParkingSpotId(), parkingSpot);
        }

    }