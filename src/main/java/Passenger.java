public class Passenger {

    private String passengerName;
    private double fare;
    private int passengerId;

    public Passenger(int id,String name, double fare){
        this.passengerName = name;
        this.fare = fare;
        this.passengerId = id;
    }

    public int getPassengerId(){
        return this.passengerId;
    }

    public String getPassengerName() {
        return this.passengerName;
    }

    public double getFare(){
        return this.fare;
    }
}
