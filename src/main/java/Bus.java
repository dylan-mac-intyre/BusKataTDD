public class Bus {

    private int capacity;
    private int vacancies;
    private Passenger[] passengers;
    private int passengerCount;
    private int totalFare;

    public Bus(){

    }

    public Bus(int capacity){
        this.capacity = capacity;
        this.vacancies = this.capacity;
        passengers = new Passenger[this.capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    public int getVacancies() {
        return vacancies;
    }

    public String board(Passenger passenger){
        if(this.vacancies != 0) {
            passengers[this.passengerCount] = passenger;
            this.passengerCount++;
            this.vacancies--;
            this.totalFare += passenger.getFare();
        }
        else{
            return "Bus full, cannot add any more passengers";
        }

        return "";
    }

    public String getPassengersDetails() {
        String passengerDetails = "";
        for(int i = 0; i < passengerCount; i++){
            passengerDetails += ""+passengers[i].getPassengerName() +", ";
        }

        return passengerDetails.substring(0, passengerDetails.length() -2);
    }

    public void switchSeats(Passenger passenger1, Passenger passenger2) {
        Passenger tempPassenger = passenger1;
        int indexOfP1 = 0;
        int indexOfP2 = 0;
        for(int i = 0; i < passengerCount; i++){
            if(passenger1 == this.passengers[i]){
                indexOfP1 = i;
            }
            if(passenger2 == this.passengers[i]){
                indexOfP2 = i;
            }
        }

        this.passengers[indexOfP1] = this.passengers[indexOfP2];
        this.passengers[indexOfP2] = tempPassenger;
    }

    public int paidFares() {
        return this.totalFare;
    }
}
