public class ParkingSpot{

    private final String parkingSpotId;
    private final ParkingType parkingSpotType;
    private boolean occupiedStatus;

    public ParkingSpot(
        String parkingSpotId,
        ParkingType parkingSpotType,
        boolean occupiedStatus
    ){
        this.parkingSpotId = parkingSpotId;
        this.parkingSpotType = parkingSpotType;
        this.occupiedStatus = occupiedStatus;
    }

    public String getParkingSpotId(){
        return parkingSpotId;
    }

    public ParkingType getParkingSpotType(){
        return parkingSpotType;
    }

    public boolean isOccupied(){
        return occupiedStatus;
    }

    public void occupy(){
        this.occupiedStatus = true;
    }

    public boolean canAssign(Vehicle vehicle){
        if(this.getParkingSpotType() == vehicle.getVehicleType()){

            if(!occupiedStatus){ // occupiedStatus가 false여야 assign가능

                return true;
            }
        }
        
        return false;
    }

    public void assign(){
        this.occupy();
    }
}