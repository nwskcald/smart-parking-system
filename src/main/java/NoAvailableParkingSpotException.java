public class NoAvailableParkingSpotException
    extends RuntimeException{
        
        public NoAvailableParkingSpotException(String message){
            super(message);
        }
    }