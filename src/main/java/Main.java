public class Main{
    
    public static void main(String[] args){

        VehicleRepository vehicleRepository =
            new MemoryVehicleRepository();

        ParkingSpotRepository parkingSpotRepository =
            new MemoryParkingSpotRepository();

        ParkingService service =
            new ParkingService(vehicleRepository, parkingSpotRepository);

        // Vehicle 객체생성
        Vehicle vehicle1 = new Vehicle("12가 3456", ParkingType.ELECTRIC);

        // ParkingSpot 객체생성
        ParkingSpot parkingSpot1 = new ParkingSpot("P001", ParkingType.NORMAL, false);
        ParkingSpot parkingSpot2 = new ParkingSpot("P002", ParkingType.ELECTRIC, true);
        ParkingSpot parkingSpot3 = new ParkingSpot("P003", ParkingType.ELECTRIC, false);
        ParkingSpot parkingSpot4 = new ParkingSpot("P004", ParkingType.ELECTRIC, false);

        // DB에 값 register
        service.registerVehicleService(vehicle1);
        service.registerParkingSpotService(parkingSpot1);
        service.registerParkingSpotService(parkingSpot2);
        service.registerParkingSpotService(parkingSpot3);
        service.registerParkingSpotService(parkingSpot4);

        System.out.println("Number: " + vehicle1.getVehicleNumber() + ", "
            + "Status: " + vehicle1.getVehicleStatus());
        service.printParkingSpotsService();

        try{
            service.parkVehicle("12가 3456");
        } catch (VehicleNotFoundException e){
            System.out.println(e.getMessage());
        } catch (NoAvailableParkingSpotException e){
            System.out.println(e.getMessage());
        }

        System.out.println("-------- Parking --------");
        System.out.println("Number: " + vehicle1.getVehicleNumber() + ", "
            + "Status: " + vehicle1.getVehicleStatus());
        service.printParkingSpotsService();
    }
}