package homework9;

public class Asphalt extends Road{
    protected Vehicle vehicle;
    public  void setVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }
    public  void opition(){
        System.out.println("行驶在在沥青路上");
    }
}
