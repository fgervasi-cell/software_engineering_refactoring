import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @org.junit.jupiter.api.Test
    void statement() {
        String expected = "Rental Record for joe\n";
        expected += "\tTitle\t\tDays\tAmount\n";
        expected += "\tmovie1\t\t10\t30.0\n";
        expected += "\tmovie2\t\t5\t4.5\n";
        expected += "Amount owed is 34.5\n";
        expected += "You earned 3 frequent renter points";

        Movie m1 = new Movie("movie1", 1);
        Movie m2 = new Movie("movie2", 2);
        Rental r1 = new Rental(m1, 10);
        Rental r2 = new Rental(m2, 5);
        Customer c1 = new Customer("joe");
        c1.addRental(r1);
        c1.addRental(r2);

        assertEquals(expected, c1.statement());
    }
}
