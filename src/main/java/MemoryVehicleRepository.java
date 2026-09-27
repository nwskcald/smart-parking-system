import java.util.Map;
import java.util.HashMap;

public class MemoryVehicleRepository
    implements VehicleRepository{

        Map<String, Vehicle> memoryVehicleRepository =
            new HashMap<>();

        @Override
        public Vehicle findByNumber(String vehicleNumber){
            return memoryVehicleRepository.get(vehicleNumber);
        }

        @Override
        public void updateVehicle(Vehicle vehicle){
            memoryVehicleRepository.put(vehicle.getVehicleNumber(), vehicle);
        }

        @Override
        public void registerVehicle(Vehicle vehicle){
            memoryVehicleRepository.put(vehicle.getVehicleNumber(), vehicle);
        }
    }