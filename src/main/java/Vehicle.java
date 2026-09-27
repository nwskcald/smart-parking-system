public class Vehicle{

    private final String vehicleNumber;
    private final ParkingType vehicleType;
    private VehicleStatus vehicleStatus = VehicleStatus.WAITING;

    public Vehicle(
        String vehicleNumber,
        ParkingType vehicleType
    ){
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public void markParked(){
        this.vehicleStatus = VehicleStatus.PARKED;  
    }

    public String getVehicleNumber(){
        return vehicleNumber;
    }

    public ParkingType getVehicleType(){
        return vehicleType;
    }

    public VehicleStatus getVehicleStatus(){
        return vehicleStatus;
    }
}