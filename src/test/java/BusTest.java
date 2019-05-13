import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


public class BusTest {

    private Bus notEmptyBus;

    @Before
    public void setup(){
        notEmptyBus = new Bus(10);
    }

    @Test
    public void createEmptyBus(){
        Bus emptyBus = new Bus();
    }

    @Test
    public void createBusWithCapacity(){
        assertEquals(10, notEmptyBus.getCapacity());
    }

    @Test
    public void busVacanciesShouldBeEqualToCapacityAtStart(){
        assertEquals(10, notEmptyBus.getCapacity());
        assertEquals(10, notEmptyBus.getVacancies());
    }

    @Test
    public void addPassengerWithFareToTheBus(){
        Passenger p = new Passenger(1,"Joe Bloggs", 5);

        notEmptyBus.board(p);

        assertEquals(10, notEmptyBus.getCapacity());
        assertEquals(9, notEmptyBus.getVacancies());
    }

    @Test
    public void addTooManyPassengersToTheBusAndReturnBusFullMessage(){
        Passenger Joe = new Passenger( 1,"Joe Bloggs", 5);
        Passenger Mary = new Passenger(2,"Mary Smith", 5);
        Passenger Kurt = new Passenger(3,"Kurt Russell", 8);
        Passenger Susan = new Passenger(4,"Susan Harp", 10);
        Passenger Phil = new Passenger(5,"Phil Jones", 15);
        Passenger joe = new Passenger(6, "Joe Jones", 5);
        Passenger kat = new Passenger(7, "Kat Kaplan", 5);
        Passenger sue = new Passenger(8, "Sue Summers", 8);
        Passenger yas = new Passenger(9, "Yasamine Yarrow", 10);
        Passenger Kyle = new Passenger(10, "Kyle Wills", 10);
        Passenger Peter = new Passenger(11, "Shane Smith", 5);


        notEmptyBus.board(Joe);
        notEmptyBus.board(Mary);
        notEmptyBus.board(Kurt);
        notEmptyBus.board(Susan);
        notEmptyBus.board(Phil);
        notEmptyBus.board(joe);
        notEmptyBus.board(kat);
        notEmptyBus.board(sue);
        notEmptyBus.board(yas);
        notEmptyBus.board(Kyle);

        assertEquals(10, notEmptyBus.getCapacity());
        assertEquals(0, notEmptyBus.getVacancies());

        assertEquals("Bus full, cannot add any more passengers", notEmptyBus.board(Peter));
    }

    @Test
    public void addPassengersToTheBusAndReturnPassengerList(){
        Passenger Joe = new Passenger( 1,"Joe Bloggs", 5);
        Passenger Mary = new Passenger(2,"Mary Smith", 5);
        Passenger Kurt = new Passenger(3,"Kurt Russell", 8);
        Passenger Susan = new Passenger(4,"Susan Harp", 10);
        Passenger Phil = new Passenger(5,"Phil Jones", 15);

        notEmptyBus.board(Joe);
        notEmptyBus.board(Mary);
        notEmptyBus.board(Kurt);
        notEmptyBus.board(Susan);
        notEmptyBus.board(Phil);

        assertEquals(10, notEmptyBus.getCapacity());
        assertEquals(5, notEmptyBus.getVacancies());

        String expectedPassengerDetails = "Joe Bloggs, Mary Smith, Kurt Russell, Susan Harp, Phil Jones";

        assertEquals(expectedPassengerDetails, notEmptyBus.getPassengersDetails());

        Passenger John = new Passenger(6, "John Wick", 5);
        notEmptyBus.board(John);

        assertEquals(10, notEmptyBus.getCapacity());
        assertEquals(4, notEmptyBus.getVacancies());

        expectedPassengerDetails = "Joe Bloggs, Mary Smith, Kurt Russell, Susan Harp, Phil Jones, John Wick";
        assertEquals(expectedPassengerDetails, notEmptyBus.getPassengersDetails());
    }

    @Test
    public void AllowsPassengersToSwitchSeats(){
        Passenger joe = new Passenger(1, "Joe Jones", 5);
        Passenger kat = new Passenger(4, "Kat Kaplan", 5);
        Passenger sue = new Passenger(3, "Sue Summers", 8);
        Passenger yas = new Passenger(2, "Yasamine Yarrow", 10);

        notEmptyBus.board(joe);
        notEmptyBus.board(kat);
        notEmptyBus.board(sue);
        notEmptyBus.board(yas);

        notEmptyBus.switchSeats(joe, sue);

        String expectedPassengerDetails = "Sue Summers, Kat Kaplan, Joe Jones, Yasamine Yarrow";

        assertEquals(expectedPassengerDetails, notEmptyBus.getPassengersDetails());

        notEmptyBus.switchSeats(kat, joe);

        expectedPassengerDetails = "Sue Summers, Joe Jones, Kat Kaplan, Yasamine Yarrow";

        assertEquals(expectedPassengerDetails, notEmptyBus.getPassengersDetails());

    }

    @Test
    public void AllowsYouToGetTheTotalOfAllPaidFares() {
        Passenger joe = new Passenger(1, "Joe Jones", 5);
        Passenger sue = new Passenger(2, "Sue Summers", 5);
        Passenger sally = new Passenger(3, "Sally Sue", 8);

        notEmptyBus.board(joe);
        assertEquals(5, notEmptyBus.paidFares());

        notEmptyBus.board(sue);
        assertEquals(10, notEmptyBus.paidFares());

        notEmptyBus.board(sally);
        assertEquals(18, notEmptyBus.paidFares());

    }


}
