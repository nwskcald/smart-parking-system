public interface VehicleRepository{

    // vehicleNumber을 받아 Vehicle return하기.
    public Vehicle findByNumber(String vehicleNumber);

    public void updateVehicle(Vehicle vehicle);

    public void registerVehicle(Vehicle vehicle);
}