import java.util.List;
import java.util.ArrayList;

public class ParkingService{

    private final VehicleRepository vehicleRepository;
    private final ParkingSpotRepository parkingSpotRepository;

    public ParkingService(
        VehicleRepository vehicleRepository,
        ParkingSpotRepository parkingSpotRepository
    ){
        this.vehicleRepository = vehicleRepository;
        this.parkingSpotRepository = parkingSpotRepository;
    }

    // parkVehicle()는 하나의 비즈니스 use-case orchestration
    public void parkVehicle(String vehicleNumber){

        Vehicle vehicle =
            vehicleRepository.findByNumber(vehicleNumber);

        if(vehicle == null){
            throw new VehicleNotFoundException(
                "존재하지 않는 차량입니다."
            );
        }

        List<ParkingSpot> parkingSpots =
            parkingSpotRepository.getParkingSpots();

        for(ParkingSpot parkingSpot : parkingSpots){

            if(parkingSpot.canAssign(vehicle)){

                parkingSpot.assign();
                vehicle.markParked();
                parkingSpotRepository.updateParkingSpot(parkingSpot);
                vehicleRepository.updateVehicle(vehicle);
                return;
            }
        }

        throw new NoAvailableParkingSpotException(
            "배정할 주차공간이 없습니다.");
    }

    // DB 저장
    public void registerVehicleService(Vehicle vehicle){
        vehicleRepository.registerVehicle(vehicle);
    }
    // DB 저장
    public void registerParkingSpotService(ParkingSpot parkingSpot){
        parkingSpotRepository.registerParkingSpot(parkingSpot);
    }

    // DB 출력
    public void printParkingSpotsService(){

        List<ParkingSpot> parkingSpots = 
            parkingSpotRepository.getParkingSpots();

        for(ParkingSpot parkingSpot : parkingSpots){
            System.out.println("ID: " + parkingSpot.getParkingSpotId() 
                + ", " + "Status: " + parkingSpot.isOccupied());
        }
    }
}