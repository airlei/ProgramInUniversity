package homework9;

public class Client {



    public static void main(String[] args) {
        Road road = new Asphalt();
        Vehicle vehicle = new Car();

        road.setVehicle(vehicle);
        vehicle.kind();
        road.opition();
    }

}
